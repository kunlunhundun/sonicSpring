package com.tiandihui.vpn.component;

import com.tiandihui.vpn.service.UmsVpnWireguardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WireguardUpdateConnectStatusTask {

    private Logger LOGGER = LoggerFactory.getLogger(WireguardUpdateConnectStatusTask.class);
    @Autowired
    private UmsVpnWireguardService wireguardService;

    /**
     * cron表达式：Seconds Minutes Hours DayofMonth Month DayofWeek [Year]
     * 每天凌晨2点执行一次 更新vpn 连接状态  要是48 个小时vpn的连接状态没有改变，则强制改为可使用状态，
     */
    @Scheduled(cron = "0 0 2 * * ?")
    private void updateConnectStatus(){
        Integer count = wireguardService.updateConnectStatus();
        LOGGER.info("updateConnectStatus：{}",count);
    }

}
