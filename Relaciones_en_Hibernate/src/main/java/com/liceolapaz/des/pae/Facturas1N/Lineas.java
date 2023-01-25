package com.liceolapaz.des.pae.Facturas1N;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Lineas {
	@Id
	private int id;
	@Column
	private int importe;
	@Column
	private String material;
	
	public Lineas(int id, int importe, String material) {
		super();
		this.id = id;
		this.importe = importe;
		this.material = material;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getImporte() {
		return importe;
	}

	public void setImporte(int importe) {
		this.importe = importe;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
}