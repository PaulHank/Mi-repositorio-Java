package com.liceolapaz.des.pae;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import com.liceolapaz.des.PersonaPojo.Persona;

public class Server {
	static boolean serverStatus = true;

	public static void main(String[] args) throws ClassNotFoundException, SocketException, UnknownHostException {
		DatagramSocket socket = new DatagramSocket();
		InetAddress host = InetAddress.getByName("localhost");
		int port = 49171;
		try {
			System.out.println("Servidor Iniciado... ");
			while (serverStatus) {
				
				//Aqui recibe el objeto que le pase el cliente
				byte[] recibo = new byte[1024];
				DatagramPacket packetRecive = new DatagramPacket(recibo, recibo.length);
				socket.receive(packetRecive);
				
				//Aqui lo parsea y lo lee
				ByteArrayInputStream bais = new ByteArrayInputStream(recibo);
				ObjectInputStream ois = new ObjectInputStream(bais);
				Persona persona = (Persona) ois.readObject();
				System.out.println("recibo: " + persona.getNombre() + ", " + persona.getEdad());
				ois.close();
				
				try {
					System.out.println("Servidor enviando... ");
					Persona personaNueva = new Persona("Maria", 23);
					
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					ObjectOutputStream oos = new ObjectOutputStream(baos);
					
					oos.writeObject(personaNueva);
					System.out.println("Envio: " + personaNueva.getNombre() + "*" + personaNueva.getEdad());
					oos.close();
					
					byte[] personaADevolver = new byte[1024];
					DatagramPacket envio = new DatagramPacket(personaADevolver,personaADevolver.length,host,port);
					socket.send(envio);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		//-----------------------//
		//Aqui lo cambiara y lo enviara
	
	
		socket.close();
	}
}
