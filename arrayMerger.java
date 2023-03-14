import java.util.Scanner;

public class arrayMerger {

	public static int[] Merger(int[] arr1,int[] arr2,int[] arr3)
	{
		int i = 0,j = 0,k = 0;
		
		while(i < arr1.length && j < arr2.length) {
		if(arr1[i] < arr2[j]) {
			arr3[k++] = arr1[i++];
		}else {
			arr3[k++] = arr2[j++];
		}
		}
		
		for(;i < arr1.length;) {
			arr3[k++] = arr1[i++];
		}
		for(;j < arr2.length;) {
			arr3[k++] = arr2[j++];
		}
		return arr3;
	}
	public static void main(String[] args) {
		System.out.println("Enter the lenght of the array 1 : ");
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr1 = new int[n];
		System.out.println("Start entering the elements of array 1 (sorted): ");
		for(int i = 0;i < n;i++) {
			arr1[i]= scn.nextInt();
		}
		System.out.println("Enter the lenght of the array 2 : ");
		int m = scn.nextInt();
		int[] arr2 = new int[m];
		System.out.println("Start entering the elements of array 2 (sorted): ");
		for(int i = 0;i < m;i++) {
			arr2[i]= scn.nextInt();
		}
		int[] arr3 = new int[n+m];
		Merger(arr1,arr2,arr3);
		System.out.println("Merged Array : ");
		for(int i = 0;i < n + m;i++) {
			System.out.print(arr3[i] + " ");
		}

	}


}
