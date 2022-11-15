package com.liceolapaz.des.pae;

import java.util.concurrent.Exchanger;

public class Overpass {

	public static void main(String[] args) {
		Exchanger<String> interlude = new Exchanger<String>();
		new Thread(new TareaUno(interlude)).start();
		new Thread(new TareaDos(interlude)).start();
	}
}