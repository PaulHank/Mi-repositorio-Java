package com.liceolapaz.des.pae;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import com.liceolapaz.des.PersonaPojo.Persona;

public class Client {

	public static void main(String[] args) throws IOException {
		DatagramSocket socketUDP = null;
		InetAddress host = InetAddress.getByName("localhost");
		int puerto = 49171;
		socketUDP = new DatagramSocket();

		//Se crea el objeto persona
		Persona persona = new Persona("Maria",22);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		
		oos.writeObject(persona);
		System.out.println("Envio: " + persona.getNombre() + "*" + persona.getEdad());
		oos.close();
		
		
		//Se convierte el objeto persona a un array de bytes y se lo envia
		try {
			byte[] byteArr = baos.toByteArray();
			 DatagramPacket petition = new DatagramPacket(byteArr, byteArr.length, host, puerto);
			socketUDP.send(petition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Se recive el objeto persona que envie el servidor modificado
		try {
			while(true) {
			//Mensaje en bytes
			byte[] personaDevueta = new byte[1024];
			DatagramPacket packetEntrante = new DatagramPacket(personaDevueta, personaDevueta.length);
			
			//Hacer que el socket reciba los datos que se le pasen, como este es solo uno, no necesita un while true
			socketUDP.receive(packetEntrante);
			ByteArrayInputStream bais = new ByteArrayInputStream(personaDevueta);
			ObjectInputStream ois = new ObjectInputStream(bais);
			
			//Se parsea el objeto recibido al tipo persona para poder leer sus datos
			Persona personaRecibida = (Persona) ois.readObject();
			System.out.println("recibo: " + personaRecibida.getNombre() + ", " + personaRecibida.getEdad());
			
			//Se cierran los objetos
			ois.close();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Por ultimo, se cierra el socket
		socketUDP.close();
	}

}
