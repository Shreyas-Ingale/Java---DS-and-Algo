import java.util.Scanner;

public class arrayTwoArraysum {

	public static void Summation(int[] arr1,int[] arr2,int[] output) {
		
		int i1 = arr1.length - 1,i2 = arr2.length - 1,io = output.length - 1,cr = 0;
		for(;i1 >= 0 && i2 >= 0;i1--,i2--) {
			int sum = arr1[i1] + arr2[i2] + cr;
			output[io] = sum % 10;
			cr = sum / 10;
			io--;
		}
		if(i1 >= 0) {
			for(;i1 >= 0;i1--) {
				int sum = arr1[i1] + cr;
				output[io--] = sum % 10;
				cr = sum / 10;
			}
		}
		if(i2 >= 0) {
			for(;i2 >= 0;i2--) {
				int sum = arr2[i2] + cr;
				output[io--] = sum % 10;
				cr = sum / 10;
			}
		}
		output[io] = cr;
		
	}
	public static void main(String[] args) {
		System.out.println("Enter the lenght of the array 1 : ");
		Scanner scn = new Scanner(System.in);
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
		int[] arr3 = new int[1 + Math.max(n, m)];
		Summation(arr1,arr2,arr3);
		System.out.println("Sum of the elements in both the arrays is : ");
		for(int i = 0;i < arr3.length;i++) {
			System.out.print(arr3[i] + " ");
		}

	}


}
