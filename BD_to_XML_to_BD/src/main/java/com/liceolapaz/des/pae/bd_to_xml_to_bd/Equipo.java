package com.liceolapaz.des.pae.bd_to_xml_to_bd;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Equipo {
	@Id
	int codEquipo;
	@Column
	String nombrEq;
	@Column
	String ciudad;
	@Column
	int anho;
	
	public Equipo(int codEquipo, String nombrEq, String ciudad, int anho) {
		super();
		this.codEquipo = codEquipo;
		this.nombrEq = nombrEq;
		this.ciudad = ciudad;
		this.anho = anho;
		}
	
	public int getCodEquipo() {
		return codEquipo;
	}
	
	public void setCodEquipo(int codEquipo) {
		this.codEquipo = codEquipo;
	}
	
	public String getNombrEq() {
		return nombrEq;
	}
	
	public void setNombrEq(String nombrEq) {
		this.nombrEq = nombrEq;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public int getAnho() {
		return anho;
	}
	
	public void setAnho(int anho) {
		this.anho = anho;
	}
	
}
