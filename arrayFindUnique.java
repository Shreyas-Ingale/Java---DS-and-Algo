import java.util.Scanner;

public class arrayFindUnique {
	
	public static int uniqueNumber(int[] arr) {
		int temp = 0,n = arr.length;
		for(int i = 0;i < n;i++) {
			boolean isDup = false;
			temp = arr[i];
			for(int k = 0;k < i;k++) {
				if(arr[k] == temp) {
					isDup = true;
					break;
				}
			}
			for(int j = i + 1;j < n;j++){
				if(arr[j] == temp) {
					isDup = true;
					break;
				}
			}
			System.out.println(temp + " " + isDup);
			if(isDup)
				continue;
			else
				break;
		}
		return temp;
		
//		int result = 0;
//		for(int i=0;i<arr.length;i++)
//		{
//			result ^= arr[i];
//		}
//
//		return (result>0 ? result : -1);
		
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
		int unq = uniqueNumber(arr);
		System.out.println("The Unique number is : " + unq);

	}

}
