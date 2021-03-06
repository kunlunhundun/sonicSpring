package com.tiandihui.vpn.controller;

import com.tiandihui.vpn.common.api.CommonResult;
import com.tiandihui.vpn.common.api.ResultCode;
import com.tiandihui.vpn.domain.LoginRquestParam;
import com.tiandihui.vpn.domain.LoginSuccessInfo;
import com.tiandihui.vpn.service.UmsMemberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


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
    @RequestMapping(value = "/registerByTelePhone", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public CommonResult registerByPhone(@RequestParam String username,
                                        @RequestParam String password,
                                        @RequestParam String telphone,
                                        @RequestParam String authCode) {
        memberService.registerByPhone(username, password, telphone, authCode);
        return CommonResult.success(null, "register is success");
    }

    @ApiOperation("会员注册")
    @RequestMapping(value = "/register", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public CommonResult register(@RequestBody LoginRquestParam requestParam) {
        LoginSuccessInfo successInfo = memberService.register(requestParam.getUsername(), requestParam.getPassword()
                , requestParam.getCode(), requestParam.getDeviceId(), requestParam.getDeviceBrand());
        successInfo.setTokenHead(tokenHead);
        String username = requestParam.getUsername();
        memberService.recLoginLog(username);
        return CommonResult.success(successInfo);
    }

    @ApiOperation("facebook登录")
    @RequestMapping(value = "/loginByFacebook", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public CommonResult loginByFacebook(@RequestParam String username) {
        LoginSuccessInfo successInfo = memberService.loginByFacebook(username);
        successInfo.setTokenHead(tokenHead);
        memberService.recLoginLog(username);
        return CommonResult.success(successInfo);
    }


    @ApiOperation("会员登录")
    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public CommonResult login(HttpServletRequest request, @RequestBody LoginRquestParam requestParam) {
        LoginSuccessInfo successInfo = memberService.login(requestParam.getUsername(), requestParam.getPassword());
        if (successInfo == null) {
            return CommonResult.validateFailed("the username is not exist or password is not correct");
        }
        successInfo.setTokenHead(tokenHead);
        String username = requestParam.getUsername();
        memberService.recLoginLog(username);

        return CommonResult.success(successInfo);
    }

    @ApiOperation("会员登录")
    @RequestMapping(value = "/loginByToken", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public CommonResult loginByToken(@RequestParam String username,
                                     @RequestParam String loginToken) {
        LoginSuccessInfo successInfo = memberService.loginByToken(username, loginToken);
        if (successInfo == null) {
            return CommonResult.failedResult(ResultCode.RELOGINAGAIN);
        }
        successInfo.setTokenHead(tokenHead);
        memberService.recLoginLog(username);
        return CommonResult.success(successInfo);
    }

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getAuthCode", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public CommonResult getAuthCode(@RequestParam String telphone) {

        String authCode = memberService.generateAuthCode(telphone);
        return CommonResult.success(authCode);
    }

    @ApiOperation("更新密码")
    @RequestMapping(value = "/updatePassword", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public CommonResult updatePassword(@RequestParam String username, @RequestParam String password,
                                       @RequestParam String code) {
        memberService.updatePassword(username, password, code);
        return CommonResult.success("reset success");
    }

    @ApiOperation("更新密码")
    @RequestMapping(value = "/updatePasswordByOldPassword", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public CommonResult updatePasswordByOldPassword(@RequestParam String username, @RequestParam String oldPassword,
                                                    @RequestParam String newPassword) {

        memberService.updatePasswordByOldPassword(username, oldPassword, newPassword);
        return CommonResult.success("reset success");
    }


}
