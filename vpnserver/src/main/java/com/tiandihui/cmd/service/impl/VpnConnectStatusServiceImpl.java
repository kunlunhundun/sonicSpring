package com.tiandihui.cmd.service.impl;

import com.tiandihui.cmd.common.exception.Asserts;
import com.tiandihui.cmd.common.javashell.ExecuteResult;
import com.tiandihui.cmd.common.javashell.LocalCommandExecutor;
import com.tiandihui.cmd.common.utils.RootShell;
import com.tiandihui.cmd.common.utils.StringUtils;
import com.tiandihui.cmd.mbg.model.UmsVpnWireguard;
import com.tiandihui.cmd.service.VpnConnectStatusService;
import com.tiandihui.cmd.service.WireGuardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class VpnConnectStatusServiceImpl implements VpnConnectStatusService {

    public static final int ERROR = 0x0;
    public static final int MAGISK = 0x4;
    public static final int YES = 0x1;

    @Autowired
    private LocalCommandExecutor localCommandExecutor;

    @Autowired
    WireGuardService wireGuardService;

    private Logger logger = LoggerFactory.getLogger(getClass());//提供日志类



    @Override
    public void updateVpnConnectStatus() {

       // String filePath = getClass().getResource("/").getPath() + "test.sh";
       // ExecuteResult executeResult = localCommandExecutor.executeCommand(filePath, 1000);
        ExecuteResult  executeResult = localCommandExecutor.executeCommand("wg  ",10000);
        String content = executeResult.getExecuteOut();

        String publicKey = "";

        String[] contentArr = content.split("\n");
        ArrayList<Map> arrayList = new ArrayList<>();
        Boolean startPeerFlag = false;
        Map<String,String> map = null;
        for (int i = 0; i < contentArr.length; i++) {
            String oneline = contentArr[i];
            String noEnterLine = StringUtils.replaceEnter(oneline);
            String noStrimLine = noEnterLine.trim();
            if (noStrimLine.length() > 2) {
                if (noStrimLine.contains("peer")) {
                    startPeerFlag = true;
                    if (map != null) {
                        arrayList.add(map);
                    }
                    map = new HashMap<>();
               }
                String[] lineArr = noStrimLine.split(":");
                if (noStrimLine.contains("publickey")) {
                    publicKey = lineArr[1];
                }
                if (startPeerFlag == true) {
                    map.put(lineArr[0],lineArr[1]);
                }
            }
        }

        logger.info("arraylist：\n" + arrayList.toString());

    }

    @Override
    public void importVpnDataFromConf() {

        String serviceId = wireGuardService.getServiceId();
        if (serviceId == null || serviceId.length() < 1) {
            logger.info("serviceid is empty \n");
            Asserts.fail("serviceid is empty  ,先导入服务，再导入用户数据");
            return ;
        }
        String lsDir = "ls /etc/wireguard";
        //lsDir = "ls /Users/ward.y/www/wireguardconf";
        ExecuteResult executeResult = localCommandExecutor.executeCommand(lsDir, 2000);
        String content = executeResult.getExecuteOut();
        String[] contentArr = content.split("\n");

        ArrayList<UmsVpnWireguard> arrayList = new ArrayList<>();
        for (int i = 0; i < contentArr.length; i++) {
            String oneline = contentArr[i];
            String noEnterLine = StringUtils.replaceEnter(oneline);
            String noStrimLine = noEnterLine.trim();
            if (noStrimLine.length() > 2 && noStrimLine.contains(".conf")
                    && !noStrimLine.contains("wg0.conf")) {
                UmsVpnWireguard vpnWireguard = new UmsVpnWireguard();
                vpnWireguard.setDeleteStatus(0);
                vpnWireguard.setUseStatus(0);
                vpnWireguard.setServiceId(Long.valueOf(serviceId));
                vpnWireguard.setUpdateTime(new Date());
                arrayList.add(vpnWireguard);

                String newCmd = "cat  " + "/etc/wireguard/" + noEnterLine;
               // newCmd = "cat  " + "/Users/ward.y/www/wireguardconf/" + noEnterLine;
                ExecuteResult vpnResult = localCommandExecutor.executeCommand(newCmd, 2000);

                String[] peerContentArr = vpnResult.getExecuteOut().split("\n");
                for (int j = 0; j < peerContentArr.length; j++) {
                    String peerContentLine = peerContentArr[j];
                    String noPeerEnterLine = StringUtils.replaceEnter(peerContentLine);
                    String noPeerStrimLine = noPeerEnterLine.trim();
                    int firstEq =  noPeerStrimLine.indexOf("=");
                    if (firstEq < 1) {
                        continue;
                    }
                    String secondStr = noPeerStrimLine.substring(firstEq+1);
                    String  firstStr = noPeerStrimLine.substring(0,firstEq);

                    if (secondStr.length() > 1) {
                        if (noPeerStrimLine.contains("PrivateKey")) {
                            vpnWireguard.setPrivatekey(secondStr);
                        } else if (noPeerStrimLine.contains("Address")) {
                            vpnWireguard.setAddress(secondStr);
                        } else if (noPeerStrimLine.contains("DNS")) {
                            vpnWireguard.setDns(secondStr);
                        } else if (noPeerStrimLine.contains("MTU")) {
                            vpnWireguard.setMtu(secondStr);
                        } else if (noPeerStrimLine.contains("PublicKey")) {
                            vpnWireguard.setPublickey(secondStr);
                        } else if (noPeerStrimLine.contains("Endpoint")) {
                            vpnWireguard.setEndpoint(secondStr);
                        } else if (noPeerStrimLine.contains("AllowedIPs")) {
                            String allowedIps = secondStr;
                            vpnWireguard.setAllowedIps("0.0.0.0/0, ::0/0");
                            int index =  allowedIps.indexOf("::");
                            StringBuilder allowedIpBuilder = new StringBuilder(allowedIps);
                             allowedIpBuilder.insert(index," ");
                            vpnWireguard.setAllowedIps(allowedIpBuilder.toString());

                        } else if (noPeerStrimLine.contains("PersistentKeepalive")) {
                            vpnWireguard.setPersistentKeepalive(Integer.valueOf(secondStr));
                        }
                    }
                } //for j
            } //if .conf
        } //for i

        if (arrayList.size() > 0) {
           int count = wireGuardService.insertList(arrayList);
           logger.info("insert " + count + "wiregurad client user\n");
        } else  {
            Asserts.fail("not find wireguard client");
            logger.info("not find wireguard client \n");
        }

    }

}
