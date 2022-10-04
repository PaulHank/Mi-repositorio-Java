package com.liceolapaz.des.pae;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class UsuariosL {
	private static HashMap<Integer, Usuarios> usuario = new HashMap<Integer, Usuarios>();

	public static void main(String[] args) {

		while (true) {
		
		menu();
		
		msjOpciones();

		
			int opcion = lectorInts();
			
			switch(opcion) {
			
			case 1:
				//Esta funcion funciona perfectamente :D
				pedirRutaArchivo();
				String archivoNombre = leerString();
				String archivo = archivoLeer(archivoNombre);
				if (archivo != null) { System.out.println(archivo); }
				break;
				
			case 2:
				Usuarios nuevoUser = añadirUsuario();
				int id = nuevoUser.getId();
				if (usuario.containsKey(id)) { System.err.println("Ya existe un usuario con el id " + id); } 
				else { usuario.put(id, nuevoUser); }
				break;
				
			case 3:
				nuevoUser = añadirUsuario();
				id = nuevoUser.getId();
				if (!usuario.containsKey(id)) { System.err.println("No hay usuarios con este id."); } 
				else { usuario.replace(id, nuevoUser); }
				break;
				
			case 4:
				pedirDato("id");
				id = lectorInts();
				if (!usuario.containsKey(id)) { System.err.println("No existe dicho usuario"); } 
				else { usuario.remove(id); System.out.println(usuario); }
				break;
				
			case 5:
				pedirRutaArchivo();
				archivoNombre = leerString();
				imprimirNuevoArchivo(archivoNombre);
				
				break;
				
			case 0: 
				System.exit(0);
				break;
				
			}
		}
	}

	private static void imprimirNuevoArchivo(String archivoNombre) {
		try {
			//EA = Escritor archivo, AP = Archivo Printer
			FileWriter EA = new FileWriter(archivoNombre);
			BufferedWriter BA = new BufferedWriter(EA);
			PrintWriter AP = new PrintWriter(BA);
			String linea = "id,email,nombre,apellido,avatar";
			AP.println(linea);
			
			for (Usuarios usuarioB : usuario.values()) {
				linea = "";
				linea += usuarioB.getId() + ";";
				linea += usuarioB.getEmail() + ";";
				linea += usuarioB.getNombre() + ";";
				linea += usuarioB.getApellido() + ";";
				linea += usuarioB.getAvatar() + ";";
				AP.println(linea);
			}
			AP.close();
			BA.close();
			EA.close();
		} catch (IOException excepcion) {
			System.err.println("Algo no fue escrito correctamente");
		}
	
	}

	private static Usuarios añadirUsuario() {
		Usuarios usuario = null;
		pedirDato("id");
		int id = lectorInts();
		pedirDato("email");
		String email = leerString();
		pedirDato("nombre");
		String nombre = leerString();
		pedirDato("apellido");
		String apellido = leerString();
		pedirDato("avatar");
		URL avatar = null;
		try {
			avatar = new URL(leerString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		usuario = new Usuarios(id, nombre, apellido, email, avatar);

		System.out.println(usuario);
		return usuario;
	}

	private static void pedirDato(String string) {
		System.out.print("Escriba " + string + ": ");
		
	}

	private static String archivoLeer(String archivoNombre) {
		String texto = "";
		File archivo = new File(archivoNombre);
		if (archivo.isFile()) {
			try {
				//AL para "Archivo-Lector", AB para "Archivo-Buffer"
				FileReader AL = new FileReader(archivo);
				BufferedReader AB = new BufferedReader(AL);
				String linea = AB.readLine();
				while (linea != null) {
					texto += linea + "\n";
					linea = AB.readLine();
				}
				
				AB.close();
				AL.close();
				return texto;
				
			} catch (FileNotFoundException e) {
				System.out.println("La ruta " + archivoNombre + " no es un fichero \n");
				return null;
				
			} catch (IOException e) {
				System.out.println("Error el leer el archivo \n");
				return null;
				
			}
		} else {
			System.out.println("La ruta " + archivoNombre + " no es un fichero \n");
			return null;
		}
	}
	
	private static String leerString() {
			try (Scanner lectorStrings = new Scanner(System.in)) {
				return lectorStrings.nextLine();
			}
			
	}

	private static void pedirRutaArchivo() {
		System.out.println("Introduce la ruta a usar para el archivo");
		
	}

	private static int lectorInts() {
		try (Scanner lectorInts = new Scanner(System.in)) {
			return lectorInts.nextInt();
		}
	}

	private static void msjOpciones() {
		System.out.println("Elije una opcion.");
		
	}

	private static void menu() {
		System.out.println("USER MANAGER \n"
				+ "1. Imprimir fichero por pantalla \n"
				+ "2. Insertar usuarios nuevos \n"
				+ "3. Editar usuarios existentes \n"
				+ "4. Borrar usuarios existentes \n"
				+ "5. Transportar el archivo a .txt \n");
		
	}
	
}
