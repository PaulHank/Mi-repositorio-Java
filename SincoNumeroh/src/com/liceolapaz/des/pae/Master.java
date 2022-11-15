package com.liceolapaz.des.pae;

import java.util.Arrays;
import java.util.Scanner;

public class Master {

	public static void main(String[] args) {
		
	mM();

	int[] numeros = new int[5];
	for (int it = 0; it < numeros.length; it++) {
		int a = reader();
		while (a < 0) {
			System.err.println("El numero introducido no puede ser negativo, por favor, vuelve a introducirlo.");
			a = reader();
		}
		numeros[it]= a;
	}
	System.out.println(Arrays.toString(numeros));
	
	
	Sumar sum = new Sumar(numeros);
	sum.start();
	
	Encontrar fin = new Encontrar(numeros);
	fin.start();
	
	ParImpar odd = new ParImpar(numeros);
	odd.start();
	}

	private static void mM() {
		System.out.println("Introduce 5 numeros enteros" 
						 + "\rNo decimales ni negativos por favor.");
	}

	private static int reader() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}
}
