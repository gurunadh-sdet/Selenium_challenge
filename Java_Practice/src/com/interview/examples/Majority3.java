package com.interview.examples;

import java.util.HashMap;

public class Majority3 {

	public static void main(String[] args) {
		int[] numbers = {10,6,5,6,10,3,5,5,10,6};
		findMajorty(numbers);
		findNby3(numbers);

	}
	// by using map for getting the repeated count-> higher space complexity
	public static void findMajorty(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer> ();
		int majority = nums.length/3;
		for(int i:nums) {
			//System.out.println(i);
			if(map.containsKey(i))
			map.put(i,map.get(i)+1);
			else
				map.put(i, 1);
		}
		//System.out.println(map);
		for(int key:map.keySet()) {
			if ((map.get(key))>majority) {
			System.out.println(key);
			}
		}

		//map.forEach((k,v)->System.out.println(k+"---"+v));
		map.forEach((k,v)-> { 
			if(v>majority) {
	 System.out.println(k);
			}
			
		});

	}
	
	//by using 2 candidates
	public static void findNby3(int[] nums) {
		
		int first =  Integer.MIN_VALUE;;
        int second = Integer.MAX_VALUE;
        System.out.println(first);
        System.out.println(second);
	}
}
