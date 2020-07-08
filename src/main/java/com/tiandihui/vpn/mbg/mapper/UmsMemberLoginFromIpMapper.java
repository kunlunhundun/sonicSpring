package com.tiandihui.vpn.mbg.mapper;

import com.tiandihui.vpn.mbg.model.UmsMemberLoginFromIp;
import com.tiandihui.vpn.mbg.model.UmsMemberLoginFromIpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsMemberLoginFromIpMapper {
    int countByExample(UmsMemberLoginFromIpExample example);

    int deleteByExample(UmsMemberLoginFromIpExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberLoginFromIp record);

    int insertSelective(UmsMemberLoginFromIp record);

    List<UmsMemberLoginFromIp> selectByExample(UmsMemberLoginFromIpExample example);

    UmsMemberLoginFromIp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsMemberLoginFromIp record, @Param("example") UmsMemberLoginFromIpExample example);

    int updateByExample(@Param("record") UmsMemberLoginFromIp record, @Param("example") UmsMemberLoginFromIpExample example);

    int updateByPrimaryKeySelective(UmsMemberLoginFromIp record);

    int updateByPrimaryKey(UmsMemberLoginFromIp record);
}