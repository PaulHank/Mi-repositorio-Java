package com.liceolapaz.des.pae;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClientSocket {

	public static void main(String[] args) throws UnknownHostException, SocketException {
		DatagramSocket SocketUDP = null;
		InetAddress host = InetAddress.getByName("localhost");
		int puerto = 49171;
		SocketUDP = new DatagramSocket();
		
		for (int i = 50; i <100; i++) {
			String mensaje = "Mensaje: " +String.valueOf(i);
			try {
				byte[] mensajeCliente  = mensaje.getBytes();
				DatagramPacket petition = new DatagramPacket(mensajeCliente,mensajeCliente.length, host, puerto);
				SocketUDP.send(petition);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		String mensajeFinal = "FIN";
		try {
			byte[] mensajeCliente = mensajeFinal.getBytes();
			DatagramPacket peticion2 = new DatagramPacket(mensajeCliente,mensajeCliente.length, host, puerto);
			SocketUDP.send(peticion2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		SocketUDP.close();
	}

}
