package com.liceolapaz.des.pae;

public class SincronizacionMetodos implements Runnable {
	
	public synchronized void metodo1() {
		System.out.println("Comienzo del metodo 1");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ie) {
			return;
		}
		System.out.println("Fin del metodo 1");
	}
	
	public synchronized void metodo2() {
		System.out.println("Comienzo del metodo 2");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ie) {
			return;
		}
		System.out.println("Fin del metodo 2");
	}
	
	public static void main(String[] args) {
		SincronizacionMetodos sm = new SincronizacionMetodos();
		new Thread(sm).start();
		new Thread(sm).start();

	}

	@Override
	public void run() {
		metodo1();
		metodo2();
	}

}
