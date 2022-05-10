package com.streams.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MergeStreams {
	//filter the names which have last letter "a" and print them in uppercase 
	ArrayList<String> names = new ArrayList<String>();
	
	
	//@Test
	public void stream_merge() {

ArrayList<String> teachers = new ArrayList<String>();
teachers.add("Ram");
teachers.add("Arjun");
teachers.add("Krishna");
teachers.add("Raja");
	List<String> students = Arrays.asList("Alekya", "Arjun", "Priya","Adhya", "Priya");
// merging the 2 different lists and sorting them
	Stream<String> merged_stream = Stream.concat(teachers.stream(), students.stream());
	
	merged_stream.sorted().distinct().forEach(s-> System.out.println(s));
	
// Check if Krishna is present in the combined list
	
	Boolean flag = merged_stream.anyMatch(s-> s.equalsIgnoreCase("Krishna"));
	System.out.println(flag);
	Assert.assertTrue(flag);

	}
	
	
	@Test
	public void stream_collect() {

		//collect the result as a list or set or map
		
		List<String> mylist = Stream.of("Guru", "Varsha","Raja", "Arjun").filter(s-> s.endsWith("a")).map(s-> s.toUpperCase())
		.collect(Collectors.toList());
		
		
		System.out.println(mylist.get(0));
		
			}
	
	@Test
	public void stream_unique() {

		//print the unique  numbers in this list
		//sort the array
		//return the array
		List<Integer> list=Arrays.asList(6,3,3,2,9,4,7,1,9);
		
		
	Stream<Integer> stream1 =list.stream();
	stream1.sorted()
	.distinct()
	.forEach(s->System.out.println(s));
	System.out.println("######## after collecting the list ###############");
	
	Stream<Integer> stream2 =list.stream();
	List<Integer> result =stream2.sorted().distinct()
	.collect(Collectors.toList());
	System.out.println(result);
		
			}
}
