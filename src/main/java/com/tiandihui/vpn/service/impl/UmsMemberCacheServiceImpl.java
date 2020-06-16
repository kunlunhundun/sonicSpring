package com.tiandihui.vpn.service.impl;

import com.tiandihui.vpn.mbg.mapper.UmsMemberMapper;
import com.tiandihui.vpn.mbg.model.UmsMember;
import com.tiandihui.vpn.service.RedisService;
import com.tiandihui.vpn.service.UmsMemberCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UmsMemberCacheServiceImpl implements UmsMemberCacheService {

    @Autowired
    private RedisService redisService;
    @Autowired
    private UmsMemberMapper memberMapper;
    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;
    @Value("${redis.expire.authCode}")
    private Long REDIS_EXPIRE_AUTH_CODE;
    @Value("${redis.expire.logintoken}")
    private Long REDIS_EXPIRE_LOGIN_TOKEN;
    @Value("${redis.key.member}")
    private String REDIS_KEY_MEMBER;
    @Value("${redis.key.authCode}")
    private String REDIS_KEY_AUTH_CODE;
    @Value("${redis.key.expireDay}")
    private String REDIS_KEY_EXPIRE_DAY;
    @Value("${redis.key.expireToken}")
    private String REDIS_KEY_EXPIRE_TOKEN;
    @Override
    public void delMember(Long memberId) {
        UmsMember umsMember = memberMapper.selectByPrimaryKey(memberId);
        if (umsMember != null) {
            String key = REDIS_DATABASE + ":" + REDIS_KEY_MEMBER + ":" + umsMember.getUsername();
            redisService.del(key);
        }
    }

    @Override
    public UmsMember getMember(String username) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_MEMBER + ":" + username;
        return (UmsMember) redisService.get(key);
    }

    @Override
    public void setMember(UmsMember member) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_MEMBER + ":" + member.getUsername();
        redisService.set(key, member, REDIS_EXPIRE);
    }

    @Override
    public void setAuthCode(String telephone, String authCode) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_AUTH_CODE + ":" + telephone;
        redisService.set(key,authCode,REDIS_EXPIRE_AUTH_CODE);
    }

    @Override
    public String getAuthCode(String telephone) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_AUTH_CODE + ":" + telephone;
        return (String) redisService.get(key);
    }

    @Override
    public void setExpireDay(String username, String expireDay) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_EXPIRE_DAY + ":" + username;
        redisService.set(key,expireDay,REDIS_EXPIRE);
    }

    @Override
    public String getExpireDay(String username) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_EXPIRE_DAY + ":" +  username;
        return (String) redisService.get(key);
    }

    @Override
    public void setLoginToken(String username, String loginToken) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_EXPIRE_TOKEN + username;
        redisService.set(key,loginToken,REDIS_EXPIRE_LOGIN_TOKEN);
    }

    @Override
    public String getLoginToken(String username) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_EXPIRE_TOKEN + username;
        return (String) redisService.get(key);
    }
}
