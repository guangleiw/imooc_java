package com.imooc.io;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.rmi.CORBA.Util;
import javax.swing.text.Utilities;

public class DosDemo {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		String file = "demo/dos.dat";
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
		dos.writeInt(10);
		dos.writeInt(-10);
		dos.writeLong(10l);
		dos.writeDouble(10.5);
		//采用UFT编码写出
		dos.writeUTF("大中国");
		dos.writeChars("大中国");
		IOUtil.printHex(file);
		dos.close();
		
		DataInputStream dis = new DataInputStream(new FileInputStream(file));
		int a = dis.readInt();
		System.out.println(a);
		long longd = dis.readLong();
		System.out.println(longd);
		int c = dis.readByte();
		System.out.println(c);
		String d = dis.readUTF();
		System.out.println(d);
		
	}

}
