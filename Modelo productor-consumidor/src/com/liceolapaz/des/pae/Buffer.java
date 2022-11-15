package com.liceolapaz.des.pae;

public class Buffer {
		
		private char contenido;
		
		private boolean disponible = false;
		
		public synchronized void poner(char c) {
			/*
			this.contenido = c;
			disponible = true;
			*/
			while(disponible) {
				try {
					wait(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			contenido = c;
			disponible = true;
		}
		
		public synchronized char recoger() {
			/*if (disponible) {
				disponible = false;
				return contenido;
			}
			*/
			while(disponible == false) {
				try {
					wait(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			disponible = false;
			notify();
			return contenido;
		}

		
		
	}