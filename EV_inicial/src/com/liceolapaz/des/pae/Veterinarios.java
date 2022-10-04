package com.liceolapaz.des.pae;

public class Veterinarios {
	private int codigo;
	String nombre;	
	static int counter;
	
	
	public Veterinarios() {
		this.codigo = ++counter;
	}
	
	public Veterinarios(String nombre) {
		this.nombre = nombre;
		this.codigo = ++counter;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Veterinarios.counter = counter;
	}
	
	public void esterilizar(Animal animal) {
	if (Animal.isEsterilizado() == false) {
		Animal.setEsterilizado(true); 
		System.out.println("El animal ha sido esterilizado por " + nombre + " con codigo " + codigo);
		} else { 
			System.out.println("Este animal ya es esteril");
		}
	}

	@Override
	public String toString() {
		return "Veterinarios [codigo=" + codigo + ", nombre=" + nombre + "]";
	}	
}