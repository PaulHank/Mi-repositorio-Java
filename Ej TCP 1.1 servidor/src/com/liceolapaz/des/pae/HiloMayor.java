package com.liceolapaz.des.pae;

import java.io.IOException;
import java.util.concurrent.Callable;

public class HiloMayor implements Callable<Integer> {
	Integer[] recibos;

	public HiloMayor(Integer[] recibo) throws IOException {
		recibos = recibo;
	}
	
	public Integer call() {
		int max = recibos[0];
		for (int i = 1; i < recibos.length; i++) {
		     if (recibos[i] > max) {
		           max = recibos[i];
		     }
		}
		System.out.println((max) + " es el mayor numero de los pasados");
		return max;
	}
}