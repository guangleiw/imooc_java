package com.imooc.collection;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {

	//���з������͵�list
	public List<Course> courses;
	
	public TestGeneric() {
		// TODO Auto-generated constructor stub
		this.courses = new ArrayList<Course>();
	}
	
	/**
	 * ��������
	 * @param args
	 */
	public void testAdd(){
		Course cr1 = new Course("1","��ѧӢ��");
		courses.add(cr1);
		//���ͼ����в�����ӹ涨����Ķ���
		//courses.add("This is a string");
		Course cr2 = new Course("2","Java ����");
		courses.add(cr2);
	}
	
	/**
	 * ����ѭ�������ķ���
	 * @param args
	 */
	public void testForEach(){
		for (Course cr : courses) {
			System.out.println("ID:"+cr.ID+" name:"+cr.name);
		}
	}
	
	/*
	 * ���ͼ��Ͽ�����ӷ��͵�������ʵ��
	 */
	public void testChild(){
		ChildCourse ccr = new ChildCourse("3", "sub_class");
		courses.add(ccr);
	}
	
	/*
	 * ���Ͳ���ʹ�û�������
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
