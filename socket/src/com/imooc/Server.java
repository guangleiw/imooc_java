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
 * 实现基于TCP的socket通信
 * Server端
 */
public class Server {
	public static void main(String[] args) {
		try {
			// 1st
			ServerSocket serverSocket = new ServerSocket(8888);
			// 2nd accept()
			Socket socket = null;
			int count = 0;
			System.out.println("***服务器即将启动,等待客户端连接***");
			while(true){
				socket = serverSocket.accept();
				//创建一个新的线程
				ServerThread serverThread = new ServerThread(socket);
				serverThread.start();
				count ++;//
				System.out.println("客户端数量："+count);
				InetAddress address = socket.getInetAddress();
				System.out.println("当前客户端的IP："+address.getHostAddress());
			} 
			//serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

//// 3rd 实现数据交互 获取输入流 读取登录信息
// InputStream is = socket.getInputStream();
// InputStreamReader isr = new InputStreamReader(is); //字节流包装为字符流
// BufferedReader br = new BufferedReader(isr);//为输入流添加缓冲
// String info = null;
// while((info = br.readLine())!= null){
// System.out.println("我是服务器，客户端说："+info);
// }
// socket.shutdownInput();
//// 4th 获取输出流
// OutputStream os = socket.getOutputStream();
// PrintWriter pw = new PrintWriter(os);
// pw.write("欢迎您！");
// pw.flush();
// pw.close();os.close();
//
//// 5th 关闭相关资源
// br.close();isr.close();is.close();socket.close();
