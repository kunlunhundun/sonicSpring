package com.tiandihui.vpn.service.impl;

import com.tiandihui.vpn.common.utils.Utils;
import com.tiandihui.vpn.mbg.mapper.UmsMemberMapper;
import com.tiandihui.vpn.mbg.mapper.UmsMemberStatisticsInfoMapper;
import com.tiandihui.vpn.mbg.model.UmsMember;
import com.tiandihui.vpn.mbg.model.UmsMemberExample;
import com.tiandihui.vpn.mbg.model.UmsMemberStatisticsInfoExample;
import com.tiandihui.vpn.service.MemberActivityService;
import com.tiandihui.vpn.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MemberActivityServiceImpl implements MemberActivityService {

    @Autowired
    UmsMemberService memberService;
    @Autowired
    UmsMemberMapper memberMapper;
    @Autowired
    UmsMemberStatisticsInfoMapper statisticsInfoMapper;

    @Override
    public int addNewUser(int day) {
        Date beforeDate = Utils.subDays(day);
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andCreateTimeGreaterThanOrEqualTo(beforeDate);
        List<UmsMember> memberList = memberMapper.selectByExample(example);
        int count = memberList.size();
        return  count;
    }


    @Override
    public int activityUser(int day) {
        Date beforeDate = Utils.subDays(day);
        UmsMemberStatisticsInfoExample statisticsInfoExample = new UmsMemberStatisticsInfoExample();
        statisticsInfoExample.createCriteria().andLastLoginTimeGreaterThanOrEqualTo(beforeDate);
        int count = statisticsInfoMapper.countByExample(statisticsInfoExample);
        return count;
    }




}
