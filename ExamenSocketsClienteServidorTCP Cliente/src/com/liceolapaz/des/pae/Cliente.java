package com.liceolapaz.des.pae;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		String host = "localhost";
		int puerto = 6000;
		Socket cliente = new Socket (host, puerto);
		
		System.out.println("Escribe cinco numeros.");
		DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
		int i = 0;
		while(i < 5) {
			int p = sc.nextInt();
			flujoSalida.writeInt(p);
			i++;
		}
		ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
		Pojillo pojillo = (Pojillo) entrada.readObject();
		System.out.println("El mayor y el menor son: " + pojillo.getmYm().toString() + " y la suma es " + pojillo.getSuma());
		cliente.close();
		sc.close();
	}

}
