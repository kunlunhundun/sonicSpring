package com.tiandihui.vpn.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class UmsMemberDeviceId implements Serializable {
    private Long id;

    private String deviceId;

    private Long memberId;

    private String username;

    @ApiModelProperty(value = "设备品牌名称")
    private String devicebrand;

    @ApiModelProperty(value = "登录类型：0->PC；1->android；->ios；")
    private Integer platform;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDevicebrand() {
        return devicebrand;
    }

    public void setDevicebrand(String devicebrand) {
        this.devicebrand = devicebrand;
    }

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", deviceId=").append(deviceId);
        sb.append(", memberId=").append(memberId);
        sb.append(", username=").append(username);
        sb.append(", devicebrand=").append(devicebrand);
        sb.append(", platform=").append(platform);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}