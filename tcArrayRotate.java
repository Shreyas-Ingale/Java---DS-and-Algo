/*
 *You have been given a random integer array/list(ARR) of size N. 
 *Write a function that rotates the given array/list by D elements(towards the left).
*/

import java.util.Scanner;

public class tcArrayRotate {

	public static void rotate(int[] arr, int d) {  

		int[] temp = new int[arr.length];
		int ti = 0;
		
		for(int i = d;i < arr.length;i++)
			temp[ti++] = arr[i];
		for(int i = 0;i < d;i++)
			temp[ti++] = arr[i];
		for(int i = 0;i < arr.length;i++)
			arr[i] = temp[i];
		
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
		System.out.println("Enter the value of d : ");
		int d = scn.nextInt();
		rotate(arr,d);
		System.out.println("Array rotated by " + d + " elements : ");
		for(int i = 0;i < n;i++) {
			System.out.print(arr[i] + " ");
		}
		
	}

}
