package com.liceolapaz.des.pae;

public class Pentagono extends Figuras_Geometricas {
	private double lado;
	private double apotema;

	public Pentagono(double lado, double apotema) {
	super();
	this.lado = lado;
	this.apotema = apotema;
	}
	
	@Override
	protected double calcularArea() {
		double area = ((this.lado)*apotema)/2;
		return area;
	}

	@Override
	protected double calcularPerimetro() {
		double perimetro = 5*lado;
		return perimetro;
	}

}
