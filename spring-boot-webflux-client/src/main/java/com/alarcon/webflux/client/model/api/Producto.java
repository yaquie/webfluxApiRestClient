package com.alarcon.webflux.client.model.api;

import java.util.Date;


public class Producto {

	
	private String id;
	
	private String nombre;
	
	
	private Double precio;
	
	private Date createAt;

	private Categoria categoria;
	
	private String foto;

	public Producto() {
		super();
	}

	public Producto(String id, String nombre, Double precio, Date createAt, Categoria categoria, String foto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.createAt = createAt;
		this.categoria = categoria;
		this.foto = foto;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", createAt=" + createAt
				+ ", categoria=" + categoria + ", foto=" + foto + "]";
	}



}
