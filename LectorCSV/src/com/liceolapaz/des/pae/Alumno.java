package com.liceolapaz.des.pae;

public class Alumno {

	private int id;
	private String nombre;
	private String ciclo;
	
	public Alumno(int id, String nombre, String ciclo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ciclo = ciclo;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	

}
