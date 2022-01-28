package com.liceolapaz.des.pae;

public class Cuadrado extends Rectangulo {
	private double lado;

	
	public Cuadrado(double lado) {
		super(lado, lado);
		this.lado = lado;

	}
	@Override
	protected double calcularArea() {
		double area = lado*lado;
		return area;
	}

	@Override
	protected double calcularPerimetro() {
		double perimetro = lado*4;
		return perimetro;
	}
}
