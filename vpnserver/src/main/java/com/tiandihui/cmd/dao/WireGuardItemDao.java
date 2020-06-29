package com.tiandihui.cmd.dao;

import com.tiandihui.cmd.mbg.model.UmsVpnWireguard;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface WireGuardItemDao {

    int insertList(@Param("list") List<UmsVpnWireguard> list);

}
