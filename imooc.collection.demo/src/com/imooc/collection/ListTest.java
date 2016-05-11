package com.imooc.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 备选课程类
 * 
 * @author Administrator
 *
 */
public class ListTest {

	// 用于存放备选课程的list
	public List coursesToSelect;

	public ListTest() {
		// TODO Auto-generated constructor stub
		this.coursesToSelect = new ArrayList();
	}

	/**
	 * 用于向coursesToselect中添加课程
	 */
	public void testAdd() {
		// 创建课程对象 并通过add方法添加进去
		Course cr1 = new Course("1", "Data Structure");
		coursesToSelect.add(cr1);
		Course temp = (Course) coursesToSelect.get(0);
		System.out.println("已经添加课程:" + temp.ID + " name:" + temp.name);

		Course cr2 = new Course("2", "C language");
		coursesToSelect.add(0, cr2);
		temp = (Course) coursesToSelect.get(0);
		System.out.println("已经添加课程:" + temp.ID + " name:" + temp.name);

		// Course cr3 = new Course("3","Test");
		// coursesToSelect.add(4, cr3);//下标越界异常

		Course[] course = { new Course("3", "Math"), new Course("4", "assemble language") };
		coursesToSelect.addAll(Arrays.asList(course));
		Course temp3 = (Course) coursesToSelect.get(2);
		Course temp4 = (Course) coursesToSelect.get(3);
		System.out.println("添加2门课程：" + temp3.ID + temp3.name + " " + temp4.ID + temp4.name);

		Course[] course2 = {};

	}

	public void testGet() {
		int size = coursesToSelect.size();
		for (int i = 0; i < size; i++) {
			Course cor = (Course) coursesToSelect.get(i);
			System.out.println("课程:" + cor.ID + cor.name);
		}
	}


	public void testIterator() {
		Iterator it = coursesToSelect.iterator();
		System.out.println("通过迭代器遍历：");
		while (it.hasNext()) {
			Course cr = (Course) it.next();
			System.out.println("课程:" + cr.ID + cr.name);
		}
	}
	
	public void testForEach(){
		System.out.println("For each 遍历");
		for (Object object : coursesToSelect) {
			Course cr  = (Course)object;
			System.out.println("课程："+cr.ID+"-"+cr.name);
		}
	}
	
	public void testModify(){
		coursesToSelect.set(2, new Course("5","毛概"));
	}
	
	public void testRemove(){
		Course cr = (Course)coursesToSelect.get(2);
		System.out.println("cr:"+cr.ID+cr.name+",即将被删除");
		Course[] crs = {(Course)coursesToSelect.get(2),(Course)coursesToSelect.get(3)};
		coursesToSelect.removeAll(Arrays.asList(crs));
		//coursesToSelect.remove(2);
	}
	
	/**
	 * 向List中添加奇怪的对象
	 * @param args
	 */
	public void testType(){
		coursesToSelect.add(new String("我不是Course 我是字符串"));
	}
	

	public static void main(String[] args) {
		ListTest lt = new ListTest();
		lt.testAdd();
//		lt.testGet();
//		lt.testIterator();
//		lt.testModify();
//		lt.testRemove();
		lt.testType();
		lt.testForEach();
	}
	


}
