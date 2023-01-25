package com.liceolapaz.des.pae;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServerSocket {
	static boolean serverStatus = true;

	public static void main(String[] args) {
		DatagramSocket socket;
		try {
			System.out.println("Servidor Iniciado");
			socket = new DatagramSocket(49171);
			while (serverStatus) {
				byte[] bufferRead = new byte[64];
				DatagramPacket datagramaEntrante = new DatagramPacket(bufferRead, bufferRead.length);
				socket.receive(datagramaEntrante);
				System.out.println(new String(bufferRead).trim());
				if (new String(bufferRead).contains("FIN")) {
					serverStatus = false;
					System.out.println("Socket del servidor cerrado");
					socket.close();
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
