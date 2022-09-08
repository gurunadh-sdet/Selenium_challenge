package com.interview.examples;

import java.util.Arrays;
import java.util.HashMap;
/*
public class LogsAccessTime {
	private static final int TIME_RANGE = 300;// seconds
	private class Node{
		String resource_name;
		int max_access;
		Node( String resource_name, int max_access){
			this.resource_name= resource_name;
			this.max_access = max_access;
		}
			
	}

	public static void main(String[] args) {
		String[][] logs1 = {
                {"58523", "user_1", "resource_1"},
                {"62314", "user_2", "resource_2"},
                {"54001", "user_1", "resource_3"},
                {"200", "user_6", "resource_5"},
                {"215", "user_6", "resource_4"},
                {"54060", "user_2", "resource_3"},
                {"53760", "user_3", "resource_3"},
                {"58522", "user_22", "resource_1"},
                {"53651", "user_5", "resource_3"},
                {"2", "user_6", "resource_1"},
                {"100", "user_6", "resource_6"},
                {"400", "user_7", "resource_2"},
                {"100", "user_8", "resource_6"},
                {"54359", "user_1", "resource_3"}
        };
		String[][] logs2 = {
                {"300", "user_1", "resource_3"},
                {"599", "user_1", "resource_3"},
                {"900", "user_1", "resource_3"},
                {"1199", "user_1", "resource_3"},
                {"1200", "user_1", "resource_3"},
                {"1201", "user_1", "resource_3"},
                {"1202", "user_1", "resource_3"}
        };
		
		String[][] logs3 = {
                {"300", "user_10", "resource_5"}
        };
		LogsAccessTime lat = new LogsAccessTime();
		Node n = lat.findMaxAccessResource(logs1);
		//System.out.println("resource name"+n.resource_name);
		//System.out.println("Max access count "+n.max_access);
	}
	
	public  Node findMaxAccessResource(String[][] logs) {
		if(logs.length==0) {
			return null;
		}
		else if (logs.length==1) {
			return new Node(logs[0][2],1);
		}
			
		//System.out.println(logs);
		Arrays.sort(logs, (a,b)-> Integer.valueOf(a[0])- Integer.valueOf(b[0]) );
		HashMap<String, Integer> freqmap = new HashMap();
		   String maxResource = logs[0][2];
	        int maxAccess = 1;
		int i=1;
		int startindex=0;
		freqmap.put(logs[0][2], 1);
		while(i<logs.length) {
			int time = Integer.valueOf(logs[i][0]);
			while (time - Integer.valueOf(logs[startindex][0]) > TIME_RANGE) {
				freqmap.put(logs[startindex][2], freqmap.get(logs[startindex][2]) - 1);
			}
			 if (! freqmap.containsKey(logs[i][2])) {
				 freqmap.put(logs[i][2], 1);
		}  else {
			freqmap.put(logs[i][2], freqmap.get(logs[i][2]) + 1);
        }
			 if ( freqmap.get(logs[i][2]) >=max_access) {
				 max_access = freqmap.get(logs[i][2]);
				 resource_name = logs[i][2];
	            }
		
		
	
		
		return new Node("no_resource",1);
	}

}
	
	/*
	You are a developer for a university. Your current project is to develop a system for students to find courses they share with friends. The university has a system for querying courses students are enrolled in, returned as a list of (ID, course) pairs.

	Write a function that takes in a collection of (student ID number, course name) pairs and returns, for every pair of students, a collection of all courses they share.


	Sample Input:

	enrollments1 = [
	  ["58", "Linear Algebra"],
	  ["94", "Art History"],
	  ["94", "Operating Systems"],
	  ["17", "Software Design"],
	  ["58", "Mechanics"],
	  ["58", "Economics"],
	  ["17", "Linear Algebra"],
	  ["17", "Political Science"],
	  ["94", "Economics"],
	  ["25", "Economics"],
	  ["58", "Software Design"],
	]

	Sample Output (pseudocode, in any order):

	find_pairs(enrollments1) =>
	{
	  "58,17": ["Software Design", "Linear Algebra"]
	  "58,94": ["Economics"]
	  "58,25": ["Economics"]
	  "94,25": ["Economics"]
	  "17,94": []
	  "17,25": []
	}



	Additional test cases:

	Sample Input:

	enrollments2 = [
	  ["0", "Advanced Mechanics"],
	  ["0", "Art History"],
	  ["1", "Course 1"],
	  ["1", "Course 2"],
	  ["2", "Computer Architecture"],
	  ["3", "Course 1"],
	  ["3", "Course 2"],
	  ["4", "Algorithms"]
	]



	Sample output:

	find_pairs(enrollments2) =>
	{
	  "1,0":[]
	  "2,0":[]
	  "2,1":[]
	  "3,0":[]
	  "3,1":["Course 1", "Course 2"]
	  "3,2":[]
	  "4,0":[]
	  "4,1":[]
	  "4,2":[]
	  "4,3":[]
	} 

	Sample Input:
	enrollments3 = [
	  ["23", "Software Design"], 
	  ["3", "Advanced Mechanics"], 
	  ["2", "Art History"], 
	  ["33", "Another"],
	]


	Sample output:

	find_pairs(enrollments3) =>
	{
	  "23,3": []
	  "23,2": []
	  "23,33":[]
	  "3,2":  []
	  "3,33": []
	  "2,33": []
	}

	All Test Cases:
	find_pairs(enrollments1)
	find_pairs(enrollments2)
	find_pairs(enrollments3)

	Complexity analysis variables:

	n: number of student,course pairs in the input
	s: number of students
	c: total number of courses being offered (note: The number of courses any student can take is bounded by a small constant)


	import java.io.*;
	import java.util.*;

	public class LogsAccessTime {
	  public static void main(String[] argv) {
	    String[][] enrollments1 = {
	      {"58", "Linear Algebra"},
	      {"94", "Art History"},
	      {"94", "Operating Systems"},
	      {"17", "Software Design"},
	      {"58", "Mechanics"},
	      {"58", "Economics"},
	      {"17", "Linear Algebra"},
	      {"17", "Political Science"},
	      {"94", "Economics"},
	      {"25", "Economics"},
	      {"58", "Software Design"}
	    };

	    String[][] enrollments2 = {
	      {"0", "Advanced Mechanics"},
	      {"0", "Art History"},
	      {"1", "Course 1"},
	      {"1", "Course 2"},
	      {"2", "Computer Architecture"},
	      {"3", "Course 1"},
	      {"3", "Course 2"},
	      {"4", "Algorithms"}
	    };

	    String[][] enrollments3 = {
	      {"23", "Software Design"}, 
	      {"3",  "Advanced Mechanics"}, 
	      {"2",  "Art History"}, 
	      {"33", "Another"},
	    };
	    Solution s = new Solution();
	    s.findpairs(enrollments3);
	  }
	  public void findpairs(String[][] enrollment){
	    HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
	   /* ArrayList<String> s1= new ArrayList();
	    ArrayList<String> s2= new ArrayList();
	    ArrayList<String> s3= new ArrayList();
	    ArrayList<String> s4= new ArrayList(); 
	    
	    HashSet<String> hs = new HashSet<String>();
	    for(String[] enr: enrollment){
	      hs.add(enr[1]);
	    }
	    
	    for(String[] enr: enrollment){
	     // List<String> l = new ArrayList<String>();
	      if(hm.containsKey(enr[0])){
	       hm.put(enr[0],Arrays.asList(enr[1]));
	      }else
	      {
	      hm.put(enr[0],Arrays.asList(enr[1]));
	      }     
	      
	    }
	     System.out.println(hm);
	     Iterator<String> it = hm.keySet().iterator();
	  while(it.hasNext()){
	   findcommon(hm.get(it.next()),hm.get(it.next()));
	  }
	          
	     }
	   
	  
	  
	  public void findcommon(List<String> l1, List<String> l2){
	    System.out.println(l2.retainAll(l1));
	    if(l2.retainAll(l2) == false){
	      System.out.print("Common elements are empty");
	    }
	    else
	    System.out.println(l2);
	  //  System.out.print("Common elements: " +l1.stream().filter(l2::contains).collect(Collectors.toList()));   

	  }
	}*/



