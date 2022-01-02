package com.markcha.bemsconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class BemsConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BemsConfigServerApplication.class, args);
	}

}
