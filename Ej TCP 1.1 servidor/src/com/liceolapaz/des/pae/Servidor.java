package com.liceolapaz.des.pae;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Servidor {	
	static Integer[] recibosApilados = new Integer[5];
		
	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		ServerSocket socketServidor = new ServerSocket(6000);
		System.out.println("Esperando input del cliente...");
	
		Socket cliente = socketServidor.accept();
		
		DataOutputStream outputFlux = new DataOutputStream(cliente.getOutputStream());
		DataInputStream inputFlux = new DataInputStream(cliente.getInputStream());
			
		for (int i = 0; i < 5; i++) {
				recibosApilados[i] = inputFlux.readInt();	
				System.out.println(recibosApilados[i]);
		}
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		Future<Integer> sumar = executor.submit(new HiloSumas(recibosApilados));
		Future<ArrayList<Integer>> primos = executor.submit(new HiloPrimos(recibosApilados));
		Future<Integer> mayor = executor.submit(new HiloMayor(recibosApilados));
		
		int suma = sumar.get();
		outputFlux.write(suma);
		
		int mayonesa = mayor.get();
		outputFlux.write(mayonesa);
		
		ArrayList<Integer> primosResult = primos.get();
		for (int i = 0; i < primosResult.size(); i++) {
			outputFlux.write(primosResult.get(i));
		}
		
		executor.shutdown();
		outputFlux.close();
		inputFlux.close();
		cliente.close();
		socketServidor.close();
	}
}

//Cada hilo hace una accion diferente de forma paralela para devolversela al cliente.

//la idea es simple, hacer que cada nuevo numero que se le pase al sevidor se almacene en un array.
//Dicho array entonces se usa para las operaciones.
//Posible problema: El array de base no tiene una longitud definida que pasarle por un bucle for.
//El unico caso en el que esto seria posible, seria en caso de que hubiese una cantidad fija de numeros a 
//pasarle, que afortunadamente, hay. Pero, y si no hubiera? 
//Tendria que obtener un primer mensaje del cliente que definiese el tamaño y automaticamente emplear ese
//input para definir el tamaño del bucle for.
//Pero como se que el primer mensaje del cliente es usado especificamente para eso?
//Puedo recojer los mensajes con el BufferedReader, pero puedo usar el primero de todos los mensajes de forma 
//individual?

/* Version con Rico
 
public class Servidor {
	
	public static void main(String[] args) {
		ServerSocker socketServidor = new serverSocket(6000);
		Socket client = server.accept();
		
		DataInputStream inputFlux = new DataInputStream(cliente.getDataInputStream());

		int[] array = new int[5];

		for(int i = o; i <5; i++) {
			array[i] = inputFlux.readInt();
		}
		
		ExecutorService executor = new ExcutorService.threadpool(3);

		inputFlux.close();
		cliente.close();
		socketServidor.close();
*/