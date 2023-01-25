package com.liceolapaz.des.pae;

import java.io.IOException;
import java.net.UnknownHostException;

//Tiene que haber cinco clientes que envien 1 objeto que contenga Int y booleans mediante TCP

public class ComputadorDeCliente {
	static POJO recibo;	
	
	public static void main(String[] args) 
			throws UnknownHostException, IOException, ClassNotFoundException {
		System.out.println("Ordenador de los cliente inicializado.");
		
		POJO pojito1 = new POJO(5,true);
		POJO pojito2 = new POJO(6,false);
		POJO pojito3 = new POJO(3,false);
		POJO pojito4 = new POJO(4,true);
		POJO pojito5 = new POJO(10,true);
		
		Cliente cliente1 = new Cliente(pojito1);
		Cliente cliente2 = new Cliente(pojito2);
		Cliente cliente3 = new Cliente(pojito3);
		Cliente cliente4 = new Cliente(pojito4);
		Cliente cliente5 = new Cliente(pojito5);
		
		cliente1.start();
		
		cliente2.start();
		cliente3.start();
		cliente4.start();
		cliente5.start();
	}
}
