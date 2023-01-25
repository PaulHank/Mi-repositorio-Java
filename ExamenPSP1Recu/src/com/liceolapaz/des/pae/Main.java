package com.liceolapaz.des.pae;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Elije cuantos numeros quieres insertar: \t");
		int cantidadNum = sc.nextInt();
		
		int[] array = new int[cantidadNum];
		
		int i = 0;
		while (i < array.length) {
			System.out.println("Introduce un numero entre 0 y 9");
			array[i] = sc.nextInt();
			while (array[i] < 0 || array[i] > 9) {
				System.err.println("El numero tiene que ser entre 0 y 9, prueba de nuevo.");
				array[i] = sc.nextInt();
			}
			i++;
		}
		
		TasksSumar sumar = new TasksSumar(array);
		TaskMayor mayor = new TaskMayor(array);
		/* Probablemente lo correcto era recojer el resultado de la thread 1 y usarlo para esta, 
		 * lo he intentado pero no me funcionaba asi que hice la otra opcion que era operar dos veces una suma */
		TaskCountdown cuenta = new TaskCountdown(array);
		
		Thread t1 = new Thread(sumar);
		Thread t2 = new Thread(mayor);
		Thread t3 = new Thread(cuenta);
		
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();

		sc.close();

	}

}
