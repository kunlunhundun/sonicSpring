package com.tiandihui.vpn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TiandihuiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiandihuiApplication.class, args);
	}

}
