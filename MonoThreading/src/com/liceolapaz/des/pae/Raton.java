package com.liceolapaz.des.pae;

public class Raton {

	private int tiempoAlimentacion;
	private String nombre;
	
	public Raton(String nombre, int tiempoAlimentacion) {
		super();
		this.nombre = nombre;
		this.tiempoAlimentacion = tiempoAlimentacion;
	}
	
	public void comer() {
		try {
			System.out.printf("Er raton %s ha empezado a comer%n" , nombre);
			Thread.sleep(tiempoAlimentacion * 1000);
			System.out.printf("El raton %s ha terminado de comer %n", nombre);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Raton Fievel = new Raton("Fievel", 4);
		Raton Henry = new Raton("Henry", 5);
		Raton Jerry = new Raton("Jerry", 3);
		Raton Mickey = new Raton("Mickey", 6);
		Fievel.comer();
		Henry.comer();
		Jerry.comer();
		Mickey.comer();
	}

}
