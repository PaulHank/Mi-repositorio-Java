package com.liceolapaz.des.pae;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.liceolapaz.des.persona.Persona;

public class Cliente {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String host = "localhost";
		int puerto = 6000;
		System.out.println("Programa cliente inizializado");
		Socket cliente = new Socket (host, puerto);
		
		ObjectInputStream personaentra = new ObjectInputStream(cliente.getInputStream());
		
		Persona dato = (Persona) personaentra.readObject();
		
		dato.setNombre("Juan Ramos");
		dato.setEdad(50);
		
		ObjectOutputStream personaSale = new ObjectOutputStream(cliente.getOutputStream());
		
		personaSale.writeObject(dato);
		System.out.println("Envio: " + dato.getNombre() + "*" + dato.getEdad());
		
		personaentra.close();
		personaSale.close();
		cliente.close();
	}

}
