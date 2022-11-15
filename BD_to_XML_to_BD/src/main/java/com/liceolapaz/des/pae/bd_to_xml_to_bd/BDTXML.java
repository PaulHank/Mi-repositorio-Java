package com.liceolapaz.des.pae.bd_to_xml_to_bd;

import java.io.File;
import java.sql.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class BDTXML {
	
    public static void main( String[] args ) throws ClassNotFoundException, SQLException, ParserConfigurationException, TransformerException {
       
    	try {
			Class.forName("org.postgresql.Driver");
			
			Connection conexionPostgres = 
			DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/AD_Control1?serverTimezone=Europe/Madrid","postgres","1234");
			
			Statement csj = conexionPostgres.createStatement();
			ResultSet rcsj = csj.executeQuery("SELECT * FROM jugador");
				    	
			//Crear documento
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();
			
			Element leboro = doc.createElement("leboro");
			doc.appendChild(leboro);
			
 
			System.out.println("Datos descargados satisfactoriamente de la base de datos\n");
			
			//Jugadores
				Element jugadores = doc.createElement("jugadores");
				leboro.appendChild(jugadores);
			
			while (rcsj.next()) { 
				
				Element jugador = doc.createElement("jugador");
				jugadores.appendChild(jugador);
				
				Element codigoJ = doc.createElement("codjugador");
				jugador.appendChild(codigoJ);
				
				Element nombreJ = doc.createElement("nombreJu");
				jugador.appendChild(nombreJ);
				
				Element posicion = doc.createElement("posicion");
				jugador.appendChild(posicion);
				
				Element codeEquipoJu = doc.createElement("codequipoJu");
				jugador.appendChild(codeEquipoJu);
			    	
				Integer ce = rcsj.getInt(1);
				String ces = ce.toString();
				
				String nj = rcsj.getString(2);
				
				String pos = rcsj.getString(3);
				
				Integer a = rcsj.getInt(4);
				String as = a.toString();
				
				String[] values = {ces, nj, pos, as};
				
				for (int i = 0; i < values.length; i++) {
					codigoJ.setTextContent(values[0]);
					nombreJ.setTextContent(values[1]);
					posicion.setTextContent(values[2]);
					codeEquipoJu.setTextContent(values[3]);
				}
				
				System.out.println(rcsj.getInt(1) 
						  + ", " + rcsj.getString(2) 
						  + ", " + rcsj.getString(3) 
						  + ", " + rcsj.getInt(4));

				
				
				StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build(); 
				SessionFactory sf = new MetadataSources(ssr).buildMetadata().buildSessionFactory();
			
				Session session = sf.openSession();
				
				Jugador jugador1 = new Jugador(ce, nj, pos, a);
				
				session.getTransaction().begin();
				session.persist(jugador1);
				session.getTransaction().commit();
				session.close();
				sf.close();
				ssr.close();
				
			}
			
			
			System.out.println();
			
			
			Statement cse = conexionPostgres.createStatement();
			ResultSet rcse = cse.executeQuery("SELECT * FROM equipo");
			
			//Equipos
			Element equipos = doc.createElement("equipos");
			leboro.appendChild(equipos);
			
			while (rcse.next()) {
				
				Element equipo = doc.createElement("equipo");
				equipos.appendChild(equipo);
				
				Element codequipo = doc.createElement("codequipo");
				equipo.appendChild(codequipo);
				
				Element nombreEq = doc.createElement("nombreEq");
				equipo.appendChild(nombreEq);
				
				Element ciudad = doc.createElement("ciudad");
				equipo.appendChild(ciudad);
				
				Element anho = doc.createElement("anho");
				equipo.appendChild(anho);
				
				Integer ce = rcse.getInt(1);
				String ne = rcse.getString(2);
				String c = rcse.getString(3);
				Integer a = rcse.getInt(4);
				String ces = ce.toString();
				String as = a.toString();
				String [] values = {ces, ne, c, as};
				
				for (int i = 0; i < values.length; i++) {
					codequipo.setTextContent(values[0]);
					nombreEq.setTextContent(values[1]);
					ciudad.setTextContent(values[2]);
					anho.setTextContent(values[3]);
				}
				
				System.out.println(rcse.getInt(1) 
						  + ", " + rcse.getString(2) 
						  + ", " + rcse.getString(3) 
						  + ", " + rcse.getInt(4));
				
				StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build(); 
				SessionFactory sf = new MetadataSources(ssr).buildMetadata().buildSessionFactory();
			
				Session session = sf.openSession();
				
				Equipo equipo1 = new Equipo(ce, ne , c, a);
				
				session.getTransaction().begin();
				session.persist(equipo1);
				session.getTransaction().commit();
				session.close();
				sf.close();
				ssr.close();
				
			}

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer optimus = tf.newTransformer();
			DOMSource dom = new DOMSource(doc);
			
			StreamResult sr = new StreamResult(new File("C:\\Users\\Pablo Abeijón DAM\\Documents\\Notas de clase\\Acceso a datos\\Ej.xml"));
			
			optimus.transform(dom, sr);

		
			
			
			
			
			cse.close();
			csj.close();
			conexionPostgres.close();
			
		} catch (ClassNotFoundException e) {
			System.err.println("La clase 'Driver' no ha sido encontrada.");
			e.printStackTrace();
		} catch (DOMException e) {
			System.err.println("Algo ha sucedido a la hora de crear el documento.");
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			System.err.println("Algo ha ocurrido al intentar transformar el documento.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Error en la consulta SQL, por favor, revisala.");
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			System.err.println("Error al parsear un elemento, por favor, revisa el codigo.");
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			System.err.println("Error al factorizar la transformacion del documento, revisa el codigo.");
			e.printStackTrace();
		} catch (TransformerException e) {
			System.err.println("Error del transformador, revisa el codigo.");
			e.printStackTrace();
		}
    	
    }
}
