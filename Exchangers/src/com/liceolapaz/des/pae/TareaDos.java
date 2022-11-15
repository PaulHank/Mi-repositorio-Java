package com.liceolapaz.des.pae;

import java.util.concurrent.Exchanger;

public class TareaDos implements Runnable {
	private Exchanger<String> interlude;
	
	public TareaDos (Exchanger<String> interlude) {
		super();
		this.interlude = interlude;
	}

	@Override
	public void run() {
		try {
			String msg = interlude.exchange("Mensaje enviado por TareaDos ");
			System.out.println("Mensaje recibido en TareaDos " + msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}