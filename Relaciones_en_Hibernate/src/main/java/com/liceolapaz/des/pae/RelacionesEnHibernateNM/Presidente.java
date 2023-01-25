package com.liceolapaz.des.pae.RelacionesEnHibernateNM;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;

@Entity
public class Presidente {

	@Id
	private int id;
	@Column
	private String nombre;
	@Column
	private double sueldo;
	@ManyToMany(mappedBy = "listaPresidentes")
	private List<Pais> pais;
	
	

	public Presidente(int id, String nombre, double sueldo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.sueldo = sueldo;
		//this.pais = pais;
	}

	
	/*
	public Pais getPais() {
		return pais;
	}

	public void setIdPais(Pais pais) {
		this.pais = pais;
	}
	*/
	
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

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
}
