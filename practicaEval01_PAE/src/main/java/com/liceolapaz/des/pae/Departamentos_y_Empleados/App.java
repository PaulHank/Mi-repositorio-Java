package com.liceolapaz.des.pae.Departamentos_y_Empleados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class App {
	
	public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\033[1;92m";
	
	 @SuppressWarnings("resource")
	public static void main( String[] args ) throws 
	 ClassNotFoundException, SQLException, ParserConfigurationException, 
	 DOMException, IOException, TransformerException {
	    	
		 //1.- Insertad, mediante JDBC, los datos correspondientes empleando PostgreSQL como gestor.
		 
	    	Class.forName("org.postgresql.Driver");
	    	
	    	Connection conexion = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/AD_Control1?serverTimezone=UTC","postgres","1234");
	    	BufferedReader brEm = new BufferedReader(new FileReader("C:\\Users\\Pablo Abeijón DAM\\Downloads\\empleados.csv"));
	    	BufferedReader brDe = new BufferedReader(new FileReader("C:\\Users\\Pablo Abeijón DAM\\Downloads\\departamentos.csv"));
	    	
	    	String linea = "";
	    	String splitter = ",";
	    	
	    	//Insercion de departamentos a la base de datos.
	    	try {
	    		
	    		while ((linea = brDe.readLine()) != null) {
	    			String[] departamento = linea.split(splitter);
	    			
	    	    	
	    	    	PreparedStatement insertDepartamentos = conexion.prepareStatement(
	    	    			"INSERT INTO departamento (codigo,nombre,provincia) VALUES (?,?,?)");
		
			    	insertDepartamentos.setInt(1, Integer.parseInt(departamento[0])); //Codigo - INTEGER
			    	insertDepartamentos.setString(2, departamento[1]); //nombre - VARCHAR
			    	insertDepartamentos.setString(3, departamento[2]); //Provincia - VARCHAR
			    	
			    	int filas = insertDepartamentos.executeUpdate();
			    	if (filas == 0) {
		 	            System.out.println("Error al insertar el registro en la tabla departamentos.");
		 	        } else {
		 	            System.out.println("El registro de departamentos se ha insertado correctamente.");
		 	        }  	
	    		}
	    		
	    	}
	    	catch (IOException e) {
	    		e.printStackTrace();
	    	}
	    	
	    	System.out.println();
	    	
	    	//Insercion de empleados a la base de datos.
	    	try {
	    		
	    		while ((linea = brEm.readLine()) != null) {

	    			String[] empleado = linea.split(splitter);
	    			
	    			
			    	PreparedStatement insertEmpleados = conexion.prepareStatement(
			    			"INSERT INTO empleado (id,nombre,apellido,puesto,salario,departamento) VALUES (?,?,?,?,?,?)");
	    	    	
	    	    	insertEmpleados.setInt(1, Integer.parseInt(empleado[0])); //id - INTEGER
	    	    	insertEmpleados.setString(2, empleado[1]); //nombre - VARCHAR
	    	    	insertEmpleados.setString(3, empleado[2]); //apellido - VARCHAR
	    	    	insertEmpleados.setString(4, empleado[3]); //puesto - VARCHAR (contienen numeros tambien)
	    	    	insertEmpleados.setInt(5, Integer.parseInt(empleado[4])); //salario - INTEGER
	    	    	insertEmpleados.setInt(6, Integer.parseInt(empleado[5])); //departamento - INTEGER
	    	    	
	    	    	int filas = insertEmpleados.executeUpdate();
	    	    	if (filas == 0) {
		 	            System.out.println("Error al insertar el registro en la tabla empleados.");
		 	        } else {
		 	            System.out.println("El registro de empleados se ha insertado correctamente.");
		 	        }  	
	    		}
	    		
	    	}
	    	catch (IOException e) {
	    		e.printStackTrace();
	    	}
	    	
	    	System.out.println();
	    	
		//2. Utilizando JDBC, realizad las siguientes dos consultas. Los resultados se mostrarán por pantalla y se escribirán en un fichero denominado "consultas.txt" 
    	// (se escribirá el resultado de la primera, se insertará una línea de diez asteriscos y, a continuación, se escribirá el resultado de la segunda, 
    	// tanto para mostrar por pantalla como para generar el fichero):

   			//2.1. Mostrad los nombres de los departamentos.
	    	
	    	
	    	FileWriter fw = new FileWriter("C:\\Users\\Pablo Abeijón DAM\\Documents\\Notas de clase\\Acceso a datos\\consultas.txt",true);
	    	
	    	BufferedWriter bw = new BufferedWriter(fw);
	    	
	    	Statement selectDepartamentos = conexion.createStatement();
	    	
	    	ResultSet resultadoSelectDpt = selectDepartamentos.executeQuery("SELECT nombre FROM departamento");
	    	
	    	while (resultadoSelectDpt.next()) {
	    		System.out.println(resultadoSelectDpt.getString(1));
	    		
	    		String nombresDepartamentos = resultadoSelectDpt.getString(1);
	    		
	    		bw.write(nombresDepartamentos + "\r");
	    	}
	    	
	    	System.out.println("**********");
	    	bw.write("**********" + "\r");
	    	
	    	//2.2. Mostrad todos los datos de los empleados que trabajan en el departamento 20.
	    	
	    	Statement selectEmpleados = conexion.createStatement();
	    	
	    	ResultSet resultadoEmpleados = selectEmpleados.executeQuery(
	    			"SELECT * FROM empleado INNER JOIN departamento ON departamento.codigo=empleado.departamento WHERE departamento.codigo = 20");
	    	
	    	while (resultadoEmpleados.next()) {
	    		System.out.println(resultadoEmpleados.getInt(1) + " " + resultadoEmpleados.getString(2) + " " + resultadoEmpleados.getString(3) 
	    		+ " " + resultadoEmpleados.getString(4) + " " + resultadoEmpleados.getInt(5) + " " + resultadoEmpleados.getInt(6));
	    		
	    		String empleado = resultadoEmpleados.getInt(1) + " " + resultadoEmpleados.getString(2) + " " + resultadoEmpleados.getString(3) 
	    		+ " " + resultadoEmpleados.getString(4) + " " + resultadoEmpleados.getInt(5) + " " + resultadoEmpleados.getInt(6);
	    		
	    		bw.write(empleado);
	    	}
	    	System.out.println(ANSI_GREEN + "TXT file done!" + ANSI_RESET);
	    	bw.flush();
	    	
	    	System.out.println();

		//3. Generad un fichero XML, llamado "datos.xml", con el contenido de los dos ficheros iniciales de esta práctica.
	    	
	    	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();
			
			Element datos = doc.createElement("empresa");
			doc.appendChild(datos);
			
			Element empleados = doc.createElement("empleados");
			datos.appendChild(empleados);
			
			brEm = new BufferedReader(new FileReader("C:\\Users\\Pablo Abeijón DAM\\Downloads\\empleados.csv"));
			

    		while ((linea = brEm.readLine()) != null) {
    			
    			String[] empleadoArr = linea.split(splitter);
    			
    			Element empleado = doc.createElement("empleado");
    			empleados.appendChild(empleado);
    			
    			
					Element id = doc.createElement("id");
					empleado.appendChild(id);
					id.setTextContent(empleadoArr[0]);
					
					Element nombre = doc.createElement("nombre");
					empleado.appendChild(nombre);
					nombre.setTextContent(empleadoArr[1]);
					
					Element apellido = doc.createElement("apellido");
					empleado.appendChild(apellido);
					apellido.setTextContent(empleadoArr[2]);
					
					Element puesto = doc.createElement("puesto");
					empleado.appendChild(puesto);
					puesto.setTextContent(empleadoArr[3]);
					
					Element salario = doc.createElement("salario");
					empleado.appendChild(salario);
					salario.setTextContent(empleadoArr[4]);
					
					Element departamento = doc.createElement("departamento");
					empleado.appendChild(departamento);
					departamento.setTextContent(empleadoArr[5]);
					
					System.out.println("Employee insertion done!");
	    			
			}	
    		
    		Element departamentos = doc.createElement("departamentos");
			datos.appendChild(departamentos);
			
			brDe = new BufferedReader(new FileReader("C:\\Users\\Pablo Abeijón DAM\\Downloads\\departamentos.csv"));
    		
    		while ((linea = brDe.readLine()) != null) {
    			
    			String[] departamentoArr = linea.split(splitter);
    			
    			Element departamento = doc.createElement("departamento");
    			departamentos.appendChild(departamento);
    				
    				Element codigo = doc.createElement("codigo");
					departamento.appendChild(codigo);
					codigo.setTextContent(departamentoArr[0]);
					
					Element nombreDpt = doc.createElement("nombre");
					departamento.appendChild(nombreDpt);
					nombreDpt.setTextContent(departamentoArr[1]);
					
					Element provincia = doc.createElement("provincia");
					departamento.appendChild(provincia);
					provincia.setTextContent(departamentoArr[2]);
							
					System.out.println("Department insertion done!");
					
    		}
    		
    		TransformerFactory tf = TransformerFactory.newInstance();
			Transformer optimus = tf.newTransformer();
			DOMSource dom = new DOMSource(doc);
			
			StreamResult sr = new StreamResult(new File("C:\\Users\\Pablo Abeijón DAM\\Documents\\Notas de clase\\Acceso a datos\\datos.xml"));
			
			optimus.transform(dom, sr);
    		
    		System.out.println(ANSI_GREEN + "XML file done!" + ANSI_RESET);
    	
		//4. Insertad, mediante Hibernate y empleando MySQL, los datos del fichero de departamentos.
			
			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build(); 
			SessionFactory sf = new MetadataSources(ssr).buildMetadata().buildSessionFactory();
		
			Session session = sf.openSession();
			
			
			brDe = new BufferedReader(new FileReader("C:\\Users\\Pablo Abeijón DAM\\Downloads\\departamentos.csv"));
				
			while ((linea = brDe.readLine()) != null) {	
				String[] departamentoArr = linea.split(splitter);
				
				Departamento dpts = new Departamento(Integer.parseInt(departamentoArr[0]), departamentoArr[1], departamentoArr[2]);
				
				session.getTransaction().begin();
				session.persist(dpts);
				session.getTransaction().commit();
				
			}

		//5. Mostrad, utilizando HQL, los nombres de los departamentos.
			
			Query<Object[]> query = session.createQuery("SELECT d.nombre FROM Departamento d", Object[].class);
			List<Object[]> departamentoList = query.getResultList();
			
			System.out.println();
			
			for (Object[] dpt : departamentoList) {
				System.out.println(dpt[0].toString());
			}
			
			session.close();
			sf.close();
			ssr.close();
	    	 
			brDe.close();
			brEm.close();
			
		//6. Sufrir por todos los bugs causados y arreglados. Total de tiempo trabajado en el proyecto: 9h
      
    }
}