import java.util.Scanner;

public class arrayRotateCheck {

	public static int checkRotate(int[] arr) {
		int cnt = 0;
		for(int i = 1;i < arr.length;i++) {
			if(arr[i-1] < arr[i]) {
				continue;
			}
			if(i == arr.length)
				cnt = 0;
			else
				cnt = i;
			break;
		}
		return cnt;
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
		int num = checkRotate(arr);
		System.out.println("The array has been rotated at index : " + num);
		
	}


}
