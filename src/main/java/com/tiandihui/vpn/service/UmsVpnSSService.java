package com.tiandihui.vpn.service;

import com.tiandihui.vpn.mbg.model.UmsVpnSs;

import java.util.List;

public interface UmsVpnSSService {

    /**
     * 增加一条ss 线路
     */
    int add(UmsVpnSs vpnSs);

    /**
     * 更新一条ss 线路
     */
    int update(UmsVpnSs vpnSs);

    /**
     * 删除一条ss线路
     */

    int delete(Long id);

    /**
     * 获取所以SS 线路
     */
    List<UmsVpnSs> list(int pageNum, int pageSize);


}
