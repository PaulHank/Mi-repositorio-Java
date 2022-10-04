
public class Coche extends Vehiculos {
	static int nRuedas = 4;
	
	public Coche(String nombre, String matricula, float vMax) {
		super(nombre, matricula, vMax, nRuedas);
	}
}
