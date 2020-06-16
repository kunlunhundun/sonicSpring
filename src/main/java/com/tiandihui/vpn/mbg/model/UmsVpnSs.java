package com.tiandihui.vpn.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class UmsVpnSs implements Serializable {
    private Long id;

    @ApiModelProperty(value = "线路名称")
    private String lineName;

    @ApiModelProperty(value = "这条vpn是否被使用0->未使用1->使用")
    private Integer useStatus;

    @ApiModelProperty(value = "删除状态：0->未删除；1->已删除")
    private Integer deleteStatus;

    @ApiModelProperty(value = "服务器id")
    private Long serviceId;

    @ApiModelProperty(value = "服务器ip")
    private String ip;

    @ApiModelProperty(value = "服务器端口")
    private String port;

    @ApiModelProperty(value = "ssl 密码")
    private String password;

    @ApiModelProperty(value = "加密类型")
    private Integer encriptionTypeId;

    @ApiModelProperty(value = "协议类型")
    private Integer protocalTypeId;

    private String protocalParam;

    @ApiModelProperty(value = "混淆")
    private Integer obfsId;

    @ApiModelProperty(value = "混淆参数")
    private String cofusedParam;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
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

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEncriptionTypeId() {
        return encriptionTypeId;
    }

    public void setEncriptionTypeId(Integer encriptionTypeId) {
        this.encriptionTypeId = encriptionTypeId;
    }

    public Integer getProtocalTypeId() {
        return protocalTypeId;
    }

    public void setProtocalTypeId(Integer protocalTypeId) {
        this.protocalTypeId = protocalTypeId;
    }

    public String getProtocalParam() {
        return protocalParam;
    }

    public void setProtocalParam(String protocalParam) {
        this.protocalParam = protocalParam;
    }

    public Integer getObfsId() {
        return obfsId;
    }

    public void setObfsId(Integer obfsId) {
        this.obfsId = obfsId;
    }

    public String getCofusedParam() {
        return cofusedParam;
    }

    public void setCofusedParam(String cofusedParam) {
        this.cofusedParam = cofusedParam;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", lineName=").append(lineName);
        sb.append(", useStatus=").append(useStatus);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", serviceId=").append(serviceId);
        sb.append(", ip=").append(ip);
        sb.append(", port=").append(port);
        sb.append(", password=").append(password);
        sb.append(", encriptionTypeId=").append(encriptionTypeId);
        sb.append(", protocalTypeId=").append(protocalTypeId);
        sb.append(", protocalParam=").append(protocalParam);
        sb.append(", obfsId=").append(obfsId);
        sb.append(", cofusedParam=").append(cofusedParam);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}