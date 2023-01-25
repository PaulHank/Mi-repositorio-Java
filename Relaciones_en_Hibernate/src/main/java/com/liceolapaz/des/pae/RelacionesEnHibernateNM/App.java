package com.liceolapaz.des.pae.RelacionesEnHibernateNM;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App {
    public static void main( String[] args ) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build(); 
		SessionFactory sf = new MetadataSources(ssr).buildMetadata().buildSessionFactory();

		Session session = sf.openSession();
		
		session.beginTransaction();
		
		//Pais
		Pais america = new Pais(100,"USA","America");
		Pais china = new Pais(300,"China","Asia");
		
		//Presidente 
		Presidente presidente1 = new Presidente(10,"Johnathan Freud Kennedy",40000);
		Presidente presidente3 = new Presidente(20, "Nicokado Madurado",20000);
		Presidente presidente2 = new Presidente(30,"Ohio Bing Xilin", 3000000);
		Presidente presidente4 = new Presidente(40, "Dimitri Petrov",1029200);
		
		List<Presidente> presidentes1 = new ArrayList<Presidente>();
		presidentes1.add(presidente4);
		presidentes1.add(presidente3);
		presidentes1.add(presidente1);
		
		List<Presidente> presidentes2 = new ArrayList<Presidente>();
		presidentes2.add(presidente2);
		
		america.setListaPresidentes(presidentes1);
		china.setListaPresidentes(presidentes2);
		
		session.persist(america);
		session.persist(china);
		
		session.persist(presidente4);
		session.persist(presidente3);
		session.persist(presidente2);
		session.persist(presidente1);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		ssr.close();
    }
}
