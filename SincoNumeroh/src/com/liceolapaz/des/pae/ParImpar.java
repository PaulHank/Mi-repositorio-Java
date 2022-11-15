package com.liceolapaz.des.pae;

public class ParImpar extends Thread {
	public int[] numeros;

	public ParImpar(int[] numeros) {
		super();
		this.numeros = numeros;
	}
	
	public void comp() {
		System.out.println("");
		for (int it = 0; it < numeros.length; it++) {
			if (numeros[it] % 2 == 0) {
				System.out.println(numeros[it] + " es par");
			} else {
				System.out.println(numeros[it] + " es impar");
			}
		}
	}
	
	public void run() {
		this.comp();
		}

}
