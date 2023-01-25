package com.liceolapaz.des.pae;

public class TasksSumar implements Runnable {
	int[] array;
	int suma;
	
	public TasksSumar(int[] array) {
		this.array = array;
	}
	
	@Override
	public void run() {
		
		int i = 0;
		while (i<array.length) {
			suma += array[i];
			i++;
		}
		
		System.out.println("La suma es: " + suma);
	
		if (suma % 2 == 0) { 
			System.out.println("La suma es par."); 
		} else { 
			System.out.println("La suma es impar."); 
		}
		System.out.println();
	}

}
