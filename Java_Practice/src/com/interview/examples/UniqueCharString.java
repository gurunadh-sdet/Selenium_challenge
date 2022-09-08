package com.interview.examples;

//Online Java Compiler
//Use this editor to write, compile and run your Java code online*//
/*Find the non-repeated unique character from the given sting.
 test_str_1 = "this is a good test"
 expected_result_1 = "hagde” [these are the only chars that are only ONCE in the test string]
 test_str1 2= 'hhhhh'
 expected_result_2 = None [Since 'h' is the only char and it is repeated 6 times]*/
 //import java.util.*
import java.util.HashMap;
class UniqueCharString {
 public static void main(String[] args) {
 //str.chars().filter(ch-> ch==charAt).count ==1
 
 String test_str_1 = "this is a good test";
 System.out.println(find_unique(test_str_1));
 
 

 
 
 }
 public static String find_unique( String str){
     String res ="";
     //char[] ar = str.toCharArray();
     HashMap<String,Integer> map = new HashMap<String,Integer>();
     for(int i=0; i<str.length();i++){
         String charAt = str.substring(i,i+1);
         if(map.containsKey(charAt)){
             map.put(charAt,map.get(charAt)+1);
         }
         else{
             map.put(charAt,1);
         }
     }
     for(String key: map.keySet()){
         if(map.get(key)==1){
             res=res+key;
         }
     }
     return res;
 }
}
