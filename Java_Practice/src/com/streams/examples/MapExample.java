package com.streams.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class MapExample {
	//filter the names which have last letter "a" and print them in uppercase 
	ArrayList<String> names = new ArrayList<String>();
	
	
	@Test
	public void stream_map() {

	//long l =Stream.of("Alekya", "Arjun", "Deepak","Aadhya", "Priya").filter(s->(s.substring((s.length())-1, s.length())).equals("a")).count();
	//System.out.println(l);
	
Stream.of("Alekya", "Arjun", "Deepak","Aadhya", "Priya")
		.filter(s->(s.endsWith("a")))
		.map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
	

	//print the names which have first letter as "A" with upper case and sorted
	
List<String> names = Arrays.asList("Alekya", "Arjun", "Deepak","Aadhya", "Priya");
names.stream()
	.filter(s->(s.startsWith("A")))
	.map(s->s.toUpperCase())
	.sorted()
	.forEach(s->System.out.println(s));

	
	//print the names by removing the duplicates in the list
	System.out.println("###### student #######");
	List<String> students = Arrays.asList("Alekya", "Arjun", "Priya","Adhya", "Priya");
	
	students.stream()
		.filter(s->(s.length())==5)
		.sorted()
		.distinct()
		.forEach(s->System.out.println(s));
	
	// use of max element in the list
	

	//print the names by removing the duplicates in the list
	System.out.println("###### max element in the list #######");
	List<Integer> marks = Arrays.asList(34, 45, 23,56, 36);
	
	Integer max =
		marks.stream()
		.mapToInt(v->v)
		.min()
		.orElseThrow(NoSuchElementException::new);
	System.out.println(max);
	}

}
