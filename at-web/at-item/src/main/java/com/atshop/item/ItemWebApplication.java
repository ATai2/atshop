package com.atshop.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ItemWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemWebApplication.class, args);
	}

}
