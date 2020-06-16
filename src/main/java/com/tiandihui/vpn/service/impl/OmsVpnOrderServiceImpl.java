package com.tiandihui.vpn.service.impl;

import com.tiandihui.vpn.component.CancelOrderSender;
import com.tiandihui.vpn.dao.PortalOrderDao;
import com.tiandihui.vpn.dao.PortalOrderItemDao;
import com.tiandihui.vpn.domain.CalcAmount;
import com.tiandihui.vpn.domain.OmsOrderDetail;
import com.tiandihui.vpn.domain.OrderParam;
import com.tiandihui.vpn.mbg.mapper.*;
import com.tiandihui.vpn.mbg.model.*;
import com.tiandihui.vpn.service.RedisService;
import com.tiandihui.vpn.service.UmsMemberService;
import com.tiandihui.vpn.service.OmsVpnOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OmsVpnOrderServiceImpl implements OmsVpnOrderService {
    @Autowired
    UmsProductMapper productMapper;
    @Autowired
    PmsSkuStockMapper skuStockMapper;
    @Autowired
    UmsMemberService memberService;

    @Autowired
    OmsOrderMapper orderMapper;
    @Autowired
    OmsOrderItemMapper orderItemMapper;
    @Autowired
    PortalOrderDao orderDao;
    @Autowired
    PortalOrderItemDao orderItemDao;

    @Autowired
    private RedisService redisService;
    @Value("${redis.key.orderId}")
    private String REDIS_KEY_ORDER_ID;
    @Value("${redis.database}")
    private String REDIS_DATABASE;

    @Autowired
    OmsOrderSettingMapper orderSettingMapper;
    @Autowired
    CancelOrderSender cancelOrderSender;


    @Override
    public CalcAmount generateConfirmOrder(OrderParam orderParam) {
        Long productId =  orderParam.getProductId();
        UmsProduct product = productMapper.selectByPrimaryKey(productId);
        PmsSkuStock skuStock = skuStockMapper.selectByPrimaryKey(orderParam.getProductSkuId());
        if (orderParam.getProductId() != skuStock.getProductId()) {
            return  null;
        }
        BigDecimal price = skuStock.getPrice();
        CalcAmount calcAmount = new CalcAmount();
        calcAmount.setTotalAmount( price);
        calcAmount.setPayAmount(price);
        calcAmount.setPromotionAmount(price);
        calcAmount.setFreightAmount(new BigDecimal(0));
        return  calcAmount;
    }

    @Override
    public Map<String, Object> generateOrder(OrderParam orderParam) {

        Long productId =  orderParam.getProductId();
        UmsProduct product = productMapper.selectByPrimaryKey(productId);
        PmsSkuStock skuStock = skuStockMapper.selectByPrimaryKey(orderParam.getProductSkuId());
        if (orderParam.getProductId() != skuStock.getProductId()) {
            return  null;
        }
        BigDecimal price = skuStock.getPrice();

        OmsOrder order = new OmsOrder();
        order.setTotalAmount(price);
        order.setFreightAmount(new BigDecimal(0));
        order.setPromotionAmount(price);

        order.setPayAmount(price);
        //转化为订单信息并插入数据库
        UmsMember member = memberService.getCurrentMember();
        order.setMemberId(member.getId());
        order.setCreateTime(new Date());
        order.setMemberUsername(member.getUsername());
        //支付方式：0->未支付；1->支付宝；2->微信
        order.setPayType(orderParam.getPayType());
        //订单来源：0->PC订单；1->app订单
        order.setSourceType(1);
        //订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
        order.setStatus(0);
        //订单类型：0->正常订单；1->秒杀订单
        order.setOrderType(0);
        //收货人信息：姓名、电话、邮编、地址
        order.setDeleteStatus(0);

        //生成订单号
        order.setOrderSn(generateOrderSn(order));
        // TODO: 2018/9/3 bill_*,delivery_*
        //插入order表和order_item表

        List<OmsOrderItem> orderItemList = new ArrayList<>();

        OmsOrderItem orderItem = new OmsOrderItem();
        orderItem.setOrderSn(order.getOrderSn());

        orderItem.setProductId(productId);
        orderItem.setProductName(product.getProductName());
        orderItem.setProductSn(product.getProductSn());
        orderItem.setProductPrice(price);
        orderItem.setProductQuantity(1);
        orderItem.setProductSkuId(skuStock.getId());
        orderItem.setProductSkuCode(skuStock.getSkuCode());
        orderItem.setPromotionAmount(price);
        orderItem.setPromotionName("");
        orderItemList.add(orderItem);
        orderMapper.insert(order);

        orderItem.setOrderId(order.getId());
        orderItemDao.insertList(orderItemList);
        for (int i = 0; i < orderItemList.size(); i++) {
            OmsOrderItem orderItem1 = orderItemList.get(i);
            orderItem1.setId(orderItem.getId());
        }
        //发送延迟消息取消订单
        sendDelayMessageCancelOrder(order.getId());
        Map<String, Object> result = new HashMap<>();
        result.put("order", order);
        result.put("orderItemList", orderItemList);
        return result;
    }

    @Override
    public Integer paySuccess(Long orderId) {
        //修改订单支付状态
        OmsOrder order = new OmsOrder();
        order.setId(orderId);
        order.setStatus(1);
        order.setPaymentTime(new Date());
        orderMapper.updateByPrimaryKeySelective(order);
        //恢复所有下单商品的锁定库存，扣减真实库存
        return 1;    }

    @Override
    public Integer cancelTimeOutOrder() {

        Integer count=0;
        OmsOrderSetting orderSetting = orderSettingMapper.selectByPrimaryKey(1L);
        //查询超时、未支付的订单及订单详情
        List<OmsOrderDetail> timeOutOrders = orderDao.getTimeOutOrders(orderSetting.getNormalOrderOvertime());
        if (CollectionUtils.isEmpty(timeOutOrders)) {
            return count;
        }
        //修改订单状态为交易取消
        List<Long> ids = new ArrayList<>();
        for (OmsOrderDetail timeOutOrder : timeOutOrders) {
            ids.add(timeOutOrder.getId());
        }
        orderDao.updateOrderStatus(ids, 4);
        return timeOutOrders.size();
    }

    @Override
    public void cancelOrder(Long orderId) {

        //查询为付款的取消订单
        OmsOrderExample example = new OmsOrderExample();
        example.createCriteria().andIdEqualTo(orderId).andStatusEqualTo(0).andDeleteStatusEqualTo(0);
        List<OmsOrder> cancelOrderList = orderMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(cancelOrderList)) {
            return;
        }
        OmsOrder cancelOrder = cancelOrderList.get(0);
        if (cancelOrder != null) {
            //修改订单状态为取消
            cancelOrder.setStatus(4);
            orderMapper.updateByPrimaryKeySelective(cancelOrder);
        }
    }

    @Override
    public void sendDelayMessageCancelOrder(Long orderId) {

        //获取订单超时时间
        OmsOrderSetting orderSetting = orderSettingMapper.selectByPrimaryKey(1L);
        long delayTimes = orderSetting.getNormalOrderOvertime() * 60 * 1000;
        //发送延迟消息
        cancelOrderSender.sendMessage(orderId, delayTimes);
    }



    /**
     * 生成18位订单编号:8位日期+2位平台号码+2位支付方式+6位以上自增id
     */
    private String generateOrderSn(OmsOrder order) {
        StringBuilder sb = new StringBuilder();
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String key = REDIS_DATABASE+":"+ REDIS_KEY_ORDER_ID + date;
        Long increment = redisService.incr(key, 1);
        sb.append(date);
        sb.append(String.format("%02d", order.getSourceType()));
        sb.append(String.format("%02d", order.getPayType()));
        String incrementStr = increment.toString();
        if (incrementStr.length() <= 6) {
            sb.append(String.format("%06d", increment));
        } else {
            sb.append(incrementStr);
        }
        return sb.toString();
    }


    @Override
    public OmsOrderDetail getDetail(Long orderId) {

       return   orderDao.getDetail(orderId);

    }
}
