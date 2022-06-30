package com.interview.examples;

public class StringAmazon {

	public static void main(String[] args) {

		
		 String str = "gfejhfewkxyz mvkkds xyzrgjfhrkghrkj xyztqufn";
		 System.out.println(findOccurences(str, "xyz"));
		 System.out.println(findMatches(str, "xyz"));
		 
		// get the number of occurences of "xyz" and the index positions
		
		
		
		
	}
	// Using index of method
	public static int findOccurences( String main, String sub) {
			
		int index =0, count=0;
		while(true) {
		index = main.indexOf(sub, index);
		if(index!=-1) {
			count++;
			System.out.println("found at index: "+index);
			index+=sub.length();
		}
		else {
			break;
		}
		}
		
		return count;
	}
	
	//Usig the simple while loop
	public static int findMatches( String main, String sub) {
		int index = main.indexOf(sub);
		if (index==-1) {
			return 0;
		}
		else {
		int count=0;
		while(index>=0) {
			count++;
			System.out.println(index);
			index = main.indexOf(sub,index+sub.length());
		}
		return count;
		}
		
	}
		

}
