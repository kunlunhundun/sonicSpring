package com.tiandihui.vpn.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class UmsVpnWireguard implements Serializable {
    private Long id;

    @ApiModelProperty(value = "这条vpn是否被使用0->未使用1->使用")
    private Integer useStatus;

    @ApiModelProperty(value = "删除状态：0->未删除；1->已删除")
    private Integer deleteStatus;

    @ApiModelProperty(value = "线路名称")
    private String lineName;

    @ApiModelProperty(value = "服务器id")
    private Long serviceId;

    @ApiModelProperty(value = "私钥")
    private String privatekey;

    private String address;

    private String dns;

    private String mtu;

    private String publickey;

    private String endpoint;

    private String allowedIps;

    private Long persistentKeepalive;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(Integer useStatus) {
        this.useStatus = useStatus;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getPrivatekey() {
        return privatekey;
    }

    public void setPrivatekey(String privatekey) {
        this.privatekey = privatekey;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDns() {
        return dns;
    }

    public void setDns(String dns) {
        this.dns = dns;
    }

    public String getMtu() {
        return mtu;
    }

    public void setMtu(String mtu) {
        this.mtu = mtu;
    }

    public String getPublickey() {
        return publickey;
    }

    public void setPublickey(String publickey) {
        this.publickey = publickey;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAllowedIps() {
        return allowedIps;
    }

    public void setAllowedIps(String allowedIps) {
        this.allowedIps = allowedIps;
    }

    public Long getPersistentKeepalive() {
        return persistentKeepalive;
    }

    public void setPersistentKeepalive(Long persistentKeepalive) {
        this.persistentKeepalive = persistentKeepalive;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", useStatus=").append(useStatus);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", lineName=").append(lineName);
        sb.append(", serviceId=").append(serviceId);
        sb.append(", privatekey=").append(privatekey);
        sb.append(", address=").append(address);
        sb.append(", dns=").append(dns);
        sb.append(", mtu=").append(mtu);
        sb.append(", publickey=").append(publickey);
        sb.append(", endpoint=").append(endpoint);
        sb.append(", allowedIps=").append(allowedIps);
        sb.append(", persistentKeepalive=").append(persistentKeepalive);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}