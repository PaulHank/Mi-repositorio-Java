package com.liceolapaz.des.pae;

public class Triangulo extends Figuras_Geometricas {
	private double lado1; 
	private double lado2; 
	private double lado3; 
	private double altura;
		
	public Triangulo(double lado1, double lado2, double lado3, double altura) {
		super();
		this.lado1 = lado1;
		this.lado2 = lado2;
		this.lado3 = lado3;
		this.altura = altura;
		
		//tendria que crea una variable de perimetro y area en la superclaso, creo.
		
		//Resulta que no, ya que son variables creadas en base a resultados de las herencias.
		
	}
	
	
	@Override
	protected double calcularArea() {
		double Area = (this.lado3*this.altura)/2;
		System.out.println("El area es: " + Area);
		return Area;
	}

	@Override
	protected double calcularPerimetro() {
			double Perimetro = this.lado1+this.lado2+this.lado3; 
				System.out.println("El perimetro es: " + Perimetro);
				return Perimetro;
	}

}
