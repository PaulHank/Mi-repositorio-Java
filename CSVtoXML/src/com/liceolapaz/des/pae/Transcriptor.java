package com.liceolapaz.des.pae;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.stream.Stream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class Transcriptor {

	static ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
	
	public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException, SAXException {
		
		Path origen = Paths.get("C:\\alumnos.csv");
		
		BufferedReader br = Files.newBufferedReader(origen);
		
		Stream<String> lineas = br.lines();
		
		lineas.forEach(linea -> {
			String[] campos = linea.split(";");
			Alumno alumno = new Alumno(Integer.parseInt(campos[0]), campos[1], campos[2]);
			listaAlumnos.add(alumno);
		});
		
		Utilidades.generarXML(listaAlumnos);
		Utilidades.leerXML("nombre");

	}

}
