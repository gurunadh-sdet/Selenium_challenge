package com.interview.examples;

public class StringReverse {

	public static void main(String[] args) {

		//Input String: I#Lo$ve%In&di*a
		//Output String: a#id$nI%ev&oL*I
		
		String str_old = "I#Lo$ve%n&di*a";
		char[] str = str_old.toCharArray();

		int r= str_old.length()-1;
		int l=0;
		while(l<r){
			if(!Character.isAlphabetic(str[l])){
				l++;
			}
			else if(!Character.isAlphabetic(str[r])){
					r--;
			}
			else
			{
				char x= str[l];
				str[l]= str[r];
				str[r] = x;
				l++;
				r--;
			}

		}
		System.out.println(str);
	}
		

}

