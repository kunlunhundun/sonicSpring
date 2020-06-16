package com.tiandihui.vpn.domain;

import com.tiandihui.vpn.mbg.model.OmsOrder;
import com.tiandihui.vpn.mbg.model.OmsOrderItem;

import java.util.List;

public class OmsOrderDetail extends OmsOrder {

    private List<OmsOrderItem> orderItemList;

    public List<OmsOrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OmsOrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
