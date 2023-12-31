package com.alarcon.webflux.client.model;

import com.alarcon.webflux.client.model.api.Categoria;
import com.alarcon.webflux.client.model.api.Producto;

public class Mapper {
	
	public static Product mapToProduct(Producto client) {
	Product p = new Product();
	p.setId(client.getId());
	p.setName(client.getNombre());
	p.setPhoto(client.getFoto());
	p.setPrice(client.getPrecio());
	p.setCreateAt(client.getCreateAt());
	
	Category c = new Category();
	c.setId(client.getCategoria().getId());
	c.setName(client.getCategoria().getNombre());
	
	p.setCategory(c);
	
	return p;
	}
	
	public static Producto mapToClient(Product request) {
		System.out.println("request: " + request.toString());
		Producto client = new Producto();
		client.setNombre(request.getName());
		client.setFoto(request.getPhoto());
		client.setPrecio(request.getPrice());
		client.setCreateAt(request.getCreateAt());
		
		Categoria cat = new Categoria();
		cat.setId(request.getCategory().getId());
		cat.setNombre(request.getCategory().getName());
		
		client.setCategoria(cat);
		System.out.println("Producto: " + client.toString());
		
		return client;
		}


}
