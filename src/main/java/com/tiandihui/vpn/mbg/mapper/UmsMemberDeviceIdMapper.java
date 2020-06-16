package com.tiandihui.vpn.mbg.mapper;

import com.tiandihui.vpn.mbg.model.UmsMemberDeviceId;
import com.tiandihui.vpn.mbg.model.UmsMemberDeviceIdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsMemberDeviceIdMapper {
    int countByExample(UmsMemberDeviceIdExample example);

    int deleteByExample(UmsMemberDeviceIdExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberDeviceId record);

    int insertSelective(UmsMemberDeviceId record);

    List<UmsMemberDeviceId> selectByExample(UmsMemberDeviceIdExample example);

    UmsMemberDeviceId selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsMemberDeviceId record, @Param("example") UmsMemberDeviceIdExample example);

    int updateByExample(@Param("record") UmsMemberDeviceId record, @Param("example") UmsMemberDeviceIdExample example);

    int updateByPrimaryKeySelective(UmsMemberDeviceId record);

    int updateByPrimaryKey(UmsMemberDeviceId record);
}