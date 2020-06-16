package com.tiandihui.vpn.controller;

import com.tiandihui.vpn.common.api.CommonResult;
import com.tiandihui.vpn.domain.LoginRquestParam;
import com.tiandihui.vpn.domain.LoginSuccessInfo;
import com.tiandihui.vpn.domain.VpnMemberInfo;
import com.tiandihui.vpn.domain.VpnSsDetailInfo;
import com.tiandihui.vpn.mbg.mapper.UmsVpnSsEncriptionTypeMapper;
import com.tiandihui.vpn.mbg.mapper.UmsVpnSsObfsMapper;
import com.tiandihui.vpn.mbg.mapper.UmsVpnSsProtocalTypeMapper;
import com.tiandihui.vpn.mbg.model.*;
import com.tiandihui.vpn.service.UmsMemberService;
import com.tiandihui.vpn.service.UmsVpnMachinesService;
import com.tiandihui.vpn.service.UmsVpnSSService;
import com.tiandihui.vpn.service.UmsVpnWireguardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.rmi.CORBA.Util;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@Api(tags = "VpnMemberController", description = "会员登录注册管理")
@RequestMapping("/sso")
public class VpnMemberController {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private UmsMemberService memberService;


    @ApiOperation("会员注册")
    @RequestMapping(value = "/registerByTelPhone",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public CommonResult registerByPhone(@RequestParam String username,
                                 @RequestParam String password,
                                 @RequestParam String telphone,
                                 @RequestParam String authCode) {
        memberService.registerByPhone(username,password,telphone,authCode);
        return CommonResult.success(null,"注册成功");
    }

    @ApiOperation("会员注册")
    @RequestMapping(value = "/register",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public CommonResult register(@RequestBody LoginRquestParam requestParam) {
        LoginSuccessInfo successInfo = memberService.register(requestParam.getUsername(),requestParam.getPassword()
                ,requestParam.getDeviceId(),requestParam.getDeviceBrand());
        successInfo.setTokenHead(tokenHead);

        return CommonResult.success(successInfo);
    }


    @ApiOperation("会员登录")
    @RequestMapping(value = "/login", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public CommonResult login(@RequestBody LoginRquestParam requestParam) {
        LoginSuccessInfo successInfo =  memberService.login(requestParam.getUsername(),requestParam.getPassword());
        if (successInfo == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        successInfo.setTokenHead(tokenHead);

       // VpnMemberInfo memberInfo = memberService.getMemberInfo();
        //memberInfo.setTokenHead(tokenHead);
        //successInfo
        return CommonResult.success(successInfo);
    }

    @ApiOperation("会员登录")
    @RequestMapping(value = "/loginByToken", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public CommonResult loginByToken(@RequestParam String username,
                              @RequestParam String loginToken) {
        LoginSuccessInfo successInfo =  memberService.loginByToken(username,loginToken);
        if (successInfo == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        successInfo.setTokenHead(tokenHead);

        return CommonResult.success(successInfo);
    }


    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getAuthCode", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public CommonResult getAuthCode(@RequestParam String telphone) {

        String authCode = memberService.generateAuthCode(telphone);
        return  CommonResult.success(authCode);
    }

    @ApiOperation("更新密码")
    @RequestMapping(value = "/updatePassword",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public CommonResult updatePassword(@RequestParam String telephone, @RequestParam String password,
                                       @RequestParam String authCode) {
        memberService.updatePassword(telephone,password,authCode);
        return CommonResult.success("更新成功");
    }

    @ApiOperation("更新密码")
    @RequestMapping(value = "/updatePasswordByOldPassword", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public CommonResult updatePasswordByOldPassword(@RequestParam String username, @RequestParam String oldPassword,
                                                    @RequestParam String newPassword) {
        memberService.updatePasswordByOldPassword(username,oldPassword ,newPassword);
        return CommonResult.success("更新成功");
    }


}
