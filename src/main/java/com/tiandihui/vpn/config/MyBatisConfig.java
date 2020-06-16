package com.tiandihui.vpn.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.tiandihui.vpn.mbg.mapper","com.tiandihui.vpn.dao"})
public class MyBatisConfig {
}
