package com.liceolapaz.des.pae;

public class Productor implements Runnable {

	private Buffer buffer;
	
	private final String letras="abcdefghijklmnopqrstuvwyxz";
	
	public Productor (Buffer b) {
		this.buffer = b;
	}

	@Override
	public void run() {
		for (int i = 0; i<10; i++) {
			char c = letras.charAt((int)(Math.random()*letras.length()));
			buffer.poner(c);
			System.out.println(i + "Productor: " + c);
			try {
				Thread.sleep(400);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
