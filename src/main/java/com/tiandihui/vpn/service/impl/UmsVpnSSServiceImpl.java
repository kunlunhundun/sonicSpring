package com.tiandihui.vpn.service.impl;

import com.github.pagehelper.PageHelper;
import com.tiandihui.vpn.mbg.mapper.UmsVpnSsMapper;
import com.tiandihui.vpn.mbg.model.UmsVpnSs;
import com.tiandihui.vpn.mbg.model.UmsVpnSsExample;
import com.tiandihui.vpn.service.UmsVpnSSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UmsVpnSSServiceImpl implements UmsVpnSSService {

    @Autowired
    private UmsVpnSsMapper vpnSsMapper;

    @Override
    public int add(UmsVpnSs vpnSs) {

        return vpnSsMapper.insert(vpnSs);
    }

    @Override
    public int update(UmsVpnSs vpnSs) {

       return vpnSsMapper.updateByPrimaryKeySelective(vpnSs);
    }

    @Override
    public int delete(Long id) {
        return vpnSsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<UmsVpnSs> list(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UmsVpnSs> vpnSsList = vpnSsMapper.selectByExample( new UmsVpnSsExample());
        return vpnSsList;
    }

}
