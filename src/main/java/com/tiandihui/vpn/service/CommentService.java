package com.tiandihui.vpn.service;

import com.tiandihui.vpn.domain.MessageInfo;
import com.tiandihui.vpn.mbg.model.CmsComment;

import java.util.List;

public interface CommentService {

    /**
     * 用户提交反馈的信息
     * @param commentType 0->功能性问题1->优化问题2->其他
     * @param content  反馈内容
     */
    int feedbackComment(int commentType, String content);

    /**
     * 官方回复内容
     * @param commentId 用户反馈问题的id
     * @param content 官方回复的内容
     */
    int officialReplay(String commentId, String content);

    /**
     *
     * @param username
     * @param pageNum 第几页 1
     * @param pageSize  每页多少条数据  10
     */

    List<CmsComment> getFeedBackComment(String username, int pageNum, int pageSize);

    /**
     * 获取所用用户的反馈问题
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<CmsComment> getFeedBackComment(int pageNum, int pageSize);

    /**
     * 获取消息列表   用户可以通过这个来查看消息的服务
     * @param pageNum
     * @param pageSize
     * @return 每条消息的组合
     */
    List<MessageInfo> getMessage(int pageNum, int pageSize);

    /**
     * 用户获取官方有没有回复消息的个数
     */
    int getCommentReplyCount(String username);
}
