package com.tiandihui.cmd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VpnserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(VpnserverApplication.class, args);
	}

}
