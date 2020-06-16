package com.tiandihui.vpn.component;

import com.tiandihui.vpn.domain.QueueEnum;
import com.tiandihui.vpn.service.OmsVpnOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 取消订单消息的处理者
 */
@Component
@RabbitListener(queues = "vpn.order.cancel")
public class CancelOrderReceiver {

    private static Logger LOGGER =LoggerFactory.getLogger(CancelOrderReceiver.class);
    @Autowired
    private OmsVpnOrderService vpnOrderService;
    @RabbitHandler
    public void handle(Long orderId){
        vpnOrderService.cancelOrder(orderId);
        LOGGER.info("process orderId:{}",orderId);
    }
}
