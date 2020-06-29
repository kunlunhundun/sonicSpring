package com.tiandihui.vpn.mbg.mapper;

import com.tiandihui.vpn.mbg.model.UmsMemberFilterApp;
import com.tiandihui.vpn.mbg.model.UmsMemberFilterAppExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsMemberFilterAppMapper {
    int countByExample(UmsMemberFilterAppExample example);

    int deleteByExample(UmsMemberFilterAppExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberFilterApp record);

    int insertSelective(UmsMemberFilterApp record);

    List<UmsMemberFilterApp> selectByExample(UmsMemberFilterAppExample example);

    UmsMemberFilterApp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsMemberFilterApp record, @Param("example") UmsMemberFilterAppExample example);

    int updateByExample(@Param("record") UmsMemberFilterApp record, @Param("example") UmsMemberFilterAppExample example);

    int updateByPrimaryKeySelective(UmsMemberFilterApp record);

    int updateByPrimaryKey(UmsMemberFilterApp record);
}