package com.tiandihui.vpn.service;

import com.tiandihui.vpn.mbg.model.UmsVpnWireguard;

import java.util.List;

public interface UmsVpnWireguardService {


    /**
     * 增加一条wireguard 线路
     */
    int add(UmsVpnWireguard vpnWireguard);

    /**
     * 更新一条ss 线路
     */
    int update(UmsVpnWireguard vpnWireguard);

    /**
     * 定时更新vpn 的状态
     * @return
     */
    int updateConnectStatus();

    /**
     * 删除一条ss线路
     */

    int delete(Long id);

    /**
     * 获取所以SS 线路
     */
    List<UmsVpnWireguard> list(int pageNum, int pageSize);


}
