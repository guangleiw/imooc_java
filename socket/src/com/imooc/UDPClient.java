package com.imooc;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UDPClient {
	public static void main(String[] args) throws IOException {
		// 1.定义服务器的地址 端口号 以及数据
		InetAddress address = InetAddress.getByName("localhost");
		int port = 8888;
		byte[] data = "用户名:admin; 密码：123".getBytes();
		// 创建数据报 包含发送的信息
		DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
		// 创建
		DatagramSocket socket = new DatagramSocket();
		// 发送数据报
		socket.send(packet);
	}
}
