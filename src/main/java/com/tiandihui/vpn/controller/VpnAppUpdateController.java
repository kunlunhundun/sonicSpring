package com.tiandihui.vpn.controller;

import com.tiandihui.vpn.common.api.CommonResult;
import com.tiandihui.vpn.service.VpnAppUpdateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@Api(tags = "VpnAppUpdateController", description = "客户端升级管理")
@RequestMapping("/update")
public class VpnAppUpdateController {

    @Autowired
    VpnAppUpdateService appUpdateService;

    @ApiOperation("添加新版本号")
    @RequestMapping(value = "/addNewVersion", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public CommonResult addNewVersion(@RequestParam String fileName,
                                      @RequestParam String appName,
                                      @RequestParam String v,
                                      @RequestParam String isMustUpdate,
                                      @RequestParam String platform ) {

        int result = appUpdateService.addNewVersion(fileName,appName,v,isMustUpdate,platform);
        if (result == 0) {
            return CommonResult.success(null, "添加版本失败");
        }
        return CommonResult.success(null, "添加版本成功");
    }

    @ApiOperation("检查版本号")
    @RequestMapping(value = "/checkVersion", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public CommonResult checkVersion(@RequestParam String v,
                                      @RequestParam String platform ) {

        Map<String, Object> resultMap = appUpdateService.checkVersion(v,platform);

        return CommonResult.success(resultMap, "成功");
    }


}
