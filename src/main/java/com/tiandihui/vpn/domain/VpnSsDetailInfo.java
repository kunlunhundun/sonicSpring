package com.tiandihui.vpn.domain;

import com.tiandihui.vpn.mbg.model.UmsVpnSs;

public class VpnSsDetailInfo extends UmsVpnSs {

    private String encriptionType;

    private String protocolType;

    private String obfsType;

    public String getEncriptionType() {
        return encriptionType;
    }

    public void setEncriptionType(String encriptionType) {
        this.encriptionType = encriptionType;
    }

    public String getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(String protocolType) {
        this.protocolType = protocolType;
    }

    public String getObfsType() {
        return obfsType;
    }

    public void setObfsType(String obfsType) {
        this.obfsType = obfsType;
    }

}
