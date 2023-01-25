package com.liceolapaz.des.pae.Cliente;

import java.io.Serializable;

public class Datos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nombre;
	String contra;
	
	public Datos(String nombre, String contra) {
		super();
		this.nombre = nombre;
		this.contra = contra;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}
	
}
