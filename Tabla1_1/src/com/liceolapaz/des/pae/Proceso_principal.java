package com.liceolapaz.des.pae;

public class Proceso_principal {
	public static void main(String[] args) {
		try {
			String[] infoProcess = {"java", "com.liceolapaz.des.pae.Proceso_Secundario"};
			Process proceso = Runtime.getRuntime().exec(infoProcess);
			int returnValue = proceso.waitFor();
			if (returnValue == 0) {
				System.out.println("Proceso terminado de forma correcta");
			} else {
				System.out.println("El proceso ha fallado con el codigo de error " + returnValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
}