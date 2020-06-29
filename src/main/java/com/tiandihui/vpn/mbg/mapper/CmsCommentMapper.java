package com.tiandihui.vpn.mbg.mapper;

import com.tiandihui.vpn.mbg.model.CmsComment;
import com.tiandihui.vpn.mbg.model.CmsCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsCommentMapper {
    int countByExample(CmsCommentExample example);

    int deleteByExample(CmsCommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsComment record);

    int insertSelective(CmsComment record);

    List<CmsComment> selectByExample(CmsCommentExample example);

    CmsComment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsComment record, @Param("example") CmsCommentExample example);

    int updateByExample(@Param("record") CmsComment record, @Param("example") CmsCommentExample example);

    int updateByPrimaryKeySelective(CmsComment record);

    int updateByPrimaryKey(CmsComment record);
}