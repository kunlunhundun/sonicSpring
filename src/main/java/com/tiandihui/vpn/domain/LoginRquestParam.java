package com.tiandihui.vpn.domain;

import lombok.Data;

@Data
public class LoginRquestParam {

    private String username;
    private String password;
    private String deviceId;
    private String deviceBrand;

}
