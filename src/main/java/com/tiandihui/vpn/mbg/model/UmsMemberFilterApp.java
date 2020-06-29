package com.tiandihui.vpn.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class UmsMemberFilterApp implements Serializable {
    private Long id;

    private String username;

    private Long memberId;

    private Date createTime;

    @ApiModelProperty(value = "过滤app->1:不过滤->2:不允许哪些app->3允许哪些APP用{'type':'1','app':[',']}")
    private String filterApp;

    @ApiModelProperty(value = "登录类型：0->PC；1->android;2->ios;")
    private Integer loginType;

    private String loginMac;

    @ApiModelProperty(value = "用户登录的设备唯一号")
    private String deviceId;

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

    public String getFilterApp() {
        return filterApp;
    }

    public void setFilterApp(String filterApp) {
        this.filterApp = filterApp;
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

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
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
        sb.append(", filterApp=").append(filterApp);
        sb.append(", loginType=").append(loginType);
        sb.append(", loginMac=").append(loginMac);
        sb.append(", deviceId=").append(deviceId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}