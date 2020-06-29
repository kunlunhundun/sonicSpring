package com.tiandihui.cmd.service.impl;

import com.tiandihui.cmd.dao.WireGuardItemDao;
import com.tiandihui.cmd.mbg.mapper.UmsVpnServiceMapper;
import com.tiandihui.cmd.mbg.mapper.UmsVpnWireguardMapper;
import com.tiandihui.cmd.mbg.model.UmsVpnService;
import com.tiandihui.cmd.mbg.model.UmsVpnServiceExample;
import com.tiandihui.cmd.mbg.model.UmsVpnWireguard;
import com.tiandihui.cmd.service.RedisService;
import com.tiandihui.cmd.service.WireGuardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class WireGuardServiceImpl implements WireGuardService {

    @Autowired
    private RedisService redisService;
    @Autowired
    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;
    @Value("${redis.key.serviceId}")
    private String REDIS_KEY_SERVICE_ID;


    @Autowired
    UmsVpnServiceMapper vpnServiceMapper;
    @Autowired
    UmsVpnWireguardMapper vpnWireguardMapper;
    @Autowired
    WireGuardItemDao wireGuardItemDao;

    private static Logger logger =LoggerFactory.getLogger(WireGuardService.class);


    @Override
    public int importVpnService(String ip, String lineName) {

        UmsVpnService vpnService = new UmsVpnService();
        vpnService.setIp(ip);
        vpnService.setLineName(lineName);
        vpnService.setUseStatus(0);
        vpnService.setDeleteStatus(0);
        int count = vpnServiceMapper.insert(vpnService);
        if (count > 0) {
           String serviceId = vpnService.getId().toString();
           setServiceId(serviceId);
        }
        return count;
    }

    @Override
    public String getVpnServiceId(String ip) {
        String serviceId = null;
        serviceId = getServiceId();
        if (!StringUtils.isEmpty(serviceId)) {
            return serviceId;
        }
        UmsVpnServiceExample example = new UmsVpnServiceExample();
        example.createCriteria().andIpEqualTo(ip);
        List<UmsVpnService>  serviceList =  vpnServiceMapper.selectByExample(example);

        if (!CollectionUtils.isEmpty(serviceList)) {
            UmsVpnService service = serviceList.get(0);
            serviceId = service.getId().toString();
            setServiceId(serviceId);
        }
        return serviceId;
    }


    public int updateVpnServiceLineName(String ip ,String lineName) {
        UmsVpnServiceExample example = new UmsVpnServiceExample();
        example.createCriteria().andIpEqualTo(ip);
        UmsVpnService vpnService = new UmsVpnService();
        vpnService.setIp(ip);
        vpnService.setLineName(lineName);
        int result = vpnServiceMapper.updateByExampleSelective(vpnService,example);
        return result;
    }


    @Override
    public int insertList(List<UmsVpnWireguard> wireguardList) {

       int count =  wireGuardItemDao.insertList(wireguardList);
       if (count > 0) {
            logger.info("inserlist count " + count);
       }
       return count;
    }


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


   //@Override
    public void setServiceId(String serviceId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_SERVICE_ID;
        redisService.set(key,serviceId,REDIS_EXPIRE);
    }

    @Override
    public String getServiceId() {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_SERVICE_ID;
        return (String) redisService.get(key);
    }


}
