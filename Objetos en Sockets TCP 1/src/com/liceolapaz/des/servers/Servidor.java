package com.liceolapaz.des.servers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.liceolapaz.des.persona.Persona;

public class Servidor {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		int puerto = 6000;
		ServerSocket servidor = new ServerSocket(puerto);
		
		System.out.println("Esperando cliente...");
		Socket cliente = servidor.accept();
		
		ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
		
		Persona persona = new Persona("Juan",20);
		oos.writeObject(persona);
		System.out.println("Encio: " + persona.getNombre() + "*" + persona.getEdad());
		
		ObjectInputStream io = new ObjectInputStream(cliente.getInputStream());
		Persona dato = (Persona) io.readObject();
		System.out.println("Recibo: " + dato.getNombre() + "*" + dato.getEdad());
		
		oos.close();
		io.close();
		cliente.close();
		servidor.close();
	}

}
