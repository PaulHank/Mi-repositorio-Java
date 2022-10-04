package com.liceolapaz.des.pae;

public class Perros extends Animal {

	@Override
	public String toString() {
		return "- Perro - \n" 
				+ nombre + "\n" 
				+ codigo + "\n" 
				+ sexo + "\n" 
				+ progenitores;
	}
	

}
