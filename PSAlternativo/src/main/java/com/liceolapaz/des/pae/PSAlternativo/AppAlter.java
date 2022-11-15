package com.liceolapaz.des.pae.PSAlternativo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;

public class AppAlter {
	
	public static void main( String[] args ) throws ClassNotFoundException, SQLException, IOException{
 
		
		Path origin = Paths.get("C:\\alumnos.txt");
    	BufferedReader br = Files.newBufferedReader(origin);
    	
    	String linea = " ";
    	String[] arrTempo = null;
    	while ((linea = br.readLine()) !=null) {
    		arrTempo = linea.split(";");
    		for (String strTempo : arrTempo) {
    			System.out.print(strTempo + " ");
    			}
    		System.out.println();
    		}  	
    	br.close();
    	
    	System.out.println();

    	Class.forName("org.postgresql.Driver");

		Connection conexion =
		DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/dam22?serverTimezone=Europe/Madrid", "postgres", "1234");

    	PreparedStatement ps = conexion.prepareStatement("INSERT INTO alumno(codigo,nombre,curso) VALUES (?, ?, ?)");
    	
    	BufferedReader lineReader = new BufferedReader(new FileReader("C:\\alumnos.txt"));
    	String lineArr;
    	
    	
    	while((lineArr = lineReader.readLine()) != null) {
    		String[] datos = lineArr.split(";");
    		String nombre = datos[0];
    		String numero = datos[1];
    		String curso = datos[2];
    		
     		ps.setInt(1, Integer.parseInt(numero));
     		ps.setString(2, nombre);
     		ps.setString(3, curso);
    	
 			int row = ps.executeUpdate();
 			if (row == 0) {
 	            System.out.println("Error al insertar el registro.");
 	        } else {
 	            System.out.println("El registro se ha insertado correctamente." + "\n");
 	        }  	
        }  	   	
    	lineReader.close();
    }
}