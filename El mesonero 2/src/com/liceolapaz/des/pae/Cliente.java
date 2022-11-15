package com.liceolapaz.des.pae;

import java.util.Random;

public class Cliente implements Runnable {
	
	private Barril barril;

	public Cliente(Barril b) {
		this.barril = b;
	}
	
	public void pedir() {
		Random rand = new Random();
		int copas = rand.nextInt(1,4);
	}

	@Override
	public void run() {
		int copas;
		
		
	}

}
