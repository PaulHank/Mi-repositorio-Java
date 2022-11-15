package com.liceolapaz.des.pae.dam22_23_hibernateintro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Alumno {
	
	@Id
	int codigo;
	@Column
	String nombre;
	@Column
	String curso;
	//Probar por mi cuenta si se puede hacer como digo yo (@Column String nombre, curso;)
	
	public Alumno(int codigo, String nombre, String curso) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.curso = curso;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getCurso() {
		return curso;
	}
	
	public void setCurso(String curso) {
		this.curso = curso;
	}
}