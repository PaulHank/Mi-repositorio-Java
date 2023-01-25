package com.liceolapaz.des.pae;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente extends Thread {
	POJO objetito;
	
	public Cliente(POJO objetito) {
		super();
		this.objetito = objetito;
	}

	@Override
	public void run() {
		
		try {
			Socket cliente = new Socket("localhost", 6000);
			
			ObjectOutputStream OOS = new ObjectOutputStream(cliente.getOutputStream());
			OOS.writeObject(objetito);
			System.out.println("Objeto enviado.");
			
			ObjectInputStream OIS = new ObjectInputStream(cliente.getInputStream());
			System.out.println("Esperando...");
			
			POJO2 datosDevueltos = (POJO2) OIS.readObject();
			System.out.println("Objeto recibido.");
			int pojo2t = datosDevueltos.getInt1();
			int pojo2f = datosDevueltos.getInt2();
			System.out.println("Los trues suman un total de " + pojo2t + " y los false " + pojo2f);
			
			
			OIS.close();
			OOS.close();
			cliente.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
