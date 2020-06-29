package com.tiandihui.vpn.mbg.mapper;

import com.tiandihui.vpn.mbg.model.CmsCommentOfficialReply;
import com.tiandihui.vpn.mbg.model.CmsCommentOfficialReplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsCommentOfficialReplyMapper {
    int countByExample(CmsCommentOfficialReplyExample example);

    int deleteByExample(CmsCommentOfficialReplyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsCommentOfficialReply record);

    int insertSelective(CmsCommentOfficialReply record);

    List<CmsCommentOfficialReply> selectByExample(CmsCommentOfficialReplyExample example);

    CmsCommentOfficialReply selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsCommentOfficialReply record, @Param("example") CmsCommentOfficialReplyExample example);

    int updateByExample(@Param("record") CmsCommentOfficialReply record, @Param("example") CmsCommentOfficialReplyExample example);

    int updateByPrimaryKeySelective(CmsCommentOfficialReply record);

    int updateByPrimaryKey(CmsCommentOfficialReply record);
}