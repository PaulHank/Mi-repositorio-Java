package com.liceolapaz.des.pae;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Ej1ServTCP {

	public static void main(String[] args) throws IOException {
		int numeroP = 6000;
		ServerSocket servidor = new ServerSocket(numeroP);
		Socket clienteConectado = null;
		System.out.println("Esperando al cliente ...");
		clienteConectado = servidor.accept();
		
		DataInputStream fluxEntry = new DataInputStream(clienteConectado.getInputStream());

		System.out.println("Recibiendo mensaje del cliente: \t\n" + fluxEntry.readUTF());
		
		DataOutputStream fluxExit = new DataOutputStream(clienteConectado.getOutputStream());
	
		fluxExit.writeUTF("Saludos al cliente desde el servidor");
		
		fluxEntry.close();
		fluxExit.close();
		clienteConectado.close();
		servidor.close();
	}

}
