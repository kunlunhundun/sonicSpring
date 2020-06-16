package com.tiandihui.vpn.service;

import com.tiandihui.vpn.domain.CalcAmount;
import com.tiandihui.vpn.domain.OmsOrderDetail;
import com.tiandihui.vpn.domain.OrderParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

public interface OmsVpnOrderService {


    /**
     * 根据用户购物车信息生成确认单信息
     */
    CalcAmount generateConfirmOrder(OrderParam orderParam);

    /**
     * 根据提交信息生成订单
     */
    @Transactional
    Map<String, Object> generateOrder(OrderParam orderParam);

    /**
     * 支付成功后的回调
     */
    @Transactional
    Integer paySuccess(Long orderId);

    /**
     * 自动取消超时订单
     */
    @Transactional
    Integer cancelTimeOutOrder();

    /**
     * 取消单个超时订单
     */
    @Transactional
    void cancelOrder(Long orderId);

    /**
     * 发送延迟消息取消订单
     */
    void sendDelayMessageCancelOrder(Long orderId);


    OmsOrderDetail getDetail(Long orderId);
}
