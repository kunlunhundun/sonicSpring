package com.tiandihui.vpn.service.impl;

import com.github.pagehelper.PageHelper;
import com.tiandihui.vpn.mbg.mapper.UmsVpnWireguardMapper;
import com.tiandihui.vpn.mbg.model.UmsVpnWireguard;
import com.tiandihui.vpn.mbg.model.UmsVpnWireguardExample;
import com.tiandihui.vpn.service.UmsVpnWireguardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class UmsVpnWireguardServiceImpl implements UmsVpnWireguardService {

    Logger logger = LoggerFactory.getLogger(UmsVpnWireguardServiceImpl.class);

    @Autowired
    UmsVpnWireguardMapper vpnWireguardMapper;

    @Override
    public int add(UmsVpnWireguard vpnWireguard) {

       return vpnWireguardMapper.insert(vpnWireguard);

    }

    @Override
    public int updateConnectStatus() {

        Date currentDate = new Date();
        Calendar calendar = new GregorianCalendar();  //GregorianCalendar();
        calendar.setTime(currentDate);
        calendar.add(calendar.DATE, -2);
        Date  beforeDate = calendar.getTime();
        UmsVpnWireguard vpnWireguard = new UmsVpnWireguard();
        vpnWireguard.setUseStatus(0);
        //vpnWireguard.setUpdateTime(beforeDate);
        UmsVpnWireguardExample example = new UmsVpnWireguardExample();
        example.createCriteria().andUpdateTimeLessThan(beforeDate).andUseStatusEqualTo(1);
       int count = vpnWireguardMapper.updateByExampleSelective(vpnWireguard,example);
       logger.info("updateConnectStatus-->" + count);

       return count;
    }

    public int update(UmsVpnWireguard vpnWireguard) {

        return vpnWireguardMapper.updateByPrimaryKeySelective(vpnWireguard);

    }


    @Override
    public int delete(Long id) {

        return vpnWireguardMapper.deleteByPrimaryKey(id);

    }

    @Override
    public List<UmsVpnWireguard> list(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return vpnWireguardMapper.selectByExample(new UmsVpnWireguardExample());
    }



}
