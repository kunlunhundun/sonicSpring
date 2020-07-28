package com.tiandihui.vpn.controller;


import com.tiandihui.vpn.common.api.CommonResult;
import com.tiandihui.vpn.domain.MessageInfo;
import com.tiandihui.vpn.mbg.model.CmsComment;
import com.tiandihui.vpn.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(tags = "CommentController", description = "评论信息管理")
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @ApiOperation("用户反馈问题")
    @RequestMapping(value = "/sendFeedBack", method = { RequestMethod.POST, RequestMethod.GET})
    @ApiImplicitParam(name = "commentType", value = "0-功能性问题>；1->优化问题;2->其他",
            defaultValue = "2", allowableValues = "0,1,2",  dataType = "integer")
    @ResponseBody
    public CommonResult sendFeedBack(@RequestParam int commentType, @RequestParam String content) {

        int result= commentService.feedbackComment(commentType, content);
        if (result == 0) {
            return CommonResult.failed("插入数据失败");
        }
        return CommonResult.success(null,"feedback success");

    }

    @ApiOperation("用户获取信息列表")
    @RequestMapping(value = "/getMessage", method = { RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public CommonResult getMessageInfo(@RequestParam int pageNum, @RequestParam int pageSize) {
        List<MessageInfo>  messageInfoList = commentService.getMessage(pageNum, pageSize);
        return CommonResult.success(messageInfoList);

    }


    @ApiOperation("官方获取相所有用户反馈信息")
    @RequestMapping(value = "/getFeedBack", method = { RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public CommonResult getFeedBack(@RequestParam int pageNum, @RequestParam int pageSize) {
        List<CmsComment>  commentList = commentService.getFeedBackComment(pageNum, pageSize);
        return CommonResult.success(commentList);

    }

    @ApiOperation("官方获取相所有用户反馈信息")
    @RequestMapping(value = "/officialReplay", method = { RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public CommonResult officialReplay(@RequestParam String  commentId, @RequestParam String content) {
        int result = commentService.officialReplay(commentId,content);
        if (result == 0) {
            CommonResult.failed("插入失败");
        }
        return CommonResult.success(null,"回复成功");
    }

    @ApiOperation("用户获取官方回了多少条消息")
    @RequestMapping(value = "/queryReplyCount", method = { RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public CommonResult queryReplyCount(@RequestParam String username) {

       int result =  commentService.getCommentReplyCount(username);
//        Map<String,Integer> map = new HashMap<String, Integer>();
//        map.put("count",result);
       return CommonResult.success(result,"success");

    }

    @RequestMapping(value = "/hello", method = { RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public CommonResult officialHello() {

        return CommonResult.success("dao dao dao ","回复成功");
    }

}
