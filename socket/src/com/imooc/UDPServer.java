package com.imooc;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
public static void main(String[] args) throws IOException {
	//������������DatagramSocket 
	DatagramSocket socket = new DatagramSocket(8888);
	byte[] data = new byte[1024];
	DatagramPacket packet = new DatagramPacket(data, data.length);
	socket.receive(packet);//�����ڽ��ܵ����ݱ�֮ǰ��һֱ����
	String info = new String(data,0, packet.getLength());
	System.out.println("���Ƿ�����,�ͻ���˵��"+info);
}
}
