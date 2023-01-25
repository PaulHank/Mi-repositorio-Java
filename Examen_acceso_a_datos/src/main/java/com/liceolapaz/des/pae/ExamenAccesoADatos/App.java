package com.liceolapaz.des.pae.ExamenAccesoADatos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class App {
	
    public static void main( String[] args ) throws FileNotFoundException {
    	
    	JDBC jdbc = new JDBC();
    	XML xml = new XML();
    	HIBERNATE hibernate = new HIBERNATE();
    	String input = null;
    
    	
    	while (true) {
    		Scanner sc = new Scanner(System.in);
			System.out.println("EXAMEN 1ª EVAL \n" 
							 + "1. JDBC \n" 
							 + "2. XML \n" 
							 + "3. HIBERNATE \n" 
							 + "4. SALIR \n");

	    	BufferedReader brAsignaturas = new BufferedReader(new FileReader("C:\\Users\\Pablo Abeijón DAM\\Downloads\\asignatura.csv"));
	    	BufferedReader brCiclo = new BufferedReader(new FileReader("C:\\Users\\Pablo Abeijón DAM\\Downloads\\ciclo.csv"));

			input = sc.next();
			if (check(input)) {
				int opcion = Integer.parseInt(input);
									
				switch (opcion) {
				case 1:
					jdbc.insert(brAsignaturas, brCiclo);
					break;
				
				case 2:
					xml.write(brAsignaturas, brCiclo);		
					break;
					
				case 3:
					hibernate.insert(brAsignaturas, brCiclo);
					break;
		
				case 4:
					System.exit(0);
					break;
				}
			}
		}	
    }

	private static boolean check(String input) {
		try {
			Integer opcionChekada = Integer.parseInt(input);
			if (opcionChekada > 4 || opcionChekada < 0) {
				System.err.println("Este numero esta fuera del rango de opciones del programa.");
				return false;
			}
		} catch (NumberFormatException e) {
			System.err.println("Tienes que introducir un numero.");
			return false;
		}
		return true;
		
	}
}
