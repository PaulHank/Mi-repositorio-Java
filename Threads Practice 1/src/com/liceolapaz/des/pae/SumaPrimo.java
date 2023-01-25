package com.liceolapaz.des.pae;

public class SumaPrimo extends Thread {
	Integer[] array;
	int resultado;
	
	public SumaPrimo(Integer[] array2) {
		this.array = array2;
	}
	
	@Override
	public void run() {
		for (int i = 0; i<array.length; i++) {
			resultado += array[i];
		}
		if (resultado %2 == 0) {
			System.out.println("El resultado (la suma de los valores) es primo");			
		} else {
			System.out.println("El resultado (la suma de los valores) no es primo");
		}
	}

}
