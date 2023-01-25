package com.liceolapaz.des.persona;

import java.io.Serializable;

public class Persona implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//implements serializable
	String nombre;
	int edad;
	
	public Persona(String nombre, int edad)  {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}

	public Persona() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
}
