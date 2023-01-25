package com.liceolapaz.des.pae.Cliente;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		DatagramSocket socket = null;
		InetAddress host = InetAddress.getByName("localhost");
		int puerto = 48000;
		socket = new DatagramSocket();
		
		System.out.println("Escribe el nombre de usuario: ");
		String nombreUser = sc.nextLine();
		System.out.println("Escribe la contraseña: ");
		String contraUser = sc.nextLine();
		
		Datos datos = new Datos(nombreUser, contraUser);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		
		oos.writeObject(datos);
		oos.close();
		
		try {
			byte[] envio = baos.toByteArray();
			DatagramPacket enviando = new DatagramPacket(envio, envio.length, host, puerto);	
			socket.send(enviando);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			byte[] recibo = new byte[1024];
			DatagramPacket reciboPacket = new DatagramPacket(recibo, recibo.length);
			socket.receive(reciboPacket);
			System.out.println(new String(recibo).trim());
		} catch (Exception e) {
			e.printStackTrace();
		}

		sc.close();
		socket.close();
	}

}
