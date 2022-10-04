package com.liceolapaz.des.pae;

import java.net.URL;

public class Usuarios {
private int id;
private String email;
private String nombre;
private String apellido;
private URL avatar;
	
	
public Usuarios(int id, String email, String nombre, String apellido, URL avatar) {
super();
this.id = id;
this.email = email;
this.nombre = nombre;
this.apellido = apellido;
this.avatar = avatar;
}	
	
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getApellido() {
	return apellido;
}

public void setApellido(String apellido) {
	this.apellido = apellido;
}

public URL getAvatar() {
	return avatar;
}

public void setAvatar(URL avatar) {
	this.avatar = avatar;
}


@Override
public String toString() {
	return "Usuarios: \n"
			+ "Id: "+ id + "\n"
			+ "Email: " + email + "\n"
			+ "Nombre: " + nombre + "\n"
			+ "Apellido: " + apellido + "\n"
			+ "Avatar: " + avatar;
}
}
