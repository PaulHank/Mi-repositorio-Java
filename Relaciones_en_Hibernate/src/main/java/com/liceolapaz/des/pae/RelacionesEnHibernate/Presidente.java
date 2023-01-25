package com.liceolapaz.des.pae.RelacionesEnHibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Presidente {

	@Id
	private int id;
	@Column
	private String nombre;
	@Column
	private double sueldo;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DAMPais", foreignKey = @ForeignKey(name = "fk_pais"))
	private Pais idPais;
	
	

	public Presidente(int id, String nombre, double sueldo, Pais idPais) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.idPais = idPais;
	}

	
	public Pais getIdPais() {
		return idPais;
	}

	public void setIdPais(Pais idPais) {
		this.idPais = idPais;
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

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
}
