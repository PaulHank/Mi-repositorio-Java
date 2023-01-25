package com.liceolapaz.des.pae;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class HiloTrue implements Callable<Integer> {
	ArrayList<Integer> numerosTrue;
	int resultadoT;
	
	public HiloTrue(ArrayList<Integer> numerosTrue) {
		super();
		this.numerosTrue = numerosTrue;	
	}

	@Override
	public Integer call() throws Exception {
		System.out.println("Empezando operacion de trues...");
		for (int i = 0; i < numerosTrue.size(); i++) {
			resultadoT += numerosTrue.get(i);
		}
		return resultadoT;
	}
}