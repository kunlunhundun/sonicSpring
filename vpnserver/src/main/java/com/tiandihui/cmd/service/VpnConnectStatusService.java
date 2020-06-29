package com.tiandihui.cmd.service;

public interface VpnConnectStatusService {

    void updateVpnConnectStatus();

    /**
     * 从/etc/wireguard目录下导入.conf配置文件的用户到数据库中
     */
    void importVpnDataFromConf();

}
