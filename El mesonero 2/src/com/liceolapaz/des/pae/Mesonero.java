package com.liceolapaz.des.pae;

public class Mesonero implements Runnable {

	private Barril barril;
	
	public Mesonero(Barril b) {
		this.barril = b;
	}

	@Override
	public void run() {
		for (int i = 0; i < 24; i++) {
			int c = 100;
			barril.beber(c);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
		
	}

}
