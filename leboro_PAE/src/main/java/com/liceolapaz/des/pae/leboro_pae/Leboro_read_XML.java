package com.liceolapaz.des.pae.leboro_pae;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Leboro_read_XML {
	
    public static void main( String[] args ) throws ParserConfigurationException, SAXException, IOException {
        
        FileInputStream leboro_XML = new FileInputStream("C:\\Users\\Pablo Abeijón DAM\\Downloads\\leboro.xml");
        DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = fac.newDocumentBuilder();
        Document documentoXML = db.parse(leboro_XML);
        
        NodeList list = documentoXML.getElementsByTagName("equipos");
        
        for (int i =0; i<list.getLength(); i++) {
            System.out.println(list.item(i).getTextContent());
        }
        
        System.out.println();
        
        NodeList listJ = documentoXML.getElementsByTagName("jugadores");
        
        for (int i =0; i<listJ.getLength(); i++) {
            System.out.println(listJ.item(i).getTextContent());
            String jugadores = listJ.item(i).getTextContent();
            System.out.println(jugadores);
            String[] JugSplit = jugadores.split(" ");
            System.out.println(Arrays.toString(JugSplit));
        }
    }
}