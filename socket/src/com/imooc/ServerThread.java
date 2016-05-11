package com.imooc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * ���������̴߳�����
 * 
 * @author wang
 *
 */
public class ServerThread extends Thread {
	// �ͱ��߳���ص�socket
	Socket socket = null;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	// ִ���̲߳�����Ӧ�ͻ�������
	public void run() {
		// 3rd ʵ�����ݽ��� ��ȡ������ ��ȡ��¼��Ϣ
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream os = null;
		PrintWriter pw = null;
		try {
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String info = null;
			while ((info = br.readLine()) != null) {
				System.out.println("���Ƿ��������ͻ���˵��" + info);
			}
			socket.shutdownInput();
			// 4th ��ȡ�����
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			pw.write("��ӭ����");
			pw.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 5th �ر������Դ
			try {

				if (pw != null) {
					pw.close();
				}
				if (os != null) {
					os.close();
				}

				if (br != null) {
					br.close();
				}
				if (isr != null) {
					isr.close();
				}
				if (is != null) {
					is.close();
				}
				if (socket != null) {
					socket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
