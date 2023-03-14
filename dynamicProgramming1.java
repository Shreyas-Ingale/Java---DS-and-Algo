import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class dynamicProgramming1 {

	static int fibonacciI(int n, int[] arr) {
		
		if(n == 0 || n == 1)
			return n;
		
		arr[0] = 0;
		arr[1] = 1;
		
		for(int i = 2;i <= n;i++)
			arr[i] = arr[i-1] + arr[i-2];
		
		return arr[n];
				
	}
	
	static int fibonacciR(int n, int[] arr) {
		
		if(n == 0 || n == 1)
			return n;
		
		int ans1,ans2;
		if(arr[n-1] != -1)
			ans1 = arr[n-1];
		else {
			ans1 = fibonacciR(n-1, arr);
			arr[n-1] = ans1;
		}
		if(arr[n-2] != -1)
			ans2 = arr[n-2];
		else {
			ans2 = fibonacciR(n-2, arr);
			arr[n-2] = ans2;
		}	
		int rslt = ans1+ans2;
		return rslt;
		
	}
	
	static long staircaseI(int n, int[] arr) {
		
		if(n == 0 || n == 1 || n == 2)
			return n;
		if(n == 3)
			return 4;
		
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		
		for(int i = 4;i <= n;i++)
			arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
		
		return arr[n];
				
	}
	
	static int staircaseR(int n, int[] arr) {
		
		if(n == 0 || n == 1 || n == 2)
			return n;
		if(n == 3)
			return 4;
		
		int ans1,ans2,ans3;
		
		if(arr[n-1] != -1)
			ans1 = arr[n-1];
		else {
			ans1 = staircaseR(n-1, arr);
			arr[n-1] = ans1;
		}
		if(arr[n-2] != -1)
			ans2 = arr[n-2];
		else {
			ans2 = staircaseR(n-2, arr);
			arr[n-2] = ans2;
		}
		if(arr[n-3] != -1)
			ans3 = arr[n-3];
		else {
			ans3 = staircaseR(n-3, arr);
			arr[n-3] = ans3;
		}
		
		return ans1 + ans2 + ans3;
		
	}
	
	static int countMinStepsToOneI(int n, int[] arr) {
		
		if(n == 1 || n == 0)
			return 0;
		
		arr[0] = 0;
		arr[1] = 0;
		
		for(int i = 2;i <= n;i++) {
			int ans1 = arr[i-1];
			int ans2 = Integer.MAX_VALUE,ans3 = Integer.MAX_VALUE;
			if((i % 2) == 0)
				ans2 = arr[i/2];
			if((i % 3) == 0)
				ans3 = arr[i/3];
			arr[i] = 1 + Math.min(ans1, Math.min(ans2, ans3));
		}
		
		return arr[n];
		
	}
	
	static int countMinStepsToOneR(int n,int[] arr) {
		
		if(n == 1 || n == 0)
			return 0;
		int ans1,ans2 = Integer.MAX_VALUE,ans3 = Integer.MAX_VALUE;
		
		if(arr[n-1] != -1)
			ans1 = arr[n-1];
		else {
			ans1 = 1 + countMinStepsToOneR(n-1,arr);
			arr[n-1] = ans1;
		}
		if(n%2 == 0) {
			if(arr[n/2] != -1)
				ans2 = arr[n/2];
			else {
				ans2 = 1 + countMinStepsToOneR(n/2,arr);
				arr[n/2] = ans2;
			}
		}
		if(n%3 == 0) {
			if(arr[n/3] != -1)
				ans3 = arr[n/3];
			else {
				ans3 = 1 + countMinStepsToOneR(n/3,arr);
				arr[n/3] = ans3;
			}
		}
		
		return Math.min(ans1, Math.min(ans2, ans3));
		
	}
	
	static int minCountI(int n, int[] arr) {
		
		if(n == 0)
			return 0;
		
		arr[0] = 0;

		for(int i = 1;i <= n;i++) {
			int minAns = Integer.MAX_VALUE;
			for(int j = 1;j*j <= i;j++) {
				int ans = 1 + arr[i-(j*j)];
				if(ans < minAns)
					minAns = ans;
			}
			arr[i] = minAns;
		}
		return arr[n];
		
	}
	
	static int minCountR(int n,int[] arr) {
		
		if(n == 0)
			return n;
		
		int minAns = Integer.MAX_VALUE;
		for(int i = 1;i*i <= n;i++) {
			int ans;
			if(arr[n-(i*i)] != -1) {
				ans = arr[n-(i*i)];
			}
			else {
				ans = 1 + minCountR(n-(i*i),arr);
				arr[n-(i*i)] = ans;
			}
			if(ans < minAns)
				minAns = ans;
		}
		
		return minAns;

	}
	
	static long bytelandianI(long n, HashMap<Long, Long> memo) {
		
		if(n == 0) // doesn't work for large values of n consider 2 by 2 matrix ?
			return n;
		
		memo.put((long)0, (long)0);
		for(long i = 1;i <= n;i++) {
			long ans2=0,ans3=0,ans4=0;
			if(memo.containsKey(i/2)) {
				ans2 = memo.get(i/2);
			}
			if(memo.containsKey(i/3)) {
				ans3 = memo.get(i/3);
			}
			if(memo.containsKey(i/4)) {
				ans4 = memo.get(i/4);
			}
			memo.put(i, Math.max(i, ans2+ans3+ans4));
		}
		return memo.get(n);
		
	}
	
	static long bytelandianR(long n, HashMap<Long, Long> memo) {
		
		if(n == 0)
			return n;
		
		long ans2,ans3,ans4;
		if(memo.containsKey(n/2)) {
			ans2 = memo.get(n/2);
		}
		else {
			ans2 = bytelandianR(n/2,memo);
			memo.put(n/2, ans2);
		}
		if(memo.containsKey(n/3)) {
			ans3 = memo.get(n/3);
		}
		else {
			ans3 = bytelandianR(n/3,memo);
			memo.put(n/3, ans3);
		}
		if(memo.containsKey(n/4)) {
			ans4 = memo.get(n/4);
		}
		else {
			ans4 = bytelandianR(n/4,memo);
			memo.put(n/4, ans4);
		}
		
		return Math.max(n, ans2+ans3+ans4);
		
	}
	
	static int maxMoneyLootedI(int[] houses) {
		
		if(houses.length == 0)
			return 0;
		if(houses.length == 1)
			return houses[0];
		
		int[] arr = new int[houses.length];
		arr[0] = houses[0];
		arr[1] = Math.max(houses[0], houses[1]);
		for(int i = 2;i < houses.length;i++)
			arr[i] = Math.max(arr[i-1], (houses[i] + arr[i-2]));
		return arr[houses.length-1];
		
	}
	
	static int maxMoneyLootedR(int[] houses, int[] arr, int si) {
		
		if(si >= houses.length)
			return 0;
		
		int max = 0;
		for(int i = si;i < houses.length;i++) {
			int ans2,ans3;
			if((i+2) < arr.length && arr[i+2] != -1)
				ans2 = arr[i+2];
			else
				ans2 = maxMoneyLootedR(houses,arr, i+2);
			if((i+3) < arr.length && arr[i+3] != -1)
				ans3 = arr[i+3];
			else
				ans3 = maxMoneyLootedR(houses,arr, i+3);
			int ans = houses[i] + Math.max(ans2, ans3);
			arr[i] = ans;
			if(ans > max)
				max = ans;
		}
		
		return max;
				
	}
	
	private static int findWinnerI(int[] arr, int n, int x, int y) {
		
		if(n == 1 || n == x || n == y)
			return 1;
		
		arr[1] = 1;
		
		int ans1=0,ans2=0,ans3=0;
		
		for(int i = 2;i < arr.length;i++) {
			if(i == x || i == y) {
				arr[i] = 1;
				continue;
			}
			if(i-x >=1)
				ans1 = arr[i-x] ^ 1;
			if(i-y >=1)
				ans2 = arr[i-y] ^ 1;
			ans3 = arr[i-1] ^ 1;
			arr[i] = Math.max(ans1, Math.max(ans2, ans3));
		}
		return arr[n];
		
	}
	
	private static int findWinnerR(int[] arr, int n, int x, int y) {

		if(n == 1 || n == x || n == y) // more efficient recursive solution through booolean return s
			return 1; 
		
		if(arr[n] != -1) {
			return arr[n];
		}
		
		int ans1=0,ans2=0,ans3=0;
		if(arr[n-1] != -1)
			ans1 = arr[n-1];
		else {
			ans1 = 1 ^ findWinnerR(arr, n-1, x, y);
			arr[n-1] = ans1;
		}
		if(n-x >= 1) {
			if(arr[n-x] != -1)
				ans2 = arr[n-x];
			else {
				ans2 = 1 ^ findWinnerR(arr, n-x, x, y);
				arr[n-x] = ans2;
			}
		}
		if(n-y >= 1) {
			if(arr[n-y] != -1)
				ans3 = arr[n-y];
			else {
				ans3 = 1 ^ findWinnerR(arr, n-y, x, y);
				arr[n-y] = ans3;
			}
		}
		
		return Math.max(ans1, Math.max(ans2, ans3));
		
	}
	
	static String findWinner(int[] arr, int n, int x, int y) {
		
		if(findWinnerR(arr,n,x,y) == 1)
			return "Beerus";
		else
			return "Whis";
		
	}
	
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the value of 'N' : ");
		int n = scn.nextInt();
//		int[] arr1 = {10,2,30,20,3,50};
//		int[] arr = new int[arr1.length];
		int[] arr = new int[n+1];
		Arrays.fill(arr, -1);
//		System.out.println(n + "th Fibonacci Number is : " + fibonacciI(n,arr));
//		System.out.println("Number of Ways to run-up to " + n + " Stairs is : " + staircaseI(n,arr));
//		System.out.println("Minimum Number of Steps required for " + n + " to get reduced to 1 are : " + countMinStepsToOneI(n,arr));
//		System.out.println("Minimum Squared Numbers required to represent " + n + " are : " + minCountI(n,arr));
//		HashMap<Long, Long> memo = new HashMap<>();
//		System.out.println("Maximum Amount of Dollars one can get are : " + bytelandianR(n,memo));
//		System.out.println("Maximum Amount of Money Thief can get is : " + maxMoneyLootedI(arr1));
		System.out.println("Enter the value of 'X' and 'Y' : ");
		int x = scn.nextInt();
		int y = scn.nextInt();
		System.out.println("Maximum Amount of Money Thief can get is : " + findWinner(arr,n, x, y));
		
	}

}
