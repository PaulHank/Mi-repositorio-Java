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
		System.out.println("FIGURAS GEOM�TRICAS \r\n"
				+ "1. Tri�ngulo \r\n"
				+ "2. Rect�ngulo \r\n"
				+ "3. Cuadrado \r\n"
				+ "4. Pentagono \r\n"
				+ "0. Salir \r\n"
				+ "Escoja opci�n:");
				
		//Lector de registro de teclado
		opciones = leerEleccion.next().charAt(0);	
		
		switch (opciones) {
		
		case '0' : System.out.print("Adi�ooooo"); break;
		
		case '1' : System.out.println("introduce longitud de base: "); 
					base = leerEleccion.nextInt(); System.out.println("introduce altura: "); altura = leerEleccion.nextInt();
						resultadoA = (base*altura)/2; System.out.println("El �era es: " +resultadoA+"cm� \r\n");
							System.out.println("Ahora introduce longitud de lado: "); lado = leerEleccion.nextInt(); resultadoP = lado+lado+lado; System.out.println("El per�metro es: " +resultadoP+"cm");
								break;
		
		case '2' : System.out.println("introduce longitud de lado: ");
					lado = leerEleccion.nextInt(); resultadoA = lado*lado; System.out.println("El �era es: " +resultadoA+"cm� \r\n");
						resultadoP =  lado+lado+lado+lado; System.out.println("El per�metro es: " +resultadoP+"cm");
							break;
			
		case '3' : System.out.println("Introduce tama�o de la base"); base = leerEleccion.nextInt(); System.out.println("introduce altura: "); altura = leerEleccion.nextInt();
					resultadoA = base*altura; System.out.println("El �era es: " +resultadoA+"cm� \r\n");
						resultadoP = base+base+altura+altura; System.out.println("El per�metro es: " +resultadoP+"cm"); 
							break;
			
		case '4' : System.out.println("Introduce cuantos lados tiene el poligono: "); NumLados = leerEleccion.nextInt(); 
					System.out.println("Introduce tama�o de lado del poligono: "); lado = leerEleccion.nextInt(); resultadoP = NumLados*lado; System.out.println("El per�metro del pol�gono es: " +resultadoP+ "cm");
						System.out.println("Ahora introduce el apotema: "); apotema = leerEleccion.nextInt();
						resultadoA = (resultadoP*apotema)/2; System.out.println("El pol�gono ocupa un total de: " +resultadoA+ "cm�");
							break;
					
		}

	}

}
