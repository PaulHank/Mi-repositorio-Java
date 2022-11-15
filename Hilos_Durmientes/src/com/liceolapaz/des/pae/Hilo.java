package com.liceolapaz.des.pae;

import java.util.Random;

public class Hilo extends Thread {
	private String nombre;

	public Hilo(String nombre) {
		this.nombre = nombre;
	}

	public void run() {
	    while (true) {
			System.out.printf("Soy el Hilo %s y estoy trabajando %n", nombre);
		      try {
		    	  Random randint = new Random();
		    	  int random = 10;
		    	  int al = randint.nextInt(random);
				Thread.sleep(1000 * al);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }
	}
	public static void main(String[] args) {
		Hilo A = new Hilo("A");
		Hilo B = new Hilo("B");
		Hilo C = new Hilo("C");
		Hilo D = new Hilo("D");
		Hilo E = new Hilo("E");
		
		new Thread(A).start();
		new Thread(B).start();
		new Thread(C).start();
		new Thread(D).start();
		new Thread(E).start();

	}

}
