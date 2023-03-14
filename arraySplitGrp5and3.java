/*
 * Given an integer array A of size N, check if the input array can be splitted in two parts such that -
- Sum of both parts is equal
- All elements in the input, which are divisible by 5 should be in same group.
- All elements in the input, which are divisible by 3 (but not divisible by 5) should be in other group.
- Elements which are neither divisible by 5 nor by 3, can be put in any group.
Groups can be made with any set of elements, i.e. elements need not to be continuous. And you need to consider each and every element of input array in some group.
Return true, if array can be split according to the above rules, else return false.
 */

import java.util.Scanner;

public class arraySplitGrp5and3 {
	
	public static boolean check(int arr[],int n,int st,int fvsum,int trsum) {
		if(st == n)
			return fvsum == trsum;
		
		if(arr[st] % 3 == 0)
			trsum += arr[st];
		else if(arr[st] % 5 == 0)
			fvsum += arr[st];
		else {
			return check(arr, n, st + 1, fvsum + arr[st], trsum) || check(arr, n, st + 1, fvsum, trsum + arr[st]);
		}
		
		return check(arr, n, st + 1, fvsum, trsum);
		
	}
	
	public static boolean splitArray(int arr[]) {
		
		return check(arr,arr.length,0,0,0);
		
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		System.out.println(splitArray(arr));
		s.close();

	}

}
