package com.liceolapaz.des.pae.dam22_23_hibernateintro;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class Principal {

	public static void main(String[] args) {

		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build(); 
		SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		
		Session sesion = sf.openSession();
		
		Alumno alumno1 = new Alumno(100,"Papo","DAM");
		Alumno alumno2 = new Alumno(200,"Pipo","DAW");
		Alumno alumno3 = new Alumno(300,"Pepo","ASIR");
		
		// Estas dos lineas hacen absolutamente lo mismo: sesion.getTransaction().begin();
		sesion.beginTransaction();
		
		
		sesion.persist(alumno1);
		sesion.persist(alumno2);
		sesion.persist(alumno3);
		
		Query<Alumno> query = sesion.createQuery("SELECT a FROM Alumno a", Alumno.class);
		List<Alumno> alumnos = query.getResultList();
		
		for (Alumno al : alumnos) {
			System.out.println(al.getCodigo() + " " + al.getNombre() + " " + al.getCurso());
		}
		
		Query<Object[]> listaVal = sesion.createQuery("SELECT a.codigo, a.nombre, a.curso FROM Alumno a",Object[].class);
		List <Object[]> listaValImpr = listaVal.getResultList();
		for (Object[] o : listaValImpr) {
			System.out.println(o[0].toString() + " " + o[1].toString() + " " + o[2].toString());
		}
		
		//Consulta para obtener el nombre del alumno de codigo 200.
		Query<Alumno> alumnos200 = sesion.createQuery("SELECT j FROM Alumno j WHERE codigo = :dam",Alumno.class);
		List<Alumno> resultado = alumnos200.setParameter("dam",200).getResultList();
		for (Alumno al : resultado) {
			System.out.println(al.getNombre());
		}
		
		sesion.getTransaction().commit();
		sesion.close();
		sf.close();
	}

}
