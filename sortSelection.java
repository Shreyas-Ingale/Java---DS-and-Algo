import java.util.Scanner;

public class sortSelection {

	public static void selectionSort(int[] arr)
	{
		int n = arr.length,curr = 0;
		while(curr < n - 1) {
			int min = curr;
			for(int i = curr + 1;i < n;i++) {
				if(arr[i] < arr[min])
					min = i;
			}
			int temp = arr[curr];
			arr[curr] = arr[min];
			arr[min] = temp;
			curr++;
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
		selectionSort(arr);
		System.out.println("Sorted Array : ");
		for(int i = 0;i < n;i++) {
			System.out.print(arr[i] + " ");
		}

	}


}
