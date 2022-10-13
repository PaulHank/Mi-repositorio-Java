package com.liceolapaz.des.pae;

public class Bomba implements Runnable {
	int segundos;
	String nombre;
	
	
	public Bomba(String nombre, int segundos) {
		super();
		this.nombre = nombre;
		this.segundos = segundos;
	}
	
	public void explotar() {
		System.out.printf("La bomba %s va a explotar!%n", nombre);
		for (int i = 0; i<segundos; segundos--){
			System.out.println(segundos);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			if (segundos == 0) {
			System.out.println(nombre + ": BOOM");
			}
	}
	
	public void run() {
		      this.explotar();
	}
	
	public static void main(String[] args) {
	    Bomba RushA = new Bomba("RushA", 10);
	    Bomba Lacasitos = new Bomba("Lacasitos", 10);
	    Bomba Tsar = new Bomba("Tsar", 10);
	    
	    new Thread(RushA).start();
	    new Thread(Lacasitos).start();
	    new Thread(Tsar).start();		
	} 
}