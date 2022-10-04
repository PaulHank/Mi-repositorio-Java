package com.liceolapaz.pae.des;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Principal {

	public Principal() {}

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("C:\\alumnos.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String linea;
		while((linea = br.readLine()) != null)
			System.out.println(linea);
		/*Con un bucle if, hacer que elija una letra de nuestro nombre en el archivo y lo sustituya por una mayuscula,
		 *  en caso de estar en minuscula. */
		br.close();
		fr.close();
	}

}
