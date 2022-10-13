package com.liceolapaz.des.pae;

public class RatonSimple implements Runnable {
	private String nombre;
	private int tAlimentacion;
	private int aConsumido;

	public RatonSimple(String nombre, int tAlimentacion) {
		super();
		this.nombre = nombre;
		this.tAlimentacion = tAlimentacion;
	}
	
	public void comer() {
		try {
			System.out.printf("El raton %s esta empezado a comer%n", nombre);
			Thread.sleep(tAlimentacion * 1000);
			aConsumido++;
			System.out.printf("Alimento consumido:%d%n", aConsumido);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void run() {
		this.comer();
		
	}
	
	public static void main(String[] args) {
		RatonSimple fievel = new RatonSimple("Fievel", 4);
		new Thread(fievel).start();
		new Thread(fievel).start();
		new Thread(fievel).start();
		new Thread(fievel).start();
	}

}
