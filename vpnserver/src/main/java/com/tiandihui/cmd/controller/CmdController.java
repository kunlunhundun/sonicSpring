package com.tiandihui.cmd.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tiandihui.cmd.service.VpnConnectStatusService;
import com.tiandihui.cmd.service.WireGuardService;

@Api(tags = "CmdController", description = "vpn服务管理")
@Controller
@RequestMapping("/cmd")
public class CmdController {

    @Autowired
    WireGuardService wireGuardService;
    @Autowired
    VpnConnectStatusService vpnConnectStatusService;

    @ApiOperation("导入服务，生成vpnservice 数据库")
    @RequestMapping(value = "/importService", method = RequestMethod.GET)
    @ResponseBody
    public String generateService(@RequestParam String ip, @RequestParam String lineName) {

        int result = wireGuardService.importVpnService(ip,lineName);
        if (result == 0) {
            return  "导入失败";
        }
        return "导入成功";
    }

    @ApiOperation("导入所有的用户peers 从.conf文件中 到数据库wireguard数据库中")
    @RequestMapping(value = "/importAllPeers", method = RequestMethod.GET)
    @ResponseBody
    public String importAllConf() {

         vpnConnectStatusService.importVpnDataFromConf();
        return "导入成功";
    }

}
