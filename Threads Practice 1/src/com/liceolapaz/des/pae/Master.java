package com.liceolapaz.des.pae;

import java.util.Scanner;

public class Master {

	public static void main(String[] args) {
		Integer[] array = new Integer[5];
		Scanner sc = new Scanner(System.in);
		
		int i = 0;

		
		try {
			while (i < array.length) {
				System.out.println("Pon un numero para la posicion " + i +" del array");	
				array[i] = Integer.parseInt(sc.next());
				while (array[i] < 0 || array[i] instanceof Integer) {
					System.out.println("Eso no era correcto, prueba otra vez. Index: ["+i+"]");
					array[i] = Integer.parseInt(sc.next());
				}
				i++;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		MayorMenor mm = new MayorMenor(array);
		Multiplicar mp = new Multiplicar(array);
		SumaPrimo sp = new SumaPrimo(array);
		mm.start();
		mp.start();
		sp.start();
		sc.close();
	}

}