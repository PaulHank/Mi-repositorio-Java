package com.liceolapaz.des.pae.leboro_pae;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Principal {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		File leboro_XML = new File("C:\\Users\\Pablo Abeijón DAM\\Downloads\\leboro.xml");
		DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = fac.newDocumentBuilder();
		Document documentoXML = db.parse(leboro_XML);
		
		Leboro_read_XML2.lecturaDelXML(documentoXML);
		System.out.println();
		Leboro_to_CSV2.escribirCSV(documentoXML);
		System.out.println();
		Leboro_to_database2.transferirEquipos(documentoXML);
		System.out.println();
		Leboro_to_database2.transferirJugadores(documentoXML);	
	}
}