package com.interview.examples;

	import java.io.*;
	import java.math.*;
	import java.security.*;
	import java.text.*;
	import java.util.*;
	import java.util.concurrent.*;
	import java.util.function.*;
	import java.util.regex.*;
	import java.util.stream.*;
	import static java.util.stream.Collectors.joining;
	import static java.util.stream.Collectors.toList;

	class Result {

	    /*
	     * Complete the 'plusMinus' function below.
	     *
	     * The function accepts INTEGER_ARRAY arr as parameter.
	     */

	    public static void plusMinus(List<Integer> arr) {
	    // Write your code 
	    int size = arr.size();
	    System.out.println(size);
	    int positive=0, negative=0,zero=0;
	    for(int i=0;i<size;i++){
	        
	    if(arr.get(i)>0)
	        positive= positive+1;
	    else if(arr.get(i)<0)
	        negative= negative+1;
	     else
	        zero= zero+1;
	    }
	    System.out.println(positive);
	    System.out.println(negative);
	    System.out.println(zero);
	    

	    }

	}

	public class PLusMinus {
	    public static void main(String[] args) throws IOException {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	        int n = Integer.parseInt(bufferedReader.readLine().trim());

	        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
	            .map(Integer::parseInt)
	            .collect(toList());

	        Result.plusMinus(arr);

	        bufferedReader.close();
	    }
	}
