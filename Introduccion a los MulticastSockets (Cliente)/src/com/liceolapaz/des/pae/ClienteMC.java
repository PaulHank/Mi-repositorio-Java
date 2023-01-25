package com.liceolapaz.des.pae;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;

public class ClienteMC {

	public static void main(String[] args) throws IOException {
		
		int Puerto = 12345;
		MulticastSocket ms = new MulticastSocket(Puerto);
		InetAddress multicastAddress = InetAddress.getByName("228.0.0.1");
		InetSocketAddress grupo = new InetSocketAddress(multicastAddress,6000);
		NetworkInterface nI = NetworkInterface.getByName("bge0");
		
		ms.joinGroup(grupo, nI);
		String msg = "";
		while(!msg.trim().equals("*")) {
			byte[] buf = new byte[1000];
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			ms.receive(packet);
			msg = new String(packet.getData());
			System.out.println("Recibo: " + msg.trim());
		}
		ms.leaveGroup(grupo, nI);
		ms.close();
		System.out.println("Socket cerrado...");

	}

}
