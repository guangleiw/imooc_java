package com.imooc.collection;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {

	//带有泛型类型的list
	public List<Course> courses;
	
	public TestGeneric() {
		// TODO Auto-generated constructor stub
		this.courses = new ArrayList<Course>();
	}
	
	/**
	 * 测试增加
	 * @param args
	 */
	public void testAdd(){
		Course cr1 = new Course("1","大学英语");
		courses.add(cr1);
		//泛型集合中不能添加规定以外的对象
		//courses.add("This is a string");
		Course cr2 = new Course("2","Java 基础");
		courses.add(cr2);
	}
	
	/**
	 * 测试循环遍历的方法
	 * @param args
	 */
	public void testForEach(){
		for (Course cr : courses) {
			System.out.println("ID:"+cr.ID+" name:"+cr.name);
		}
	}
	
	/*
	 * 泛型集合可以添加泛型的子类型实例
	 */
	public void testChild(){
		ChildCourse ccr = new ChildCourse("3", "sub_class");
		courses.add(ccr);
	}
	
	/*
	 * 泛型不能使用基本类型
	 */
	public void testBasicType(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		System.out.println(list.get(0));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestGeneric tg = new TestGeneric();
		tg.testAdd();
		tg.testAdd();
		tg.testForEach();
		tg.testBasicType();
	}

}
