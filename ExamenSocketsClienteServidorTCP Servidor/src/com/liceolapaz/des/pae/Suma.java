package com.liceolapaz.des.pae;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class Suma implements Callable<Integer> {
	ArrayList<Integer> array;
	int result;

	public Suma(ArrayList<Integer> array) {
		super();
		this.array = array;
	}

	public Integer call() throws Exception {
		int i = 0;
		while (i < array.size()) {
			result += array.get(i);
			i++;
		}
		return result;
	}
}
