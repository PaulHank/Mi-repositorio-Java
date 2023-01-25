package com.liceolapaz.des.pae.EjercicioEncriptacionServidor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ToEncript {
	@Id
	private int id;
	@Column
	private String cifrado;
	
	public ToEncript() {
		
	}
	
	public ToEncript(int id, String cifrado) {
		super();
		this.id = id;
		this.cifrado = cifrado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCifrado() {
		return cifrado;
	}

	public void setCifrado(String cifrado) {
		this.cifrado = cifrado;
	}
	
}
