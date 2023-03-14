import java.util.Scanner;

public class arrayShiftZerostoRight {

	public static void ShiftZeros(int[] arr)
	{  
		for(int i = 0,k = 0;i < arr.length;i++) {
			if(arr[i] != 0) {
				int temp = arr[i];
				arr[i] = arr[k];
				arr[k] = temp;
				k++;
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
		ShiftZeros(arr);
		System.out.println("Sorted Array : ");
		for(int i = 0;i < n;i++) {
			System.out.print(arr[i] + " ");
		}

	}


}
