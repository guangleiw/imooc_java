package com.immoc;

public class Animal {
	public String name;
	public int age;
//	public Animal(){
//		System.out.println("Animal ���캯��");
//		age  =10;
//	}
	
	public Animal(int newAge){
		System.out.println("Animal ���캯��");
		age  =newAge;
	}
	
	void eat(){
		System.out.println("������гԶ���������.");
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + "]";
	}
}
