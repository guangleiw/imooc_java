package com.imooc;

import java.util.Scanner;

public class Initial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("��ӭ����ε��⳵ϵͳ,��������Ҫ�⳵ô��1 ��  ;0 ����");

		//
		Scanner scanner = new Scanner(System.in);
		if (!scanner.next().equals("1")) {
			System.out.println("лл���ټ�~");
			return;
		}
		
		Car[] car_array = new Car[]{new Coach("�µ�A4",500,4),new Coach("���Դ�6",400,4), new Pickup("Ƥ��ѩ6", 450, 2, 4),
				new Coach("����", 800, 20),new Truck("�ɻ���", 400, 4), new Truck("��ά��", 1000, 20)};
		
		System.out.println("�����������Լ���Ŀ��");
		System.out.println("���	��������	���	����");
		
		int index = 1;
		for (Car car : car_array) {
			System.out.println((index++)+"	"+car.getBrand()+"	"+car.getPrice()+"Ԫ/��"+"	"+"����/�ػ�:"+car.getCapacity()+"/"+car.getLoad());
		}
		
		System.out.println("��������Ҫ�⳵��������");
		
		int num = scanner.nextInt();
		if (num >6 || num <= 0) return;	

	}

}
