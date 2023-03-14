import java.util.Scanner;

public class arraySort0sand1s {
	
	public static int[] sort0sand1s(int[] arr)
	 {
	     int n = arr.length,s,e;
	     for(s = 0,e = n-1;s < e;) {
	    	 if(arr[s] == 0) {
	    		 s++;
	    		 continue;
	    	 }
	    	 for(;e > s;e--) {
	    		 if(arr[e] == 1)
	    			 continue;
	    		 arr[s] = 0;
	    		 arr[e] = 1;
	    		 break;
	    	 }
	    	 
	     }
//		 for(int i = 0;i < n;i++) {
//			 if(arr[i] == 0) {
//				 continue;
//			 }
//			 for(int j = i;j < n;j++) {
//				 if(arr[j] == 0) {
//					 int temp = arr[i];
//					 arr[i]=arr[j];
//					 arr[j]=temp;
//					 break;
//				 }
//			 }
//		 }
	     
		 return arr;
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
			arr = sort0sand1s(arr); 
			System.out.println("Sorted array :");
			for(int i = 0;i < n;i++) {
				System.out.print(arr[i] +" ");
			}
			
	 }

	
}
