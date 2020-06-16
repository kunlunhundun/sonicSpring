package com.tiandihui.vpn.service;

import com.tiandihui.vpn.mbg.model.UmsVpnService;
import com.tiandihui.vpn.mbg.model.UmsVpnSs;

import java.util.List;
import java.util.Map;

public interface UmsVpnMachinesService {

    /**
     * 添加一台主机
     * @param vpnService
     * @return
     */
    int add(UmsVpnService vpnService);

    /**
     * 更新主机
     */
    int update(UmsVpnService vpnService);

    /**
     * 删除一台主机
     */
    int delete(UmsVpnService vpnService);


    /**
     * 获取一组组线路下的vpn数据
     */
    List<Map<String,Object>> getWireGuardLine();

}
