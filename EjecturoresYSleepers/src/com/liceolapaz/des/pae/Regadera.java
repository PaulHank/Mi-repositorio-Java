package com.liceolapaz.des.pae;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Regadera implements Runnable{

	public Regadera() {
		
	}
	
	public static void main (String[] args) {
		Regadera reg = new Regadera();
		ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
		ses.scheduleAtFixedRate(reg, 3, 15, TimeUnit.SECONDS);
	} //El metodo scheduleAtfixedRate de la clase Executors, ejecuta un proceso despues de X segundos (3) y cada x segundos (15).

	@Override
	public void run() {
		System.out.println("Regando... ");
	}
}