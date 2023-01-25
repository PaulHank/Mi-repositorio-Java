package com.liceolapaz.des.pae;

public class Main {

	public static void main(String[] args) {
		
		Hamburguesas hamburguesas = new Hamburguesas();
		
		Glotones glotones = new Glotones(hamburguesas);
		
		Thread gloton1 = new Thread(glotones);
		Thread gloton2 = new Thread(glotones);
		
		System.out.println("Hay " + hamburguesas.numeroHamburguesas + " hamburguesas");
		
		gloton1.start();
		gloton2.start();
	}
}