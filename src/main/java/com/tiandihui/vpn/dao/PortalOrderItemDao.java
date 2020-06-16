package com.tiandihui.vpn.dao;

import com.tiandihui.vpn.mbg.model.OmsOrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * 订单商品信息自定义Dao
 */
public interface PortalOrderItemDao {
    int insertList(@Param("list") List<OmsOrderItem> list);

}
