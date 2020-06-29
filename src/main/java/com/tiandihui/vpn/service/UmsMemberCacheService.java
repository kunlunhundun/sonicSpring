package com.tiandihui.vpn.service;

import com.tiandihui.vpn.mbg.model.UmsMember;

public interface UmsMemberCacheService {

    /**
     * 删除会员用户缓存
     */
    void delMember(Long memberId);

    /**
     * 获取会员用户缓存
     */
    UmsMember getMember(String username);

    /**
     * 设置会员用户缓存
     */
    void setMember(UmsMember member);

    /**
     * 设置验证码
     */
    void setAuthCode(String telephone, String authCode);

    /**
     * 获取验证码
     */
    String getAuthCode(String telephone);


    /**
     * 设置邮箱验证码
     */
    void setEmailAuthCode(String emailUser, String authCode);

    /**
     * 获取邮箱验证码
     */
    String getEmailAuthCode(String emailUser);

    /**
     * 设置过期日期
     */
    void setExpireDay(String username, String expireDay);

    /**
     * 设置过期日期
     */
    String getExpireDay(String username);

    /**
     * 设置登录token
     */
    void setLoginToken(String username, String loginToken);

    /**
     * 获取登录的token
     */
    String getLoginToken(String username);

}
