package com.tiandihui.vpn.controller;

import com.tiandihui.vpn.common.api.CommonResult;
import com.tiandihui.vpn.common.api.ResultCode;
import com.tiandihui.vpn.domain.MailInfo;
import com.tiandihui.vpn.domain.OrderParam;
import com.tiandihui.vpn.service.MailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@Api(tags = "MailController", description = "订单管理")
@RequestMapping("/mail")
public class MailController {

    @Autowired
    MailService mailService;

    @ApiOperation("通过邮件获取验证码")
    @RequestMapping(value = "/sendCode", method = { RequestMethod.POST, RequestMethod.GET})
    @ApiImplicitParam(name = "use", value = "1->register；2->forgetpassword;",
            defaultValue = "1", allowableValues = "1,2",  dataType = "integer")
    @ResponseBody
    public CommonResult sendEmail(@RequestParam String username, @RequestParam int use) {

      //  MailInfo mailInfo = new MailInfo();
       // mailInfo.setTo(username);
        mailService.generateCode(username,use);
        return CommonResult.success(ResultCode.SENDCODESUCCESS);
    }


}
