package com.tiandihui.vpn.service.impl;

import com.tiandihui.vpn.common.exception.Asserts;
import com.tiandihui.vpn.common.utils.Utils;
import com.tiandihui.vpn.domain.LoginSuccessInfo;
import com.tiandihui.vpn.domain.MemberDetails;
import com.tiandihui.vpn.domain.VpnMemberInfo;
import com.tiandihui.vpn.domain.VpnSsDetailInfo;
import com.tiandihui.vpn.mbg.mapper.*;
import com.tiandihui.vpn.mbg.model.*;
import com.tiandihui.vpn.security.JwtTokenUtil;
import com.tiandihui.vpn.service.UmsMemberCacheService;
import com.tiandihui.vpn.service.UmsMemberService;
import com.tiandihui.vpn.service.UmsVpnSSService;
import com.tiandihui.vpn.service.UmsVpnWireguardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UmsMemberServiceImpl.class);

   // @Autowired
   // private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private   UmsMemberMapper memberMapper;
    @Autowired
    private UmsMemberCacheService memberCacheService;
    @Autowired
    private UmsMemberLevelMapper memberLevelMapper;
    @Autowired
    private UmsVpnSSService vpnSSService;

    @Autowired
    private UmsVpnWireguardService wireguardService;

    @Autowired
    private UmsVpnSsEncriptionTypeMapper ssEncriptionTypeMapper;

    @Autowired
    UmsVpnSsProtocalTypeMapper ssProtocalTypeMapper;

    @Autowired
    UmsVpnSsObfsMapper ssObfsMapper;

    @Autowired
    UmsMemberLoginLogMapper loginLogMapper;

    @Autowired
    UmsMemberStatisticsInfoMapper statisticsInfoMapper;

    @Autowired
    UmsMemberDeviceIdMapper deviceIdMapper;

    @Override
    public UmsMember getByUsername(String username) {
        UmsMember member = memberCacheService.getMember(username);
        if (member != null) return  member;
        UmsMemberExample memberExample = new UmsMemberExample();
        memberExample.createCriteria().andUsernameEqualTo(username);
        List<UmsMember> memberList = memberMapper.selectByExample(memberExample);
        if (!CollectionUtils.isEmpty(memberList)) {
            member = memberList.get(0);
            memberCacheService.setMember(member);
            return  member;
        }
        return null;
    }

    @Override
    public UmsMember getById(Long id) {
        UmsMember member = memberMapper.selectByPrimaryKey(id);
        return member;
    }



    @Override
    public LoginSuccessInfo register(String username, String password, String deviceId, String deviceBrand) {
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UmsMember> memberList = memberMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(memberList)) {
            Asserts.fail("该用户已经存在");
        }
        //1.保存用戶
        UmsMember umsMember = new UmsMember();
        umsMember.setUsername(username);
        umsMember.setPassword(password);
        umsMember.setCreateTime(new Date());
        umsMember.setStatus(1);

        //2.設置用戶等級
        UmsMemberLevelExample levelExample = new UmsMemberLevelExample();
        levelExample.createCriteria().andIdEqualTo(1L);
        List<UmsMemberLevel> memberLevelList = memberLevelMapper.selectByExample(levelExample);
        if (!CollectionUtils.isEmpty(memberLevelList)) {
            umsMember.setMemberLevelId(memberLevelList.get(0).getId());
        }
        memberMapper.insert(umsMember);

        //3.从UmsMemberDeviceId表中查询设备之前是否有注册过，有的话获取过期日期。
        //获取过期日期要在UmsMemberStatisticsInfo列表中查询开始的日期和过期的日期 并计算距离现在还有多久过期
        int newExpireDay = 7; // 默认7 天的有效期
        UmsMemberDeviceIdExample deviceIdExample = new UmsMemberDeviceIdExample();
        deviceIdExample.createCriteria().andDeviceIdEqualTo(deviceId);
        List<UmsMemberDeviceId> memberDeviceIdList = deviceIdMapper.selectByExample(deviceIdExample);
        UmsMemberStatisticsInfoExample statisticsInfoExample =  new UmsMemberStatisticsInfoExample();
        for (int i = 0; i < memberDeviceIdList.size(); i++) {
            UmsMemberDeviceId memberDeviceId = memberDeviceIdList.get(i);
            statisticsInfoExample.createCriteria().andMemberIdEqualTo(memberDeviceId.getMemberId() );
            List<UmsMemberStatisticsInfo> memberStatisticsInfoList =  statisticsInfoMapper.selectByExample(statisticsInfoExample);
            if (!CollectionUtils.isEmpty(memberStatisticsInfoList)) {

                UmsMemberStatisticsInfo memberStatisticsInfo = memberStatisticsInfoList.get(0);
                Date startRecMemberTime =  memberStatisticsInfo.getStartRecMemberTime();
                int expireDay = memberStatisticsInfo.getExpireTime();
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(startRecMemberTime);
                calendar.add(calendar.DATE,expireDay); //把日期往后增加一天,整数  往后推,负数往前移动
                Date  newDate = calendar.getTime(); //这个时间就是日期往后推一天的结果
                Date nowDate = new Date();
                if ( !newDate.before(nowDate)) { //没有过期  !(nowDate > newDate)
                     newExpireDay = Utils.differentDaysByMillisecond( nowDate,newDate);
                } else {
                    newExpireDay = 0;
                }
                break;
            }
        }
        //4保存过期日期到缓存中
        memberCacheService.setExpireDay(umsMember.getUsername(),String.valueOf(newExpireDay));
        //5.把用户名和过期时间保存deviceid设备列表中
        UmsMemberDeviceId  memberDeviceId = new UmsMemberDeviceId();
        memberDeviceId.setDeviceId(deviceId);
        memberDeviceId.setDevicebrand(deviceBrand);
        memberDeviceId.setUsername(username);
        memberDeviceId.setMemberId(umsMember.getId());
        deviceIdMapper.insertSelective(memberDeviceId);
        //6.吧过期时间保存到UmsMemberStatisticsInfo 表中
        UmsMemberStatisticsInfo memberStatisticsInfo = new UmsMemberStatisticsInfo();
        memberStatisticsInfo.setStartRecMemberTime(new Date());
        memberStatisticsInfo.setFirstLoginTime(new Date());
        memberStatisticsInfo.setMemberId(umsMember.getId());
        memberStatisticsInfo.setExpireTime(newExpireDay);
        memberStatisticsInfo.setTotalTime(newExpireDay);
        memberStatisticsInfo.setLastLoginTime(new Date());
        statisticsInfoMapper.insertSelective(memberStatisticsInfo);

        //7 获取用户信息 且产生token 把过期时间返回去
        UserDetails userDetails = loadUserByUsername(username);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        String token = jwtTokenUtil.generateToken(userDetails);

        memberCacheService.setLoginToken(umsMember.getUsername(),token);

        LoginSuccessInfo successInfo = new LoginSuccessInfo();
        BeanUtils.copyProperties(umsMember, successInfo);
        successInfo.setToken(token);
        successInfo.setExpireDay(newExpireDay);
        return successInfo;
    }

    @Override
    public void registerByPhone(String username, String password, String telephone, String authCode) {
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        example.or(example.createCriteria().andPhoneEqualTo(telephone));
        List<UmsMember> memberList = memberMapper.selectByExample(example);

        if (!CollectionUtils.isEmpty(memberList)) {
            Asserts.fail("该用户已经存在");
        }
        UmsMember umsMember = new UmsMember();
        umsMember.setUsername(username);
        umsMember.setPhone(telephone);
        umsMember.setPassword(password);
        umsMember.setCreateTime(new Date());
        umsMember.setStatus(1);

        UmsMemberLevelExample levelExample = new UmsMemberLevelExample();
        levelExample.createCriteria().andDefaultStatusEqualTo(1);
        List<UmsMemberLevel> memberLevelList = memberLevelMapper.selectByExample(levelExample);
        if (!CollectionUtils.isEmpty(memberLevelList)) {
            umsMember.setMemberLevelId(memberLevelList.get(0).getId());
        }
        memberMapper.insert(umsMember);
    }

    @Override
    public String generateAuthCode(String telephone) {

        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        memberCacheService.setAuthCode(telephone, stringBuilder.toString());
        return stringBuilder.toString();
    }

    @Override
    public void updatePassword(String telephone, String password, String authCode) {
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andPhoneEqualTo(telephone);
        List<UmsMember> memberList = memberMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(memberList)) {
            Asserts.fail("该账号不存在");
        }
        if (!verifyAuthCode(authCode,telephone)) {
            Asserts.fail("验证码不正确");
        }
        UmsMember umsMember = memberList.get(0);
        umsMember.setPassword(password);
        memberMapper.updateByPrimaryKeySelective(umsMember);
        memberCacheService.delMember(umsMember.getId());
    }

    @Override
    public void updatePasswordByOldPassword(String username, String oldPassword, String newPassword) {
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UmsMember> memberList = memberMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(memberList)) {
            Asserts.fail("该账号不存在");
        }
        UmsMember member = memberList.get(0);
        if (!oldPassword.equals(member.getPassword())) {
            Asserts.fail("密码不对");
        }
