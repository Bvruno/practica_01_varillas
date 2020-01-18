package com.isil.practica01.model;

/**
 * Auto.java
 * This is a model class represents a Auto entity
 * @author Bruno Varillas
 *
 */
public class Auto {
	protected int id;
	protected String modelo;
	protected String color;
	protected String marca;
	
	public Auto() {
	}
	
	public Auto(String modelo, String color, String marca) {
		super();
		this.modelo = modelo;
		this.color = color;
		this.marca = marca;
	}

	public Auto(int id, String modelo, String color, String marca) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.color = color;
		this.marca = marca;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
}
