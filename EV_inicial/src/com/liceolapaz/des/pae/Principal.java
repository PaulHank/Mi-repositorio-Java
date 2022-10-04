package com.liceolapaz.des.pae;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public Principal() {}

	public static void main(String[] args) {

/* Preplanning code:
 * Animal animalPapa = progenitores.get(x)
 * x = scanner 
 * 
 * Other option
 * 
 * int IndiceAnimales = progenitores.indexOf("Rico")
 * if (IndiceAnimales < 0) {
 * 		System.out.println("Animal \"Rico"\ no encontrado.);
 * 		} else {
 * 		System.out.println("Animal Rico es el numero 2 + IndiceAnimales
 * 
 * Deberes personales: Probar a hacer un programa para operar y practicar los ArrayList.
*/
		AnimalSelect();
		String animal = leerOpc();
		
		if (animal.equals("perro")) {
			nuevoPerro();
		}
		if (animal.equals("gato")) {
			nuevoGato();
		} else { 
			System.out.println("Solo se admiten gatos u perros");
		}
	}

	private static Animal nuevoPerro() {
		Perros animal = null;
		PedirOp("nombre");
		String nombre = leerOpc();
		PedirOp("codigo");
		String codigo1 = leerOpc();
		int codigo = 0;
		try{
            codigo = Integer.parseInt(codigo1);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
		PedirOp("sexo");
		Sexo sexo = leerSexo();
	
		PedirOp("esterilizado");
		String esterilizado1 = leerOpc();
		boolean esterilizado = false;
		try {
			esterilizado = Boolean.parseBoolean(esterilizado1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PedirOp("progenitores");
		ArrayList<Animal> progenitores = leerAnimal();
		animal = new Perros(nombre, codigo, sexo, esterilizado, progenitores);
		System.out.println(animal);
		return animal;

			}
	
	private static Sexo leerSexo() {
		// TODO Auto-generated method stub
		return null;
	}

	private static Animal nuevoGato() {
		Gatos animal = null;
		PedirOp("nombre");
		String nombre = leerOpc();
		PedirOp("codigo");
		String codigo1 = leerOpc();
		int codigo = 0;
		try{
            codigo = Integer.parseInt(codigo1);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
		
		PedirOp("sexo");
		Sexo sexo = leerSexo();
		
		PedirOp("esterilizado");
		String esterilizado1 = leerOpc();
		boolean esterilizado = false;
		try {
			esterilizado = Boolean.parseBoolean(esterilizado1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PedirOp("progenitores");
		String[] progenitores = leerAnimal();
		
		PedirOp("limpio");
		String limpio1 = leerOpc();
		boolean limpio = false;
		try {
			limpio = Boolean.parseBoolean(limpio1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		animal = new Gatos(nombre, codigo, sexo, esterilizado, progenitores, limpio);	
		System.out.println("Nombre: " + nombre + "\n" +
							"Codigo: " + codigo + "\n" +
							"Sexo: " + sexo + "\n" +
							"Esterilizado: " + esterilizado + "\n" +
							"Progenitores: " + progenitores + "\n" +
							"Limpio: " + limpio);

		return animal;
	
			}

	private static String[] leerAnimal() {
		String[] papas = new String[2];
		datospapa();
		papas[0] = leerOpc();
		datosmama();
		papas[1] = leerOpc();
		return papas;
	}

	private static Animal datosmama() {
		System.out.println("Inserta el nombre de la madre");
		return null;
	}

	private static Animal datospapa() {
		System.out.println("inserta el nombre del padre");
		return null;
	}

	private static void PedirOp(String string) {
		System.out.println("Pon el " + string + " de tu mascota");
	}

	@SuppressWarnings("resource")
	private static String leerOpc() {
		Scanner scanner = new Scanner (System.in);
		return scanner.next();
		
	}

	private static void AnimalSelect() {
		System.out.println("Que tipo de animal es?");
	}

}
