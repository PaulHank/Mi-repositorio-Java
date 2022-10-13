package com.liceolapaz.des.pae;

public class Raton extends Thread {

	private String nombre;
	private int tAlimentacion;
	
	public Raton(String nombre, int tAlimentacion) {
		super();
	}
	
	public void comer() {
		try {
			System.out.printf("El raton %s ha empezado a alimentarse%n", nombre);
			Thread.sleep(tAlimentacion * 1000);
			System.out.printf("El raton %s ha dejado de alimentarse%n", nombre);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int gettAlimentacion() {
		return tAlimentacion;
	}
	public void settAlimentacion(int tAlimentacion) {
		this.tAlimentacion = tAlimentacion;
	}
	@Override
	public String toString() {
		return "Raton [nombre=" + nombre + ", tAlimentacion=" + tAlimentacion + "]";
	}
	
	@Override
	public void run() {
		this.comer();
	}

}
