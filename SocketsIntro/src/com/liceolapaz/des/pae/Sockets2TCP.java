package com.liceolapaz.des.pae;

import java.net.InetAddress;
import java.net.Socket;

public class Sockets2TCP {

	public static void main(String[] args) {
		try {
			String host = "localhost";
			int puerto = 6000;
			
			Socket cliente = new Socket(host,puerto);
			
			InetAddress i = cliente.getInetAddress();
			System.out.println("Puerto local: " + cliente.getLocalPort());
			System.out.println("Puerto remoto: " + cliente.getPort());
			System.out.println("Host remoto: " + i.getHostName());
			System.out.println("IP Host remoto: " + i.getHostAddress().toString());
			cliente.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
