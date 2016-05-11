package com.immoc;

public class Animal {
	public String name;
	public int age;
//	public Animal(){
//		System.out.println("Animal 构造函数");
//		age  =10;
//	}
	
	public Animal(int newAge){
		System.out.println("Animal 构造函数");
		age  =newAge;
	}
	
	void eat(){
		System.out.println("动物具有吃东西的能力.");
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + "]";
	}
}
