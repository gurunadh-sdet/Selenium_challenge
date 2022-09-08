package collection.examples;

public class Coins {

	public static void main(String[] args) {
		int[] coins = {1,2,5};
		int sum =10;
		findcoins(coins,10);
		

	}
	public static void findcoins(int[] A, int sum) {
		int temp=0;
		for(int i=0;i<A.length;i++) {
			for(int j=i+1;j<A.length-1;j++) {
				for(int k=0;k<=sum/k;k++) {
					temp =A[k]+temp;
					if(temp==sum) {
					System.out.println("the values are");	
					}
		}
			
				
		


		
		}
		
}
	}

}