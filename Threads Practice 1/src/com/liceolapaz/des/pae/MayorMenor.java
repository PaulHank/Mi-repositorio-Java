package com.liceolapaz.des.pae;

public class MayorMenor extends Thread {
	Integer[] array;
		
	public MayorMenor(Integer[] array2) {
		super();
		this.array = array2;
	}
	
	@Override
	public void run() {
		int min = array[0];
		int max = array[0];
		
		
		for (int i = 0; i < array.length; i++) {
		     if (array[i] > max) {
		           max = array[i];
		     }
		}
		System.out.println(max);
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		System.out.println(min);
	}
}
