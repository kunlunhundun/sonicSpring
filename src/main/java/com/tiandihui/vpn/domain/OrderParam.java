package com.tiandihui.vpn.domain;

import lombok.Data;

@Data
public class OrderParam {

    //产品ID
    private Long productId;
    //skuID
    private Long productSkuId;
    //优惠券id
    private Long couponId;
    //使用的积分数
    private Integer useIntegration;
    //支付方式
    private Integer payType;

}
