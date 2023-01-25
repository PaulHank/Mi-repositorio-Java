package com.liceolapaz.des.pae.MultiBD_Transfer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class App {	

	private static void transferencia(String usuario, String ruta, String contra, String driver) 
			throws ClassNotFoundException, SQLException, ParserConfigurationException, SAXException, IOException {
		
		File XML = new File("C:\\Users\\Pablo Abeijón DAM\\Downloads\\leboro.xml");
		DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = fac.newDocumentBuilder();
		Document documentoXML = db.parse(XML);
		
		Class.forName(driver);
		
		Connection conexion = DriverManager.getConnection(ruta,usuario,contra);
		
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
	}
	
	
    public static void main( String[] args ) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException, ParserConfigurationException, SAXException {
    	
    	@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
    	
        Properties prop = new Properties();
        
        prop.load(new FileReader("C:\\Users\\Pablo Abeijón DAM\\eclipse-workspace\\MultiBD_Transfer\\Gestores.properties"));
    		
    	System.out.println("Tranferencia de datos. \n" +
    						"1. PostgreSQL \n" +
    						"2. MySQL \n" +
    						"3. SQLite \n" +
    						"4. Salir. \n");
    	
    	int opcion = sc.nextInt();
    	System.out.println();
    	
    	switch (opcion) {
    	
    	case 1: 
            
            String usuarioPostgres = prop.getProperty("usuarioPostgreSQL");
            String rutaPostgreSQL = prop.getProperty("rutaPostgreSQL");
            String contraPostgreSQL = prop.getProperty("passwordPostgreSQL");
            String driverPostgreSQL = prop.getProperty("driverPostgreSQL");
            transferencia(usuarioPostgres, rutaPostgreSQL, contraPostgreSQL, driverPostgreSQL);
    		break;
    		
    	case 2: 
    		
            String usuarioMySQL = prop.getProperty("usuarioMySQL");
            String rutaMySQL = prop.getProperty("rutaMySQL");
            String contraMySQL = prop.getProperty("passwordSQL");
            String driverMySQL = prop.getProperty("driverMySQL");
            transferencia(usuarioMySQL,rutaMySQL,contraMySQL,driverMySQL);
    		break;
    	
    	case 3: 
    		
    		String usuarioSQLite = prop.getProperty("usuarioSQLite");
    		String rutaSQLite = prop.getProperty("rutaSQLite");
    		String contraSQLite = prop.getProperty("passwordSQLite");
    		String driverSQLite = prop.getProperty("driverSQLite");
    		transferencia(usuarioSQLite, rutaSQLite, contraSQLite, driverSQLite);
    		break;
    	
    	case 4: 
    		System.out.print("Saliendo...");
    		System.exit(0);
    		break;	
    	}     
    }
}