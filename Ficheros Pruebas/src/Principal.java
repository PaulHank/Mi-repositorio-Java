import java.io.File;
import java.io.IOException;

public class Principal {

	public static void main (String[] args) {
		String directorio = "C:\\PRUEBAS";
		File noseque = new File(directorio);
		File nuevodir = new File(noseque, "APrueba");
		
		nuevodir.mkdir();
		
		File ficheiroFacheiro = new File (nuevodir, "datos.text");
		
		try {
			ficheiroFacheiro.createNewFile();} 
		catch (IOException e) { 
			System.out.println("Ñ"); }
		
		File[] archivos = noseque.listFiles();
		
		for (int i = 0; i<archivos.length; i++) {
			 System.out.println("Nombre: " + archivos[i].getName());
			 }

		
	}
}
