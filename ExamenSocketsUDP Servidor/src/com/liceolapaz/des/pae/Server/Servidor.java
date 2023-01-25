package com.liceolapaz.des.pae.Server;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import com.liceolapaz.des.pae.Pojo.Datos;

public class Servidor {

	public static void main(String[] args) throws SocketException, UnknownHostException, ClassNotFoundException {
		DatagramSocket socket = new DatagramSocket(48000);
		InetAddress host = InetAddress.getByName("localhost");
		
		try {
			System.out.println("Servidor Iniciado");

			byte[] recibo = new byte[1024];
			DatagramPacket packetRecive = new DatagramPacket(recibo, recibo.length);
			socket.receive(packetRecive);
			ByteArrayInputStream bais = new ByteArrayInputStream(recibo);
			ObjectInputStream ois = new ObjectInputStream(bais);
			
			Datos datos = (Datos) ois.readObject();
			System.out.println("test");
			System.out.println("Datos:" + datos.getNombre() + " " + datos.getContra());
			if(!datos.getNombre().contains("Pollo")) {
				String mensajeServidor = "El nombre de usuario no era correcto";
				System.out.println(mensajeServidor);
				byte[] mServeBytes = mensajeServidor.getBytes();
				DatagramPacket devolucion = new DatagramPacket(mServeBytes, mServeBytes.length, host, 48000);
				socket.send(devolucion);
			} else {
				if (!datos.getContra().contains("Frito")) {
					String mensajeServidor = "La contraseña no era correcta";
					System.out.println(mensajeServidor);
					byte[] mServeBytes = mensajeServidor.getBytes();
					DatagramPacket devolucion = new DatagramPacket(mServeBytes, mServeBytes.length, host, 48000);
					socket.send(devolucion);
				} else {
					String mensajeServidor = "Bienvenido " + datos.getNombre();
					System.out.println(mensajeServidor);
					byte[] mServeBytes = mensajeServidor.getBytes();
					DatagramPacket devolucion = new DatagramPacket(mServeBytes, mServeBytes.length, host, 48000);
					socket.send(devolucion);
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		socket.close();
	}
}
