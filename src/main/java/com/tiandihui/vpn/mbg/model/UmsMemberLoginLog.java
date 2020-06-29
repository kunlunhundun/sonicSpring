package com.tiandihui.vpn.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class UmsMemberLoginLog implements Serializable {
    private Long id;

    private String username;

    private Long memberId;

    private Date createTime;

    @ApiModelProperty(value = "用户登录的目标IP")
    private String fromIp;

    @ApiModelProperty(value = "用户IP归属地")
    private String ipLocation;

    @ApiModelProperty(value = "连接选择的服务器ip")
    private String serviceIp;

    private String city;

    @ApiModelProperty(value = "用户的设备ID")
    private String deviceId;

    @ApiModelProperty(value = "登录类型：0->PC；1->android;2->ios;")
    private Integer loginType;

    private String loginMac;

    private String loginUid;

    @ApiModelProperty(value = "开始连接时间")
    private Date connectTime;

    @ApiModelProperty(value = "断开时间")
    private Date disconnectTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFromIp() {
        return fromIp;
    }

    public void setFromIp(String fromIp) {
        this.fromIp = fromIp;
    }

    public String getIpLocation() {
        return ipLocation;
    }

    public void setIpLocation(String ipLocation) {
        this.ipLocation = ipLocation;
    }

    public String getServiceIp() {
        return serviceIp;
    }

    public void setServiceIp(String serviceIp) {
        this.serviceIp = serviceIp;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getLoginType() {
        return loginType;
    }

    public void setLoginType(Integer loginType) {
        this.loginType = loginType;
    }

    public String getLoginMac() {
        return loginMac;
    }

    public void setLoginMac(String loginMac) {
        this.loginMac = loginMac;
    }

    public String getLoginUid() {
        return loginUid;
    }

    public void setLoginUid(String loginUid) {
        this.loginUid = loginUid;
    }

    public Date getConnectTime() {
        return connectTime;
    }

    public void setConnectTime(Date connectTime) {
        this.connectTime = connectTime;
    }

    public Date getDisconnectTime() {
        return disconnectTime;
    }

    public void setDisconnectTime(Date disconnectTime) {
        this.disconnectTime = disconnectTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", memberId=").append(memberId);
        sb.append(", createTime=").append(createTime);
        sb.append(", fromIp=").append(fromIp);
        sb.append(", ipLocation=").append(ipLocation);
        sb.append(", serviceIp=").append(serviceIp);
        sb.append(", city=").append(city);
        sb.append(", deviceId=").append(deviceId);
        sb.append(", loginType=").append(loginType);
        sb.append(", loginMac=").append(loginMac);
        sb.append(", loginUid=").append(loginUid);
        sb.append(", connectTime=").append(connectTime);
        sb.append(", disconnectTime=").append(disconnectTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}