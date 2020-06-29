package com.tiandihui.vpn.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class CmsAppFile implements Serializable {
    private Long id;

    @ApiModelProperty(value = "app名字")
    private String appName;

    @ApiModelProperty(value = "apk地址")
    private String appAddress;

    @ApiModelProperty(value = "app版本号")
    private String v;

    @ApiModelProperty(value = "0->正常更新1->强制更新")
    private Integer isMustUpdate;

    private Date createTime;

    @ApiModelProperty(value = "0->android1->ios2->pc")
    private Integer platform;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppAddress() {
        return appAddress;
    }

    public void setAppAddress(String appAddress) {
        this.appAddress = appAddress;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public Integer getIsMustUpdate() {
        return isMustUpdate;
    }

    public void setIsMustUpdate(Integer isMustUpdate) {
        this.isMustUpdate = isMustUpdate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
        sb.append(", appName=").append(appName);
        sb.append(", appAddress=").append(appAddress);
        sb.append(", v=").append(v);
        sb.append(", isMustUpdate=").append(isMustUpdate);
        sb.append(", createTime=").append(createTime);
        sb.append(", platform=").append(platform);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}