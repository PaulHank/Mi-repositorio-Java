package com.liceolapaz.des.pae;

import java.io.IOException;
import java.util.concurrent.Callable;

public class HiloSumas implements Callable<Integer> {
	Integer[] recibos;
	int suma;
	String resultado = "";

	public HiloSumas(Integer[] recibo) throws IOException {
		recibos = recibo;
	}
	
	public Integer call() {
		
		for (int i = 0; i < recibos.length; i++) {
			suma += recibos[i]; 
			}
		
		resultado = String.valueOf(suma) + " es la suma de los valores pasados";
		System.out.println(resultado);
		return suma;
	}
}

/*

public class HiloSumas implemnents Runnable {

	public HiloSumas(Integer[] recibo) throws IOException {
		recibos = recibo;
	}
	
	public void run() {
		int suma = 0;
		for (int i = 0; i < recibos.length; i++) {
			suma += recibos[i]; 
			}
			
		resultado = String.valueOf(suma) + " es la suma de los valores pasados";
		System.out.println(resultado);
}

*/