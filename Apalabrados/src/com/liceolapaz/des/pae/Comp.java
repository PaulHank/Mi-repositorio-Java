package com.liceolapaz.des.pae;

public class Comp extends Thread {
 public String palabra1;
 public String palabra2;
 final String[] consonantes = {"b","B","c","C","d","D","f","F","g","G","h","H","j","J","k","K","l","L","m","M","n","N","ñ","Ñ","p","P","q","Q","r","R","s","S","t","T","v","V","w","W","y","Y","x","X","z","Z"};
 
	public Comp(String palabra1, String palabra2) {
		super();
		this.palabra1 = palabra1;
		this.palabra2 = palabra2;
	}
	 
	public void tamaño (String palabra1, String palabra2) {
		System.out.println(palabra1.length());
		System.out.println(palabra2.length());
		System.out.println();
	}
	 
	public void doubleCheck (String palabra1, String palabra2) {
		String[] pal = {palabra1,palabra2};
		for (String l : pal) {
			for (String con : consonantes) {
				if (l.startsWith(con)) {
					System.out.println(l + " empieza por consonante");
				}
			}
		}
		return;
	}
	
	public void mix (String palabra1, String palabra2) {
		String subp1 = palabra1.substring(0, 3).toLowerCase();
		String subp2 = palabra2.substring(0, 3).toLowerCase();
		System.out.println(subp1 + subp2);
		System.out.println();
	}
	 
	public void compLength (String palabra1, String palabra2) {
		 
		 if (palabra1.length() < palabra2.length()) {
			System.out.println(palabra2 +" es mas largo que " + palabra1);
			} 
			
		if (palabra1.length() > palabra2.length()) {
			System.out.println(palabra2 +" es mas corto que " + palabra1);
			} 
			
		if (palabra1.length() == palabra2.length()) {
			System.out.println("Ambas palabras son iguales en terminos de longitud.");
			}
		System.out.println();
	}


	@Override
	public void run() {
		this.mix(palabra1, palabra2);
		this.compLength(palabra1, palabra2);
		this.doubleCheck(palabra1, palabra2);
		this.tamaño(palabra1, palabra2);
		
	}
 
}