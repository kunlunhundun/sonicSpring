package com.tiandihui.cmd.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cmd")
public class CmdController {

    @RequestMapping(value = "/cmd", method = RequestMethod.POST)
    @ResponseBody
    public String sendCmd(@RequestParam String cmd) {

        return "下单成功";
    }

}
