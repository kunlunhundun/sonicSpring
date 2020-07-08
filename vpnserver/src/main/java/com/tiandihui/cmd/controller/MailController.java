package com.tiandihui.cmd.controller;

import com.tiandihui.cmd.common.api.CommonResult;
import com.tiandihui.cmd.service.MailService;
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
    @RequestMapping(value = "/generateCode", method = { RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public CommonResult generateCode(@RequestParam String username, @RequestParam int use) {

        mailService.generateCode(username,use);
        return CommonResult.success(null, "验证码发送成功");
    }

   /* @ApiImplicitParam(name = "use", value = "1->register；2->forgetpassword;",
            defaultValue = "1", allowableValues = "1,2",  dataType = "integer") */

}
