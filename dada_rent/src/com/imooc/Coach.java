/**
 * 
 */
package com.imooc;

/**
 * @author Administrator
 *
 */
public class Coach extends Car {

	protected int load = 0;

	public Coach(String brand, double price, int capacity) {
		super(brand, price, capacity, 0);
		// TODO Auto-generated constructor stub
		
		this.brand = brand;
		this.price = price;
		this.capacity = capacity;
	}

}
