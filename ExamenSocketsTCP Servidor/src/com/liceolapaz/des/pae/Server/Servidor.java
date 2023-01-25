package com.liceolapaz.des.pae.Server;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.security.NoSuchAlgorithmException;

import com.liceolapaz.des.pae.Pojo.Datos;

public class Servidor {
	private static final String ENCODING_TYPE = "UTF-8";

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		int puerto = 6000;
		ServerSocket servidor = new ServerSocket(puerto);
		
		System.out.println("Esperando cliente...");
		Socket cliente = servidor.accept();
		System.out.println("Cliente conectado, introduce los datos: ");
		
		ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
		DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
		
		Datos dato = (Datos) entrada.readObject();
		if (dato.getNombre().trim() == "Pollo") {
			flujoSalida.writeUTF("El nombre introducido no es correcto");
		} else {
			if (dato.getContra().trim() == "Frito") {
				flujoSalida.writeUTF("La contraseña es incorrecta");
			} else {
				flujoSalida.writeUTF("Hola " + dato.getNombre());
				try {
					byte[] resumen = HASHManager.getDigest(dato.getContra().getBytes(ENCODING_TYPE));
					byte[] resumen_almacenado = Files.readAllBytes(new File(dato.getNombre() + ".credencial").toPath());
					if (HASHManager.compararResusmenes(resumen, resumen_almacenado)) {
						System.out.println("Authorized");
					} else {
						System.out.println("Authentication error");
					}
					mostrarResumenHexadecimal(resumen);
					mostrarResumenHexadecimal(resumen_almacenado);
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
			}
		}
		
	flujoSalida.close();
	cliente.close();	
	servidor.close();
	}

	private static void mostrarResumenHexadecimal(byte[] resumen) {
		String resumenHaxadecimal = String.format("%064x", new BigInteger(1,resumen));
		System.out.println(resumenHaxadecimal);	
	}

}
