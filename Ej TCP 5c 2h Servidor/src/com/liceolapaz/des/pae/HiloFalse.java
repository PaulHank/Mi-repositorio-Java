package com.liceolapaz.des.pae;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class HiloFalse implements Callable<Integer> {
	ArrayList<Integer> numerosFalse;
	int resultadoF;
	
	public HiloFalse(ArrayList<Integer> numerosFalse) {
		super();
		this.numerosFalse = numerosFalse;
	}

	@Override
	public Integer call() throws Exception {
		System.out.println("Empezando operacion de falses...");
		for (int i = 0; i < numerosFalse.size(); i++) {
			resultadoF += numerosFalse.get(i);
		}
		return resultadoF;
	}
}