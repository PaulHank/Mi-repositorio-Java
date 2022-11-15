package com.liceolapaz.des.pae.leboro_pae;

import java.io.*;

import javax.xml.parsers.*;

import org.w3c.dom.*;

public class Leboro_read_XML2 {

	public static void main(String[] args){
	       
        try {
			File leboro_XML = new File("C:\\Users\\Pablo Abeijón DAM\\Downloads\\leboro.xml");
			DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = fac.newDocumentBuilder();
			Document documentoXML = db.parse(leboro_XML);
			
			System.out.println("Raiz: " + documentoXML.getDocumentElement().getNodeName() + "\r");  
			
			NodeList listE = documentoXML.getElementsByTagName("equipos");
			
			for (int i = 0; i < listE.getLength(); i++) {
				
				NodeList list2 = documentoXML.getElementsByTagName("equipo");
				
				for (int t = 0; t < list2.getLength(); t++) {

				    Node node = listE.item(i);
				    System.out.println(node.getNodeName());
				    
				    if (node.getNodeType() == Node.ELEMENT_NODE) {
				        
				        Element element = (Element) node;
	
				        System.out.println("Codigo de equipo: " + element.getElementsByTagName("codequipo").item(t).getTextContent()); 
				
				        System.out.println("Nombre de equipo: " + element.getElementsByTagName("nombreEq").item(t).getTextContent()); 
	
				        System.out.println("Ciudad: " + element.getElementsByTagName("Ciudad").item(t).getTextContent());
	
				        System.out.println("Anho de creacion: " + element.getElementsByTagName("anho").item(t).getTextContent()); 
				        
				        System.out.println("-------");
				    } 
			    }
			}
			
			System.out.println("---------------------- \r");
			
			
			NodeList listJ = documentoXML.getElementsByTagName("jugadores");
			
			for (int i = 0; i < listJ.getLength(); i++) {
				
				NodeList list2 = documentoXML.getElementsByTagName("jugador");
				
				for (int t = 0; t < list2.getLength(); t++) {

				    Node node = listJ.item(i);
				    System.out.println(node.getNodeName());
				    
				    if (node.getNodeType() == Node.ELEMENT_NODE) {
				        
				        Element element = (Element) node;
	
				        System.out.println("Codigo de jugador: " + element.getElementsByTagName("codjugador").item(t).getTextContent()); 
				
				        System.out.println("Nombre del jugador: " + element.getElementsByTagName("nombreJu").item(t).getTextContent()); 
	
				        System.out.println("Posicion: " + element.getElementsByTagName("posicion").item(t).getTextContent());
	
				        System.out.println("Codigo de equipo del jugador: " + element.getElementsByTagName("codequipoJu").item(t).getTextContent()); 
				        
				        System.out.println("------");
				    } 
			    }
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}