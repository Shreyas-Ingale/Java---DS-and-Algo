import java.util.Scanner;

public class arrayPopulate {

//	public static int[] populate1(int n)
//	 {
//	     int[] arr = new int[n];
//	     int i,val = 1;
//	     if(n % 2 == 0) {
//	    	 for(i = 0;i < (n/2);i++) {
//	    		 arr[i] = val;
//	    		 val += 2;
//	    	 }
//	    	 val = n;
//	    	 for(;i < n;i++) {
//	    		 arr[i] = val;
//	    		 val -= 2;
//	    	 }
//	    	 return arr;
//	     }
//	     else {
//	    	 for(i = 0;i < (n/2 + 1);i++) {
//	    		 arr[i] = val;
//	    		 val += 2;
//	    	 }
//	    	 val = n - 1;
//	    	 for(;i < n;i++) {
//	    		 arr[i] = val;
//	    		 val -= 2;
//	    	 }
//	    	 return arr;
//	     }
//	        
//	 }
	public static int[] populate2(int n)
	 {
	     int[] arr = new int[n];
		 int s = 0,e = n - 1,val = 1; 
	     if(n % 2 == 0) {
	    	 for(int i = 0;s < e;i++) {
	    		 arr[s++] = val++;
		    	 arr[e--] = val++;
	    	 }
	    	 return arr;
	     }
	     else {
	    	 for(int i = 0;true;i++) {
	    		if(s == e) {
	    			arr[s] = val;
	    			return arr;
	    		}
	    		arr[s++] = val++;
		    	arr[e--] = val++;
	    	 }
	     }
	     
	 }
	 public static void main(String[] args) {
			System.out.println("Enter the length of the array : ");
			int n = new Scanner(System.in).nextInt();
//			int[] arr = populate1(n);
			int[] arr = populate2(n);
			for(int i = 0;i < n;i++) {
				System.out.print(arr[i] + " ");
			}
			
			
		}


}
