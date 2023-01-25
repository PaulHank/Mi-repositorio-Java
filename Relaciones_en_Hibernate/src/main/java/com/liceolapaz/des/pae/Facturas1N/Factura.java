package com.liceolapaz.des.pae.Facturas1N;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Factura {
	@Id
	private int codigo;
	@Column
	private String nombre;
	@OneToMany(fetch = FetchType.LAZY)
	private List<Lineas> lineas;
	

	public Factura(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
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

	public List<Lineas> getLineas() {
		return lineas;
	}

	public void setLineas(List<Lineas> lineas) {
		this.lineas = lineas;
	}
	
	public void masLineas(Lineas l) {
		lineas.add(l);
	}
	
	public void menosLineas(Lineas l) {
		lineas.remove(l);
	}	
}
