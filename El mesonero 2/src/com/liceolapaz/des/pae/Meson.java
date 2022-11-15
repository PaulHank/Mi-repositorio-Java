package com.liceolapaz.des.pae;

public class Meson {
	
	public static void main(String[] args) {
		
		Barril b = new Barril();
		Mesonero serv = new Mesonero(b);
		Cliente client = new Cliente(b);
		
		Thread Agallas = new Thread(serv);
		Thread Paco = new Thread(client);
		Thread Manolo = new Thread(client);
		
		Agallas.start();
		Paco.start();
		Manolo.start();
		
	}
}
