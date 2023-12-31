package com.alarcon.webflux.client.services;

import org.springframework.http.codec.multipart.FilePart;

import com.alarcon.webflux.client.model.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
	
	public Flux<Product> findAll();
	public Mono<Product> findById(String id);
	public Mono<Product> save(Product p);
	public Mono<Product> update(Product p, String id);
	public Mono<Void> delete(String id);
	public Mono<Void> upload(FilePart file, String id);

}
