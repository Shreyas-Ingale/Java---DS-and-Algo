import java.util.Scanner;

public class arraySort0s1s2s {
	
	public static void sort0s1s2s(int[] arr) {
		
	  int i0 = 0,i2 = arr.length - 1;
//	  int[] temp = new int[arr.length]; // with another array
//	  for(int i = 0;i < arr.length;i++) {
//		  if(arr[i] == 0) {
//			  temp[i0++] = arr[i];
//		  }
//		  else if(arr[i] == 2) {
//			  temp[i2--] = arr[i];
//		  }
//	  }
//	  for(;i0 <= i2;i0++) {
//		  temp[i0] = 1;
//	  }
//	  for(int i = 0;i < arr.length;i++) {
//		arr[i] = temp[i];  
//	  }
	  
	  for(int i = 0; i <= i2;) {   // in the same array
		  if(arr[i] == 0) {
			  int temp = arr[i];
			  arr[i] = arr[i0];
			  arr[i0] = temp;
			  i0++;
			  i++;
			  continue;
		  }
		  if(arr[i] == 2) {
			  int temp = arr[i];
			  arr[i] = arr[i2];
			  arr[i2] = temp;
			  i2--;
			  continue;
		  }
		  i++;
	  }
	  
	 }
	 public static void main(String[] args) {
			System.out.println("Enter the length of the array : ");
			Scanner scn = new Scanner(System.in);
			int n = scn.nextInt();
			int[] arr = new int[n];
			System.out.println("Start entering the elements of the array");
			for(int i = 0;i < n;i++) {
				arr[i]= scn.nextInt();
			}
			sort0s1s2s(arr); 
			System.out.println("Sorted array :");
			for(int i = 0;i < n;i++) {
				System.out.print(arr[i] +" ");
			}
			
	 }

	
}