//        if (!passwordEncoder.encode(oldPassword).equals(member.getPassword())) {
//            Asserts.fail("密码不对");
//        }
        memberMapper.updateByPrimaryKeySelective(member);
    }

    @Override
    public UmsMember getCurrentMember() {
        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication auth = ctx.getAuthentication();
        MemberDetails memberDetails = (MemberDetails) auth.getPrincipal();
        return memberDetails.getUmsMember();
    }

    @Override
    public void updateIntegration(Long id, Integer integration) {
        UmsMember record=new UmsMember();
        record.setId(id);
        record.setIntegration(integration);
        memberMapper.updateByPrimaryKeySelective(record);
        memberCacheService.delMember(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UmsMember umsMember = getByUsername(username);
        if (umsMember != null) {
            return new MemberDetails(umsMember);
        }
        throw  new UsernameNotFoundException("用户名或密码错误");
    }


    @Override
    public LoginSuccessInfo loginByToken(String username, String token) {
        LoginSuccessInfo successInfo = null;
        try {
            UserDetails userDetails = loadUserByUsername(username);
            String lastToken = memberCacheService.getLoginToken(username);
            if (!lastToken.equals(token) ) {
                throw new BadCredentialsException("token不正确或已失效,请重新登录");
            }
            successInfo = handleLogin(userDetails);

        } catch (Exception e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return successInfo;
    }

    @Override
    public LoginSuccessInfo login(String username, String password) {
        LoginSuccessInfo successInfo = null;
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if (!password.equals(userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            successInfo = handleLogin(userDetails);

        } catch (Exception e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return successInfo;
    }

    @Override
    public VpnMemberInfo getMemberInfo() {

        VpnMemberInfo memberInfo = new VpnMemberInfo();

        UmsMember member = getCurrentMember();
        BeanUtils.copyProperties(member,memberInfo);
        if (member.getMemberLevelId() == null ) {
            return memberInfo;
        }
        List<UmsVpnSs> vpnSsList = vpnSSService.list(1,10);
        List<VpnSsDetailInfo> ssDetailInfoList = new ArrayList<>();
        for (int i = 0; i < vpnSsList.size(); i++ ) {
            UmsVpnSs vpnSs = vpnSsList.get(i);
            VpnSsDetailInfo ssDetailInfo = new VpnSsDetailInfo();
            BeanUtils.copyProperties(vpnSs, ssDetailInfo);
            UmsVpnSsEncriptionType ssEncriptionType = ssEncriptionTypeMapper.selectByPrimaryKey(vpnSs.getEncriptionTypeId());
            ssDetailInfo.setEncriptionType(ssEncriptionType.getEncriptionType());
            UmsVpnSsProtocalType ssProtocalType = ssProtocalTypeMapper.selectByPrimaryKey(vpnSs.getProtocalTypeId());
            ssDetailInfo.setProtocolType(ssProtocalType.getProtocalType());
            UmsVpnSsObfs ssObfs = ssObfsMapper.selectByPrimaryKey(vpnSs.getObfsId());
            ssDetailInfo.setObfsType(ssObfs.getObfs());
            ssDetailInfoList.add(ssDetailInfo);
        }
        memberInfo.setVpnSsList(ssDetailInfoList);

        List<UmsVpnWireguard> vpnWireguardList = wireguardService.list(1,10);
        memberInfo.setVpnWireguardList(vpnWireguardList);
        return memberInfo;
    }


    @Override
    public int connected(int connectType, Long id) {

        return modifyConnectStatus(connectType,id,1);
    }

    public int disConnect(int connectType, Long id) {

       return modifyConnectStatus(connectType,id,0);
    }


    @Override
    public int recLoginLog() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String ip =  request.getRemoteUser();
        String mac = request.getHeader("mac");
        String uid = request.getHeader("uid");
        UmsMember member = getCurrentMember();
        UmsMemberLoginLog loginLog = new UmsMemberLoginLog();
        loginLog.setCreateTime(new Date());
        loginLog.setMemberId(member.getId());
        loginLog.setIp(ip);
        loginLog.setLoginMac(mac);
        loginLog.setLoginUid(uid);
        return loginLogMapper.insertSelective(loginLog);
    }
    //对输入的验证码进行校验
    private boolean verifyAuthCode(String authCode, String telephone){
        if (StringUtils.isEmpty(authCode)) {
            return false;
        }
        String realAuthCode = memberCacheService.getAuthCode(telephone);
        return authCode.equals(realAuthCode);
    }


    private int modifyConnectStatus(int connectType, Long id, int status) {

        UmsMember member = getCurrentMember();
        member.setVpnConnectType(connectType);
        memberMapper.updateByPrimaryKeySelective(member);

        UmsMemberStatisticsInfo statisticsInfo = new UmsMemberStatisticsInfo();
        statisticsInfo.setLastConnectway(connectType);
        if (connectType == 1) {
            statisticsInfo.setSsId(id);

        } else  if (connectType == 2) {
            statisticsInfo.setWireguardId(id);
            UmsVpnWireguard vpnWireguard = new UmsVpnWireguard();
            vpnWireguard.setId(id);
            vpnWireguard.setUseStatus(status);
            wireguardService.update(vpnWireguard);
        }
        UmsMemberStatisticsInfoExample example = new UmsMemberStatisticsInfoExample();
        example.createCriteria().andMemberIdEqualTo(member.getId());
        return  statisticsInfoMapper.updateByExampleSelective(statisticsInfo,example);
    }

    private LoginSuccessInfo handleLogin(UserDetails userDetails) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        int newExpireDay = 0;

        UmsMember member = getCurrentMember();
        String day = memberCacheService.getExpireDay(member.getUsername());
        newExpireDay = day == null ? 0 : Integer.valueOf(day);
        UmsMemberStatisticsInfo statisticsInfo = new UmsMemberStatisticsInfo();

        UmsMemberStatisticsInfoExample example = new UmsMemberStatisticsInfoExample();
        example.createCriteria().andMemberIdEqualTo(member.getId());
        List<UmsMemberStatisticsInfo> statisticsInfos = statisticsInfoMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(statisticsInfos)) {
            statisticsInfo = statisticsInfos.get(0);
        }
        //如果缓存中没有缓存过期日期，那就去数据库计算获取日期
        if (newExpireDay == 0) {
            Date startRecMemberTime =  statisticsInfo.getStartRecMemberTime();
            int expireDay = statisticsInfo.getExpireTime();

            Calendar calendar = new GregorianCalendar();
            calendar.setTime(startRecMemberTime);
            calendar.add(calendar.DATE,expireDay); //把日期往后增加一天,整数  往后推,负数往前移动
            Date  newDate = calendar.getTime(); //这个时间就是日期往后推一天的结果
            Date nowDate = new Date();
            if ( !newDate.before(nowDate)) { //没有过期  !(nowDate > newDate)
                newExpireDay = Utils.differentDaysByMillisecond( nowDate,newDate);
            } else {
                newExpireDay = 0;
            }
            memberCacheService.setExpireDay(member.getUsername(),String.valueOf(newExpireDay));
        }
        statisticsInfo.setLastLoginTime(new Date());
        int loginCount = (statisticsInfo.getLoginCount() == null) ? 1 : statisticsInfo.getLoginCount();
        loginCount = loginCount + 1;
        statisticsInfo.setLoginCount(loginCount);
        statisticsInfoMapper.updateByExampleSelective(statisticsInfo,example);

        // 获取用户信息 且产生token 把过期时间返回去
        String token = null;
        token = jwtTokenUtil.generateToken(userDetails);
        memberCacheService.setLoginToken(member.getUsername(),token);

        UmsMember currentMember = getCurrentMember();
        LoginSuccessInfo successInfo = new LoginSuccessInfo();
        BeanUtils.copyProperties(currentMember, successInfo);
        successInfo.setToken(token);
        successInfo.setExpireDay(newExpireDay);
        return successInfo;
    }

}
