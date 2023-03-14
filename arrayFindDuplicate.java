import java.util.Scanner;

public class arrayFindDuplicate {
	
	public static int duplicateNumber(int[] arr) {
		int temp = 0,n = arr.length;
		boolean isDup = false;
		for(int i = 0;i < n;i++) {
			temp = arr[i];
			for(int j = i + 1;j < n;j++){
				if(arr[j] == temp)
					isDup = true;
			}
			if(isDup)
				break;
		}
		return temp;
	}

	public static void main(String[] args) {
		System.out.println("Enter the lenght of the array : ");
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		System.out.println("Start entering the elements int the range - (0 to " + (n - 2) +")");
		for(int i = 0;i < n;i++) {
			arr[i]= scn.nextInt();
		}
		int dup = duplicateNumber(arr);
		System.out.println("The Dupliacte number is : " + dup);

	}

}
