package com.liceolapaz.des.pae;

import java.util.concurrent.Exchanger;

public class TareaUno implements Runnable {
	private Exchanger<String> interlude;
	
	public TareaUno (Exchanger<String> interlude) {
		super();
		this.interlude = interlude;
	}

	@Override
	public void run() {
		try {
			String msg = interlude.exchange("Mensaje enviado por TareaUno ");
			System.out.println("Mensaje recibido en TareaUno " + msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}