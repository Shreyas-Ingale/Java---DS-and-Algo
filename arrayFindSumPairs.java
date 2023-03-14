import java.util.Scanner;

public class arrayFindSumPairs {
	
	public static int pairSum(int[] arr,int x)
	 {
	     int pair = 0,n = arr.length;
		 for(int i = 0;i < n;i++) {
			 int temp = arr[i];
			 for(int j = i+1;j < n;j++) {
				 if(temp + arr[j] == x)
					 pair++;
			 }
		 }
		 return pair;
	 }
	 public static void main(String[] args) {
			System.out.println("Enter the length of the array : ");
			Scanner scn = new Scanner(System.in);
			int n = scn.nextInt();
			int[] arr = new int[n];
			System.out.println("Start entering the elements of the array");
			for(int i = 0;i < n;i++) {
				arr[i]= scn.nextInt();
			}
			System.out.println("Enter the sum element : ");
			int x = scn.nextInt();
			System.out.println("Number of pairs are : " + pairSum(arr,x));
			
	 }

	
}
