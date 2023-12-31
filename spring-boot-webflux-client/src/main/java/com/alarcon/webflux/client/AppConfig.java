package com.alarcon.webflux.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class AppConfig {
	
	@Value("${config.client.endpoint}")
	private String url;
	
	@Bean
	public WebClient registrarWEbCliente() {
		//return WebClient.create("http://localhost:8080/v2/products");
		return WebClient.create(url);
	}

}
