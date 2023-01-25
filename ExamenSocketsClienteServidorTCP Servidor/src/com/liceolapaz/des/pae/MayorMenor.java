package com.liceolapaz.des.pae;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class MayorMenor implements Callable<ArrayList<Integer>> {
	ArrayList<Integer> array;
	ArrayList<Integer> result = new ArrayList<Integer>();

	public MayorMenor(ArrayList<Integer> array) {
		super();
		this.array = array;
	}

	@Override
	public ArrayList<Integer> call() throws Exception {
		int minimo = array.get(0);
		for (int i = 1; i < array.size(); i++) {
		     if (array.get(i) < minimo) {
		           minimo = array.get(i);
		           result.add(minimo);
		     }
		}
		
		int maximo = array.get(0);
		for (int i = 1; i < array.size(); i++) {
			if(array.get(i) > maximo) {
				maximo = array.get(i);
				result.add(maximo);
			}
		}
		return result;
	}

}
