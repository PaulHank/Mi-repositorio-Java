package com.liceolapaz.des.pae;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
	
		do {	
		escribirMenu();
		pedirOpcion();
		
		int opcion = leerOpcion();
		Figuras_Geometricas figura = null;
		switch (opcion) {
		
		case 1:
			
			double lado1 = 0;
			double lado2 = 0;
			double lado3 = 0;
			double altura = 0;
			EscribirSubMenu();
			
			opcion = leerOpcion();
			
			switch (opcion) {
			
			case 1:
			
				pedirBase();
				lado3 = leerNumeros();
				pedirAltura();
				altura = leerNumeros();
				figura = new Triangulo(lado1, lado2, lado3, altura);
				operarArea(figura);
				continue;
				
			case 2: 
				
				pedirLados();
				lado1 = leerNumeros();
				lado2 = leerNumeros();
				lado3 = leerNumeros();
				figura = new Triangulo(lado1, lado2, lado3, altura);
				operarPerimetro(figura);
				continue;
				
			case 0: continue;
			}
			
		case 2:
			
			double base = 0;
			double h = 0;
			EscribirSubMenu();
			
			opcion = leerOpcion();
			
			switch (opcion) {
			
			case 1:
				
				pedirBase();
				base = leerNumeros();
				pedirAltura();
				h = leerNumeros();
				figura = new Rectangulo(base, h);
				operarArea(figura);
				continue;
				
			case 2: 
				
				pedirBase();
				base = leerNumeros();
				pedirAltura();
				h = leerNumeros();
				figura = new Rectangulo(base, h);
				operarPerimetro(figura);
				continue;
				
			case 0: continue;
			}
			 
		case 3:
			
			double lado = 0;
			EscribirSubMenu();
			
			opcion = leerOpcion();
			
			switch (opcion) {
			 	
			case 1:
				
				pedirLado();
				lado = leerNumeros();
				figura = new Cuadrado(lado);
				operarArea(figura);
				continue;
				
			case 2: 
				pedirLado();
				lado = leerNumeros();
				figura = new Cuadrado(lado);
				operarPerimetro(figura);
				continue;
				
			case 0: continue;
			}
			
		case 4:
			lado = 0;
			double apotema = 0;
			EscribirSubMenu();
			
			opcion = leerOpcion();
			
			switch (opcion) {
			
			case 1:
				
				pedirLado();
				lado = leerNumeros();
				pedirApotema();
				apotema = leerNumeros();
				figura = new Pentagono(lado, apotema);
				operarArea(figura);
				continue;
				
			case 2: 
				
				pedirLado();
				lado = leerNumeros();
				figura = new Pentagono(lado, apotema);
				operarPerimetro(figura);
				continue;
				
			case 0: continue;
			}
			
		case 0: System.exit(0);
		}
		
		} while (true); 
	
	
} 

	private static void pedirApotema() {
		System.out.println("Introduce un apotema: ");
		
	}

	private static void pedirLado() {
		System.out.println("Introduce longitud de lado: ");
		
	}

	private static double operarPerimetro(Figuras_Geometricas figura) {

		return figura.calcularPerimetro();
		
	}
	
	private static double leerNumeros() {
		@SuppressWarnings("resource")
		Scanner escaner = new Scanner(System.in);
		return escaner.nextDouble();
	}
	
	private static void pedirOpcion() {
		System.out.println("Escoje figura: ");
		
	}
	
	private static double operarArea(Figuras_Geometricas figura) {
		
		return figura.calcularArea();
		
	}
	
	private static void pedirLados() {
		System.out.println("Establece los lados del triangulo: ");
		
	}
	
	private static void pedirAltura() {
		System.out.println("Establece una altura: ");
		
	}
	
	private static void pedirBase() {
		System.out.println("Establece una base: ");
	}
	
	private static void EscribirSubMenu() {
		System.out.println("Selecciona accion \r\n"
				+ "1.Calcular area\r\n"
				+ "2.Calcular perimetro \r\n"
				+ "0.Volver");	
	}
	
	private static int leerOpcion() {
		@SuppressWarnings("resource")
		Scanner escaner = new Scanner(System.in);
		return escaner.nextInt();
	}
	
	private static void escribirMenu() {
		System.out.println("Calculadora Geometrica \r\n"
				+ "1.Triangulo \r\n"
				+ "2.Rectangulo \r\n"
				+ "3.Cuadrado \r\n"
				+ "4.Pentagono \r\n"
				+ "0.Apagar");
	}

}