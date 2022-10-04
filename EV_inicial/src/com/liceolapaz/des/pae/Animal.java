package com.liceolapaz.des.pae;

import java.util.ArrayList;

public class Animal {
     String nombre;
     int codigo;
     Sexo sexo;
     static boolean esterilizado;
     ArrayList<Animal> progenitores;
     static int countCode;
      
public Animal(String nombre, int codigo, Sexo sexo, boolean esterilizado, ArrayList<Animal> progenitores) {
	this.nombre = nombre;
	this.codigo = codigo;
	this.sexo = sexo;
	Animal.esterilizado = esterilizado;
	this.progenitores = progenitores;
}

public Animal(Animal animalPapa, Animal animalMama) {
	ArrayList<Animal> progenitores = new ArrayList<Animal>();
	progenitores.add(animalMama);
	progenitores.add(animalPapa);
	this.progenitores = progenitores;
}

public Animal() {
	this.codigo = ++countCode;
}

public Animal(String nombre, Sexo sexo, boolean esterilizado, ArrayList<Animal> progenitores) {
	this.nombre = nombre;
	this.sexo = sexo;
	this.esterilizado = esterilizado;
	this.progenitores = progenitores;
}

public static Animal aparear(Animal animalPapa, Animal animalMama) {
	if (SpEqual(animalMama, animalPapa)) {
		if(SxComp(animalMama, animalPapa)) {
			if(TaEsteril(animalPapa, animalMama)) {
				return new Animal(animalPapa, animalMama);
			}
		}
	}
	return null;
	
}

private static boolean TaEsteril(Animal animalPapa, Animal animalMama) {
	if(animalPapa.isEsterilizado() || animalMama.isEsterilizado()) {
		System.out.println("Uno de los animales es esteril");
		return false;
	}
	return true;
}

private static boolean SxComp(Animal animalMama, Animal animalPapa) {
	if(animalPapa.getSexo() != animalMama.getSexo()) {
		return true;
	}
	System.out.println("Son gays, esto no funciona.");
	return false;
}

private static boolean SpEqual(Animal animalMama, Animal animalPapa) {
	if(animalPapa.getClass().isInstance(animalMama)) {
		return true;
	}
	System.out.println("Los animales son de diferente especie.");
	return false;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public int getCodigo() {
	return codigo;
}

public void setCodigo(int codigo) {
	this.codigo = codigo;
}

public Sexo getSexo() {
	return sexo;
}

public void setSexo(Sexo sexo) {
	this.sexo = sexo;
}

public static boolean isEsterilizado() {
	return esterilizado;
}

public static void setEsterilizado(boolean esterilizado) {
	Animal.esterilizado = esterilizado;
}

public ArrayList<Animal> getProgenitores() {
	return progenitores;
}

public void setProgenitores(ArrayList<Animal> progenitores) {
	this.progenitores = progenitores;
}

@Override
public String toString() {
	return "- Animal - \n" + nombre 
			+ "\n" + codigo 
			+ "\n" + sexo 
			+ "\n" + progenitores;
}


}