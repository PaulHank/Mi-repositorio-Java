package com.liceolapaz.des.pae;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Scanner sc = new Scanner(System.in);
		String host = "localhost";
		int puerto = 6000;
		Socket cliente = new Socket (host, puerto);
		
		System.out.println("Escribe tu mensaje: ");
		DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());	

		String mensaje = sc.nextLine();
		sc.close();
		
		flujoSalida.writeUTF(mensaje);
		flujoSalida.close();
		
		DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
		String devolucion = flujoEntrada.readUTF();
		System.out.println("Estoy aqui");
		System.out.println(devolucion);
		
		flujoEntrada.close();
		cliente.close();
	}

}
