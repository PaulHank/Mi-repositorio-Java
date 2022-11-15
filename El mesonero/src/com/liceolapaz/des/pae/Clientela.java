package com.liceolapaz.des.pae;

import java.util.Random;

public class Clientela extends Thread {
	Random random = new Random();
	private String nombre;
	
	public Clientela (String nombre) {
		super();
		this.nombre = nombre;
	}
		
	@Override
	public void run() {
		try {
			
				int copas = random.nextInt(1,4);	
				System.out.printf("El cliente %s se bebio " + copas + " copas %n", nombre);
				Barril.capacidad = (Barril.capacidad - copas);
				
				System.out.println("Al barril le quedan " + Barril.capacidad + " litros");
				System.out.println();
				
				if (Barril.capacidad <= 5) {
					Mesonero mesonero = new Mesonero();
					mesonero.run();
				}
				
				if (Barril.capacidad <= 0) {
					System.err.printf("Agallas no ha sobrevivido a %s", nombre);
					System.out.println();
					return;
				}
				
				sleep(600);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}