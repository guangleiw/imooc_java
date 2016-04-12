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
			//2nd获取输出流 向server发送登录信息
			OutputStream os = socket.getOutputStream();//
			PrintWriter pw = new PrintWriter(os);//将输出流包装为打印流
			pw.write("用户名： admin;密码：123");
			pw.flush();
			socket.shutdownOutput();
			//3rd 获取输入流
			InputStream is = socket.getInputStream();
			BufferedReader bf = new BufferedReader(new InputStreamReader(is));
			String info = null;
			while((info=bf.readLine())!= null){
				System.out.println("我是客户端，服务器说："+info);
			}
			//关闭资源
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
