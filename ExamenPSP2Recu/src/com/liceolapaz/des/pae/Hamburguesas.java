package com.liceolapaz.des.pae;

public class Hamburguesas {
	int numeroHamburguesas = 50;
	boolean hay = true;
	
	public synchronized void comer() {
		while (hay) {
			numeroHamburguesas = numeroHamburguesas -1;
			System.out.println("El gloton " + Thread.currentThread().getId() + " se ha comido una hamburguesa, quedan " + numeroHamburguesas);
			if (numeroHamburguesas == 0) {
				hay = false;
				System.out.println("Se acabaron las hamburguesas, el gloton " + Thread.currentThread().getId() + " ha terminado de comerselas");
			}
			
			try {
				wait(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
