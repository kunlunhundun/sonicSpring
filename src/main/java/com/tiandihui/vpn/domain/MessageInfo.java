package com.tiandihui.vpn.domain;

import com.tiandihui.vpn.mbg.model.CmsComment;
import com.tiandihui.vpn.mbg.model.CmsCommentOfficialReply;
import lombok.Data;

import java.util.List;

@Data
public class MessageInfo {

    CmsComment comment;

    List<CmsCommentOfficialReply> officialReplyList;

}
