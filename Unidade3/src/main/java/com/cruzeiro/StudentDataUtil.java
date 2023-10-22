package com.cruzeiro;

import java.util.ArrayList;
import java.util.List;

public class StudentDataUtil {
	public StudentDataUtil() {
		
	}
	public static List<Student> getStudent(){
		//criar umam lista vazia
		List<Student> student = new ArrayList<>();
		
		//adicionar dados a lista
		student.add(new Student("Maike", "Costa", "fulano@fulano.com"));
		student.add(new Student("Ashiley", "Batista", "ciclana@ciclana.com"));
		student.add(new Student("Jenna", "Rozz", "Beltrana@beltrana.com"));
		
		return student;
	}
	
}
