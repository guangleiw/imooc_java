package com.imooc.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ��ѡ�γ���
 * @author Administrator
 *
 */
public class ListTest {

	//���ڴ�ű�ѡ�γ̵�list
	public List coursesToSelect;
	
	public ListTest() {
		// TODO Auto-generated constructor stub
		this.coursesToSelect = new ArrayList();
	}
	
	/**
	 *������coursesToselect����ӿγ� 
	 */
	public void testAdd(){
		//�����γ̶��� ��ͨ��add������ӽ�ȥ 
		Course cr1 = new Course("1","Data Structure");
		coursesToSelect.add(cr1);
		Course temp = (Course)coursesToSelect.get(0);
		System.out.println("�Ѿ���ӿγ�:"+temp.ID+" name:"+temp.name);
		
		Course cr2 = new Course("2","C language");
		coursesToSelect.add(0, cr2);
		temp = (Course)coursesToSelect.get(0);
		System.out.println("�Ѿ���ӿγ�:"+temp.ID+" name:"+temp.name);
		
//		Course cr3 = new Course("3","Test");
//		coursesToSelect.add(4, cr3);//�±�Խ���쳣

		Course[] course = {new Course("3","Math"),new Course("4","assemble language")};
		coursesToSelect.addAll(Arrays.asList(course));
		Course temp3 = (Course)coursesToSelect.get(2);
		Course temp4 = (Course)coursesToSelect.get(3);
		System.out.println("���2�ſγ̣�"+temp3.ID+temp3.name+" "+temp4.ID+temp4.name);
		
		Course[] course2 = {};
		
		
		
		
		
		
	}
	
	public static void main(String[] args){
		ListTest lt = new ListTest();
		lt.testAdd();
	}

}
