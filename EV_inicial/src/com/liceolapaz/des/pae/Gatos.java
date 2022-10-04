package com.liceolapaz.des.pae;

import java.util.ArrayList;

public class Gatos extends Animal {
	static boolean limpio;

	public Gatos(Animal animal) {
		super(animal.getNombre(), animal.getSexo(), animal.isEsterilizado(), animal.getProgenitores());
			this.limpio = false;
		}
	
	public Gatos(String nombre, Sexo sexo, boolean esterilizado, ArrayList<Animal> progenitores, boolean limpio) {
		super(nombre, sexo, esterilizado, progenitores);
		this.limpio = limpio;
	}
	
	static boolean isLimpio() {
		return limpio;
	}

	static void setLimpio(boolean limpio) {
		Gatos.limpio = limpio;
	}

	void lavar() {
		if(!this.isLimpio()) {
			this.setLimpio(true);
			System.out.println("Gato limpito");
		}
	}

	@Override
	public String toString() {
		return "- Gato - \n" 
				+ nombre + "\n" 
				+ codigo + "\n" 
				+ sexo + "\n" 
				+ progenitores;
	}
	
	
}
