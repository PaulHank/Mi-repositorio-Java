package com.liceolapaz.des.pae.leboro_pae;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Leboro_to_CSV2 {

	public static void main(String[] args) throws IOException {
	
		leerEquipos();
		
		System.out.println();
		
		leerJugadores();

	}

	private static String[] leerJugadores() {

		try {
			
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
				        
				        String[] jugador = {codjugador,nombreJu,posicion,codequipoJu};
				        
				        System.out.println(Arrays.toString(jugador));
				        
				        
						BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Pablo Abeijón DAM\\Documents\\Notas de clase\\Leboro.csv", true));
				        
						bw.write("Jugadores");
						bw.newLine();
						
						for (int o = 0; o < jugador.length; o++) {	
							bw.write(jugador[o]+";");
						}
						
						bw.newLine();
						bw.flush();
						bw.close();
				    } 
				}
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			}
		return null;
	}

	private static String[] leerEquipos() {

		try {
			
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
				        
				        String[] equipo = {codEquipo,nombreEq,ciudad,anho};
				        
				        System.out.println(Arrays.toString(equipo));
				        
				         
						BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Pablo Abeijón DAM\\Documents\\Notas de clase\\Leboro.csv", true));
				        
						bw.write("Equipo");
						bw.newLine();
						
				        for (int o = 0; o < equipo.length; o++) {
				        	bw.write(equipo[o]+";");
						}
				        
				        bw.newLine();
				        bw.flush();
						bw.close();
				    } 
				}
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			}
		return null;
		
	}
}