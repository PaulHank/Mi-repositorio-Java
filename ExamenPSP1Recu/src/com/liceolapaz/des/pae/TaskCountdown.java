package com.liceolapaz.des.pae;

public class TaskCountdown implements Runnable {
	int[] array;

	public TaskCountdown(int[] array) {
		this.array = array;	
	}

	@Override
	public synchronized void run() {
		int suma = 0;
		
		int i = 0;
		while (i<array.length) {
			suma += array[i];
			i++;
		}
		
		int t = 0;
		while (t < suma) {
			System.out.println(suma);
			suma--;
			try {
				this.wait(1000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		
		System.out.println("Despegue!");
		System.out.println();
		
	}

}
