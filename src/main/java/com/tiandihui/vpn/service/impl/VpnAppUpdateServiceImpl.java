package com.tiandihui.vpn.service.impl;

import com.tiandihui.vpn.common.api.ResultCode;
import com.tiandihui.vpn.common.exception.Asserts;
import com.tiandihui.vpn.mbg.mapper.CmsAppFileMapper;
import com.tiandihui.vpn.mbg.model.CmsAppFile;
import com.tiandihui.vpn.mbg.model.CmsAppFileExample;
import com.tiandihui.vpn.service.VpnAppUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class VpnAppUpdateServiceImpl implements VpnAppUpdateService {

    @Autowired
    CmsAppFileMapper appFileMapper;

    @Override
    public int addNewVersion(String fileName, String appName, String v, String isMustUpdate, String platform) {

        CmsAppFile appFile = new CmsAppFile();
        appFile.setAppName(appName);
        appFile.setAppAddress(fileName);
        appFile.setV(v);
        appFile.setIsMustUpdate( Integer.valueOf(isMustUpdate) );
        appFile.setPlatform(Integer.valueOf(platform));
        appFile.setCreateTime(new Date());
        return appFileMapper.insert(appFile);
    }

    @Override
    public Map<String, Object> checkVersion(String v, String platform) {

        Map<String,Object> dataMap = new HashMap<>();

        CmsAppFileExample example = new CmsAppFileExample();
        example.createCriteria().andPlatformEqualTo(Integer.valueOf(platform));
        example.setOrderByClause("create_time desc");
        List<CmsAppFile> appFileList = appFileMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(appFileList)){
            dataMap.put("mustUpdate",0);
            return dataMap;
            // Asserts.fail("查询数据库失败");
        }

        CmsAppFile appFile = appFileList.get(0);
        String lastV = appFile.getV();
        if (v.equals(lastV)) {
           //return "版本相同"; 0 不更新,1 普通更新， 2 强制更新
            dataMap.put("mustUpdate",0);
            return dataMap;
        }
        String[] lastVs = lastV.split("\\.");
        String[] userVs = v.split("\\.");
        if (userVs.length < 2) {
            Asserts.fail(ResultCode.VALIDATE_FAILED);
        }
        String firstLs = lastVs[0];
        String firstUs = userVs[0];

        //传过来的版本小于数据库的版本，需要升级
        if ( firstLs.compareTo(firstUs) > 0) {
            int update = appFile.getIsMustUpdate();
            dataMap.put("mustUpdate",update+1);
            dataMap.put("fileName",appFile.getAppAddress());
            dataMap.put("v",appFile.getV());
            return dataMap;

        } else if (firstLs.compareTo(firstUs) == 0) {
            String secondLs = lastVs[1];
            String secondUs = userVs[1];
            //传过来的版本小于数据库的版本，需要升级
            if (secondLs.compareTo(secondUs) > 0) {
                int update = appFile.getIsMustUpdate();
                dataMap.put("mustUpdate",update+1);
                dataMap.put("fileName",appFile.getAppAddress());
                dataMap.put("v",appFile.getV());
                return dataMap;
            }
            else if (secondLs.compareTo(secondUs) == 0) {
                String thirdLs = lastVs[2];
                String thirdUs = userVs[2];
                //传过来的版本小于数据库的版本，需要升级
                if (thirdLs.compareTo(thirdUs) > 0) {
                    int update = appFile.getIsMustUpdate();
                    dataMap.put("mustUpdate",update+1);
                    dataMap.put("fileName",appFile.getAppAddress());
                    dataMap.put("v",appFile.getV());
                    return dataMap;
                }//不存在等于的情况了，如果等于，一开始比较的时候就会相等
            }
        }
        dataMap.put("mustUpdate",0);
        return dataMap;
    }

}
