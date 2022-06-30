package com.interview.examples;

public class DigitsExample {

	public static void main(String[] args) {
		System.out.println(sumOfDigits(45));

	}

	
	public static int sumOfDigits(int number) {
		if(String.valueOf(number).length()==1) {
			return number;
		}
		//number = 456
		int sum =0;
		while(number>0) {
			int d = number%10;
			sum =sum+d;//6+5+4=15
			number =number/10;	
		}
		return sumOfDigits(sum);
	}
}
