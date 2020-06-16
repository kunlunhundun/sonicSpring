package com.tiandihui.vpn.mbg.mapper;

import com.tiandihui.vpn.mbg.model.UmsVpnSsObfs;
import com.tiandihui.vpn.mbg.model.UmsVpnSsObfsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsVpnSsObfsMapper {
    int countByExample(UmsVpnSsObfsExample example);

    int deleteByExample(UmsVpnSsObfsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UmsVpnSsObfs record);

    int insertSelective(UmsVpnSsObfs record);

    List<UmsVpnSsObfs> selectByExample(UmsVpnSsObfsExample example);

    UmsVpnSsObfs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UmsVpnSsObfs record, @Param("example") UmsVpnSsObfsExample example);

    int updateByExample(@Param("record") UmsVpnSsObfs record, @Param("example") UmsVpnSsObfsExample example);

    int updateByPrimaryKeySelective(UmsVpnSsObfs record);

    int updateByPrimaryKey(UmsVpnSsObfs record);
}