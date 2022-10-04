package com.liceolpaz.des.pae;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Principal {

	public static void main(String[] args) throws IOException{
		Path origen = Paths.get("C:\\alumnos.txt");
		BufferedReader br = Files.newBufferedReader(origen);
		
		Stream<String> lineas = br.lines();
		lineas.forEach(System.out::println);
		br.close();
	}

}
