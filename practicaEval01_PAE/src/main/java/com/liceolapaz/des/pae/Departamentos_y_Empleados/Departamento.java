package com.liceolapaz.des.pae.Departamentos_y_Empleados;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Departamento {
	
	@Id
	int codigo;
	@Column
	String nombre,provincia;
	
	public Departamento(int codigo, String nombre, String provincia) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.provincia = provincia;
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

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

}