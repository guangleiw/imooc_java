package com.immoc;

public class Initial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog = new Dog();
		Dog dog2 = new Dog();
		if(dog.equals(dog2))
		{
			System.out.println("Same object.");
		}else  {
			System.out.println("Diferent!!");
		}
	}

}
