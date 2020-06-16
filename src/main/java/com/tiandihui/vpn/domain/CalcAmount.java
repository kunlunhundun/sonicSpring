package com.tiandihui.vpn.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CalcAmount {

    //订单商品总金额
    private BigDecimal totalAmount;
    //运费
    private BigDecimal freightAmount;
    //活动优惠
    private BigDecimal promotionAmount;
    //应付金额
    private BigDecimal payAmount;

}
