package com.des.liceolapaz.pae;

public class ZaIn implements Runnable {

	@Override
	public void run() {
		int i = 1;
		while (i<4) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (i == 3) {
				System.out.println(Thread.currentThread().getName() + " " + "Zapatito ingles");
			}
			i++;
		}
		
	}

}
