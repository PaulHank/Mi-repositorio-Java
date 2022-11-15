package com.liceolapaz.des.pae;

public class ApalabradosSync {
	
	public static void main(String[] args) throws InterruptedException {
		
		Comp comp = new Comp("Aguacate", "Perejil");
		Comp comp2 = new Comp("Patata", "Gonzalo");
		Comp comp3 = new Comp("Agua", "Melodia");
		
		comp.start();
		comp.join();
		comp2.start();
		comp2.join();
		comp3.start();
	}

}
