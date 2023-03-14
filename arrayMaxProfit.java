/*
 * You have made a smartphone app and want to set its subscription price such that the profit earned is maximised. There are certain users who will subscribe to your app only if their budget is greater than or equal to your price.
You will be provided with a list of size N having budgets of subscribers and you need to return the maximum profit that you can earn.
Lets say you decide that price of your app is Rs. x and there are N number of subscribers. So maximum profit you can earn is :
 m * x
where m is total number of subscribers whose budget is greater than or equal to x.
 */

import java.util.Arrays;
import java.util.Scanner;

public class arrayMaxProfit {
	
	public static int maximumProfit(int brr[]) {
		Arrays.sort(brr);
		int prc,pft=0;
		for(int i = 0;i < brr.length;i++) {
			int cnt = brr.length - i;
			if(cnt * brr[i] > pft) {
				pft = cnt * brr[i];
				prc = brr[i];
			}
		}
		return pft;
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int input[] = new int[n];
		for(int i=0;i<n;i++)
			input[i] = s.nextInt();
		System.out.println(maximumProfit(input));
		s.close();
		
	}

}
