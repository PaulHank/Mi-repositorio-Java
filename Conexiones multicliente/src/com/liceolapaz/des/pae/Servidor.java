package com.liceolapaz.des.pae;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		ServerSocket servidor;
		servidor = new ServerSocket(6000);
		System.out.println("Servidor iniciado...");
		//El servidor siempre esta escuchando para recibir nuevos mensajes
		while (true) {
			//Cada cliente es un socket, y debe ser aceptado
			Socket cliente = new Socket();
			cliente = servidor.accept();
			//Se establece un hilo que tramita el proceso de cada cliente para que sea concurrente todo.
			HiloServidor hilo = new HiloServidor(cliente);
			//Cada hilo solo se inicia una vez que hay un cliente, 
			//por lo cual el metodo start no dira que ya se habia iniciado
			hilo.start();
		}
	}
}