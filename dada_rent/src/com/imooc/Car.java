package com.imooc;

/*
 * This is a good car
 */

public abstract class Car {
	protected String brand;
	protected double price;
	protected int capacity;
	protected int load ;

	public String getBrand() {
		// TODO Auto-generated method stub
		return this.brand;
	}

	public void setBrand(String brand) {
		// TODO Auto-generated method stub
		this.brand = brand;
	}

	public double getPrice() {
		// TODO Auto-generated method stub
		return this.price;
	}

	public void setPrice(double price) {
		// TODO Auto-generated method stub
		this.price = price;
	}

	public double rent(int days) {
		// TODO Auto-generated method stub
		return this.price * days;
	}

	public Car(String brand, double price, int capacity, int load) {
		super();
		this.brand = brand;
		this.price = price;
		this.capacity = capacity;
		this.load = load;
	}
	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public int getLoad() {
		return load;
	}

	public void setLoad(int load) {
		this.load = load;
	}

}
