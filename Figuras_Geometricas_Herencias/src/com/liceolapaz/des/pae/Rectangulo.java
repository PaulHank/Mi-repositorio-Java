package com.liceolapaz.des.pae;

public class Rectangulo extends Figuras_Geometricas {
	protected double base;
	protected double h;
	
	public Rectangulo(double base, double h) {
		super();
		this.base = base;
		this.h = h;
	}
	
@Override
protected double calcularPerimetro() { 
			double Perimetro = (this.base*2)+(this.h*2); 
			System.out.println("El perimetro es: " + Perimetro);
			return Perimetro;
}

@Override
protected double calcularArea() {
			double Area = (base*h)/2;
			System.out.println("El area es: "+ Area);
			return Area;
	
}


}