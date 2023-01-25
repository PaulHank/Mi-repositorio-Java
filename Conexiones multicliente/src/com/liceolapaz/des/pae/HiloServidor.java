package com.liceolapaz.des.pae;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloServidor extends Thread {
	BufferedReader entryFlux;
	PrintWriter outputFlux;
	Socket socket = null;

	public HiloServidor(Socket s) throws IOException {
		//Entendiendo lo que hace cada cosa:
		//Esto, es el cliente que se le pasa a la clase.
		socket = s;
		//Esto es el flujo de salida que devuelve la clase al cliente
		outputFlux = new PrintWriter(socket.getOutputStream(),true);
		//Esto lee lo que le pase el socket cliente de cada vez.
		entryFlux = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}
	
	public void run() {
		try {
			String texto = "";
			while(!texto.trim().equals("*")) {
				System.out.println("Comunica con: " + socket.toString());
				//El texto es igual a la linea de texto que escriba el cliente.
				texto = entryFlux.readLine();
				//Se devuelve ese mismo texto pero en mayusculas y recortado.
				outputFlux.println(texto.trim().toUpperCase());
			}
			
			System.out.println("Fin con: " + socket.toString());
			outputFlux.close();
			entryFlux.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
