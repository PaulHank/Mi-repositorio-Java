package com.liceolapaz.des.pae;

import java.util.Scanner;

public class Clase extends Thread {

	
	private volatile boolean flag = false;
	private volatile boolean flag2 = false;
	int numero1;
	int numero2;
	int numero3;
	int numero4;
	int numero5;
	int result;

	Clase(int numero1, int numero2, int numero3, int numero4, int numero5) {
		this.numero1 = numero1;
		this.numero2 = numero2;
		this.numero3 = numero3;
		this.numero4 = numero4;
		this.numero5 = numero5;
	}

	public void primos() {  
        synchronized(this) {  
        	int[] numeros =  {numero1,numero2,numero3,numero4,numero5};
        	System.out.println();
        	
        	for (int i = 0; i < numeros.length; i++) {
        		if (numeros[i] % 2 == 0) {
        			System.out.println(numeros[i] + " es primo");
        		} else {
        			System.out.println(numeros[i] + " no es primo");
        		}
        	}
        	System.out.println();
        	//this.notify();
        }  
    }

    public void sumar() {  
        synchronized(this) {
        	/*
        	try { wait(); }
        	catch (InterruptedException ie) { ie.printStackTrace(); }
        	*/
            result = numero1 + numero2 + numero3 + numero4 + numero5;
        	System.out.println(result);
        	System.out.println();
        	this.notify();
        }  
    }  
    
    public void multi() {  
        synchronized(this) { 
        	
        	try { wait(); }
        	catch (InterruptedException e1) { e1.printStackTrace(); }
        	
        	if (result % 3 == 0) { System.out.println("La suma de los numeros es multiplo de 3"); } 
        	else { System.out.println("La suma de los numeros no era multiplo de 3 :("); }
        } 
    }    
    
    public void run() {
    	if (!flag) {
    		flag = true;
			primos();
    	} else {
    		if (!flag2) {
    			flag2=true;
    			sumar();
    		} else {
    			multi();
    		}	
    	}
    }
    
    public static void main(String[] args) throws InterruptedException {  
    	
    	@SuppressWarnings("resource")
		Scanner lector = new Scanner(System.in);
    	
    	System.out.println("Introduce el primer numero: ");
    	int numero1 = lector.nextInt();
    	System.out.println("Introduce el segundo numero: ");
    	int numero2 = lector.nextInt();
    	System.out.println("Introduce el tercer numero: ");
    	int numero3 = lector.nextInt();
    	System.out.println("Introduce el cuarto numero: ");
    	int numero4 = lector.nextInt();
    	System.out.println("Introduce el quinto numero: ");
    	int numero5 = lector.nextInt();
    	
        Clase T1 = new Clase(numero1, numero2, numero3, numero4, numero5); 
          
        new Thread(T1).start();  
        new Thread(T1).start();
        new Thread(T1).start();
    }  
}  
