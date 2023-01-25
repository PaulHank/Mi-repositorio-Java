package com.liceolapaz.des.pae;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//Tiene que haber dos hilos que procesen las operaciones en base al contenido del Object recibido.
//Si el objeto contiene un TRUE, un hilo lo hace, si contiene FALSE, al otro
//Los hilos suman los numeros recibidos y los juntan en un objeto que devolver a todos los clientes.

public class Servidor {

	public static void main(String[] args) 
			throws IOException, ClassNotFoundException, InterruptedException, ExecutionException {
		System.out.println("Servidor Inicializado correctamente.");
		System.out.println();
		ServerSocket socketDelServidor = new ServerSocket(6000);
		ArrayList<Integer> numerosTrue = new ArrayList<Integer>();
		ArrayList<Integer> numerosFalse = new ArrayList<Integer>();

		int i = 0;
		while (i <5) {
			Socket socketDelCliente = socketDelServidor.accept();
			System.out.println("Cliente aceptado.");
			
			ObjectInputStream OIS = new ObjectInputStream(socketDelCliente.getInputStream());
			System.out.println("Objeto recibido.");
			
			POJO datos = (POJO) OIS.readObject();
			System.out.println("Objeto leido.");
			
			boolean booleanoRecibido = datos.getBooleano();
			System.out.println("Booleano leido." + datos.getBooleano());
			
			if (booleanoRecibido  == true) {
				numerosTrue.add(datos.getNumero());
				System.out.println("Añadido al array: True, " + datos.getNumero());
			} else {
				numerosFalse.add(datos.getNumero());
				System.out.println("Añadido al array: False, " + datos.getNumero());
			}
			i++;
			System.out.println();
			
			if (i == 5) {
				ExecutorService executor = Executors.newFixedThreadPool(2);
				
				Future<Integer> True = executor.submit(new HiloTrue(numerosTrue));
				Future<Integer> False = executor.submit(new HiloFalse(numerosFalse));
				
				int t = True.get();
				System.out.println("Recibido resultado de los Trues");
				int f = False.get();
				System.out.println("Recibido resultado de los Falses");
				
				POJO2 pojoEnvio = new POJO2(t,f);
				ObjectOutputStream OOS = new ObjectOutputStream(socketDelCliente.getOutputStream());
				OOS.writeObject(pojoEnvio);
				System.out.println("Objeto enviado.");
				socketDelCliente.close();
			}	
		}
		System.out.println("Servidor cerrado.");
		socketDelServidor.close();
	}
}
