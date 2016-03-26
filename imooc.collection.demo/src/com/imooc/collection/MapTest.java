package com.imooc.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class MapTest {

	public Map<String,Student> students;
	
	/**
	 * Initial in constructor
	 * @param args
	 */
	public MapTest(){
		this.students = new HashMap<String,Student>();
	}
	
	/**
	 * 
	 * Add test:Input student ID ,and check available
	 * if not,input name and create student object before add into students
	 * @param args
	 */
	public void testPut(){
		Scanner scanner = new Scanner(System.in);
		int i = 0;
		while(i<3){
			System.out.println("Please input id:");
			String ID = scanner.next();
			//check available
			if(students.get(ID)==(null)){
				System.out.println("Please input name of the new student:");
				String name = scanner.next();
			    Student newStu = new Student(ID, name);
				students.put(ID, newStu);
				System.out.println("Successfully added !!");
				i++;
			}else{
				System.out.println("Not available for this ID !!!");
				continue;
			}
		}
	}
	
	/**
	 * Test for keySet method
	 * @param args
	 */
	public void testKeySet(){
		// Use keySet method to get the set of keys;
		Set<String> keySet = students.keySet();
		System.out.println("Size of this set:"+students.size());
		// Traversing the keyset and get the corresponding values of this set;
		for (String stuid : keySet) {
			Student st = students.get(stuid);
			if(null != st){
				System.out.println("name:"+st.name);
			}
		}
	}
	
	/**
	 * Test for remove
	 * @param args
	 */
	public void testRemove(){
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("Please input the ID of the sudent to be removed:");
			String ID = sc.next();
			// Check if there is a student id
			Student st = students.get(ID);
			if(null == st){
				System.out.println("No such ID!");
				continue;
			}
			students.remove(ID);
			System.out.println("Remove sucessfully!!");
			break;
		}
	}
	
	/**
	 * Using EntrySet to traverse
	 * @param args
	 */
	public void testEntrySet(){
		Set<Entry<String,Student>> entrySet = students.entrySet();
		for (Entry<String, Student> entry : entrySet) {
			System.out.println("Get key:"+entry.getKey());
			System.out.println("Get value:"+entry.getValue().name);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MapTest mapTest = new MapTest();
		mapTest.testPut();
		mapTest.testKeySet();
		mapTest.testRemove();
		mapTest.testEntrySet();
	}

}
