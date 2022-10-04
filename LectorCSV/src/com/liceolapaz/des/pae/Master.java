package com.liceolapaz.des.pae;

import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Master {

	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException{
		FileInputStream alXML = new FileInputStream("C:\\Alumnos.xml");
		DocumentBuilderFactory fac = DocumentBuilderFactory.newDefaultInstance();
		DocumentBuilder db = fac.newDocumentBuilder();
		
		Document doc = db.parse(alXML);
		
		NodeList listaNom = doc.getElementsByTagName("Telefono");
		
		for (int i=0; i<listaNom.getLength(); i++) {
		System.out.println(listaNom.item(i).getTextContent());
		}
	}
}


/*
 * static ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
 * 
 * lineas.forEach(linea -> { 
 * String[] campos = linea.split(";");
 * Alumno alumno = new Alumno(Integer.parseInt(campos[0]), campos[1], campos[2]);
 * }};
 * 
 * for(Alumnos a: ListaAlumnos) {
 * System.out.println(a.get)
 */
