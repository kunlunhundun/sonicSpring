package com.tiandihui.vpn.mbg.mapper;

import com.tiandihui.vpn.mbg.model.UmsVpnSsProtocalType;
import com.tiandihui.vpn.mbg.model.UmsVpnSsProtocalTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsVpnSsProtocalTypeMapper {
    int countByExample(UmsVpnSsProtocalTypeExample example);

    int deleteByExample(UmsVpnSsProtocalTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UmsVpnSsProtocalType record);

    int insertSelective(UmsVpnSsProtocalType record);

    List<UmsVpnSsProtocalType> selectByExample(UmsVpnSsProtocalTypeExample example);

    UmsVpnSsProtocalType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UmsVpnSsProtocalType record, @Param("example") UmsVpnSsProtocalTypeExample example);

    int updateByExample(@Param("record") UmsVpnSsProtocalType record, @Param("example") UmsVpnSsProtocalTypeExample example);

    int updateByPrimaryKeySelective(UmsVpnSsProtocalType record);

    int updateByPrimaryKey(UmsVpnSsProtocalType record);
}