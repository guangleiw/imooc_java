package com.imooc;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class TestIntAddress {
	public static void main(String[] args) throws UnknownHostException{
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("Name:"+address.getHostName());
		System.out.println("IP:" + address.getHostAddress());
		byte[] bytes = address.getAddress();
		System.out.println("IP:" + Arrays.toString(bytes));
		System.out.println(address);
		
		
		//根据主机名 获取INETADDRESS
		InetAddress addr = InetAddress.getByName("wang-PC");
		System.out.println("IP:" + addr.getHostAddress());
		
		//根据IP地址获取
		InetAddress addr5 = InetAddress.getByName("192.168.1.6");
		System.out.println("Name:" +addr5.getHostName());
	}
}
