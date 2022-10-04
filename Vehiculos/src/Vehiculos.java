
public class Vehiculos {
		String matricula;
		String nombre;
		float vMax;
		float kmRecorridos;
		int nRuedas;
		int vel;
		
	public Vehiculos(String matricula, String nombre, float vMax, int nRuedas, float kmRecorridos) {
		this.matricula = matricula;
		this.nombre = nombre;
		this.vMax = vMax;
		this.nRuedas = nRuedas;
		this.kmRecorridos = kmRecorridos;
		
	recorrerKm(kmRecorridos);
	recorrerDia();
	recorrerDia(vel);
}

	public Vehiculos(String matricula, String nombre, float vMax, int nRuedas) {
		super();
		this.matricula = matricula;
		this.nombre = nombre;
		this.vMax = vMax;
		this.nRuedas = nRuedas;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getvMax() {
		return vMax;
	}

	public void setvMax(float vMax) {
		this.vMax = vMax;
	}

	public float getKmRecorridos() {
		return kmRecorridos;
	}

	public void setKmRecorridos(float kmRecorridos) {
		this.kmRecorridos = kmRecorridos;
	}

	public int getnRuedas() {
		return nRuedas;
	}

	public void setnRuedas(int nRuedas) {
		this.nRuedas = nRuedas;
	}

	public int getVel() {
		return vel;
	}

	public void setVel(int vel) {
		this.vel = vel;
	}

	@Override
	public String toString() {
		return "Vehiculos [matricula=" + matricula + ", nombre=" + nombre + ", vMax=" + vMax + ", kmRecorridos="
				+ kmRecorridos + ", nRuedas=" + nRuedas + ", vel=" + vel + "]";
	}

	float recorrerDia(float vel) {
			return vel*8;
		}

	static float recorrerDia() {
		int cal = vMax*8;
		return cal;
	}

	static void recorrerKm(float kmRecorridos) {
	
	}
}
