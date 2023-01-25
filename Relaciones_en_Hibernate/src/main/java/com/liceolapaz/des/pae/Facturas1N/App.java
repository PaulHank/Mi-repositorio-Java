package com.liceolapaz.des.pae.Facturas1N;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App {

	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build(); 
		SessionFactory sf = new MetadataSources(ssr).buildMetadata().buildSessionFactory();

		Session session = sf.openSession();
		
		session.beginTransaction();
		
		Factura factura1 = new Factura(172717, "Papo");
		Factura factura2 = new Factura(193181, "Pepo");
		
		Lineas linea1 = new Lineas(17, 600, "Llantas de aluminio");
		Lineas linea2 = new Lineas(2, 23, "Caja de ChupaChups");
		Lineas linea3 = new Lineas(56, 120, "Vajilla completa");
		Lineas linea4 = new Lineas(616, 9999999, "Ohio");
		Lineas linea5 = new Lineas(1, 0, "Yisus Cries T");
		
		session.persist(factura1);
		session.persist(factura2);
		
		session.persist(linea5);
		session.persist(linea4);
		session.persist(linea3);
		session.persist(linea2);
		session.persist(linea1);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		ssr.close();
	}

}
