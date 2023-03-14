/*
 * For a given array/list(ARR) of size 'N,' find and return the 'Equilibrium Index' of the array/list.
 * Equilibrium Index of an array/list is an index 'i' such that the sum of elements at indices [0 to (i - 1)] is equal to the sum of elements at indices [(i + 1) to (N-1)]. 
 * One thing to note here is, the item at the index 'i' is not included in either part.
 * If more than one equilibrium indices are present, then the index appearing first in left to right fashion should be returned. 
 * Negative one(-1) if no such index is present.
 */

import java.util.Scanner;

public class tcArrayEquilibriumIdx {
	
	public static int arrayEquilibriumIndex(int[] arr){  
		
		int tlsum = 0,ltsum = 0;
		
		for(int i = 0;i < arr.length;i++)
			tlsum += arr[i];
		
		for(int i = 0;i < arr.length;i++) {
			int rtsum = tlsum - ltsum - arr[i];
			if(rtsum == ltsum)
				return i;
			ltsum += arr[i];
		}
		
		return -1;
		
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
		
		int rslt = arrayEquilibriumIndex(arr);
		
		if(rslt != -1)
			System.out.println("Equilibrium Index found at : " + rslt);
		else
			System.out.println("Equilibrium Index not found.");

	}

}
