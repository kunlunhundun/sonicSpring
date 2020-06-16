package com.tiandihui.vpn.domain;

import com.tiandihui.vpn.mbg.model.UmsMember;
import lombok.Data;

@Data
public class LoginSuccessInfo extends UmsMember {
    private String token;
    private int expireDay;
    private String tokenHead;
}
