import java.util.Scanner;
import java.util.HashMap;

public class Principal {

	public static void main(String[] args) {
		HashMap<String, Vehiculos> vehiculos = new HashMap<String, Vehiculos>();
		
		while (true)
		menu();
		
		int opcion = read();
		switch (opcion) {
		case 1:
			menu2();
			read();
			
			switch (opcion){
			case 1:
				Bici bici = añadirBici();
				if (bici != null) {
					boolean check = CM(bici.matricula, vehiculos);
					if(check == true) {
					System.out.println("Bici añadida.");
					}
					else { System.out.println("Esta bici ya existe.");
					}
				}
				break;
					
			case 2: 
				Camion camion = añadirCamion();
				if (camion != null) {
					boolean check = CM(camion.matricula, vehiculos);
					if(check == true) {
					System.out.println("Camió añadido.");
					}
					else { System.out.println("Este vehiculo ya existe.");
					}
				}
					break;
					
			case 3: 
				Coche coche = añadirCoche();
				if (coche != null) {
					boolean check = CM(coche.matricula, vehiculos);
					if(check == true) {
					System.out.println("Coche añadido.");
					}
					else { System.out.println("Este vehiculo ya existe.");
					}
				}
					break;
					
			default:
				break;
			}
			break;
			
		case 2:
			menu3();
			opcion = read();
			switch(opcion) {
			case 1:
				String matricula = readSt();
				if (vehiculos.get(matricula) != null) {
					Vehiculos.recorrerDia();
				} else {
					System.out.println("Esta matricula no existe.");
				}
				break;
				
			case 2:
				if (vehiculos.get(matricula) != null) {
					Vehiculos.recorrerKm(0);
				} else {
					System.out.println("Esta matricula no existe.");
				}
				break;
				
			case 3:
				if (vehiculos.get(matricula) != null) {
					Vehiculos.recorrerDia();
				} else {
					System.out.println("Esta matricula no existe.");
				}
				break;
				
			default: 
				break;
			}
			break;
			
		case 3:
			System.out.println(vehiculos);
			break;
			
		case 0: 
			System.exit(0);
		}

	}

	private static Coche añadirCoche() {
		Coche coche = null;
		pedirNombre();
		String nombre = readSt();
		pedirMatricula();
		String matricula = readSt();
		pedirVel();
		float vMax = read();
		
		coche = new Coche(nombre, matricula, (int) vMax);
		return coche;
	}

	private static Camion añadirCamion() {
		Camion camion = null;
		pedirNombre();
		String nombre = readSt();
		pedirMatricula();
		String matricula = readSt();
		pedirRuedas();
		int nRuedas = read();
		pedirVel();
		float vMax = read();
		
		try {
			camion = new Camion(nombre, matricula, nRuedas, (int) vMax);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return camion;
	}

	private static void pedirRuedas() {
		System.out.println("Introduce cuantas ruedas tiene el camion.");
		
	}

	private static boolean CM(String matricula, HashMap<String,Vehiculos> vehiculos) {
		boolean check = true;
		
		for (String id : vehiculos.keySet()) {
			if(id.equalsIgnoreCase(matricula)) {
				check = false;
			}
		}
		return check;
	}

	private static Bici añadirBici() {
		Bici bici = null;
		pedirNombre();
		String nombre = readSt();
		pedirMatricula();
		String matricula = readSt();
		pedirVel();
		float vMax = read();
		
		bici = new Bici(nombre, matricula, (int) vMax);
		return bici;
	}

	private static void pedirMatricula() {
		System.out.println("introduce la matricula del vehiculo: ");
		
	}

	private static void pedirVel() {
		System.out.println("Introduce la velocidad maxima del vehiculo: ");
		
	}

	private static void pedirNombre() {
		System.out.println("introduce el nombre del vehiculo: ");
		
	}

	private static String readSt() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner (System.in);
		return scanner.next();
	}

	private static void menu3() {
		System.out.println( "1 - Recorrer día. \n" + 
							"2 - Recorrer nº Km. \n" +
							"3 - Recorrer día * velocidad. \n");
	}

	private static void menu2() {
		System.out.println( "1 - Agregar bici. \n" + 
							"2 - Agregar camión. \n" +
							"3 - Agregar coche. \n");
		
	}

	private static int read() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner (System.in);
		return scanner.nextInt();
	}

	private static void menu() {
		System.out.println( "1 - Agregar vehículo. \n" +
							"2 - Seleccionar vehiculo para recorrer Km. \n" +
							"3 - Estadisticas. \n");
		
	}

}
