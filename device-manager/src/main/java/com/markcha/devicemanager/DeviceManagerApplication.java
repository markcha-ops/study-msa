package com.markcha.devicemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DeviceManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeviceManagerApplication.class, args);
	}

}
