package com.liceolapaz.des.pae;

import java.util.ArrayList;

public class Pincipal {


	public static void main(String[] args) {
		RatonSimple mickey = new RatonSimple("Mickey", 6);
		ArrayList<Thread.State> estadosHilo = new ArrayList<>();
		Thread h = new Thread(mickey);
		
		estadosHilo.add(h.getState());
		h.start();
		while(h.getState() !=Thread.State.TERMINATED) {
			if(!estadosHilo.contains(h.getState())) {
				estadosHilo.add(h.getState());
			}
		}
		if (!estadosHilo.contains(h.getState())) {
			estadosHilo.add(h.getState());
		}
		for (Thread.State estado : estadosHilo) {
			System.out.println(estado);
		}

	}

}
