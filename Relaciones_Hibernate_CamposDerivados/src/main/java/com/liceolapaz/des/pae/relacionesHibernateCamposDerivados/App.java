package com.liceolapaz.des.pae.relacionesHibernateCamposDerivados;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App {
    public static void main( String[] args ) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sf = new MetadataSources(ssr).buildMetadata().buildSessionFactory();
        
        Session sesion = sf.openSession();
        
        Usuario user1 = new Usuario("Mamawebo", "noseque");
        
        sesion.beginTransaction();
        sesion.persist(user1);
        
        sesion.clear();
        sesion.close();
        sf.close();
        ssr.close();
    }
}
