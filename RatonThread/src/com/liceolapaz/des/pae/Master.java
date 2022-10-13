package com.liceolapaz.des.pae;

public class Master {

	public static void main(String[] args) {
		Raton fievel = new Raton("Fievel", 4);
		Raton jerry = new Raton("Jerry", 5);
		Raton pinky = new Raton("Pinky", 3);
		Raton jamacuco = new Raton("Jamacuco", 6);
	
		fievel.start();
		jerry.start();
		pinky.start();
		jamacuco.start();
	}

}
