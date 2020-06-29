package com.tiandihui.cmd.service;

import com.tiandihui.cmd.mbg.model.UmsVpnWireguard;

import java.util.List;

public interface WireGuardService {


    /**
     * 通过ip 和线路名写入到ums_vpn_service数据库中
     * @param ip
     * @param lineName
     * @return
     */

    int importVpnService(String ip, String lineName);


    String getServiceId();

    String getVpnServiceId(String ip);

    /**
     * 批量插入数据库
     */
    int insertList(List<UmsVpnWireguard> wireguardList);
    /**
     * 增加一条wireguard 线路
     */
    int add(UmsVpnWireguard vpnWireguard);

    /**
     * 更新一条ss 线路
     */
    int update(UmsVpnWireguard vpnWireguard);

    /**
     * 删除一条ss线路
     */

    int delete(Long id);


}
