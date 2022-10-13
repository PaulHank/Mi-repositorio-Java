package com.liceolapaz.des.pae;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Queuer implements Runnable {
	private static Queue<Integer> cola = new ConcurrentLinkedDeque<Integer>();

	@Override
	public void run() {
		cola.add(6);
		/*Dependiendo de si se usa "int" o "Integer", el resultado del programa es alterado en terminos de orden.
		  int saca un resultado mas desordenado, por algun motivo, mientras que Integer da uno mas estructurado. */
		for (Integer i : cola) {
			System.out.println(i + ":");
			System.out.println("Tamaño de cola: " + cola.size());
		}
	}
	
	public static void main(String[] args) {
		for (int i = 0; i<6; i++) {
			new Thread(new Queuer()).start();
		}
	}
}