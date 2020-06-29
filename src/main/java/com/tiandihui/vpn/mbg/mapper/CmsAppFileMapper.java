package com.tiandihui.vpn.mbg.mapper;

import com.tiandihui.vpn.mbg.model.CmsAppFile;
import com.tiandihui.vpn.mbg.model.CmsAppFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsAppFileMapper {
    int countByExample(CmsAppFileExample example);

    int deleteByExample(CmsAppFileExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsAppFile record);

    int insertSelective(CmsAppFile record);

    List<CmsAppFile> selectByExample(CmsAppFileExample example);

    CmsAppFile selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsAppFile record, @Param("example") CmsAppFileExample example);

    int updateByExample(@Param("record") CmsAppFile record, @Param("example") CmsAppFileExample example);

    int updateByPrimaryKeySelective(CmsAppFile record);

    int updateByPrimaryKey(CmsAppFile record);
}