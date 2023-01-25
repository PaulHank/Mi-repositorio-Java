package com.liceolapaz.des.pae;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class HiloPrimos implements Callable<ArrayList<Integer>> {
	Integer[] recibos;
	
	public HiloPrimos(Integer[] recibos) throws IOException {
		this.recibos = recibos;
	}
	
	public ArrayList<Integer> call() {
		ArrayList<Integer> arrayResultado = new ArrayList<Integer>();
		for (int i = 0; i < recibos.length; i++) {
			if (recibos[i]%2 == 0) {
				System.out.println((recibos[i]) + " no es primo");
			} else {
				arrayResultado.add(recibos[i]);
				System.out.println(recibos[i] + " es primo");
			}
		}
		return arrayResultado;
	}
}