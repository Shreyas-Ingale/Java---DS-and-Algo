import java.util.Scanner;

public class arraySecondLargest {

	public static int find2ndLargest(int[] arr) {
		int ln = 0,sln = 0;
		if(arr.length > 1) {
			for(int i = 0;i < arr.length;i++) {
				if(arr[i] > ln) {
					sln = ln;
					ln = arr[i];
					continue;
				}
				if(arr[i] > sln && arr[i] != ln) {
					sln = arr[i];
				}
			}
			return sln;
		}
		else
			return Integer.MIN_VALUE;
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
		int num = find2ndLargest(arr);
		System.out.println("Second Largest Number in the Array : " + num);
		
	}


}
