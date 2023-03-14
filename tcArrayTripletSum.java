/*You have been given a random integer array/list(ARR) and a number X.
 * Find and return the triplet(s) in the array/list which sum to X. 
 */

import java.util.Arrays;
import java.util.Scanner;

public class tcArrayTripletSum {
	
	public static int pairSum(int[] arr,int si,int sum) {  

//		int prcnt = 0;
//		for(int i = si;i < arr.length;i++) {
//			for(int j = i + 1;j < arr.length;j++) {
//				if(arr[i] + arr[j] == sum)
//					prcnt++;
//			}
//		}
//		
//		return prcnt;
		
		int ei = arr.length-1,pairs = 0;
		
		while(si < ei) {
			if(arr[si] + arr[ei] < sum)
				si++;
			else if(arr[si] + arr[ei] > sum)
				ei--;
			else {
				int strtelmnt = arr[si];
				int endelmnt = arr[ei];
				if(strtelmnt == endelmnt) {
					int totelmnt = (ei - si) + 1;
					pairs += ((totelmnt)*(totelmnt-1))/2;
					return pairs;
				}
				int tmpsi = si + 1;
				int tmpei = ei - 1;
				while(tmpsi <= tmpei && arr[tmpsi] == strtelmnt)
					tmpsi++;
				while(tmpei >= tmpsi && arr[tmpei] == endelmnt)
					tmpei--;
				int ttlelfrmstrt = tmpsi - si;
				int ttlelfrmend = ei - tmpei;
				pairs += (ttlelfrmend * ttlelfrmstrt);
				si = tmpsi;
				ei = tmpei;
			}
		}
		
		return pairs;

	}
	
	public static int tripletSum(int[] arr,int sum) {
		int trpltcnt = 0;
		Arrays.sort(arr);
		for(int i = 0;i < arr.length;i++) {
			int prsum = sum - arr[i];
			int prcnt = pairSum(arr,i+1,prsum);
			trpltcnt += prcnt;
		}
		return trpltcnt;
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
		System.out.println("Enter the value for sum element : ");
		int sum = scn.nextInt();
		int rslt = tripletSum(arr,sum);
		System.out.println("Total number of triplets that sums upto " + sum + " are : " + rslt);


	}

}
