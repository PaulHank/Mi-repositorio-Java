package com.liceolapaz.des.pae.ExamenAccesoADatos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XML {
	
	public void write(BufferedReader brAsignaturas, BufferedReader brCiclo) {
    	try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();
			
	    	String linea = "";
	    	String splitter = ",";
			
			Element datos = doc.createElement("Noseque");
			doc.appendChild(datos);
			
				Element asignaturas = doc.createElement("Asignaturas");
				datos.appendChild(asignaturas);
				
				while ((linea = brAsignaturas.readLine()) != null) {
					
					String[] asignaturaArr = linea.split(splitter);
	    			
	    			Element asignatura = doc.createElement("Asignatura");
	    			asignaturas.appendChild(asignatura);
		    			
		    			Element codigo = doc.createElement("codigo");
						asignatura.appendChild(codigo);
						codigo.setTextContent(asignaturaArr[0]);
						
						Element nombre = doc.createElement("nombre");
						asignatura.appendChild(nombre);
						nombre.setTextContent(asignaturaArr[1]);
						
						Element codCiclo = doc.createElement("codCiclo");
						asignatura.appendChild(codCiclo);
						codCiclo.setTextContent(asignaturaArr[2]);
					
				}
				
				Element ciclos = doc.createElement("Ciclos");
				datos.appendChild(ciclos);
				
				while ((linea = brCiclo.readLine()) != null) {		
					
					String[] cicloArr = linea.split(splitter);
	    			
	    			Element asignatura = doc.createElement("Ciclo");
	    			asignaturas.appendChild(asignatura);
		    			
		    			Element codigo = doc.createElement("codigo");
						asignatura.appendChild(codigo);
						codigo.setTextContent(cicloArr[0]);
						
						Element nombre = doc.createElement("nombre");
						asignatura.appendChild(nombre);
						nombre.setTextContent(cicloArr[1]);
					
				}
				
				TransformerFactory tf = TransformerFactory.newInstance();
				Transformer transformer = tf.newTransformer();
				DOMSource dom = new DOMSource(doc);
				
				StreamResult sr = new StreamResult(new File("C:\\Users\\Pablo Abeijón DAM\\Documents\\Notas de clase\\Acceso a datos\\ExamenAcesoADatos.xml"));
				System.out.println("El archivo se creo de forma exitosa.");
				transformer.transform(dom, sr);
			
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

}
