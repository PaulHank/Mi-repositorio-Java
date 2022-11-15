package com.liceolapaz.des.pae;

public class Mesonero extends Thread {
	
	public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\033[1;92m";
    //Verde + negrita
	

	
	@Override
	public void run() {
				Barril.capacidad = Barril.capacidad + 10;
				System.out.println(ANSI_GREEN + "Agallas ha rellenado el barril!" + ANSI_RESET);
	}
}