package com.liceolapaz.des.pae.bd_to_xml_to_bd;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Jugador {
	@Id
	int codJugador;
	@Column
	String nombreJu;
	@Column
	String posicion;
	@Column
	int codEquipoJu;
	
	public Jugador(int codJugador, String nombreJu, String posicion, int codEquipoJu) {
		super();
		this.codJugador = codJugador;
		this.nombreJu = nombreJu;
		this.posicion = posicion;
		this.codEquipoJu = codEquipoJu;
		}

	public int getCodJugador() {
		return codJugador;
	}

	public void setCodJugador(int codJugador) {
		this.codJugador = codJugador;
	}

	public String getNombreJu() {
		return nombreJu;
	}

	public void setNombreJu(String nombreJu) {
		this.nombreJu = nombreJu;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public int getCodEquipoJu() {
		return codEquipoJu;
	}

	public void setCodEquipoJu(int codEquipoJu) {
		this.codEquipoJu = codEquipoJu;
	}
	
}
