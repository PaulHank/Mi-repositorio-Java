package com.liceolapaz.des.pae;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ServidorMC {

	public static void main (String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		MulticastSocket ms = new MulticastSocket();
		
		int puerto = 12345;
		InetAddress grupo = InetAddress.getByName("228.0.0.1");
		String cadena = "";
		
		while(!cadena.trim().equals("*")) {
			System.out.print("Datos a enviar al grupo: ");
			cadena = in.readLine();
			
			DatagramPacket packet = new DatagramPacket(cadena.getBytes(), cadena.length(), grupo, puerto);
			
			ms.send(packet);
		}
		ms.close();
		System.out.println("Socket cerrado.");
	}
}