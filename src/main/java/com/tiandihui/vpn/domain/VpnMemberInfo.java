package com.tiandihui.vpn.domain;

import com.tiandihui.vpn.mbg.model.UmsMember;
import com.tiandihui.vpn.mbg.model.UmsVpnService;
import com.tiandihui.vpn.mbg.model.UmsVpnSs;
import com.tiandihui.vpn.mbg.model.UmsVpnWireguard;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class VpnMemberInfo extends UmsMember {

    private String  token;
    private String  tokenHead;
    private   UmsVpnService vpnService;
    private List<VpnSsDetailInfo> vpnSsList;
    private List<UmsVpnWireguard>  vpnWireguardList;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenHead() {
        return tokenHead;
    }

    public void setTokenHead(String tokenHead) {
        this.tokenHead = tokenHead;
    }


    public UmsVpnService getVpnService() {
        return vpnService;
    }

    public void setVpnService(UmsVpnService vpnService) {
        this.vpnService = vpnService;
    }

    public List<VpnSsDetailInfo> getVpnSsList() {
        return vpnSsList;
    }

    public void setVpnSsList(List<VpnSsDetailInfo> vpnSsList) {
        this.vpnSsList = vpnSsList;
    }

    public List<UmsVpnWireguard> getVpnWireguardList() {
        return vpnWireguardList;
    }

    public void setVpnWireguardList(List<UmsVpnWireguard> vpnWireguardList) {
        this.vpnWireguardList = vpnWireguardList;
    }



}
