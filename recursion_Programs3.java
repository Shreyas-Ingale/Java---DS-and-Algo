import java.util.ArrayList;
import java.util.HashMap;

public class recursion_Programs3 {

	static ArrayList<String> findSubsequences(String str) {

		if(str.length() == 0) {
			ArrayList<String> rslt = new ArrayList<>();
			rslt.add("");
			return rslt;
		}

		ArrayList<String> rslt = findSubsequences(str.substring(1));
		int len = rslt.size();
		for(int i = 0;i < len;i++) {
			rslt.add(str.charAt(0) + rslt.get(i));
		}
		return rslt;

	}

	private static HashMap<Integer, String> mapKeypad(){
		HashMap<Integer, String> keypadMap = new HashMap<>();
		keypadMap.put(2, "abc");
		keypadMap.put(3, "def");
		keypadMap.put(4, "ghi");
		keypadMap.put(5, "jkl");
		keypadMap.put(6, "mno");
		keypadMap.put(7, "pqrs");
		keypadMap.put(8, "tuv");
		keypadMap.put(9, "wxyz");
		return keypadMap;
	}

	static String[] keypad(int n){

		if(n == 0 || n == 1) {
			String[] rslt = new String[1];
			rslt[0] = "";
			return rslt;
		}

		String[] rtndString = keypad(n/10);
		String[] rslt = new String[0];
		int key = n % 10;
		HashMap<Integer, String> map = mapKeypad();
		String curr = "";
		if(map.containsKey(key)) {
			curr = map.get(key);
			rslt = new String[rtndString.length * map.get(key).length()];
		}
		int k = 0;
		for(int i = 0;i < rtndString.length;i++) {
			for(int j = 0;j < curr.length();j++) {
				rslt[k++] = rtndString[i] + curr.charAt(j); 
			}
		}

		return rslt;

	}

	static void printFactorial(int n,int ans) {

		if(n == 0 || n == 1) {
			System.out.println("Factorial is : " + ans);
			return;
		}

		ans *= n;
		printFactorial(n-1, ans);

	}

	static void printMinimum(int arr[],int min,int si) {

		if(si == arr.length) {
			System.out.println("Minimum of the Array : " + min);
			return;
		}

		if(arr[si] < min)
			min = arr[si];
		printMinimum(arr, min, si+1);

	}

	static void printSubsequences(String str, String op) {

		if(str.length() == 0) {
			System.out.print(op + " ");
			return;
		}

		printSubsequences(str.substring(1), op);
		printSubsequences(str.substring(1), op + str.charAt(0));

	}

	static void printKeypad(int num, String op) {

		if(num == 0 || num == 1) {
			System.out.println(op + " ");
			return;
		}
		int key = num % 10;
		HashMap<Integer, String> map = mapKeypad();
		String curr = "";
		if(map.containsKey(key)) {
			curr = map.get(key);
		}

		for(int  i = 0;i < curr.length();i++) {

			printKeypad(num/10, curr.charAt(i) + op);
		}

	}

	private static int[][] subsetsSumKHelper(int arr[], int si, int k){

		if(si == arr.length && k != 0) {
			return new int[0][0];
		}
		if(k == 0) {
			int [][] rslt = new int[1][0];
			return rslt;
		}

		int[][] incld = subsetsSumKHelper(arr, si+1, k-arr[si]);
		int[][] excld = subsetsSumKHelper(arr, si+1, k);

		int[][] rslt = new int[incld.length + excld.length][0];
		int lp = 0;
		for(int i = 0 ; i < incld.length;i++) {
			rslt[lp] = new int[incld[i].length+1];
			rslt[lp][0] = arr[si];
			for(int j = 0;j < incld[i].length;j++) {
				rslt[lp][j+1] = incld[i][j];
			}
			lp++;
		}


		for(int i = 0 ; i < excld.length;i++) {
			rslt[lp] = new int[excld[i].length];
			for(int j = 0;j < excld[i].length;j++) {
				rslt[lp][j] = excld[i][j];
			}
			lp++;
		}

		return rslt;

	}

	static int[][] subsetsSumK(int input[], int k) {
		return subsetsSumKHelper(input,0,k);
	}	 

