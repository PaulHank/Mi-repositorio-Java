package com.liceolapaz.des.pae;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	static Integer input;
	static String recibo = "";

	public static void main(String[] args) throws UnknownHostException, IOException, EOFException {
		System.out.println("Cliente.");
		Socket cliente = new Socket("localhost",6000);
		
		DataOutputStream outputFlux = new DataOutputStream(cliente.getOutputStream());	
		DataInputStream inputFlux = new DataInputStream(cliente.getInputStream());
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 5; i++) {
			int numero = sc.nextInt();
			outputFlux.writeInt(numero);
		}
		System.out.println();
		
		System.out.println(inputFlux.read());
		System.out.println(inputFlux.read());
		System.out.println(inputFlux.read());
		System.out.println(inputFlux.read());
		System.out.println(inputFlux.read());
		
		System.out.println("Fin de las transacciones.");
		outputFlux.close();
		sc.close();
		cliente.close();
	}
}

/* Version con Rico

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("Cliente.");
		Socket cliente = new Socket("localhost",6000);
		
		DataOutputStream outputFlux = new DataOutputStream(cliente.getOutputStream());	
				
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 5; i++) {
			int numero = sc.nextInt();
			outputFlux.writeInt(numero);
		}

*/