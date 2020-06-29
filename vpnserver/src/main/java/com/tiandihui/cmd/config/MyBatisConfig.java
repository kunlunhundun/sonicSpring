package com.tiandihui.cmd.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.tiandihui.cmd.mbg.mapper","com.tiandihui.cmd.dao"})
public class MyBatisConfig {
}
