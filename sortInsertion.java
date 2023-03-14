import java.util.Scanner;

public class sortInsertion {

	public static void insertionSort(int[] arr)
	{
		for(int i = 1;i < arr.length;i++) {
			int temp = arr[i];
			int j = i - 1;
			while(j >= 0 && arr[j] > temp) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}

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
		insertionSort(arr);
		System.out.println("Sorted Array : ");
		for(int i = 0;i < n;i++) {
			System.out.print(arr[i] + " ");
		}

	}


}
