package com.alarcon.webflux.client.handler;

import java.net.URI;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.alarcon.webflux.client.model.Product;
import com.alarcon.webflux.client.services.ProductService;

import reactor.core.publisher.Mono;

@Component
public class ProductHandler {
	
	@Autowired
	private ProductService service;
	
	public Mono<ServerResponse> listar (ServerRequest request){
		return ServerResponse
				.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.findAll(), Product.class);
	}

	
	public Mono<ServerResponse> findById (ServerRequest request){		
		String id= request.pathVariable("id");
		return service.findById(id)
				.flatMap(p -> ServerResponse.ok()
						.contentType(MediaType.APPLICATION_JSON)
						.bodyValue(p))
				.switchIfEmpty(ServerResponse.noContent().build());
	}
	
	
	public Mono<ServerResponse> save(ServerRequest request){	
		System.out.println("ingrese al handler!!!!!");
		Mono<Product> product = request.bodyToMono(Product.class);
		return product.flatMap(p -> {
			if (null==p.getCreateAt()) {
				p.setCreateAt(new Date());
			}
			return service.save(p);
		})//cambiando a server response
				.flatMap(p -> 
				ServerResponse.created(URI.create("/api/client/".concat(p.getId())))
				.contentType(MediaType.APPLICATION_JSON)
				.bodyValue(p))
				.onErrorResume(error -> {
					NullPointerException errorResponse = (NullPointerException)error;
					 ServerResponse.badRequest()
							.contentType(MediaType.APPLICATION_JSON)
							.syncBody(errorResponse.getMessage());
					
					return Mono.error(errorResponse);
					});
		
	}

	
	public Mono<ServerResponse> update(ServerRequest request){	
		String id= request.pathVariable("id");		
		Mono<Product> product = request.bodyToMono(Product.class);
		
		return product.flatMap(p -> 
				ServerResponse.created(URI.create("/api/client/".concat(id)))
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.update(p, id), Product.class));
	}
	
	public Mono<ServerResponse> delete(ServerRequest request){	
		String id= request.pathVariable("id");		
		
		return service.delete(id)
				.then(ServerResponse.ok().build());
	}
	
}
