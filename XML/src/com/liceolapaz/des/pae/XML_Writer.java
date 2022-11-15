package com.liceolapaz.des.pae;

import java.io.File;
import java.util.Scanner;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XML_Writer {

	public static void main(String[] args) throws ParserConfigurationException, TransformerException {
		Scanner scanner = new Scanner (System.in);
		    
	    DocumentBuilderFactory creador = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = creador.newDocumentBuilder();
		Document documento = db.newDocument();
	    
		 Element alumnos = documento.createElement("alumnos");
		 documento.appendChild(alumnos);
		 
		 Element alumno = documento.createElement("alumno");
		 alumnos.appendChild(alumno);
		 
    		 Element dni = documento.createElement("dni");
    		 System.out.println("Dni del alumno: ");
    		 String dniAl = scanner.next();
    		 dni.setTextContent(dniAl);
    		 alumno.appendChild(dni);
    		 
    		 Element nombre = documento.createElement("nombre");
    		 System.out.println("Nombre del alumno: ");
             String nombreAl = scanner.next();
    		 nombre.setTextContent(nombreAl);
    		 alumno.appendChild(nombre);
    		 
    		 Element curso = documento.createElement("curso");
    		 System.out.println("Curso del alumno: ");
    		 String cursoAl = scanner.next();
    		 curso.setTextContent(cursoAl);
    		 alumno.appendChild(curso);

		 TransformerFactory tf = TransformerFactory.newInstance();
		 Transformer transformer = tf.newTransformer();
		 DOMSource dom = new DOMSource(documento);
		 StreamResult sr = new StreamResult(new File("C:\\Users\\Pablo Abeijón DAM\\Documents\\Alumnos.xml"));
		 transformer.transform(dom, sr); 		 
	
	}
}