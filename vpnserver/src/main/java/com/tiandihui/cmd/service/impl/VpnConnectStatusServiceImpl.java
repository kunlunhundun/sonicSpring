package com.tiandihui.cmd.service.impl;

import com.tiandihui.cmd.common.javashell.ExecuteResult;
import com.tiandihui.cmd.common.javashell.LocalCommandExecutor;
import com.tiandihui.cmd.common.utils.RootShell;
import com.tiandihui.cmd.common.utils.StringUtils;
import com.tiandihui.cmd.service.VpnConnectStatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class VpnConnectStatusServiceImpl implements VpnConnectStatusService {

    public static final int ERROR = 0x0;
    public static final int MAGISK = 0x4;
    public static final int YES = 0x1;

    @Autowired
    private LocalCommandExecutor localCommandExecutor;

    private Logger logger = LoggerFactory.getLogger(getClass());//提供日志类

    @Override
    public void updateVpnConnectStatus() {

       // String filePath = getClass().getResource("/").getPath() + "test.sh";
       // ExecuteResult executeResult = localCommandExecutor.executeCommand(filePath, 1000);
        ExecuteResult  executeResult = localCommandExecutor.executeCommand("wg  ",10000);
        String content = executeResult.getExecuteOut();
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
                if (startPeerFlag == true) {
                    map.put(lineArr[0],lineArr[1]);
                }
            }
        }

        logger.info("arraylist：\n" + arrayList.toString());

    }
}
