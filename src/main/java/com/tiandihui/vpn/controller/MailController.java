package com.tiandihui.vpn.controller;

import com.tiandihui.vpn.common.api.CommonResult;
import com.tiandihui.vpn.domain.MailInfo;
import com.tiandihui.vpn.domain.OrderParam;
import com.tiandihui.vpn.service.MailService;
import io.swagger.annotations.Api;
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

    @ApiOperation("根据购物车信息生成订单")
    @RequestMapping(value = "/generateOrder", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult sendEmail(@RequestParam String username) {

        MailInfo mailInfo = new MailInfo();
        mailInfo.setTo(username);
        MailInfo result = mailService.sendMail(mailInfo);
        return CommonResult.success(result, "下单成功");
    }


}
