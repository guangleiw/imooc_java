package com.imooc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * ʵ�ֻ���TCP��socketͨ��
 * Server��
 */
public class Server {
	public static void main(String[] args) {
		try {
			// 1st
			ServerSocket serverSocket = new ServerSocket(8888);
			// 2nd accept()
			Socket socket = null;
			int count = 0;
			System.out.println("***��������������,�ȴ��ͻ�������***");
			while(true){
				socket = serverSocket.accept();
				//����һ���µ��߳�
				ServerThread serverThread = new ServerThread(socket);
				serverThread.start();
				count ++;//
				System.out.println("�ͻ���������"+count);
				InetAddress address = socket.getInetAddress();
				System.out.println("��ǰ�ͻ��˵�IP��"+address.getHostAddress());
			} 
			//serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

//// 3rd ʵ�����ݽ��� ��ȡ������ ��ȡ��¼��Ϣ
// InputStream is = socket.getInputStream();
// InputStreamReader isr = new InputStreamReader(is); //�ֽ�����װΪ�ַ���
// BufferedReader br = new BufferedReader(isr);//Ϊ��������ӻ���
// String info = null;
// while((info = br.readLine())!= null){
// System.out.println("���Ƿ��������ͻ���˵��"+info);
// }
// socket.shutdownInput();
//// 4th ��ȡ�����
// OutputStream os = socket.getOutputStream();
// PrintWriter pw = new PrintWriter(os);
// pw.write("��ӭ����");
// pw.flush();
// pw.close();os.close();
//
//// 5th �ر������Դ
// br.close();isr.close();is.close();socket.close();
