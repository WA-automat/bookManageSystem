package com.example.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author WA_automat
 * @version 1.0
 * @since 2022-10-12
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
// 开启自动缓存
@EnableCaching
public class BackendApplication {

	// 梦开始的地方
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
