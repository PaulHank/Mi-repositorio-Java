package com.liceolapaz.des.pae;

public class El_Meson {

	public static void main(String[] args) {
		
		Clientela Paco = new Clientela("Paco");
		Clientela Juan = new Clientela("Juan");
		Clientela Jose = new Clientela("Jose");
		Clientela Manolo = new Clientela("Manolo");
		Clientela Adolfo = new Clientela("Adolfo");

		for (int i = 0; i < 24; i++) {
			(Paco).run();
			(Juan).run();
			(Jose).run();
			(Manolo).run();
			(Adolfo).run();
		}
		
		if (!Paco.isAlive() && !Juan.isAlive() && !Jose.isAlive() && !Manolo.isAlive() && !Adolfo.isAlive()) {
			System.err.println("Agallas lo logro.");
		}
	}
}


/*
 	Clientela[] clientes = {Paco,Juan,Jose,Manolo,Adolfo};
 	
 	for (Clientela e : clientes) {
 		for (Integer i : 24) {
		 	while (ba.capacidad > 0) {
		 		clientes[e].run();
		 		if (ba.capacidad <= 5) {
		 			Agallas.run();
		 		}
	 		}
 		}
 	}
 */


/*
	 Clientela[] clientes = {Paco,Juan,Jose,Manolo,Adolfo};
	 
	 for (Clientela e : clientes) {
	 	clientes[e].start();
	 	Thread.sleep(1000);
	 	if (ba.capacidad <= 5) {
	 		Agallas.run();
 		}
		}
 */