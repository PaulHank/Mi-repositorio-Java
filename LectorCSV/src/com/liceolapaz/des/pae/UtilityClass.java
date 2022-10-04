package com.liceolapaz.des.pae;

import java.io.File;
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

public class UtilityClass {

		public static void generarXML(ArrayList<Alumno> ListaAlumno) throws ParserConfigurationException, TransformerException {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		Document doc = db.newDocument();
		
		
		Element alumnos = doc.createElement("alumnos");
		doc.appendChild(alumnos);
		
		for (Alumno al: ListaAlumno) {
			
			Element alumno = doc.createElement("alumno");
			alumnos.appendChild(alumno);
			
			Element id = doc.createElement("id");
			id.setTextContent(String.valueOf(al.getId()));
			alumnos.appendChild(id);
			
			Element nombre = doc.createElement("nombre");
			nombre.setTextContent(al.getNombre());
			alumnos.appendChild(nombre);
			
			Element ciclo = doc.createElement("ciclo");
			ciclo.setTextContent(al.getCiclo());
			alumnos.appendChild(ciclo);
			
			}
		
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer Optimus = tf.newTransformer();		
		
		DOMSource dom = new DOMSource(doc);
		StreamResult sr = new StreamResult(new File("C:\\Alumnos.xml"));
		
		Optimus.transform(dom, sr);
		}

}
