package com.alarcon.webflux.client.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.http.codec.multipart.FilePart;

import static org.springframework.http.MediaType.*;

import java.util.Collections;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.alarcon.webflux.client.model.Mapper;
import com.alarcon.webflux.client.model.Product;
import com.alarcon.webflux.client.model.api.Producto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired(required=true)
	private WebClient client;

	@Override
	public Flux<Product> findAll() {
		//Flux<Producto> productsCliente = client.get().accept(APPLICATION_JSON).retrieve().bodyToFlux(Producto.class);
		
		return client.get()
				.accept(APPLICATION_JSON)
				.retrieve()
				.bodyToFlux(Producto.class)
				.map(client -> {
					return Mapper.mapToProduct(client);
				});
	
	}

	@Override
	public Mono<Product> findById(String id) {

		return client
				.get()
				.uri("/{id}", Collections.singletonMap("id", id))
				.accept(APPLICATION_JSON)
				.retrieve()
				.bodyToMono(Producto.class)
				.map(response ->  {
					return Mapper.mapToProduct(response);
				});
	}

	@Override
	public Mono<Product> save(Product p) {
		System.out.println("ingresamos al service!");
		return client
				.post()
				.accept(APPLICATION_JSON)
				.contentType(APPLICATION_JSON)
				// .body(BodyInserters.fromObject(p))
				.bodyValue(Mapper.mapToClient(p))
				.retrieve()
				.bodyToMono(Producto.class)
				.map(response ->  {
					return Mapper.mapToProduct(response);
				});
			
				
	}

	@Override
	public Mono<Product> update(Product p, String id) {
		System.out.println("update!!");
		return client
				.put()
				.uri("/{id}", Collections.singletonMap("id", id))
				.accept(APPLICATION_JSON)
				.contentType(APPLICATION_JSON)
				.bodyValue(Mapper.mapToClient(p))
				.retrieve()
				.bodyToMono(Producto.class).map(response ->  {
					return Mapper.mapToProduct(response);
				});
	}

	@Override
	public Mono<Void> delete(String id) {
		return client
				.delete()
				.uri("/{id}", Collections.singletonMap("id", id))
				.accept(APPLICATION_JSON)
				.retrieve()
				.bodyToMono(Void.class);
	}

	@Override
	public Mono<Void> upload(FilePart file, String id) {
		MultipartBodyBuilder parts = new MultipartBodyBuilder();
		parts.asyncPart("file", file.content(), DataBuffer.class)
		.headers(h ->{
			h.setContentDispositionFormData("file", file.filename());
		});
		return null;
	}

}
