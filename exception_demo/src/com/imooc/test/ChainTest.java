package com.imooc.test;

public class ChainTest {

	public ChainTest() {
		// TODO Auto-generated constructor stub
	}
	
	public void test1() throws DrunckException{
		throw new DrunckException("ºÈ³µ±ð¿ª¾Æ!!!");
	}
	
	public void test2(){
		try {
			test1();
		} catch (DrunckException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			RuntimeException newExc = new RuntimeException(e);
			throw newExc;
		}
	}
	
	public static void main(String[] args){
		 ChainTest c = new ChainTest();
		 try {
			c.test2();
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("This is main method");;
			// TODO: handle exception
		}
		
	}

}
