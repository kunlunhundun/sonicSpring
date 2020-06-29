package com.tiandihui.vpn.dao;

import com.tiandihui.vpn.mbg.model.OmsOrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WireguardUpdateConnectDao {

    int updateConnectStatus();

}
