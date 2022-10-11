package com.example.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
// 开启自动缓存
@EnableCaching
public class BackendApplication {

	// 梦开始的地方
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
