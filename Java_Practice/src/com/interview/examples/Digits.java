package com.interview.examples;

import java.util.ArrayList;

public class Digits {

	public static void main(String[] args) {
System.out.println("Hello World");
getDigitswithpower();


//sample input: 70458
//print all the digits
int n = 70458;
ArrayList<Integer> al = new ArrayList<Integer>();

while(n!=0) {
	int x= n%10;
	al.add(x); // adding all the digits into array list
		//System.out.println(x);
	n= n/10;	
}

//print 7000 + 400 + 50 +8

for(int i=al.size()-1;i>=0;i--) {
	//System.out.println(al.get(i));
	int num= (int)(al.get(i)*Math.pow(10, i));
	if (num==0) {
		continue;
	}
	if (i==0) {
		System.out.print(num);
	}else
		System.out.print(num+" + ");

}


	}
	
	public static void getDigitswithpower() {
		int a = 70458;
		int d;
		String sum="";
		String num = String.valueOf(a);
		for(int i=0; i<=num.length()-1;i++) {
			d= a%10;
			int check =(int) (d*Math.pow(10, i));
			sum = check+" + "+sum;
			a=a/10;
			
		}
		System.out.println(sum.trim());


	}
	


}
