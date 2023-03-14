import java.util.Scanner;

public class arrayFindSumTriplets {
	
	public static int tripletSum(int[] arr,int x)
	 {
	     int triplet = 0,n = arr.length;
		 for(int i = 0;i < n;i++) {
			 int temp1 = arr[i];
			 for(int j = i+1;j < n;j++) {
				 int temp2 = arr[j];
				 for(int k = j +1;k < n;k++) {
					 if(temp1 + temp2 + arr[k] == x)
						 triplet++;
				 }
			 }
		 }
		 return triplet;
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
			System.out.println("Number of triplets are : " + tripletSum(arr,x));
			
	 }

	
}
