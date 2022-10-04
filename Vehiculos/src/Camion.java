class Camion extends Vehiculos {
	
	public Camion(String nombre, String matricula, float vMax, int nRuedas) throws Exception {
		super(nombre, matricula, vMax, nRuedas);
		if (nRuedas%2 !=0) {
			String msg = "Numero de ruedas invalido";
			Exception R = new Exception(msg);
			throw R;
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + " // Camion";
	}
}
