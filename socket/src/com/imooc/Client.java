package com.imooc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) {
		//1st create socket
		try {
			Socket socket = new Socket("localhost",8888);
			//2nd��ȡ����� ��server���͵�¼��Ϣ
			OutputStream os = socket.getOutputStream();//
			PrintWriter pw = new PrintWriter(os);//���������װΪ��ӡ��
			pw.write("�û����� admin;���룺123");
			pw.flush();
			socket.shutdownOutput();
			//3rd ��ȡ������
			InputStream is = socket.getInputStream();
			BufferedReader bf = new BufferedReader(new InputStreamReader(is));
			String info = null;
			while((info=bf.readLine())!= null){
				System.out.println("���ǿͻ��ˣ�������˵��"+info);
			}
			//�ر���Դ
			bf.close();is.close();
			pw.close();os.close();socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
