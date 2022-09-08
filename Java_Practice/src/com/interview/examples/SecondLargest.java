	package com.interview.examples;

public class SecondLargest {

	public static void main(String[] args) {

		
			int max= 0; 
			int max2=0;
			int[] a= {7,6,8,4,9,5,10,12};
			for(int i=0;i<a.length;i++){
			if(a[i]>max) {
				max=a[i];
			}
			else if(a[i]>max2) {
				max2= a[i];	
				}
		
			}
			System.out.println(max);
			System.out.println(max2);
			

	}
	
	

}