	private static int[][] subsetsHelper(int arr[], int si){

		if(si == arr.length) {
			int [][] rslt = new int[1][0];
			return rslt;
		}

		int[][] temp = subsetsHelper(arr, si+1);
		int[][] rslt = new int[temp.length*2][0];
		int lp = 0;
		for(int i = 0;i < temp.length;i++) {
			rslt[lp] = new int[temp[i].length];
			for(int j = 0;j < temp[i].length;j++) {
				rslt[lp][j] = temp[i][j];
			}
			lp++;
		}

		for(int i = 0;i < temp.length;i++) {
			rslt[lp] = new int[rslt[i].length+1];
			rslt[lp][0] = arr[si];
			for(int j = 0;j < temp[i].length;j++) {
				rslt[lp][j+1] = temp[i][j];
			}
			lp++;
		}
		
		return rslt;

	}	
	
	static int[][] subsets(int input[]) {
		return subsetsHelper(input,0);
	}
	
	private static int factorial(int n) {
		
		if(n == 0 || n == 1)
			return 1;
		
		int rslt = n * factorial(n-1);
		return rslt;
		
	}
	
	static String[] permutationOfString(String str){
		
		if(str.length() == 0) {
			return new String[0];
		}
		
		if(str.length() == 1) {
			String[] rslt = new String[1];
			rslt[0] = str;
			return rslt;
		}
		
		String[] temp = permutationOfString(str.substring(1));
		String[] rslt = new String[factorial(str.length())];
		int k = 0;
		for(int i = 0;i < temp.length;i++) {
			for(int j = 0;j < temp[i].length()+1;j++) {
				String addStr = temp[i].substring(0,j) + str.charAt(0) + temp[i].substring(j);
				rslt[k++] = addStr;
			}
		}
		
		return rslt;
		
	}
	
	private static void printSubsetsHelper(int arr[], int si, int[] op) {
		
		if(si == arr.length) {
			for(int i : op)
				System.out.print(i + " ");
			System.out.println();
			return;
		}
		
		printSubsetsHelper(arr, si+1, op);
		int[] temp = new int[op.length + 1];
		int i;
		for(i = 0;i < op.length;i++)
			temp[i] = op[i];
		temp[i] = arr[si];
		printSubsetsHelper(arr, si+1, temp);
		
	}
	
	static void printSubsets(int input[]) {
		
		int[] op = new int[0];
		printSubsetsHelper(input,0,op);
		
	}
	
	private static void printSubsetsSumTokHelper(int arr[], int k, int si, int[] op) {
		
		if(si == arr.length && k != 0)
			return;
		if(k == 0) {
			for(int i : op)
				System.out.print(i + " ");
			System.out.println();
			return;
		}
		
		printSubsetsSumTokHelper(arr, k, si+1, op);
		int[] temp = new int[op.length+1];
		int i;
		for(i = 0;i < op.length;i++)
			temp[i] = op[i];
		temp[i] = arr[si];
		printSubsetsSumTokHelper(arr, k-arr[si], si+1, temp);
		
	}
	
	static void printSubsetsSumTok(int input[], int k) {
		
		int[] op = new int[0];
		printSubsetsSumTokHelper(input,k,0,op);
		
	}
	
	private static void printPermutationOfStringHelper(String str,String op) {
		
		if(str.length() == 0) {
			System.out.println(op);
			return;
		}
		
		for(int i = 0;i <str.length();i++) {
			String temp = op;
			temp = temp + str.charAt(i);
			String rest = str.substring(0,i) + str.substring(i+1);
			printPermutationOfStringHelper(rest, temp);
		}
		
	}
	
	static void printPermutationOfString(String input){
		printPermutationOfStringHelper(input,"");
	}

	public static void main(String[] args) {
		
//		ArrayList<String> rslt = findSubsequences("ab");
//		String[] rslt = keypad(23);
//		for(String s : rslt)
//			System.out.println(s);
//		printFactorial(5,1);
//		int[] arr = {5,12,3,17,1,18,15,3,17};
//		printMinimum(arr,Integer.MAX_VALUE,0);
//		System.out.println("Subsequences are : ");
//		printSubsequences("ab","");
//		System.out.println("All the possible String are : ");
//		printKeypad(23,"");
//		int[][] rslt = subsetsSumK(arr, 6);
//		int[][] rslt = subsets(arr);
//		for(int i = 0;i < rslt.length;i++) {
//			for(int j = 0;j < rslt[i].length;j++) {
//				System.out.print(rslt[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.println("All the possible Permutations of the String are : ");
//		String[] rslt = permutationOfString("");
//		for(String s : rslt)
//			System.out.println(s);
//		printSubsets(arr);
//		printSubsetsSumTok(arr,6);
		printPermutationOfString("agi");
		
	}

}
