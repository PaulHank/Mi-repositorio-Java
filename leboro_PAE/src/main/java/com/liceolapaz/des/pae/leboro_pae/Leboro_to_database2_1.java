package com.liceolapaz.des.pae.leboro_pae;

import java.io.File;
import java.sql.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

public class Leboro_to_database2_1 {

	public static void main( String[] args ){

    	try {
			Class.forName("org.postgresql.Driver");

			Connection conexion =
			DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/AD_Control1?serverTimezone=Europe/Madrid", "postgres", "1234");
			
			File leboro_XML = new File("C:\\Users\\Pablo Abeijón DAM\\Downloads\\leboro.xml");
			DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = fac.newDocumentBuilder();
			Document documentoXML = db.parse(leboro_XML);
			
			NodeList listE = documentoXML.getElementsByTagName("equipos");
			
			for (int i = 0; i < listE.getLength(); i++) {
				
				NodeList list2 = documentoXML.getElementsByTagName("equipo");
				
				for (int t = 0; t < list2.getLength(); t++) {

				    Node node = listE.item(i);
				    
				    if (node.getNodeType() == Node.ELEMENT_NODE) {
				        
				        Element element = (Element) node;
	
				        String codEquipo = (element.getElementsByTagName("codequipo").item(t).getTextContent()); 
				        String nombreEq = (element.getElementsByTagName("nombreEq").item(t).getTextContent()); 
				        String ciudad = (element.getElementsByTagName("Ciudad").item(t).getTextContent());
				        String anho = (element.getElementsByTagName("anho").item(t).getTextContent());
				        
				        PreparedStatement ps = conexion.prepareStatement("INSERT INTO equipo(codEquipo, nombre, ciudad, anho) VALUES (?, ?, ?, ?)");
				        
				        ps.setInt(1, Integer.parseInt(codEquipo));
				        ps.setString(2, nombreEq);
				        ps.setString(3, ciudad);
				        ps.setInt(4, Integer.parseInt(anho));
				          
				        int row = ps.executeUpdate();
			 			if (row == 0) {
			 	            System.out.println("Error al insertar el registro en la tabla equipo.");
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