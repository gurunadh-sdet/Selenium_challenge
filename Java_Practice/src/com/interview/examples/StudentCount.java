package com.interview.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class StudentCount {
	//count the number of  names start with alphabet A in the list
	ArrayList<String> names = new ArrayList<String>();
	
	
	@Test
	public  void find_student_count() { 

		 List<Student> student_list = Arrays.asList(
			        new Student("brian", "chennai", 300), 
			        new Student("raoul", "banglore", 1000),
			        new Student("jai", "chennai", 400),
			        new Student("mario", "hyd", 710),  
			        new Student("rani", "banglore", 700),
			        new Student("ram", "chennai", 950)
			    );  
			    
		// student_list.stream().forEach(s-> System.out.println(s.getCity()));
		 
		 System.out.println(Collections.frequency(student_list,  new Student("ram", "chennai", 950)));
		 
		 //Map<String, String> student_map =student_list.stream().collect(Collectors.toMap(Student::getCity, Student::getName, (existing, replacement) -> existing));
		 
		// Map<String, Student> student_map =student_list.stream().collect(Collectors.toMap(Student::getName, Function.identity()));
		 
		 //System.out.println(student_map);
		//student_list.stream().collect(Collectors.toMap(s-> s.getCity(), Collections.frequency(student_list, s.getCity())));
		 
		//List<String> city_list= student_list.stream().map(s->s.getCity()).collect(Collectors.toList());
		//Map<String, Integer> citymaps= city_list.stream().collect(Collectors.toMap(x->x, x-> Collections.frequency(city_list, x),(existing, replacement) -> existing));
	//	System.out.println(citymaps);
		
		//student_list.stream().map(s->s.getCity()).collect(Collectors.toList()).stream().collect(Collectors.toMap(x->x, x-> Collections.frequency(city_list, x),(existing, replacement) -> existing));
		
		
		student_list.stream().collect((Collectors.toMap(e-> e.getCity(), e-> student_list.stream().filter(l-> l.getCity().equals(e.getCity())).count())));
		
//		Map<String,Integer> map1 = new HashMap<String, Integer>();
//		for(String city:city_list) {
//			map1.put(city,Collections.frequency(city_list, city));
//		}
//		System.out.println(map1);
	}

		
	
	//@Test
	public void stream_method() {
		
}
	}
