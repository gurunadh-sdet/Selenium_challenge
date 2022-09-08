package com.interview.examples;

public class ReverseString {

	// Online Java Compiler
	// Use this editor to write, compile and run your Java code online


	    public static void main(String[] args) {
	        System.out.println("Hello, World!");
	        String str ="I work for dentira";
	        //res= "I work for aritned"
	       /* 1.split the string with dentira delimter
	        2.pick the second index value and reverse it
	        3.join the two values*/
	        System.out.println(reverseDentira(str));
	        
	        
	    }
	    public static String reverseDentira(String str){
	    	String res ="";
	        String[] list =str.split(" ");
	        for(String s:list) {
	        	 System.out.println(s);
	        	 if(s.equalsIgnoreCase("dentira")){
	        		 StringBuilder sb = new StringBuilder(s);
	        		 sb.reverse();
	        		 res= res+" "+sb;
	        	 	//reverse the string	
	        	 }
	        	 else
	        		 res= res+" "+s;
	        }
	      
	        return res.trim();
	    }
	}


