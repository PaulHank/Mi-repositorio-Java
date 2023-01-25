package com.liceolapaz.des.pae.RelacionesEnHibernate;

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
		Presidente presidente1 = new Presidente(10,"JFK",40000, america);
		Presidente presidente2 = new Presidente(30,"John Xina", 3000000, china);
		
		
		session.persist(america);
		session.persist(china);
		
		session.persist(presidente2);
		session.persist(presidente1);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		ssr.close();
    }
}
