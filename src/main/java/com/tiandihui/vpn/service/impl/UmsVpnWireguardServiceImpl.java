package com.tiandihui.vpn.service.impl;

import com.github.pagehelper.PageHelper;
import com.tiandihui.vpn.mbg.mapper.UmsVpnWireguardMapper;
import com.tiandihui.vpn.mbg.model.UmsVpnWireguard;
import com.tiandihui.vpn.mbg.model.UmsVpnWireguardExample;
import com.tiandihui.vpn.service.UmsVpnWireguardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UmsVpnWireguardServiceImpl implements UmsVpnWireguardService {

    @Autowired
    UmsVpnWireguardMapper vpnWireguardMapper;

    @Override
    public int add(UmsVpnWireguard vpnWireguard) {

       return vpnWireguardMapper.insert(vpnWireguard);

    }

    @Override
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
