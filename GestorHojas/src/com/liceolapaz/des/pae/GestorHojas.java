package com.liceolapaz.des.pae;

import java.util.List;
import java.util.concurrent.*;

public class GestorHojas extends Thread {
	private static List<String> lista = new CopyOnWriteArrayList <String>();
	
	@Override
	public void run() {
		while(true) {
			if (lista.size()>=10) {
				lista.remove(0);
			}
			else if (lista.size()<10) {
				lista.add(new String("Texto"));
			}
			for (@SuppressWarnings("unused") String string : lista) {
				//System.out.print(string);
				//POR FAVOR NO EJECUTAR EL PROGRAMA SI ESTA LINEA DE CODIGO ESTA ACTIVADA O PETA EL IDE.
			}
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			lista.add(new String("Texto"));
		}
		for (int i = 0; i < 10; i++) {
			new GestorHojas().start();
		}

	}

}
