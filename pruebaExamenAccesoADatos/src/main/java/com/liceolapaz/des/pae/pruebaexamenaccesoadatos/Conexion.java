package com.liceolapaz.des.pae.pruebaexamenaccesoadatos;

import java.sql.*;

public class Conexion {
Connection conexion = crearCon();

    public static void main( String[] args ) throws ClassNotFoundException, SQLException {
      
    }
    
    private Connection crearCon() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Error");
			e.printStackTrace();
		}
		Connection con = null;
	    try {
			con =  DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/dam22?serverTimezone=Europe/Madrid", "postgres", "1234");
		} catch (SQLException e) {
			System.err.println("Error");
			e.printStackTrace();
		}
	      
	     Statement consulta = null;
		try {
			consulta = con.createStatement();
		} catch (SQLException e) {
			System.err.println("Error");
			e.printStackTrace();
		}
	     try {
			consulta.execute("CREATE DATABASE alumnos");
		} catch (SQLException e) {
			System.err.println("Error");
			e.printStackTrace();
		}
	     
	     try {
			consulta.close();
		} catch (SQLException e) {
			System.err.println("Error");
			e.printStackTrace();
		}
		return con;
	}

	public void tablas(String nombre) throws SQLException {
    	Statement createTable = conexion.createStatement();
    	try {
			createTable.executeUpdate("CREATE TABLE personas (\r\n"
					+ "    personaID int,\r\n"
					+ "    apellido varchar(255),\r\n"
					+ "    nombre varchar(255),\r\n"
					+ "    direccion varchar(255),\r\n"
					+ "    ciudad varchar(255)\r\n"
					+ ");");
		} catch (Exception e) {
			System.err.println("Error");
		}
    }
}
