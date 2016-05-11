package com.imooc;

public class Pickup extends Car {

	protected int load = 0;
	protected int capacity = 0;

	public Pickup(String brand, double price, int load, int capacity) {
		super(brand, price, capacity, capacity);
		// TODO Auto-generated constructor stub
		this.brand = brand;
		this.price = price;
		this.load = load;
		this.capacity = capacity;
	}

	public int getLoad() {
		return load;
	}

	public void setLoad(int load) {
		this.load = load;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
