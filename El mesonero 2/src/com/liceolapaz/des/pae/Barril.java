package com.liceolapaz.des.pae;

public class Barril {
	private int capacidad = 100;
	private boolean lleno = true;
	
	public int beber(int c) {
		if (lleno) {
			lleno = false;
			return capacidad;
		}
		return 0;
	}
	
	public void servir(int capacidad) {
		this.capacidad = capacidad;
		lleno = true;
	}

}
