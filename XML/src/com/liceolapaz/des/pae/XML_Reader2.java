package com.liceolapaz.des.pae;

import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XML_Reader2 {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
       
        FileInputStream fisXML = new FileInputStream("C:\\Users\\Pablo Abeijón DAM\\Documents\\Alumnos.xml");
        DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = fac.newDocumentBuilder();
        Document documentoXML = db.parse(fisXML);

        
        System.out.println("Elemento base del fichero: " + documentoXML.getDocumentElement().getNodeName());
        System.out.println();
        
        NodeList list = documentoXML.getElementsByTagName("alumno");
        
        for (int i = 0; i < list.getLength(); i++) {

            Node node = list.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                
                Element element = (Element) node;

                String dni = element.getElementsByTagName("dni").item(i).getTextContent();
        
                String nombre = element.getElementsByTagName("nombre").item(i).getTextContent();
                
                String curso = element.getElementsByTagName("curso").item(i).getTextContent();

                System.out.println("Tag actual :" + node.getNodeName());
                System.out.println("DNI del alumno: " + dni);
                System.out.println("Nombre: " + nombre);
                System.out.println("Curso: " + curso);
            }
        }
    }
}