package com.tiandihui.vpn.mbg.mapper;

import com.tiandihui.vpn.mbg.model.UmsVpnService;
import com.tiandihui.vpn.mbg.model.UmsVpnServiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsVpnServiceMapper {
    int countByExample(UmsVpnServiceExample example);

    int deleteByExample(UmsVpnServiceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsVpnService record);

    int insertSelective(UmsVpnService record);

    List<UmsVpnService> selectByExample(UmsVpnServiceExample example);

    UmsVpnService selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsVpnService record, @Param("example") UmsVpnServiceExample example);

    int updateByExample(@Param("record") UmsVpnService record, @Param("example") UmsVpnServiceExample example);

    int updateByPrimaryKeySelective(UmsVpnService record);

    int updateByPrimaryKey(UmsVpnService record);
}