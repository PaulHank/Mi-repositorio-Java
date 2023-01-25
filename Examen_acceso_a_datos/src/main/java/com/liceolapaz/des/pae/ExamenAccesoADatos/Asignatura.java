package com.liceolapaz.des.pae.ExamenAccesoADatos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Asignatura {

	@Id
	int codigo;
	@Column
	String nombre;
	@Column
	int codCiclo;
	
	public Asignatura(int codigo, String nombre, int codCiclo) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.codCiclo = codCiclo;
	}


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


	public int getCodCiclo() {
		return codCiclo;
	}


	public void setCodCiclo(int codCiclo) {
		this.codCiclo = codCiclo;
	}
	

}
