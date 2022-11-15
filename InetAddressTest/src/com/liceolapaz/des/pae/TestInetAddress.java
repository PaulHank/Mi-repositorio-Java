package com.liceolapaz.des.pae;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {
	public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\033[1;92m";
    public static final String ANSI_CYAN = "\u001B[36m";
	
	public static void main (String[] args) {
		
		InetAddress dir = null;
		System.out.println(ANSI_CYAN + "--------------------------------------------------" + ANSI_RESET);
		System.out.println("Salida para LocalHost: ");
		
		try {
			dir = InetAddress.getByName("LAPTOP-8JB7OD6D");
			pruebaMetodos(dir);
			
			System.out.println(ANSI_CYAN + "--------------------------------------------------" + ANSI_RESET);
			System.out.println("Salida para URL: ");
			dir = InetAddress.getByName("www.youtube.com");
			pruebaMetodos(dir);
			
			System.out.println("\tDirecciones IP para: " + dir.getHostName() + ":");
			InetAddress[] direcciones = InetAddress.getAllByName(dir.getHostName());
			for (int i = 0; i < direcciones.length; i++) {
				System.out.println("\t\t"+ ANSI_GREEN + direcciones[i].toString() + ANSI_RESET);
			}
			System.out.println(ANSI_CYAN + "--------------------------------------------------" + ANSI_RESET);
		} catch (UnknownHostException uhe) {
			uhe.printStackTrace();
		}
	}

	private static void pruebaMetodos(InetAddress dir) {
		System.out.println("\tMetodo getByName(): " + dir);
		InetAddress dir2;
		try {
			dir2 = InetAddress.getLocalHost();
			System.out.println("\tMetodo getLocalHost(): " + dir2);
		} catch (UnknownHostException uhe) {
			uhe.printStackTrace();
		}
		
		System.out.println("\tMetodo getHostName(): " + dir.getHostName());
		System.out.println("\tMetodo getHostAddress(): " + dir.getHostAddress());
		System.out.println("\tMetodo toString(): " + dir.toString());
		System.out.println("\tMetodo getCanonicalHostName(): " + dir.getCanonicalHostName());
	}
}
