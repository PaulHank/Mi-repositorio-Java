package com.liceolapaz.des.pae;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Profesores extends Thread {
	Semaphore semaforo = new Semaphore(3);
	Random corregir = new Random();
	private String nombreP;
	
	public Profesores (String nombre) {
		this.nombreP = nombre;
	}
	
	public void run() {
		
		synchronized (this) {
				try {
					semaforo.acquire();
					
					while (Examenes.getNumExamenes() > 20) {
						int examenesCorr = corregir.nextInt(1,4);
						if ((Examenes.getNumExamenes() - examenesCorr) < 20) {
							examenesCorr = examenesCorr - 2;
						}
						Examenes.setNumExamenes(Examenes.getNumExamenes() - examenesCorr);
						System.out.printf("El profesor %s ha corregido " + examenesCorr + " examanes, quedan " + Examenes.getNumExamenes() + "%n", nombreP);
						System.out.println();
						
						try {
							wait(1000);
						} catch (InterruptedException ie) {
							ie.printStackTrace();
						}
					}
					semaforo.release();
					System.out.println("Se han corregido todos los 30 examanes");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Hay 50 examenes que corregir.");
		
		Profesores profesor1 = new Profesores("nosequien");
		Profesores profesor2 = new Profesores("Rico");
		Profesores profesor3 = new Profesores("Yisus");
		
		new Thread(profesor1).start();
		new Thread(profesor2).start();
		new Thread(profesor3).start();
		
		//He probado muchas veces el codigo, siempre da 20 de resto, aunque me pone el Exception arriba.
	}

}
