package com.tiandihui.vpn.service.impl;

import com.tiandihui.vpn.mbg.mapper.PmsSkuStockMapper;
import com.tiandihui.vpn.mbg.model.PmsSkuStock;
import com.tiandihui.vpn.mbg.model.PmsSkuStockExample;
import com.tiandihui.vpn.service.UmsVpnProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UmsVpnProductServiceImpl implements UmsVpnProductService {

    @Autowired
    private PmsSkuStockMapper skuStockMapper;

    @Override
    public List<PmsSkuStock> normalVipVpnList() {
        PmsSkuStockExample example = new PmsSkuStockExample();
        example.createCriteria().andProductIdEqualTo(20L);
        List<PmsSkuStock> skuStockList = skuStockMapper.selectByExample(example);
        return skuStockList;
    }

    @Override
    public List<PmsSkuStock> superVipVpnList() {
        PmsSkuStockExample example = new PmsSkuStockExample();
        example.createCriteria().andProductIdEqualTo(50L);
        List<PmsSkuStock> skuStockList = skuStockMapper.selectByExample(example);
        return skuStockList;    }
}
