package com.liceolapaz.des.pae.ExamenAccesoADatos;

import java.io.BufferedReader;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HIBERNATE {
	
	public void insert(BufferedReader brAsignaturas, BufferedReader brCiclo) {
		
		try {
			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build(); 
			SessionFactory sf = new MetadataSources(ssr).buildMetadata().buildSessionFactory();

			Session session = sf.openSession();
					
			String linea = "";
			String splitter = ",";
			
			while ((linea = brCiclo.readLine()) != null) {
				String[] cicloArr = linea.split(splitter);
				
				Ciclo ciclos = new Ciclo(Integer.parseInt(cicloArr[0]),cicloArr[1]);
				
				session.getTransaction().begin();
				session.persist(ciclos);
				session.getTransaction().commit();
			}
			
			while ((linea = brAsignaturas.readLine()) != null) {	
				String[] asigArr = linea.split(splitter);
				
				Asignatura asig = new Asignatura(Integer.parseInt(asigArr[0]), asigArr[1], Integer.parseInt(asigArr[2]));
				
				session.getTransaction().begin();
				session.persist(asig);
				session.getTransaction().commit();
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
