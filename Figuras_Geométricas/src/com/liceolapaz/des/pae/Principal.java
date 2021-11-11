package com.liceolapaz.des.pae;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		///Generar menu principal y asignar opciones a este.
		
		
		//Variables
		
		int NumLados;
		
		double lado;
		double base;
		double altura;
		double apotema;
		
		char opciones;
		
		double resultadoA;
		double resultadoP;
		
		
		//Lector de teclado 
		@SuppressWarnings("resource")
		Scanner leerEleccion = new Scanner (System.in);
		
		
		//Menu visual
		System.out.println("FIGURAS GEOMÉTRICAS \r\n"
				+ "1. Triángulo \r\n"
				+ "2. Rectángulo \r\n"
				+ "3. Cuadrado \r\n"
				+ "4. Pentagono \r\n"
				+ "0. Salir \r\n"
				+ "Escoja opción:");
				
		//Lector de registro de teclado
		opciones = leerEleccion.next().charAt(0);	
		
		switch (opciones) {
		
		case '0' : System.out.print("Adióooooo"); break;
		
		case '1' : System.out.println("introduce longitud de base: "); 
					base = leerEleccion.nextInt(); System.out.println("introduce altura: "); altura = leerEleccion.nextInt();
						resultadoA = (base*altura)/2; System.out.println("El áera es: " +resultadoA+"cm² \r\n");
							System.out.println("Ahora introduce longitud de lado: "); lado = leerEleccion.nextInt(); resultadoP = lado+lado+lado; System.out.println("El perímetro es: " +resultadoP+"cm");
								break;
		
		case '2' : System.out.println("introduce longitud de lado: ");
					lado = leerEleccion.nextInt(); resultadoA = lado*lado; System.out.println("El áera es: " +resultadoA+"cm² \r\n");
						resultadoP =  lado+lado+lado+lado; System.out.println("El perímetro es: " +resultadoP+"cm");
							break;
			
		case '3' : System.out.println("Introduce tamaño de la base"); base = leerEleccion.nextInt(); System.out.println("introduce altura: "); altura = leerEleccion.nextInt();
					resultadoA = base*altura; System.out.println("El áera es: " +resultadoA+"cm² \r\n");
						resultadoP = base+base+altura+altura; System.out.println("El perímetro es: " +resultadoP+"cm"); 
							break;
			
		case '4' : System.out.println("Introduce cuantos lados tiene el poligono: "); NumLados = leerEleccion.nextInt(); 
					System.out.println("Introduce tamaño de lado del poligono: "); lado = leerEleccion.nextInt(); resultadoP = NumLados*lado; System.out.println("El perímetro del polígono es: " +resultadoP+ "cm");
						System.out.println("Ahora introduce el apotema: "); apotema = leerEleccion.nextInt();
						resultadoA = (resultadoP*apotema)/2; System.out.println("El polígono ocupa un total de: " +resultadoA+ "cm²");
							break;
					
		}

	}

}
