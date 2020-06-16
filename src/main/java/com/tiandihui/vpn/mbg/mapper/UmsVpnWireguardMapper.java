package com.tiandihui.vpn.mbg.mapper;

import com.tiandihui.vpn.mbg.model.UmsVpnWireguard;
import com.tiandihui.vpn.mbg.model.UmsVpnWireguardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsVpnWireguardMapper {
    int countByExample(UmsVpnWireguardExample example);

    int deleteByExample(UmsVpnWireguardExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsVpnWireguard record);

    int insertSelective(UmsVpnWireguard record);

    List<UmsVpnWireguard> selectByExample(UmsVpnWireguardExample example);

    UmsVpnWireguard selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsVpnWireguard record, @Param("example") UmsVpnWireguardExample example);

    int updateByExample(@Param("record") UmsVpnWireguard record, @Param("example") UmsVpnWireguardExample example);

    int updateByPrimaryKeySelective(UmsVpnWireguard record);

    int updateByPrimaryKey(UmsVpnWireguard record);
}