package com.imooc.exam;

import java.util.Scanner;

public class Initial {

	public Initial() {
		// TODO Auto-generated constructor stub
	}

	public static String getName(Book[] list, int index) throws Exception {
		for (int i = 0; i < list.length; i++) {
			if (i == index)
				return list[i].getName();
		}
		throw new Exception();
	}

	public static int getIndex(Book[] list, String name) throws Exception {
		for (int i = 0; i < list.length; i++) {
			if (list[i].getName().equals(name))
				return i;
		}
		throw new Exception();
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Book[] bookList = { new Book("Math"), new Book("English"), new Book("History") };

		System.out.println("Please input your command: 1-find by name.2-find by number.");
		Scanner sc = new Scanner(System.in);
		String cmd = sc.next();
		while (!cmd.equals("1") && !cmd.equals("2")) {
			try {
				throw new Exception("Please input the right command!!!!");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				cmd = sc.next();
			}
		}

		if (cmd.equals("1")) {
			System.out.println("ÇëÊäÈëÍ¼Êé±àºÅ£º");
			while ((cmd = sc.next()) != null) {
				System.out.println(getName(bookList, Integer.parseInt(cmd)));
			}
		}else {
			System.out.println("ÇëÊäÈëÍ¼ÊéÃû³Æ£º");
			while((cmd=sc.next())!=null){
				System.out.println(getIndex(bookList, cmd));
			}
		}

	}

}
