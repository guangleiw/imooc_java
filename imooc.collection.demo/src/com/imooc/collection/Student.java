package com.imooc.collection;

import java.util.HashSet;
import java.util.Set;
/**
 * Ñ§ÉúÀà
 * @author Administrator
 *
 */
public class Student {

	public String ID , name;
	public Set courses;
	
	public Student(String id,String name) {
		// TODO Auto-generated constructor stub
		this.ID=id;
		this.name=name;
		this.courses = new HashSet();
	}

}
