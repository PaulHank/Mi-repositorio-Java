package com.liceolapaz.des.pae;

public class Glotones implements Runnable{
	
	Hamburguesas hamburguesas;
	
	public Glotones(Hamburguesas hamburguesas) {
		this.hamburguesas = hamburguesas;
	}

	@Override
	public void run() {
		System.out.println("El gloton "  + Thread.currentThread().getId() + " ha empezado a comer");
		hamburguesas.comer();
	}
}
