import java.util.Scanner;

public class sortBubble {

	public static void bubbleSort(int[] arr)
	{  
		for(int i = 0;i < arr.length - 1;i++) {
			for(int j = 0;j < arr.length - i - 1;j++) {
				if(arr[j+1] < arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
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
		bubbleSort(arr);
		System.out.println("Sorted Array : ");
		for(int i = 0;i < n;i++) {
			System.out.print(arr[i] + " ");
		}

	}


}
