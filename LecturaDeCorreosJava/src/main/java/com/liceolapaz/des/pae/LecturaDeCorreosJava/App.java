package com.liceolapaz.des.pae.LecturaDeCorreosJava;

import java.util.Properties;
import java.util.Scanner;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;

import com.sun.mail.imap.IMAPFolder;

public class App {
	//iqklonuytitemete
	private Session getSessionImap() {
		Properties propiedades = new Properties();
		propiedades.setProperty("mail.store.protocol", "imap");
		propiedades.setProperty("mail.imap.host", "imap.gmail.com");
		propiedades.setProperty("mail.imap.port","993");
		propiedades.setProperty("mail.imap.ssl.enable","true");
		propiedades.setProperty("mail.imap.ssl.trust", "imap.gmail.com");
		Session sesion = Session.getDefaultInstance(propiedades);
		return sesion;
	}
	
	public void leerCarpetaInbox (String email, String password) throws Exception {
		Session sesion = this.getSessionImap();
		Store almacen = sesion.getStore("imaps");
		almacen.connect("imap.gmail.com", 993, email, password);
		IMAPFolder inbox = (IMAPFolder) almacen.getFolder("INBOX");
		inbox.open(Folder.READ_WRITE);
		Message[] mensajes = inbox.getMessages();
		for (int i = 0; i < mensajes.length; i++) {
			Message mensaje = mensajes[i];
			Address[] direccionesOrigen = mensaje.getFrom();
			String from = direccionesOrigen[0].toString();
			Address[] direccionesDestino = mensaje.getRecipients(RecipientType.TO);
			String to = direccionesDestino[0].toString();
			String subject = mensaje.getSubject();
			MimeMultipart mimeMultipart = (MimeMultipart) mensaje.getContent();
			if (mimeMultipart.getBodyPart(0).isMimeType("text/plain")) {
				String textoMensaje = (String) mimeMultipart.getBodyPart(0).getContent();
				System.out.printf("De: %s\nA: %s\nAsunto: %s\nMensaje: %s\n", from, to, subject, textoMensaje);
			} else {
				System.out.printf("De: %s\nA: %s\nAsunto: %s\nMensaje: %s\n", from, to, subject, "El mensaje no solo esta compuesto de texto plano");
			}
		}
	}
	
	
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la direccion de correo: ");
        String email = sc.nextLine();
        System.out.println("Introduce la contraseña: ");
        String password = sc.nextLine();
        System.out.println();
        sc.close();
        try {
			new App().leerCarpetaInbox(email, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
