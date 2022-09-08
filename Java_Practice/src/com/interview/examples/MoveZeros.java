package com.interview.examples;

import java.util.Arrays;

public class MoveZeros {

	public static void main(String[] args) {
		int[] A = {0,6,7,0,1,3,4,0};
		int len =A.length;
		
		int current = len-1;
		for(int i=len-1;i>=0;i--) {
			if(A[i]!=0) {
				A[current]=A[i];
				current--;				
			}
			
		}
		//System.out.println(current);
		while(current>=0) {
			A[current]=0;
			current--;
			
		}
		System.out.println("values after appending zeros: ");
		for(int j=0;j<len;j++) {
			System.out.println(A[j]);
		}
		Arrays.sort(A);
		System.out.println("values after sorting the array: ");
		for(int j=0;j<len;j++) {
			System.out.println(A[j]);
		}

	}
	public static void swap(int[] A, int i, int j) {
		int temp;
		temp = A[i];
		A[i]= A[j];
		A[j]= temp;
	}

}
