package com.liceolapaz.des.pae;

public class TaskMayor implements Runnable {
	int[] array;

	public TaskMayor(int[] array) {
		this.array = array;	
	}

	@Override
	public void run() {
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
		     if (array[i] > max) {
		           max = array[i];
		     }
		}
		System.out.println(String.valueOf(max).repeat(max));
		
		System.out.println();
	}	
}
