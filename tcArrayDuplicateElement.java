/*
*You have been given an integer array/list(ARR) of size N which contains numbers from 0 to (N - 2).
 *Each number is present at least once. That is, if N = 5, the array/list constitutes values ranging from 0 to 3
  and among these, there is a single integer value that is present twice.
 *You need to find and return that duplicate number present in the array. 
 */

import java.util.Scanner;

public class tcArrayDuplicateElement {

	public static int findDuplicate(int[] arr) {  

		int arsum = 0;
		for(int i = 0;i < arr.length;i++) {
			arsum += arr[i];
		}
		int nnsum = (arr.length-2)*(arr.length-1)/2;
		return arsum-nnsum;

	}

	public static void main(String[] args) {

		System.out.println("Enter the lenght of the array : ");
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		System.out.println("Start entering the elements : ");
		for(int i = 0;i < n;i++) {
			arr[i]= scn.nextInt();
		}

		int rslt = findDuplicate(arr);


		System.out.println("Duplicate Element is : " + rslt);


	}

}
