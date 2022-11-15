package com.liceolapaz.des.pae;

public class Sumar extends Thread {
	public int[] numeros;

	public Sumar(int[] numeros) {
		super();
		this.numeros = numeros;
	}
	
	public void sumar() {
		System.out.println("");
		int suma = 0; 
		for (int i = 0; i < numeros.length; i++) {
			suma += numeros[i];
		}
		
		if ((suma / 5) == 0) {
			System.out.println("Los numeros son divisibles por 5");
		} else {
			System.out.println("Los numeros no son divisibles por 5");
		}
		
			System.out.println("La suma total de los valores introducidos es " + suma);
		
		return;
	}
	
	public void run() {
	this.sumar();
	}
}
