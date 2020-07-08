package com.tiandihui.vpn.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface VpnAppUpdateService {


    /**
     * 检查版本是否需要升级
     */
    Map<String, Object> checkVersion(String v, String platform);

    /**
     * 把上传好的地址 以及版本的需求写入到数据库中
     */

    int addNewVersion(String fileName, String appName, String v, String isMustUpdate, String platform );

}
