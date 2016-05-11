/**
 * 
 */
package com.imooc;

/**
 * @author Administrator
 *
 */
public class Truck extends Car {

	protected int capacity = 0;

	public Truck(String brand, double price, int load) {
		super(brand, price, 0, load);
		// TODO Auto-generated constructor stub
		this.brand = brand;
		this.price = price;
		this.load = load;
	}
}
