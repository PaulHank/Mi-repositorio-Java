package com.liceolapaz.des.pae.GestorEmail;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchProviderException;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class GestorEmail {
	private Properties propiedades;
	private Session sesion;
	
	private void setPropiedadesServidorSMTP() {
		propiedades = System.getProperties();
		propiedades.put("mail.smtp.auth", "true");
		propiedades.put("mail.smtp.host", "smtp.gmail.com");
		propiedades.put("mail.smtp.port", "587");
		propiedades.put("mail.smtp.starttls.enable","true");
		sesion = Session.getInstance(propiedades,null);
	}

	private Transport conectarServidorSMTP(String direccionEmail, String password) 
	throws NoSuchProviderException, MessagingException {
		Transport t = (Transport) sesion.getTransport("smtp");
		t.connect(propiedades.getProperty("mail.smtp.host"), direccionEmail,password);
		return t;
	}
	
	private Message crearNucleoMensaje (String emisor, String destinatario, String asunto) 
	throws AddressException, MessagingException {
		Message mensaje = new MimeMessage(sesion);
		mensaje.setFrom(new InternetAddress(emisor));
		mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
		mensaje.setSubject(asunto);
		return mensaje;
	}
	
	private Message crearMensajeTexto (String emisor, String destinatario, String asunto, String textoMensaje)
	throws MessagingException, AddressException, IOException {
		Message mensaje = crearNucleoMensaje(emisor, destinatario, asunto);
		mensaje.setText(textoMensaje);
		return mensaje;
	}
	
	private Message crearMensajeConAdjunto(String emisor, String destinatario, String asunto, String textoMensaje, String pathFichero) 
	throws MessagingException, AddressException, IOException {
		Message mensaje = crearNucleoMensaje(emisor, destinatario, asunto);
		BodyPart bodyPart = new MimeBodyPart();
		bodyPart.setText(textoMensaje);
		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		mimeBodyPart.attachFile(new File(pathFichero));
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(bodyPart);
		multipart.addBodyPart(mimeBodyPart);
		mensaje.setContent(multipart);
		return mensaje;
	}
	
	public void enviarMensajeTexto(String emisor, String destinatario, String asunto, String textoMensaje, String password)
	throws AddressException, MessagingException, IOException, NoSuchProviderException {
		setPropiedadesServidorSMTP();
		Message mensaje = crearMensajeTexto(emisor, destinatario, asunto, textoMensaje);
		Transport t = conectarServidorSMTP(destinatario, password);
		t.sendMessage(mensaje, mensaje.getAllRecipients());
		t.close();
		return;
	}
	
	public void enviarMensajeConAdjunto(String emisor, String destinatario, String asunto, String textoMensaje, String password, String pathFichero)
	throws AddressException, MessagingException, IOException, NoSuchProviderException {
		setPropiedadesServidorSMTP();
		Message mensaje = crearMensajeConAdjunto(emisor, destinatario, asunto, textoMensaje, pathFichero);
		Transport t = conectarServidorSMTP(destinatario, password);
		t.sendMessage(mensaje, mensaje.getAllRecipients());
		return;
	}
	
	public static void main(String[] args) {
	try {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce direccion de correo: ");
		String emailEmisor = sc.nextLine();
		System.out.print("Introduce contraseña: ");
		String passwordEmisor = sc.nextLine();
		sc.close();
		
		GestorEmail gestorEmail = new GestorEmail();
		gestorEmail.enviarMensajeTexto(emailEmisor, "Pablo585.PAE@gmail.com", "Aviso de entrega de factura", 
									   "El import de la factura es noseque", passwordEmisor);
		
		gestorEmail.enviarMensajeConAdjunto(emailEmisor, "Pablo585.PAE@gmail.com", "Aviso de entrega de factura", 
											"El importe de la factura es noseque", passwordEmisor, 
											"C:/Users/Pablo Abeijón DAM/Downloads/campeon.html");
		
		System.out.println("Correo enviado.");
	} catch (Exception e) {
		e.printStackTrace();
	}

	}

}
