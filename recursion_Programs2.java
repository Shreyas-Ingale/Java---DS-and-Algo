import java.util.Scanner;

public class recursion_Programs2 {

	static int checkZeros(int n) {
		
		if(n == 0)
			return 0;
		if(n % 10 == 0)
			return 1 + checkZeros(n/10);
		else
			return checkZeros(n/10);
		
	}
	
	public static int countZerosRec(int n){
		
		if(n == 0)
			return 1;
		else
			return checkZeros(n);
	}
	
	static boolean findNum(int[] arr,int x) {
		
		if(arr.length == 1)
			return false;
		if(arr[0] == x)
			return true;
		int[] srr = new int[arr.length-1];
		for(int i = 1;i < arr.length;i++)
			srr[i-1] = arr[i];
		boolean rslt = findNum(srr,x);
		return rslt;
		
	}
	
	static int firstIndex(int[] arr,int x) {

		if(arr[0] == x)
			return 0;
		if(arr.length == 1)
			return -1;
		int[] srr = new int[arr.length-1];
		for(int i = 1;i < arr.length;i++)
			srr[i-1] = arr[i];
		int rslt = firstIndex(srr,x);
		if(rslt != -1)
			return rslt + 1;
		else
			return -1;

	}

	static int firstIndex(int[] arr,int x,int si) {

		if(arr[si] == x)
			return 0;
		if(si == arr.length-1)
			return -1;
		int rslt = firstIndex(arr,x,si+1);
		if(rslt != -1)
			return rslt + 1;
		else
			return -1;

	}

	static int lastIndex(int[] arr,int x) {

		if(arr.length == 1) {
			if(arr[0] == x)
				return 0;
			else
				return -1;
		}
		int[] srr = new int[arr.length-1];
		for(int i = 1;i < arr.length;i++)
			srr[i-1] = arr[i];
		int rslt = lastIndex(srr, x);
		if(rslt == -1) {
			if(arr[0] == x)
				return 0;
			else
				return -1;
		}
		else
			return rslt + 1;
		
	}

	static int lastIndex(int[] arr,int x,int si) {

		if(si == arr.length - 1) {
			if(arr[si] == x)
				return 0;
			else 
				return -1;
		}
		int rslt = lastIndex(arr,x,si+1);
		if(rslt == -1) {
			if(arr[si] == x)
				return 0;
			else 
				return -1;
		}
		else
			return rslt + 1;

	}
	
	static double findGeometricSum(int k){
		
		if(k == 0)
			return 1;
		double ans = 1/Math.pow(2,k) + findGeometricSum(k-1);
		return ans;
	}
		
	static int multiplyTwoIntegers(int m, int n){
			
			if(n == 0 || m == 0)
				return 0;
			int ans = m + multiplyTwoIntegers(m, n - 1);
			return ans;
			
	}
		
	static int digits(int n) {
		
		if(n == 0)
			return 0;
		int rslt = digits(n / 10) + 1;
		return rslt;
		
	}
	
	static int power(int x,int n) {
		
		if(n == 0)
			return 1;
		if(x == 0)
			return 0;
		if(n == 1)
			return x;
		
		int rslt = x * power(x,n - 1);
		return rslt;
		
	}
	
	static int sum(int[] arr) {
		
		if(arr.length == 1)
			return arr[0];
		arr[1] = arr[0] + arr[1];
		int[] srr = new int[arr.length-1];
		for(int i = 1;i < arr.length;i++)
			srr[i-1] = arr[i];
		int rslt = sum(srr);
		return rslt;
		
	}
	
	static int sumOfDigits(int n) {
		
		if(n == 0)
			return n;
		int rslt = sumOfDigits(n/10) + n % 10;
		return rslt;
		
	}
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
//		int n = s.nextInt();
//		System.out.println(countZerosRec(n));
//		System.out.println("Enter the lenght of the Array : ");
//		int n = s.nextInt();
//		System.out.println("Enter the elements of the Array : ");
//		int[] arr = new int[n];
//		for(int i = 0;i < n;i++) 
//			arr[i] = s.nextInt();
//		System.out.println("Enter the Element to be Found : ");
//		int x = s.nextInt();
//		if(findNum(arr,x))
//			System.out.println("Element was found");
//		else
//			System.out.println("Element wasn't found");
//		System.out.println("Enter the lenght of the Array : ");
//		int n = s.nextInt();
//		System.out.println("Enter the elements of the Array : ");
//		int[] arr = new int[n];
//		for(int i = 0;i < n;i++) 
//			arr[i] = s.nextInt();
//		System.out.println("Enter the Element to be Found : ");
//		int x = s.nextInt();
//		int rslt = firstIndex(arr,x,0);
//		if(rslt != -1)
//			System.out.println("Element was found at index : " + rslt);
//		else
//			System.out.println("Element wasn't found");
//		System.out.println("Enter the lenght of the Array : ");
//		int n = s.nextInt();
//		System.out.println("Enter the elements of the Array : ");
//		int[] arr = new int[n];
//		for(int i = 0;i < n;i++) 
//			arr[i] = s.nextInt();
//		System.out.println("Enter the Element to be Found : ");
//		int x = s.nextInt();
//		int rslt = lastIndex(arr,x,0);
//		if(rslt != -1)
//			System.out.println("Element was found at index : " + rslt);
//		else
//			System.out.println("Element wasn't found");
//		int k = s.nextInt();
//		double ans = findGeometricSum(k);
//		System.out.println(ans);
//		int m = s.nextInt();
//		int n = s.nextInt();
//		System.out.println(multiplyTwoIntegers(m, n));
//		System.out.println("Write the Number : ");
//		int n= s.nextInt();
//		System.out.println("Number of digits in the given number is : " + (digits(n)));
//		System.out.println("Write the values of Base and Power respt. : ");
//		int x = s.nextInt();
//		int n = s.nextInt();
//		System.out.println("Final answer is : " + power(x,n));
//		System.out.println("Enter the lenght of the Array : ");
//		int n= s.nextInt();
//		System.out.println("Enter the elements of the Array : ");
//		int[] arr = new int[n];
//		for(int i = 0;i < n;i++) 
//			arr[i] = s.nextInt();
//		System.out.println("Sum of the elements of the Array is : " + sum(arr));
//		int n = s.nextInt();
//		System.out.println(sumOfDigits(n));

	}

}
