/*
 * You have been given two integer arrays/list(ARR1 and ARR2) of size N and M, respectively. 
 * You need to print their intersection; 
 * An intersection for this problem can be defined when both the arrays/lists contain a particular value
 * or when there is a common value that exists in both the arrays/lists.
 */

import java.util.Scanner;

public class tcArrayIntersection {
	
	static void mergeSort(int[] arr){

		if(arr.length <= 1)
			return;

		int i,mid = arr.length / 2;
		int s1[] = new int[mid];
		int s2[] = new int[arr.length - mid];
		for(i = 0;i < mid;i++)
			s1[i] = arr[i];
		for(int j = 0;i < arr.length;i++,j++)
			s2[j] = arr[i];

		mergeSort(s1);
		mergeSort(s2);

		int j = 0,k = 0;
		for(i = 0;j < s1.length && k < s2.length;) {
			if(s1[j] < s2[k] ) {
				arr[i++] = s1[j++];
			}
			else
				arr[i++] = s2[k++];
		}
		for(;j < s1.length;)
			arr[i++] = s1[j++];
		for(;k < s2.length;)
			arr[i++] = s2[k++];

	}
	
	public static void intersection(int[] arr1, int[] arr2) {
		
		mergeSort(arr1);
		mergeSort(arr2);
		
		for(int i = 0,j = 0;i < arr1.length && j < arr2.length;) {
			if(arr1[i] == arr2[j]) {
				System.out.print(arr1[i] + " ");
				i++;
				j++;
			}
			else if(arr1[i] > arr2[j])
				j++;
			else
				i++;
		}
		
	}

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter the lenght of the array 1 : ");
		int n = scn.nextInt();
		int[] arr1 = new int[n];
		System.out.println("Start entering the elements of array 1): ");
		for(int i = 0;i < n;i++) {
			arr1[i]= scn.nextInt();
		}
		
		System.out.println("Enter the lenght of the array 2 : ");
		int m = scn.nextInt();
		int[] arr2 = new int[m];
		System.out.println("Start entering the elements of array 2: ");
		for(int i = 0;i < m;i++) {
			arr2[i]= scn.nextInt();
		}
		
		
		System.out.println("Intersection point(s) for both the arrays is/are : ");
		intersection(arr1,arr2);
		
		scn.close();

	}

}
