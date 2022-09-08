package com.interview.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class StringShuffle {

	public static void main(String[] args) {
		//String str1 = "sachin and swara got engaged just now";
		//String str2= "just answer";
		String str1 = "sachin";
		String str2= "achin";
		//str1.chars().forEach(s-> System.out.println(s));
		// System.out.println(isShuffledExists(str1,str2));
		//System.out.println("Answer is " + isJustAnswerString());
		//System.out.println("Answer is " + isJustAnswerStringUsingArrayList());
		
		//System.out.println("Answer is "+isJustAnswerStringUsingArrayListsecondapproach());

		System.out.println(isJustAnswerString_UsingLinkedList("xybhbdf"));
		System.out.println(isJustAnswerString_UsingLinkedList(""));
		System.out.println(isJustAnswerString_UsingLinkedList(" "));
		System.out.println(isJustAnswerString_UsingLinkedList("sachin and swara got engaged just now"));
		System.out.println(isJustAnswerString_UsingLinkedList("this is my code"));
		
		
	}
	public static boolean isShuffledExists(String str1, String str2) {
		int m=str1.length();
		int n =str2.length();
		if(m<n) {
			return false;
		}
		str2 = sort(str2);
		for(int i=0;i<=m-n;i++) {
			
			String str="";
			for(int j=i;j<n+i;j++) {
				str=str+str1.charAt(j);
			}
			System.out.println(sort(str));
			if(str2.equals(sort(str))) {
				return true;
			}
		}
		
		return false;
	}
	
	public static String sort(String str) {
		char[] temp = str.toCharArray();
		Arrays.sort(temp);
		return String.valueOf(temp);
	}
	  public static boolean isJustAnswerString(String input){
       // String input = "sachin and swara got engaged just now";
        String str = "this is my code"; 
       // String str = "justanswer";
        for (int i=0;i<str.length();i++){
            char charAt = str.charAt(i);
            long expectedCount = str.chars().filter(ch -> ch == charAt).count();
            long actualCount = input.chars().filter(ch -> ch == charAt).count();
         
            if (expectedCount> actualCount){
                return false;
            }
        }
        return true;
    }
	  
	 
	public static boolean isJustAnswerStringUsingArrayList(){
	       // String input = "sachin and swara got engaged just now";
	        String input = "this is my code";
	        String str = "justanswer";
	    
	        //Add the all the characters in an arraylist using substring
	        ArrayList<String> mylist = new ArrayList<String>();    
		    for(int k=0;k<input.length();k++) {
		    	  mylist.add(input.substring(k,k+1));
		    }  
		    // Now loop through the second string and check if each character exists in the primary string
	        for (int i=0;i<str.length();i++){
	            if (!mylist.contains(str.substring(i,i+1))) {
	            	return false;
	            }
	            else
	            	mylist.remove(str.substring(i,i+1));	// removing the matching character so that next occurrence will not be duplicate   	   
	        }
	        return true;
	    }
	
	public static boolean isJustAnswerString_UsingLinkedList(String input){
        String str = "just answer";
    	if(input.length()<str.length()) {
    		return false;
    	}
        LinkedList<String> mylist = new LinkedList<String>();
	    for(int k=0;k<input.length();k++) {
	    	mylist.add(input.substring(k,k+1));
	    }  
        for (int i=0;i<str.length();i++){
        	if(!mylist.remove(str.substring(i,i+1)))	//Used linkedlist here as remove operation will be faster than arraylist
        	   return false;
        }           
        return true;
    }


}
