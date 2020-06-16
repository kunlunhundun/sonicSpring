package com.tiandihui.vpn.mbg.mapper;

import com.tiandihui.vpn.mbg.model.UmsVpnSsEncriptionType;
import com.tiandihui.vpn.mbg.model.UmsVpnSsEncriptionTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsVpnSsEncriptionTypeMapper {
    int countByExample(UmsVpnSsEncriptionTypeExample example);

    int deleteByExample(UmsVpnSsEncriptionTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UmsVpnSsEncriptionType record);

    int insertSelective(UmsVpnSsEncriptionType record);

    List<UmsVpnSsEncriptionType> selectByExample(UmsVpnSsEncriptionTypeExample example);

    UmsVpnSsEncriptionType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UmsVpnSsEncriptionType record, @Param("example") UmsVpnSsEncriptionTypeExample example);

    int updateByExample(@Param("record") UmsVpnSsEncriptionType record, @Param("example") UmsVpnSsEncriptionTypeExample example);

    int updateByPrimaryKeySelective(UmsVpnSsEncriptionType record);

    int updateByPrimaryKey(UmsVpnSsEncriptionType record);
}