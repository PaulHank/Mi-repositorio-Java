package com.liceolapaz.des.pae;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Utilidades {
	
	public static void generarXML(ArrayList<Alumno> listaAlumnos) throws ParserConfigurationException, TransformerException {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		
		Element alumnos = doc.createElement("alumnos");
		doc.appendChild(alumnos);
		
		for (Alumno al: listaAlumnos) {
			
			Element alumno = doc.createElement("alumno");
			alumnos.appendChild(alumno);
			
			Element id = doc.createElement("id");
			id.setTextContent(String.valueOf(al.getId()));
			alumno.appendChild(id);
			
			Element nombre = doc.createElement("nombre");
			nombre.setTextContent(al.getNombre());
			alumno.appendChild(nombre);
			
			Element ciclo = doc.createElement("ciclo");
			ciclo.setTextContent(al.getCiclo());
			alumno.appendChild(ciclo);
			
		}
		
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		
		DOMSource dom = new DOMSource(doc);
		StreamResult sr = new StreamResult(new File("C:\\alumnos.xml"));
		
		transformer.transform(dom, sr);
		
	}
	
	public static void leerXML(String etiqueta) throws ParserConfigurationException, SAXException, IOException {
		
		FileInputStream fis = new FileInputStream("C:\\alumnos.xml");
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(fis);
		
		NodeList nodos = doc.getElementsByTagName("nombre");
		
		for(int i = 0; i < nodos.getLength(); i++) {
			System.out.println(nodos.item(i).getTextContent());
		}
		
	}

}