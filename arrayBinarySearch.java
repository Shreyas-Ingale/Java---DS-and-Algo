import java.util.Scanner;

public class arrayBinarySearch {
	
	public static int BinarySearch(int[] arr,int x) {
		int temp = -1,n = arr.length,strt = 0,end = n - 1,mid = 0;
		while(strt <= end) {
			mid = (strt + end) / 2;
			if(x == arr[mid]) {
				return mid;
			}
			else if(x < arr[mid]) { 
				end = mid - 1;
			}
			else {
				strt = mid + 1;
			}
		
		}
		return temp;
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
		System.out.println("Enter the number of iterations : ");
		int it = scn.nextInt();
		while(it != 0) {
			System.out.println("Enter the number to be found : ");
			int x = scn.nextInt();
			int rslt = BinarySearch(arr,x);
			if(rslt != -1)
				System.out.println("Given number found at : " + rslt);
			else
				System.out.println("Given number not found ; -1");
			it--;
		}

	}

}
