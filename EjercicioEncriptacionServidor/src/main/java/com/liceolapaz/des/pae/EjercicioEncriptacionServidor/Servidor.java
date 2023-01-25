package com.liceolapaz.des.pae.EjercicioEncriptacionServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class Servidor {
	final static String PASSWORD = "MeLlamoSpiderman";

	public static Key obtenerclave (String password,int longitud) {
		Key clave = new SecretKeySpec(password.getBytes(),0,longitud,"AES");
		return clave;
	}
	
	public static String cifrar (String textoEnClaro, Key key) 
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, 
					IllegalBlockSizeException, BadPaddingException {
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE,key);
		byte[] cipherText = cipher.doFinal(textoEnClaro.getBytes());
		return Base64.getEncoder().encodeToString(cipherText);
	}
	
	public static String decypher(String txtoCdifrado, Key key) 
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, 
					IllegalBlockSizeException, BadPaddingException {
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE,key);
		byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(txtoCdifrado));
		return new String(plainText);
	}
	
    public static void main(String[] args) throws IOException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
    	int puerto = 6000;
		ServerSocket servidor = new ServerSocket(puerto);
		
		System.out.println("Esperando cliente...");
		Socket cliente = servidor.accept();
		System.out.println("Cliente conectado.");

		DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
		DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
		
		String recibido = flujoEntrada.readUTF();
		System.out.println("El mensaje fue recibido. ");
		Key clave = obtenerclave(PASSWORD,16);
		String cifrado = cifrar(recibido,clave);
	
			
			
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build(); 
		SessionFactory sf = new MetadataSources(ssr).buildMetadata().buildSessionFactory();

		Session session;
		try {
			session = sf.openSession();
			session.beginTransaction();
			
			ToEncript push = new ToEncript(1,cifrado);
			session.persist(push);
			
			session.getTransaction().commit();
			System.out.println("La transaccion se completo correctamente.");
			session.close();

			Session nuevaSession;
			

			nuevaSession = sf.openSession();
			nuevaSession.beginTransaction();
			System.out.println("Aqui he llegado");
			
			//Pequeña nota: a la hora de usar Hibernate, el nombre de la "table" realmente ha de ser el de la clase que actua como entidad.
		
			/*
			 * Otra pequeña nota respecto al error "Converting `org.hibernate.InstantiationException` to JPA `PersistenceException` : No default constructor for entity:"
			 * Resulta que toda clase que actue como entidad NECESITA tener un constructor de base vacio para funcionar, a parte del propio con los nuevos parametros
			 */
			
			/*
			 * 
			 */
			
			Query<ToEncript> query = nuevaSession.createQuery("SELECT i FROM ToEncript i", ToEncript.class);
			List<ToEncript> lista =  query.getResultList();
			for (ToEncript encriptado: lista) {
				System.out.println(encriptado.getCifrado());
				String aDevolverSinDescifrar = encriptado.getCifrado();
				flujoSalida.writeUTF(aDevolverSinDescifrar);
			}
			nuevaSession.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		sf.close();
		ssr.close();
		
		flujoEntrada.close();
		flujoSalida.close();
		servidor.close();
		
    }
}