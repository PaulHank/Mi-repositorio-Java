package com.liceolapaz.des.pae;

public class Encontrar extends Thread {
	public int[] numeros;
	
	public Encontrar(int[] numeros) {
		super();
		this.numeros = numeros;
	}

	public void find() {
		System.out.println("");
		System.out.println("El primer valor de la lista es " + numeros[0] + " y el ultimo " + numeros[4]);
	}
	
	public void run() {
		this.find();
		}
}
