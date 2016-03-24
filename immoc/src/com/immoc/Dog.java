package com.immoc;

public class Dog extends Animal{
	public int age = 20;
	public void eat()
	{
		System.out.println("Dog 的eat方法.");
	}
	
	public Dog(){
		super(12);
		System.out.println("Dog的构造函数");
	}
	
	public void method(){
		System.out.println(age);
		super.eat();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		if (age != other.age)
			return false;
		return true;
	}
}
