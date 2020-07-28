package com.tiandihui.vpn.service;

import com.tiandihui.vpn.domain.LoginSuccessInfo;
import com.tiandihui.vpn.domain.VpnMemberInfo;
import com.tiandihui.vpn.mbg.model.UmsMember;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

public interface UmsMemberService {


    /**
     * 根据用户名获取会员
     */
    UmsMember getByUsername(String username);

    /**
     * 根据会员编号获取会员
     */
    UmsMember getById(Long id);

    /**
     * 用户注册 手机号 加验证码
     */
    @Transactional
    void registerByPhone(String username, String password, String telephone, String authCode);

    /**
     * 用户注册 直接注册
     */
    @Transactional
     LoginSuccessInfo register(String username, String password, String code ,String deviceId, String deviceBrand);

    @Transactional
    LoginSuccessInfo loginByFacebook(String username);

    /**
     * 生成验证码
     */
    String generateAuthCode(String telephone);

    /**
     * 修改密码
     */
    @Transactional
    void updatePassword(String username, String password, String authCode);


    @Transactional
    void updatePasswordByOldPassword(String username, String oldPassword, String newPassword);

    /**
     * 获取当前登录会员
     */
    UmsMember getCurrentMember();

    /**
     * 根据会员id修改会员积分
     */
    void updateIntegration(Long id,Integer integration);


    /**
     * 获取用户信息
     */
    UserDetails loadUserByUsername(String username);

    /**
     * 登录后获取token
     */
    LoginSuccessInfo login(String username, String password);


    /**
     * 登录通过token
     */
    LoginSuccessInfo loginByToken(String username, String token);

    /**
     * 登录后获取用户的信息
     */
     VpnMemberInfo getMemberInfo();

    /**
     * 登录后选择线路成功连接后
     * @param connectType  连接类型 1->ss 2->wireguard 3->openvpn
     * @param id   选择的哪一个线路id
     * @return
     */
     int connected(int connectType, Long id);

    /**
     * 断开连接
     * @param connectType
     * @param id
     * @return
     */
    int disConnect(int connectType, Long id);

    /**
     * 记录登录日志
     */
     int  recLoginLog(String username);

    /**
     * 客户选择了那些app
     */
    void filterApp(Integer filterType, String appName);

}
