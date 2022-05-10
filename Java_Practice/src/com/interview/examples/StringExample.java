package com.interview.examples;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.stream.Stream;

public class StringExample {

	public static void main(String[] args) {
		String s1 =StringExample.findCountofString("aaaabbbccpppptttrrruu");
		String s2 =StringExample.findCountofString("a");
		System.out.println(s2.contains(Character.toString(s1.charAt(0))));
		
		System.out.println(s1);
		System.out.println(s2);
		String s= "123b";
		System.out.println(Integer.parseInt(s));
	}
	
	public static String findCountofString(String str) {
		if(str.isEmpty()) {
			System.out.println("please pass the string as input");
			return null;
		}
		char[] char_arr = str.toCharArray();
		LinkedHashMap<Character,Integer> map =new LinkedHashMap<Character,Integer>();
	
		for(char c: char_arr) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}
			else
			{
				map.put(c, 1);
			}
		}
		System.out.println(map.values());
		Iterator<Character> it =map.keySet().iterator();
		String op="";
		while(it.hasNext()) {
			char key =  it.next();
			int value =map.get(key);
			
			op= op+key+value;
		}
			return op;
		}
	

}
