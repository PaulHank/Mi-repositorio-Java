package com.liceolapaz.des.pae;

public class Multiplicar extends Thread {
	Integer[] array;
	int resultado = 1;
	
	public Multiplicar(Integer[] array2) {
		this.array = array2;
	}
	
	@Override
	public void run()  {
		for (int i = 0; i < array.length; i++) {
			resultado = resultado * array[i];
		}
		
		if (resultado >= 100) {
			System.out.println(resultado + " Que numero tan grande!");
		} else {
			System.out.println(resultado + " Vaya timo de multiplicacion.");
		}
	}
	
}
