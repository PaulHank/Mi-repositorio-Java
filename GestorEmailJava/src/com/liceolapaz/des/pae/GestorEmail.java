package com.liceolapaz.des.pae;

import java.io.IOException;
import java.security.NoSuchProviderException;
import java.util.Properties;


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
		Transport t = (Transport) sesion.getTrasnport("smtp");
		t.connect(propiedades.getProperty("mail.smtp.host"), direccionEmail,password;
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
	
	private Message crearMensajeTexto (String emisor, String destinatario, String asunto, String tectoMensaje)
	throws MessagingException, AddressException, IOException {
		Message mensaje = crearNucleoMensaje(emisor, destinatario, asunto);
		mensaje.setText(textoMensaje);
		return mensaje;
	}
	
	private Message 
	
	public static void main(String[] args) {
	

	}

}
