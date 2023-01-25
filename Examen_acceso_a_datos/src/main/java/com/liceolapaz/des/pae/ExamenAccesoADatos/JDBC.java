package com.liceolapaz.des.pae.ExamenAccesoADatos;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC {
	
	public void insert(BufferedReader brAsignaturas, BufferedReader brCiclo) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/examenjdbc?serverTimezone=UTC", "root", "");		
	    	
	    	String linea = "";
	    	String splitter = ",";
	    	
			while ((linea = brCiclo.readLine()) != null) {
	    			String[] ciclo = linea.split(splitter);
	    			
	    			PreparedStatement insertCiclos = conexion.prepareStatement(
	    					"INSERT INTO ciclo (codigo, nombre) VALUES (?,?)");
	    			
	    			insertCiclos.setInt(1,Integer.parseInt(ciclo[0]));
	    			insertCiclos.setString(2,ciclo[1]);
	    			
	    			int filas = insertCiclos.executeUpdate();
			    	if (filas == 0) {
		 	            System.out.println("Error al insertar el registro en la tabla (ciclo).");
		 	        } else {
		 	            System.out.println("El ciclo se ha insertado correctamente.");
		 	        }  	
	    		}

    		while ((linea = brAsignaturas.readLine()) != null) {
    			String[] asignatura = linea.split(splitter);
    			
    	    	
    	    	PreparedStatement insertAsignaturas = conexion.prepareStatement(
    	    			"INSERT INTO asignatura (codigo, nombre, codCiclo) VALUES (?,?,?)");
	
		    	insertAsignaturas.setInt(1, Integer.parseInt(asignatura[0]));
		    	insertAsignaturas.setString(2, asignatura[1]);
		    	insertAsignaturas.setInt(3, Integer.parseInt(asignatura[2]));
		    	
		    	int filas = insertAsignaturas.executeUpdate();
		    	if (filas == 0) {
	 	            System.out.println("Error al insertar el registro en la tabla (asignatura).");
	 	        } else {
	 	            System.out.println("La asignatura se ha insertado correctamente.");
	 	        }  	
    		}
    		
    					
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
