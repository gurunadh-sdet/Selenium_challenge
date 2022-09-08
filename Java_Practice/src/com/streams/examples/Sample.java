package com.streams.examples;

public class Sample {

	public static void main(String[] args) {
		
	    String str1="BNY Mellon";
	
	    String str2="Pershing";
	
	   // compare string and print difference of both strings in the output
	    
 //System.out.println(str1.compareTo(str2));

 for(int i=0; i<str1.length();i++) {
	
	 boolean flag =false;
	 for(int j=0; j<str2.length();j++) {
		 if((str2.charAt(j)==str1.charAt(i))){
			 flag = true;
		 }
	 }
	 if (flag == false) {
		 System.out.println(str1.charAt(i));
	 }
 }
 
 for(int i=0; i<str2.length();i++) {
		
	 boolean flag =false;
	 for(int j=0; j<str1.length();j++) {
		 if((str1.charAt(j)==str2.charAt(i))){
			 flag = true;
		 }
	 }
	 if (flag == false) {
		 System.out.println(str2.charAt(i));
	 }
 }

	


}
}