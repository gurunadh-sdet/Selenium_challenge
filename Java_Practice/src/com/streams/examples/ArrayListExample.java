package com.streams.examples;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class ArrayListExample {
	//count the number of  names start with alphabet A in the list
	ArrayList<String> names = new ArrayList<String>();
	
	
	//@Test
	public  void find_alphabets() { 

		names.add("Alekya");
		names.add("Arjun");
		names.add("Deepak");
		names.add("Aadhya");
		names.add("Priya");
		
		int count =0;
		for(int i=0;i<names.size();i++){
		String s= names.get(i);
		//System.out.println(s.substring(0, 1));
		//if(s.substring(0, 1).equals("A")) {
		if(s.startsWith("A")) {
			count++;
		}
		}
		System.out.println(count);
	}
	
	//@Test
	public void stream_method() {
		names.add("Alekya");
		names.add("Arjun");
		names.add("Deepak");
		names.add("Aadhya");
		names.add("Priya");
		
		//there is no life for intermediate op  if there is no terminal op
		//terminal op will execute only if intermediate op returns true
		 
		long count = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(count);
		//another way of doing it directly by creating stream
		long d= Stream.of("Alekya", "Arjun", "Deepak","Aadhya", "Priya").filter(s->s.startsWith("A")).count();
		System.out.println(d);
		
		long e= Stream.of("Alekya", "Arjun", "Deepak","Aadhya", "Priya").filter(s->
		{
			s.startsWith("A");
			return false; //here you can use this if you have multiple lines of in 
			//secondary lamba expression, it should return the value
			
		}).count();
		
		System.out.println(e);
	}
	
	@Test
	public void stream_foreach() {
		//get the list of names which having length greater than 5
		long l=Stream.of("Alekya", "Arjun", "Deepak","Aadhya", "Priya").filter(s->s.length()>5).count();
		System.out.println(l);
		//Stream.of("Alekya", "Arjun", "Deepak","Aadhya", "Priya").filter(s->s.length()>5).forEach(s-> System.out.println(s));
		// we can limit the output of the filter certain length in the order
		Stream.of("Alekya", "Arjun", "Deepak","Aadhya", "Priya").filter(s->s.length()>5).limit(2).forEach(s-> System.out.println(s));
		
	}

}
