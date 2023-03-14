import java.util.Scanner;

public class arrayFindIntersection {
	
	public static void intersection(int[] arr1,int[] arr2) {
		
		for(int i = 0;i < arr1.length;i++) {
			int temp = arr1[i];
			for(int j = 0;j < arr2.length;j++){
				if(temp == arr2[j]) {
					arr2[j]=Integer.MIN_VALUE;
					System.out.print(temp + " ");
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the lenght of the 1st array : ");
		int n = scn.nextInt();
		int[] arr1 = new int[n];
		System.out.println("Start entering the elements of 1st array");
		for(int i = 0;i < n;i++) {
			arr1[i]= scn.nextInt();
		}
		System.out.println("Enter the lenght of the 2 array : ");
		int m = scn.nextInt();
		int[] arr2 = new int[m];
		System.out.println("Start entering the elements of 2nd array");
		for(int i = 0;i < m;i++) {
			arr2[i]= scn.nextInt();
		}
		intersection(arr1,arr2);

	}

}
