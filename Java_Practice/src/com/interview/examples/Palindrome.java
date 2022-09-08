package com.interview.examples;

public class Palindrome {

	public static void main(String[] args) {
		
		System.out.println(isPalindromeNumber(12345));
		System.out.println(isPalindromeNumber(12321));
		System.out.println(isPalindromeNumberWithoutStringConversion(585));
		System.out.println(isPalindrome("guru"));
		System.out.println(isPalindrome("gurug"));
		System.out.println(isPalindrome("gag"));		
		System.out.println(isPalindrome("gaggag"));
		
		System.out.println(isPalindromeUsingBuffer("ramaraju"));
		System.out.println(isPalindromeUsingBuffer("ramar"));		
		System.out.println(isPalindromeUsingBuffer("gannag"));


//find the longest palindrome in the given string
//sample input: "aaaabbaa"
// Sample output : "aabbaa"-> longest palindrome
//all the palindromes are =a,aa,aaa,aaaa,bb,abba,aabbaa

	}
	
	public static boolean isPalindrome(String str) {	
		char[] ch=str.toCharArray();
		for(int i=0; i<=(ch.length)/2;i++) {
		if(ch[i]==ch[ch.length-i-1]) {
		continue;	
		}
		else 
			return false;
		}
		return true;
	}

	public static boolean isPalindromeUsingBuffer(String str) {	
		StringBuffer buffer = new StringBuffer(str);
		buffer.reverse();
		String reversedstr = buffer.toString();
		if(str.equals(reversedstr)) 
			return true;
		else
			return false;		
	}
	
	public static boolean isPalindromeNumber(Integer num) {	
		String str = num.toString();
		char[] ch=str.toCharArray();
		for(int i=0; i<=(ch.length)/2;i++) {
		if(ch[i]==ch[ch.length-i-1]) {
		continue;	
		}
		else 
			return false;
		}
		return true;
	}
	
	public static boolean isPalindromeNumberWithoutStringConversion(Integer n) {	
		
		int sum = 0;
		while(n>0) {
		int r=n%10;
		sum = sum*10 +r;
		n = n/10;
		}
		
	System.out.println(sum);

	return true;
	}


}
