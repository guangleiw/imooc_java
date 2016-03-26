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
	 * ������coursesToselect����ӿγ�
	 */
	public void testAdd() {
		// �����γ̶��� ��ͨ��add������ӽ�ȥ
		Course cr1 = new Course("1", "Data Structure");
		coursesToSelect.add(cr1);
		Course temp = (Course) coursesToSelect.get(0);
//		System.out.println("�Ѿ���ӿγ�:" + temp.ID + " name:" + temp.name);

		Course cr2 = new Course("2", "C language");
		coursesToSelect.add(0, cr2);
		temp = (Course) coursesToSelect.get(0);
//		System.out.println("�Ѿ���ӿγ�:" + temp.ID + " name:" + temp.name);

		// Course cr3 = new Course("3","Test");
		// coursesToSelect.add(4, cr3);//�±�Խ���쳣

		Course[] course = { new Course("3", "Math"), new Course("4", "assemble language") };
		coursesToSelect.addAll(Arrays.asList(course));
		Course temp3 = (Course) coursesToSelect.get(2);
		Course temp4 = (Course) coursesToSelect.get(3);
//		System.out.println("���2�ſγ̣�" + temp3.ID + temp3.name + " " + temp4.ID + temp4.name);

		Course[] course2 = {};
	}
	
	public void testForEach(){
		System.out.println("For each ����");
		for (Object object : coursesToSelect) {
			Course cr  = (Course)object;
			System.out.println("�γ̣�"+cr.ID+"-"+cr.name);
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
		Student student = new Student("1","С��");
		System.out.println("Welcome "+student.name+" select courses!");
		//����һ��Scanner����  �����Ӽ��̽�������γ�ID
		Scanner console  = new Scanner(System.in);
		
		for (int i = 0; i < 3; i++) {
			System.out.println("������Ҫѡ�εĿγ�ID:");
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
