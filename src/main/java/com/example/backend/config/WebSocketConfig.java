package com.example.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author WA_automat
 * @version 1.0
 * @since 2022-10-12
 */
// 后续实现websocket相关内容
// (继续画饼)
@Configuration
public class WebSocketConfig {

	@Bean
	public ServerEndpointExporter serverEndpointExporter() {

		return new ServerEndpointExporter();
	}
}
