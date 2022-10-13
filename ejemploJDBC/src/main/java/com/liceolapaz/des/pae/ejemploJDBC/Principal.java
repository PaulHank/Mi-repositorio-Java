package com.liceolapaz.des.pae.ejemploJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {

	public Principal() {
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conexion =
		DriverManager.getConnection("jdbc:mysql://localhost/dam22", "root", "");

		Statement sentencia = conexion.createStatement();
		ResultSet resultados = sentencia.executeQuery("SELECT * FROM alumno");

		while (resultados.next()) {
			System.out.println(resultados.getInt(1) + " " + resultados.getString(2) + " "+ resultados.getString(3));
		}
	}

}
