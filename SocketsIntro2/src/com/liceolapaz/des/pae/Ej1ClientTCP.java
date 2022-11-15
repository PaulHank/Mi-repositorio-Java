package com.liceolapaz.des.pae;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ej1ClientTCP {

	public static void main(String[] args) throws UnknownHostException, IOException {
		String host = "localhost";
		int puerto = 6000;
		
		System.out.println("Programa cliente iniciado");
		Socket cliente = new Socket(host,puerto);
		
		DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
		
		flujoSalida.writeUTF("Saludos al servidor del cliente");
		
		DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());

		System.out.println("Recibiendo mensaje del servidor: \n\t" + flujoEntrada.readUTF());
	
		flujoEntrada.close();
		flujoSalida.close();
		cliente.close();
	}

}
