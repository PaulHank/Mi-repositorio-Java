package com.liceolapaz.des.pae.relacionesHibernateCamposDerivados;

import java.sql.Date;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Usuario {

	@Id
	private String login;
	@ColumnTransformer(
			write=" MD5(?) "
			)
	private String password;
	@CreationTimestamp
	private Date fechaAlta;
	@Generated(value = GenerationTime.INSERT)
	@Column(
			columnDefinition = " VARCHAR(30) AS (CONCAT (login,fechaAlta)) "
			)
	private String userDate;
	
	public Usuario(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	
	
}