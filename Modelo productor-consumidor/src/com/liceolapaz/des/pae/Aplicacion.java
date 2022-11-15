package com.liceolapaz.des.pae;


public class Aplicacion {

	public static void main(String[] args) {


		Buffer b = new Buffer();
		Productor prod = new Productor(b);
		Consumidor cons = new Consumidor(b);
		
		Thread tProd = new Thread(prod);
		Thread tCons = new Thread(cons);
		
		
		tProd.start();
		tCons.start();

	}

}
