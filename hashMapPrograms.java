import java.util.*;

public class hashMapPrograms {
	
	static ArrayList<Integer> removeDuplicates(int[] arr){
		
		if(arr.length == 0)
			return null;
		ArrayList<Integer> rslt = new ArrayList<>();
		HashMap<Integer, Boolean> map = new HashMap<>();
		for(int i = 0;i < arr.length;i++) {
			if(map.containsKey(arr[i]))
				continue;
			rslt.add(arr[i]);
			map.put(arr[i], true);
			
		}
		return rslt;
		
	}
	
	static int maxFrequencyNumber(int[] arr){ 
		
		if(arr.length == 0)
			return -1;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i : arr) {
			map.put(i, map.getOrDefault(i, 0)+1);
		}
		int rslt = -1,maxval = 0;
		for(int i : arr) {
			if(map.containsKey(i)) {
				if(map.get(i) > maxval) {
					rslt = i;
					maxval = map.get(i);
				}
			}
		}
		return rslt;
		
	}
	
	static void printIntersection(int[] arr1,int[] arr2){
		
		if(arr1.length == 0 || arr2.length == 0)
			return;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i : arr1) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		for(int i : arr2) {
			if(map.containsKey(i)) {
				if(map.get(i) > 0) {
					System.out.print(i + " ");
					map.put(i, map.get(i) - 1);
				}
			}
		}
		
	}
	
	static int PairSum(int[] input, int size) {
		
		if(size == 0)
			return 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		int rslt = 0;
		for(int i : input) {
			if(map.containsKey(-i)) {
				rslt += map.get(-i);
				map.put(i, map.getOrDefault(i, 0) + 1);
			}
			else {
				map.put(i,1);
			}
		}
		return rslt;
		
	}
	
	static String uniqueChar(String str){
		
		if(str.isEmpty())
			return str;
		HashMap<Character, Boolean> map = new HashMap<>();
		String rslt = "";
		for(int i = 0;i < str.length();i++) {
			if(map.containsKey(str.charAt(i)))
				continue;
			rslt += str.charAt(i);
			map.put(str.charAt(i), true);
		}
		return rslt;
		
	}
	
	static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
		
		if(arr.length == 0)
			return null;
		ArrayList<Integer> rslt = new ArrayList<>();
		HashMap<Integer, Boolean> map = new HashMap<>();
		int maxLength = 0,start = -1,end = -1,j;
		for(int i = 0;i < arr.length;i++)
			map.put(arr[i], true);
		for(int i = 0;i < arr.length;i++) {
			int maxLengthT = 1;
			int startT = arr[i];
			int endT = arr[i];
			if(map.get(arr[i])) {
				j = 1;
				while(map.containsKey(arr[i]+j)) {
					maxLengthT++;
					endT = arr[i]+j;
					map.put(arr[i]+j, false);
					j++;
				}
				j = 1;
				while(map.containsKey(arr[i]-j)) {
					maxLengthT++;
					startT = arr[i]-j;
					map.put(arr[i]-j, false);
					j++;
				}
			}
			if(maxLengthT > maxLength) {
				maxLength = maxLengthT;
				start = startT;
				end = endT;
			}
			else if(maxLengthT == maxLength) {
				int k,kT;
				for(k = 0;k < arr.length;k++) {
					if(arr[k] == start)
						break;
				}
				for(kT = 0;kT < arr.length;kT++) {
					if(arr[kT] == startT)
						break;
				}
				if(kT < k) {
					maxLength = maxLengthT;
					start = startT;
					end = endT;
				}
			}
		}
		rslt.add(start);
		rslt.add(end);
		return rslt; // alternative solution below but consumes more time
		
	}
	
	static int getPairsWithDifferenceK(int arr[], int k) {
		
		if(arr.length == 0 || k < 0)
			return 0;
		int rslt = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i : arr) {
			boolean flag = true;
			if(k == 0)
				flag = false;
			if(map.containsKey(i+k))
				rslt += map.get(i+k);
			if(map.containsKey(i-k) && flag)
				rslt += map.get(i-k);
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		return rslt;
		
	}
	
	static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
		
		if(arr.length == 0)
			return 0;
		int maxLenght = 0,sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0;i < arr.length;i++) {
			sum += arr[i];
			if(sum == 0)
				maxLenght = i + 1;
			Integer elemIdx = map.get(sum);
			if(elemIdx != null)
				maxLenght = Math.max(maxLenght, i - elemIdx);
			else
				map.put(sum, i);
		}
		return maxLenght;
		
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
//		int[] brr = {1,2,3,4,2};
//		String str = "abcde";
//		ArrayList<Integer> rslt1 = removeDuplicates(arr);
//		System.out.println("Array without Duplicates : ");
//		System.out.println(rslt1);
//		int rslt2 = maxFrequencyNumber(arr);
//		System.out.println("Number with max appearances : " + rslt2);
//		printIntersection(arr, brr);
//		System.out.println("Number of pair of elements in the array which sum up to 0 : " + PairSum(arr, arr.length));
//		System.out.println("String after removing the duplicates : " + uniqueChar(str));
//		ArrayList<Integer> rslt = longestConsecutiveIncreasingSequence(arr);
//		System.out.println("First and Last Element of the Longest Consecutive Sequence is : " + rslt.get(0) + " " + rslt.get(1));
//		System.out.println("Enter the value for Difference Number (k) : ");
//		int k = scn.nextInt();
//		System.out.println("Number of pair of elements which have Difference of k : " + getPairsWithDifferenceK(arr, k));
		System.out.println("Length of the longest SubArray whose sum's zero is : " + lengthOfLongestSubsetWithZeroSum(arr));
		
	}

}

// alternative solution to longestConsecutiveIncreasingSequence :
/*
{
	if(arr.length == 0)
				return null;
	ArrayList<Integer> rslt = new ArrayList<>();
	HashMap<Integer, Boolean> visitedMap = new HashMap<>();
	HashMap<Integer, Integer> indexedMap = new HashMap<>();
	for(int i = 0; i < arr.length; i++) {
	          visitedMap.put(arr[i], true);
	          indexedMap.put(arr[i], i);
	      }
	int maxLength = 1;
	int startIndex = 0;
	for(int i = 0; i < arr.length; i++){
		int currLength = 0;
		int currIndex = i;
		int currNumber = arr[i];
		while(visitedMap.containsKey(currNumber) && visitedMap.get(currNumber)) {
			visitedMap.put(currNumber, false);
			currLength++;
			currNumber++;
		}
		currNumber = arr[i]-1;
		while(visitedMap.containsKey(currNumber) && visitedMap.get(currNumber)) {
			visitedMap.put(currNumber, false);
			currLength++;
			currIndex = indexedMap.get(currNumber);
			currNumber--;
		}
		if(currLength > maxLength) {
			maxLength = currLength;
			startIndex = currIndex;
		}
		else if(currLength == maxLength) {
			if(currIndex<startIndex)
				startIndex = currIndex;
		}
	}
	rslt.add(arr[startIndex]);
	rslt.add(arr[startIndex]+maxLength-1);
	return rslt;
}
*/
