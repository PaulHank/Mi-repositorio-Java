package com.liceolapaz.des.pae;

import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XML_Reader {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
       
        FileInputStream fisXML = new FileInputStream("C:\\Users\\Pablo Abeijón DAM\\Documents\\Alumnos.xml");
        DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = fac.newDocumentBuilder();
        Document documentoXML = db.parse(fisXML);
        
        NodeList listaNombre = documentoXML.getElementsByTagName("alumno");
        
        for (int i =0; i<listaNombre.getLength(); i++) {
            System.out.println(listaNombre.item(i).getTextContent());
        }
            
    }

}
