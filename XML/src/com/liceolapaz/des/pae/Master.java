package com.liceolapaz.des.pae;

import java.io.File;

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

public class Master {

	public static void master(String[] args) throws ParserConfigurationException, TransformerException {
		
		DocumentBuilderFactory creador = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = creador.newDocumentBuilder();
		Document documento = db.newDocument();
		
		 Element alumnos = documento.createElement("alumnos");
		 documento.appendChild(alumnos);
		 Element alumno = documento.createElement("alumno");
		 alumnos.appendChild(alumno);
		 Element nombre = documento.createElement("nombre");
		 alumnos.appendChild(nombre);

		 
		 TransformerFactory tf = TransformerFactory.newInstance();
		 Transformer transformer = tf.newTransformer();
		 DOMSource dom = new DOMSource(documento);
		 StreamResult sr = new StreamResult(new File("C:\\Alumnos.xml"));
		 transformer.transform(dom, sr);
	}

}
