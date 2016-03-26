package com.imooc.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SetTest {

	public List<Course> coursesToSelect; 
	
	public SetTest() {
		// TODO Auto-generated constructor stub
		this.coursesToSelect = new ArrayList<Course>();
	}
	
	/**
	 * 用于向coursesToselect中添加课程
	 */
	public void testAdd() {
		// 创建课程对象 并通过add方法添加进去
		Course cr1 = new Course("1", "Data Structure");
		coursesToSelect.add(cr1);
		Course temp = (Course) coursesToSelect.get(0);
//		System.out.println("已经添加课程:" + temp.ID + " name:" + temp.name);

		Course cr2 = new Course("2", "C language");
		coursesToSelect.add(0, cr2);
		temp = (Course) coursesToSelect.get(0);
//		System.out.println("已经添加课程:" + temp.ID + " name:" + temp.name);

		// Course cr3 = new Course("3","Test");
		// coursesToSelect.add(4, cr3);//下标越界异常

		Course[] course = { new Course("3", "Math"), new Course("4", "assemble language") };
		coursesToSelect.addAll(Arrays.asList(course));
		Course temp3 = (Course) coursesToSelect.get(2);
		Course temp4 = (Course) coursesToSelect.get(3);
//		System.out.println("添加2门课程：" + temp3.ID + temp3.name + " " + temp4.ID + temp4.name);

		Course[] course2 = {};
	}
	
	public void testForEach(){
		System.out.println("For each 遍历");
		for (Object object : coursesToSelect) {
			Course cr  = (Course)object;
			System.out.println("课程："+cr.ID+"-"+cr.name);
		}
	}
	
	public void testForEachForSet(Student student){
		//Print the courses selected by student
		for (Course course : student.courses) {
			System.out.println("Select courses:"+course.name);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetTest st = new SetTest();
		st.testAdd();
		st.testForEach();
		Student student = new Student("1","小明");
		System.out.println("Welcome "+student.name+" select courses!");
		//创建一个Scanner对象  用来从键盘接收输入课程ID
		Scanner console  = new Scanner(System.in);
		
		for (int i = 0; i < 3; i++) {
			System.out.println("请输入要选课的课程ID:");
			String courseID = console.next();
			for (Course cr : st.coursesToSelect) {
				if(cr.ID.equals(courseID)){
					student.courses.add(cr);
					student.courses.add(cr);
				}
			}
		}
		
		st.testForEachForSet(student);

	}

}
