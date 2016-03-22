package com.imooc;

import java.util.Scanner;

public class Initial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("欢迎进入滴滴租车系统,请问你是要租车么：1 是  ;0 不是");

		//
		Scanner scanner = new Scanner(System.in);
		if (!scanner.next().equals("1")) {
			System.out.println("谢谢，再见~");
			return;
		}
		
		Car[] car_array = new Car[]{new Coach("奥迪A4",500,4),new Coach("马自达6",400,4), new Pickup("皮卡雪6", 450, 2, 4),
				new Coach("金龙", 800, 20),new Truck("松花江", 400, 4), new Truck("依维柯", 1000, 20)};
		
		System.out.println("你可租的类型以及价目表：");
		System.out.println("序号	汽车名称	租金	容量");
		
		int index = 1;
		for (Car car : car_array) {
			System.out.println((index++)+"	"+car.getBrand()+"	"+car.getPrice()+"元/天"+"	"+"载人/载货:"+car.getCapacity()+"/"+car.getLoad());
		}
		
		System.out.println("请输入你要租车的数量：");
		
		int num = scanner.nextInt();
		if (num >6 || num <= 0) return;	

	}

}
