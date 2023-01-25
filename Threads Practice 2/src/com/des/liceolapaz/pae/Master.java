package com.des.liceolapaz.pae;

public class Master {

	public static void main(String[] args) {
		
		ZaIn nojeque = new ZaIn();
		
		Thread a = new Thread(nojeque);
		Thread b = new Thread(nojeque);
		Thread c = new Thread(nojeque);
		Thread d = new Thread(nojeque);
		Thread e = new Thread(nojeque);
		
		a.start();
		b.start();
		c.start();
		d.start();
		e.start();
	}

}
