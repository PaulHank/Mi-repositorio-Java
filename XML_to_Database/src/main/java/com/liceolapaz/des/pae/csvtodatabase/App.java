package com.liceolapaz.des.pae.csvtodatabase;

import java.io.*;

import java.sql.*;

import javax.xml.parsers.*;

import org.w3c.dom.*;

public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException{
      
    	try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/dam22?serverTimezone=Europe/Madrid", "root","");
	    	Statement consulta = conexion.createStatement();
	    	
	    	DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
	    	DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
	    	Document doc = docBuilder.parse (new File("c:\\Users\\Pablo Abeijón DAM\\Documents\\Alumnos.xml"));
	    	
	    	System.out.println ("Elemento raiz del XML: " + doc.getDocumentElement().getNodeName());
	    	System.out.println();
	    	
	    	NodeList list = doc.getElementsByTagName("alumno");
	        
	        for (int i = 0; i < list.getLength(); i++) {

	            Node node = list.item(i);

	            if (node.getNodeType() == Node.ELEMENT_NODE) {
	                
	                Element element = (Element) node;

	                String idB = element.getAttribute("id");
	        
	                String id = element.getElementsByTagName("id").item(0).getTextContent();
	                String nombre = element.getElementsByTagName("nombre").item(0).getTextContent();
	                String curso = element.getElementsByTagName("curso").item(0).getTextContent();
	
	    			consulta.executeUpdate("INSERT INTO alumno(id,nombre,curso) VALUES('"+id+","+nombre+"','"+curso+"')");
	    			
	    			}
	    		}
	    	
	    	System.out.println("Datos volcados sin problema.");
    	}catch (Exception err) {
    		System.out.println(" " + err.getMessage ());
    	}
    }
}
