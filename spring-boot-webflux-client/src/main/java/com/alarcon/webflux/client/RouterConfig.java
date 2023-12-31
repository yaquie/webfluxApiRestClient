package com.alarcon.webflux.client;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import org.springframework.web.reactive.function.server.RouterFunction;
import static org.springframework.web.reactive.function.server.RouterFunctions.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.alarcon.webflux.client.handler.ProductHandler;

@Configuration
public class RouterConfig {
	
	@Bean
	public RouterFunction<ServerResponse> rutas (ProductHandler handler){
		
		return route(GET("/api/client"), handler::listar)
				.andRoute(GET("/api/client/{id}"), handler::findById)
				.andRoute(POST("/api/client"), handler::save)
				.andRoute(PUT("/api/client/{id}"), handler::update)
				.andRoute(DELETE("/api/client/{id}"), handler::delete);
	}

}
