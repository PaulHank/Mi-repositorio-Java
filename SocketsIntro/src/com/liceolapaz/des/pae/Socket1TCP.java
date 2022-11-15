package com.liceolapaz.des.pae;

import java.net.ServerSocket;
import java.net.Socket;

public class Socket1TCP {

	public Socket1TCP() {
		
	}

	public static void main(String[] args) {
		try {
			int puerto = 6000;
			ServerSocket servidor = new ServerSocket(puerto);
			System.out.println("Escuchando en " + servidor.getLocalPort());
			Socket client1 = servidor.accept();
			Socket client2 = servidor.accept();
			servidor.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
