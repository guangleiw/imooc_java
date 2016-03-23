package com.imooc.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 备选课程类
 * @author Administrator
 *
 */
public class ListTest {

	//用于存放备选课程的list
	public List coursesToSelect;
	
	public ListTest() {
		// TODO Auto-generated constructor stub
		this.coursesToSelect = new ArrayList();
	}
	
	/**
	 *用于向coursesToselect中添加课程 
	 */
	public void testAdd(){
		//创建课程对象 并通过add方法添加进去 
		Course cr1 = new Course("1","Data Structure");
		coursesToSelect.add(cr1);
		Course temp = (Course)coursesToSelect.get(0);
		System.out.println("已经添加课程:"+temp.ID+" name:"+temp.name);
		
		Course cr2 = new Course("2","C language");
		coursesToSelect.add(0, cr2);
		temp = (Course)coursesToSelect.get(0);
		System.out.println("已经添加课程:"+temp.ID+" name:"+temp.name);
		
//		Course cr3 = new Course("3","Test");
//		coursesToSelect.add(4, cr3);//下标越界异常

		Course[] course = {new Course("3","Math"),new Course("4","assemble language")};
		coursesToSelect.addAll(Arrays.asList(course));
		Course temp3 = (Course)coursesToSelect.get(2);
		Course temp4 = (Course)coursesToSelect.get(3);
		System.out.println("添加2门课程："+temp3.ID+temp3.name+" "+temp4.ID+temp4.name);
		
		Course[] course2 = {};
		
		
		
		
		
		
	}
	
	public static void main(String[] args){
		ListTest lt = new ListTest();
		lt.testAdd();
	}

}
