package com.liceolapaz.des.pae;

import java.io.Serializable;

public class POJO implements Serializable {

	private static final long serialVersionUID = -3955914379653705082L;
	int numero;
	boolean booleano;
	
	public POJO(int numero,boolean booleano) {
		super();
		this.numero = numero;
		this.booleano = booleano;
	}	
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean getBooleano() {
		return booleano;
	}

	public void setBooleano(boolean booleano) {
		this.booleano = booleano;
	}
}