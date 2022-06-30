package com.interview.examples;

import java.util.Arrays;
import java.util.HashSet;

public class TripletsfromArray {

	public static void main(String[] args) {
		int [] arrr = {1,4,3,6,7,10};
		findDoublets(arrr, 9);
		findDoubletsUsingHashing(arrr,10);
		
		int[] triple_array = {1,5,2,4,3};
		findTripletBrute(triple_array,8);
		findTripletUsing2Pointer(triple_array,8);
	}
	// two pointer method to find the doublets which get the sum x from the elements of given array
	public static void findDoublets(int[] ar, int sum) {
		//ar ={1, 4,3 ,6,10}, sum =9
		Arrays.sort(ar);
		int len= ar.length;
		int l=0, r=len-1;
		while(l<r) {
			if(ar[l]+ar[r]==sum) {
				System.out.println("The Doublets using 2 pointer technique: "+ar[l]+","+ar[r]);
				break;
			}else if(ar[l]+ar[r]>sum){
				r--;
			}else l++;
		}
		
	}
	
	//// Hashing method to find the doublets which get the sum x from the elements of given array
	public static void findDoubletsUsingHashing(int[] ar, int sum) {
		//ar ={1, 4,3 ,6,10}, sum =9
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i=0; i<ar.length-1;i++) {
			int temp =sum-ar[i];// get the difference between sum and given number and compare with other numbers
			if (hs.contains(temp)) {
				System.out.println("The Doublets using Hashing Technique: "+temp+","+ar[i]);
			}else
				hs.add(ar[i]);
		}		
		
	}
	//Problem - Given an array A[] and a number x, check for triplets in A[] with sum as x
	//method1: using 3 for loops-> Time Complexity O(n^3) and Space Complexity O(1)
	public static void findTripletBrute(int[] my_array, int sum) {
	boolean flag =false;
	for(int i=0; i<my_array.length;i++) {
		for(int j=i+1;j<my_array.length;j++) {
			for(int k=j+1;k<my_array.length;k++) {	
			if ((my_array[i]+my_array[j]+my_array[k])==sum) {
				flag = true;
				System.out.println("The triplets using nested loops: " +my_array[i]+"," +my_array[j]+","+my_array[k]);
			}
			}
		}
	}
	}
	
	public static void findTripletUsing2Pointer(int[] my_array, int sum) {
		boolean flag =false;
		Arrays.sort(my_array);
		for(int i=0; i<my_array.length-2;i++) {
		int l=i+1,r=my_array.length-1;
			while(l<r) {
				int res =my_array[i]+my_array[l]+my_array[r];
				if(res==sum) {
					System.out.println("The Triplets using 2 pointer are: "+my_array[i]+","+my_array[l]+","+my_array[r]);
					l++;
				}else if(res>sum) {
					r--;
				}else l++;
				
			}	
						
		}
	}
	
	
}
