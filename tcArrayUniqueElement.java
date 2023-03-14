/*
 * You have been given an integer array/list(ARR) of size N. Where N is equal to [2M + 1].
 * Now, in the given array/list, 'M' numbers are present twice and one number is present only once.
 * You need to find and return that number which is unique in the array/list.
 */

import java.util.Scanner;

public class tcArrayUniqueElement {

	public static int findUnique(int[] arr) {  

		int rslt = 0;
		for(int i = 0;i < arr.length;i++) {
			rslt ^= arr[i];
		}
		return rslt;

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

		int rslt = findUnique(arr);


		System.out.println("Unique Element is : " + rslt);


	}

}
