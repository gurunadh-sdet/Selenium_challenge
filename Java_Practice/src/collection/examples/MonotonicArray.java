package collection.examples;

public class MonotonicArray {

	public static void main(String[] args) {
	/*	
		list1 = [6, 5, 4, 4]
				list2 = [1,1,1,3,3,4,3,2,4,2]
				list3 = [1,1,2,3,7]*/
		int[] list1 = {6,5,4,4};
		int[] list2 = {3,1,1,3,3,4,3,2,4,2};
		int[] list3 = {1,1,2,3,7};
		System.out.println(isMonotonic(list1));
		System.out.println(isMonotonic(list2));
		System.out.println(isMonotonic(list3));											

	}
	
	public static boolean isMonotonic(int[] A) {
		boolean flag= true;
		int l= A.length;
		if(A[0]>A[l-1]) {
			for(int i=0;i<l-1;i++) {	
				if(A[i]<A[i+1]) {
					return false;
				}
			}
		}
		else {
			for(int i=0;i<l-1;i++) {	
				if(A[i]>A[i+1]) {
					return false;
				}
			}
		}
	return flag;
	}

}

