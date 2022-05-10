package com.interview.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class CollectionFrequency {
	//count the number of  names start with alphabet A in the list
	ArrayList<String> names = new ArrayList<String>();
	
	
	@Test
	public  void find_alphabets() { 

		names.add("Alekya");
		names.add("Arjun");
		names.add("Deepak");
		names.add("Aadhya");
		names.add("Priya");
		names.add("Priya");
		names.add("Alekya");
		
		System.out.println(Collections.frequency(names, "Alekya"));
	
	}
		
		
	
	//@Test
	public void stream_method() {
		
}
	}
