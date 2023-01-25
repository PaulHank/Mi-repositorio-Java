package com.liceolapaz.des.pae;

import java.io.PrintWriter;
import java.security.Key;

public class CifradorAESSimple {

	public static void main(String[] args) {
		final int LONGITUD_BLOQUE = 16;
		final String NOMBRE_FICHERO = "mensaje_cifrado.txt";
		final String PASSWORD = "MeLlamoSpiderman";
		final String TEXTO_EN_CLARO = "La clave secrete de la caja fuerte es 3842873110";
		try {
			Key clave = AESSimpleManager.obtenerclave(PASSWORD, LONGITUD_BLOQUE);
			String textoENClaro = TEXTO_EN_CLARO;
			String textoCifrado = AESSimpleManager.cifrar(textoENClaro, clave);
			PrintWriter pw = new PrintWriter(NOMBRE_FICHERO);
			pw.write(textoCifrado);
			pw.close();
			System.out.println("El mensaje se ha cifrado correctamente");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
