package com.imooc;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UDPClient {
	public static void main(String[] args) throws IOException {
		// 1.����������ĵ�ַ �˿ں� �Լ�����
		InetAddress address = InetAddress.getByName("localhost");
		int port = 8888;
		byte[] data = "�û���:admin; ���룺123".getBytes();
		// �������ݱ� �������͵���Ϣ
		DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
		// ����
		DatagramSocket socket = new DatagramSocket();
		// �������ݱ�
		socket.send(packet);
	}
}
