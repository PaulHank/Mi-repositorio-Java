package com.liceolapaz.des.pae;

import java.util.Scanner;

public class Principal extends Thread {
	private volatile boolean flag1 = false;
	private volatile boolean flag2 = false;
	int[] numero;
	int suma;
	
	public Principal (int[] numero) {
		this.numero = numero;
	}
	
	public synchronized void sumar() {

		for (int i = 0; i < numero.length; i++) { suma += numero[i]; }
		
		System.out.println("La suma de los numero es: " + suma);
	
		if (suma % 2 == 0) { System.out.println("La suma es par."); } 
		else { System.out.println("La suma es impar."); }
		
		System.out.println();
	
	}
	
	public synchronized void display() {
	
		int max = numero[0];
		for (int i = 1; i < numero.length; i++) {
		     if (numero[i] > max) {
		           max = numero[i];
		     }
		}
		for (int i = 0; i < max; i++) {
			System.out.print(max);
		}
		
		System.out.println();
		try {
			this.wait(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		notify();
	
	}
	
	public synchronized void countdown() {
	
		try { wait(); } 
		catch (Exception e) { e.printStackTrace(); }
		
		for (int i = 0; i < suma; suma--) {
			System.out.println(suma);
			try {
				sleep(1000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		
		System.out.println("Despegue!");
		System.out.println();	
	
	}
	
	
	public void run() {
		if (!flag1) {
			flag1 = true;
			sumar();
		} else {
			if (!flag2) {
				flag2 = true;
				display();
			} else {
				countdown();
			}
		}
		return;
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner lector = new Scanner(System.in);
		
		System.out.println("Elije cuantos numeros quieres insertar: \t");
		
		int cantidadNum = lector.nextInt();
		
		int[] numeros = new int[cantidadNum];
		
		for (int i = 0; i < cantidadNum; i++) {
			System.out.println("Introduce un numero entre 0 y 9");
			numeros[i] = lector.nextInt();
			while (numeros[i] < 0 || numeros[i] > 9) {
				System.err.println("El numero tiene que ser entre 0 y 9, prueba de nuevo.");
				numeros[i] = lector.nextInt();
			}
		}
		
		Principal operaciones = new Principal(numeros);
		new Thread(operaciones).start();
		new Thread(operaciones).start();
		new Thread(operaciones).start();
		
	}

}
