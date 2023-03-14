import java.util.Scanner;

public class arraySum {
	
	public static int sum(int[] arr) {
		int sum = 0,n = arr.length;
		for(int i = 0;i < n;i++) {
			sum += arr[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println("Enter the lenght of the array : ");
		int n = new Scanner(System.in).nextInt();
		int[] arr = new int[n];
		System.out.println("Start entering the elements of the array");
		for(int i = 0;i < n;i++) {
			arr[i]= new Scanner(System.in).nextInt();
		}
		int sum = sum(arr);
		System.out.println("Sum of the elements is : " + sum);

	}

}
