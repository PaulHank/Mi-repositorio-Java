package com.liceolapaz.des.pae.RelacionesEnHibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pais {
	
	@Id
	private int codigo;
	@Column
	private String nombre;
	@Column
	private String continente;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContinente() {
		return continente;
	}
	public void setContinente(String continente) {
		this.continente = continente;
	}
	
	public Pais(int codigo, String nombre, String continente) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.continente = continente;
	}
	
	
		

}
