package com.imooc;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
public static void main(String[] args) throws IOException {
	//创建服务器端DatagramSocket 
	DatagramSocket socket = new DatagramSocket(8888);
	byte[] data = new byte[1024];
	DatagramPacket packet = new DatagramPacket(data, data.length);
	socket.receive(packet);//方法在接受到数据报之前会一直阻塞
	String info = new String(data,0, packet.getLength());
	System.out.println("我是服务器,客户端说："+info);
}
}
