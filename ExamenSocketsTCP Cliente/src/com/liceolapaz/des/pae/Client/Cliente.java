package com.liceolapaz.des.pae.Client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.liceolapaz.des.pae.Pojo.Datos;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Scanner sc = new Scanner(System.in);
		String host = "localhost";
		int puerto = 6000;
		Socket cliente = new Socket (host, puerto);
		
		ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
		
		System.out.println("Escribe el nombre de usuario: ");
		String nombreUser = sc.nextLine();
		System.out.println("Escribe la contraseña: ");
		String contraUser = sc.nextLine();
		
		Datos datos = new Datos(nombreUser, contraUser);
		
		oos.writeObject(datos);
		
		
		DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
		System.out.println(flujoEntrada.readUTF());
		
		sc.close();
		cliente.close();
		flujoEntrada.close();
	}

}
