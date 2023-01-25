package com.liceolapaz.des.pae;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class GestorPeticionesHTTP {
	public int almacenarPagina (String esquema, String servidor, String recursos, String path) throws Exception {
		recursos = URLEncoder.encode(recursos, StandardCharsets.UTF_8);
		String direccion = esquema + servidor + recursos;
		HttpClient httpClient = HttpClient.newBuilder()
											.version(HttpClient.Version.HTTP_1_1)
											.followRedirects(HttpClient.Redirect.NORMAL)
											.build();
		
		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.uri(URI.create(direccion))
				.headers("Content-Type","text/plain")
				.setHeader("User-Agent","Mozilla/5.0")
				.build();
		
		HttpResponse<Path> response = httpClient.send(request,HttpResponse.BodyHandlers.ofFile(Path.of(path)));
		return response.statusCode();
	}
	
	public static void main(String[] args) {
		String esquema = "https://";
		String servidor = "dle.rae.es/";
		String recurso = new String("Campeón").toLowerCase();
		GestorPeticionesHTTP gestor = new GestorPeticionesHTTP();
		try {
			int codigoEstado = gestor.almacenarPagina(esquema, servidor, recurso, "C:/Users/Pablo Abeijón DAM/Downloads/campeon.html");
			if (codigoEstado == HttpURLConnection.HTTP_OK) {
				System.out.println("descarga finalizada");
			} else {
				System.err.println("Error " + codigoEstado);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
