package com.liceolapaz.des.pae.PreparedStatementsExamples;

import java.io.*;
import java.nio.file.*;
import java.sql.*;

public class App {
	
    public static void main( String[] args ) throws ClassNotFoundException, SQLException, IOException{
    
    	//Leer de un CSV y pasar dichos datos a una base de datos. Deberia tenerlo por alguna parte...
    	
    	Path origin = Paths.get("C:\\alumnos.csv");
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
    	
    	/*	Stream<String> lineas = br.lines();
    		lineas.forEach(l -> {l.split(";");});
    		System.out.println();
    	*/
    	
    	Class.forName("org.postgresql.Driver");

		Connection conexion =
		DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/dam22?serverTimezone=Europe/Madrid", "postgres", "1234");

    	PreparedStatement ps = conexion.prepareStatement("INSERT INTO alumno(codigo,nombre,curso) VALUES (?, ?, ?)");
    	ps.setInt(1, Integer.parseInt(arrTempo[1]));
    	ps.setString(2, arrTempo[0]);
    	ps.setString(3, arrTempo[2]);
    	int row = ps.executeUpdate();
    	
    	if (row == 0) {
            System.out.println("Error al insertar el registro.");
        } else {
            System.out.println("El registro se ha insertado correctamente." + "\n");
        }
    	
    }

}