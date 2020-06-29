package com.tiandihui.vpn.controller;

import com.google.common.collect.ImmutableBiMap;
import com.tiandihui.vpn.common.api.CommonResult;
import com.tiandihui.vpn.domain.VpnMemberInfo;
import com.tiandihui.vpn.mbg.model.UmsVpnSs;
import com.tiandihui.vpn.mbg.model.UmsVpnWireguard;
import com.tiandihui.vpn.service.UmsMemberService;
import com.tiandihui.vpn.service.UmsVpnMachinesService;
import com.tiandihui.vpn.service.UmsVpnSSService;
import com.tiandihui.vpn.service.UmsVpnWireguardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(tags = "VpnMemberInfoController", description = "vpn信息管理")
@RequestMapping("/vpnInfo")
public class VpnMemberInfoController {

    @Autowired
    UmsVpnSSService ssService;

    @Autowired
    UmsVpnWireguardService wireguardService;

    @Autowired
    UmsMemberService memberService;

    //每台机器的vpn 用户名
    @Autowired
    UmsVpnMachinesService machinesService;

    @ApiOperation("获取所有ss线路")
    @RequestMapping(value = "/getLineSS",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public CommonResult getLineSS(@RequestParam String username) {

      List<UmsVpnSs> vpnSsList = ssService.list(1, 10);
      Map<String,Object> map = new HashMap<>();
      map.put("wireguardList",vpnSsList);
      return  CommonResult.success(map);
    }

    @ApiOperation("获取所有wireguard线路")
    @RequestMapping(value = "/getLineWireguard",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public CommonResult getLineWireguard(@RequestParam String username) {
       // List<UmsVpnWireguard> wireguardList = wireguardService.list(1,10);
        List<Map<String,Object>> wireguardMap = machinesService.getWireGuardLine();
        Map<String,Object> map = new HashMap<>();
        map.put("wireguardList",wireguardMap);
        return  CommonResult.success(map);
    }


    @ApiOperation("获取vpn列表信息")
    @RequestMapping(value = "/allVpnLine",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public CommonResult vpnListInfo(@RequestParam String userName) {
        VpnMemberInfo memberInfo = memberService.getMemberInfo();
        // UmsMember member = memberService.getCurrentMember();
        return CommonResult.success(memberInfo);
    }


    @ApiOperation("vpn连接成功")
    @RequestMapping(value = "/connected",method = {RequestMethod.GET,RequestMethod.POST})
    @ApiImplicitParam(name = "connectType", value = "1->ss；2->wireguard;3->openvpn",
            defaultValue = "1", allowableValues = "1,2,3",  dataType = "integer")
    @ResponseBody
    public CommonResult connected(@RequestParam(value = "connectType", defaultValue = "1") Integer connectType,
                                         @RequestParam String id, @RequestParam String serviceId) {

       int ret = memberService.connected(connectType, Long.valueOf(id));
        if (ret >= 0) {
            return  CommonResult.success(ret);
        }
        return  CommonResult.failed();
    }


    @ApiOperation("vpn断开成功")
    @RequestMapping(value = "/disConnect",method = {RequestMethod.GET,RequestMethod.POST})
    @ApiImplicitParam(name = "connectType", value = "1->ss；2->wireguard;3->openvpn",
            defaultValue = "1", allowableValues = "1,2,3",  dataType = "integer")
    @ResponseBody
    public CommonResult disConnect(@RequestParam(value = "connectType", defaultValue = "1") Integer connectType,
                                  @RequestParam String id, @RequestParam String serviceId) {

        int ret = memberService.disConnect(connectType,Long.valueOf(id));
        if (ret >= 0) {
            return  CommonResult.success(ret);
        }
        return  CommonResult.failed();
    }


}
