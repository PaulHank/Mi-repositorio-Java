package com.liceolapaz.des.pae;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ejemplo2Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		String host = "localhost";
		int puerto = 6000;
		
		Socket cliente = new Socket(host,puerto);
		
		PrintWriter outputFlux = new PrintWriter(cliente.getOutputStream(),true);
		BufferedReader entryFlux = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//Para comprender que es lo que esta pasando aqui:
		//Esta es mi variable eco, no tiene nada de base pero es un String tambien.
		String cadena, eco = "";
		System.out.println("Introduce cadena: ");
		//La variable cadena se rellena con la linea que se le pase.
		cadena = in.readLine();
		//Si la cadena de texto esta vacia, se rompera el bucle.
		while(cadena != null) {
			//Esto imprime la cadena de texto que le pase el cliente y se la pasa al servidor
			//El cual la lee con su entryFlux al que se le pasa el socket.getInputStream();
			outputFlux.println(cadena);
			//Aqui, eco recibe el String cadena que le envio el cliente al servidor de vuelta.
			eco = entryFlux.readLine();
			//Y aqui lo imprime!
			System.out.println(" => ECO: " + eco);
			//Y aqui se vuelve a leer, ya que el cliente puede seguir escribiendo.
			cadena = in.readLine();
		}
		
		entryFlux.close();
		outputFlux.close();
		System.out.println("Fin de envio");
		in.close();
		cliente.close();
	}
}