package com.example.TenantInfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TenantInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TenantInfoApplication.class, args);
	}

}
