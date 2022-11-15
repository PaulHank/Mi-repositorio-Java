package com.liceolapaz.des.pae.pruebaexamenaccesoadatos;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

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

public class CSVtoXML {
	BufferedReader br;
	BufferedWriter bw;
	
	
	public List<String[]> leerCSV(Path CSV) throws IOException {
		
		List<String[]> splitList = new ArrayList<>();
		br = Files.newBufferedReader(CSV);
		Stream<String> lineas = br.lines();
		lineas.forEach(al -> {
			splitList.add(al.split(";"));
		});
		System.out.println(splitList.get(1)[1]+splitList.get(1));
		return splitList;
		
	}
	
	public void generarXML (List<String[]> splitList) throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = factoria.newDocumentBuilder();
		Document documento = db.newDocument();
		
		Element alumnos = documento.createElement("alumnos");
		documento.appendChild(alumnos);
		
		Element alumno = documento.createElement("alumno");
		alumnos.appendChild(alumno);
		
		Element dni = documento.createElement("dni");
		alumno.appendChild(dni);
		
		Element nombre = documento.createElement("nombre");
		alumno.appendChild(nombre);
		
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		DOMSource dom = new DOMSource(documento);
		StreamResult sr = new StreamResult(new File("C:\\fich.xml"));
		transformer.transform(dom, sr);

	}
	
	public static void main(String[] args) {
		

	}

}
