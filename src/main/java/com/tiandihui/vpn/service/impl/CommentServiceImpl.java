package com.tiandihui.vpn.service.impl;

import com.github.pagehelper.PageHelper;
import com.tiandihui.vpn.common.api.ResultCode;
import com.tiandihui.vpn.common.exception.Asserts;
import com.tiandihui.vpn.domain.MessageInfo;
import com.tiandihui.vpn.mbg.mapper.CmsCommentMapper;
import com.tiandihui.vpn.mbg.mapper.CmsCommentOfficialReplyMapper;
import com.tiandihui.vpn.mbg.mapper.UmsMemberMapper;
import com.tiandihui.vpn.mbg.model.*;
import com.tiandihui.vpn.service.CommentService;
import com.tiandihui.vpn.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {


    @Autowired
    UmsMemberService memberService;
    @Autowired
    CmsCommentMapper commentMapper;
    @Autowired
    CmsCommentOfficialReplyMapper officialReplyMapper;
    @Autowired
    UmsMemberMapper memberMapper;

    @Override
    public int feedbackComment(int commentType, String content) {

        UmsMember member = memberService.getCurrentMember();
        if (member == null) {
            Asserts.fail(ResultCode.RELOGINAGAIN);
        }
        CmsComment cmsComment = new CmsComment();
        cmsComment.setContent(content);
        cmsComment.setCommentType(commentType);
        cmsComment.setMemberId(member.getId());
        cmsComment.setCreateTime(new Date());
        cmsComment.setReadStatus(0);
        int result = commentMapper.insertSelective(cmsComment);
        return result;
    }

    @Override
    public int officialReplay(String commentId, String content) {

        CmsCommentExample example = new CmsCommentExample();
        example.createCriteria().andIdEqualTo(Long.valueOf(commentId));
        List<CmsComment> commentList = commentMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(commentList)) {
            Asserts.fail(ResultCode.UNFINDCOMMENT);
        }
        CmsCommentOfficialReply officialReply = new CmsCommentOfficialReply();
        officialReply.setCommentId(Long.valueOf(commentId));
        officialReply.setContent(content);
        officialReply.setCreateTime(new Date());
        officialReply.setReadStatus(0);
        return officialReplyMapper.insert(officialReply);
    }

    @Override
    public List<CmsComment> getFeedBackComment(String username, int pageNum, int pageSize) {

        UmsMemberExample memberExample = new UmsMemberExample();
        memberExample.createCriteria().andUsernameEqualTo(username);
        List<UmsMember> memberList = memberMapper.selectByExample(memberExample);
        if (CollectionUtils.isEmpty(memberList)) {
            Asserts.fail(ResultCode.UNFINDUSER);
        }
        UmsMember member = memberList.get(0);
        CmsCommentExample example = new CmsCommentExample();
        example.createCriteria().andMemberIdEqualTo(member.getId());
        PageHelper.startPage(pageNum,pageSize);
        List<CmsComment> commentList = commentMapper.selectByExample(example);
        return commentList;
    }

    @Override
    public int getCommentReplyCount(String username) {
        UmsMemberExample memberExample = new UmsMemberExample();
        memberExample.createCriteria().andUsernameEqualTo(username);
        List<UmsMember> memberList = memberMapper.selectByExample(memberExample);
        if (CollectionUtils.isEmpty(memberList)) {
            Asserts.fail(ResultCode.UNFINDUSER);
        }
        UmsMember member = memberList.get(0);
        CmsCommentExample example = new CmsCommentExample();
        example.createCriteria().andMemberIdEqualTo(member.getId());
        example.setOrderByClause("create_time desc");
        List<CmsComment> commentList = commentMapper.selectByExample(example);
        int count = 0;
        for (int j = 0 ; j < commentList.size(); j++) {
            CmsComment comment = commentList.get(j);
            CmsCommentOfficialReplyExample replyExample = new CmsCommentOfficialReplyExample();
            replyExample.createCriteria().andCommentIdEqualTo(comment.getId()).andReadStatusEqualTo(0);
            List<CmsCommentOfficialReply> officialReplyList = officialReplyMapper.selectByExample(replyExample);
            count = count + officialReplyList.size();
        }
        return count;
    }


    @Override
    public List<CmsComment> getFeedBackComment(int pageNum, int pageSize) {
        CmsCommentExample example = new CmsCommentExample();
        PageHelper.startPage(pageNum,pageSize);
        List<CmsComment> commentList = commentMapper.selectByExample(example);
        return commentList;
    }

    @Override
    public List<MessageInfo> getMessage(int pageNum, int pageSize) {

        List<MessageInfo> messageInfoList = new ArrayList();
        UmsMember member = memberService.getCurrentMember();
        if (member == null) {
            Asserts.fail(ResultCode.RELOGINAGAIN);
        }
        PageHelper.startPage(pageNum,pageSize);

        CmsCommentExample example = new CmsCommentExample();
        example.createCriteria().andMemberIdEqualTo(member.getId());
        example.setOrderByClause("create_time desc");
        List<CmsComment> commentList = commentMapper.selectByExample(example);
        for (int j = 0 ; j < commentList.size(); j++) {
            CmsComment comment = commentList.get(j);
            CmsCommentOfficialReplyExample replyExample = new CmsCommentOfficialReplyExample();
            replyExample.createCriteria().andCommentIdEqualTo(comment.getId());
            List<CmsCommentOfficialReply> officialReplyList = officialReplyMapper.selectByExample(replyExample);
            MessageInfo messageInfo = new MessageInfo();
            messageInfo.setOfficialReplyList(officialReplyList);
            messageInfo.setComment(comment);
            messageInfoList.add(messageInfo);
            for (int k = 0; k < officialReplyList.size(); k++) {
                CmsCommentOfficialReply  officialReply = officialReplyList.get(k);
                officialReply.setReadStatus(1);
                officialReplyMapper.updateByPrimaryKeySelective(officialReply);
            }
        }
        return messageInfoList;
    }
}
