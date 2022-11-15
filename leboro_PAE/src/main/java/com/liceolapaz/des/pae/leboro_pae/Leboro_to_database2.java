package com.liceolapaz.des.pae.leboro_pae;

import java.io.File;
import java.sql.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

public class Leboro_to_database2 {

	public static void main( String[] args ){

    	try {
			Class.forName("org.postgresql.Driver");

			Connection conexion =
			DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/AD_Control1?serverTimezone=Europe/Madrid", "postgres", "1234");
			
			File leboro_XML = new File("C:\\Users\\Pablo Abeijón DAM\\Downloads\\leboro.xml");
			DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = fac.newDocumentBuilder();
			Document documentoXML = db.parse(leboro_XML);
			
			NodeList listJ = documentoXML.getElementsByTagName("jugadores");
			
			for (int i = 0; i < listJ.getLength(); i++) {
				
				NodeList list2 = documentoXML.getElementsByTagName("jugador");
				
				for (int t = 0; t < list2.getLength(); t++) {

				    Node node = listJ.item(i);
				    
				    if (node.getNodeType() == Node.ELEMENT_NODE) {
				        
				        Element element = (Element) node;
	
				        String codjugador = element.getElementsByTagName("codjugador").item(t).getTextContent(); 
				        String nombreJu =  element.getElementsByTagName("nombreJu").item(t).getTextContent(); 
				        String posicion =  element.getElementsByTagName("posicion").item(t).getTextContent();
				        String codequipoJu = element.getElementsByTagName("codequipoJu").item(t).getTextContent(); 
				        
				        PreparedStatement ps = conexion.prepareStatement("INSERT INTO jugador(codJugador, nombre, posicion, codEquipo) VALUES (?, ?, ?, ?)");
				        
				        ps.setInt(1, Integer.parseInt(codjugador));
				        ps.setString(2, nombreJu);
				        ps.setString(3, posicion);
				        ps.setInt(4, Integer.parseInt(codequipoJu));
				          
				        int row = ps.executeUpdate();
			 			if (row == 0) {
			 	            System.out.println("Error al insertar el registro en la tabla jugador.");
			 	        } else {
			 	            System.out.println("El registro se ha insertado correctamente." + "\n");
			 	        }  	 
				    } 
			    }
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}