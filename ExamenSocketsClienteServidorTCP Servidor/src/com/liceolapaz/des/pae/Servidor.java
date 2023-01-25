package com.liceolapaz.des.pae;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Servidor {
	private static ArrayList<Integer> array = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		int puerto = 6000;
		ServerSocket servidor = new ServerSocket(puerto);
		
		System.out.println("Esperando cliente...");
		Socket cliente = servidor.accept();
		System.out.println("Cliente conectado, introduce los datos: ");

		DataInputStream entrada = new DataInputStream(cliente.getInputStream());
		DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
		ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());

		int i = 0;
		while(i<5) {
			int recibo = entrada.readInt();
			System.out.println(recibo);
			array.add(recibo);
			i++;
		}
		
		ExecutorService exe = Executors.newFixedThreadPool(2);
		Future<ArrayList<Integer>> mYm = exe.submit(new MayorMenor(array));
		Future<Integer> sum = exe.submit(new Suma(array));
		
		ArrayList<Integer> mayormenor = mYm.get();
		int suma = sum.get();
		
		Pojillo pojillo = new Pojillo(mayormenor, suma);
		oos.writeObject(pojillo);
		
		oos.close();
		entrada.close();
		flujoSalida.close();	
		servidor.close();
	}

}
