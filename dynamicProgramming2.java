
public class dynamicProgramming2 {
	
	static int minCostPathI(int[][] input,int[][] dp) {
		
		for(int i = input.length-1;i >= 0;i--) {
			for(int j = input[0].length-1;j >= 0;j--) {
				if(i == input.length-1 && j == input[0].length-1) {
					dp[i][j] = input[i][j];
					continue;
				}
				int ansb = dp[i+1][j];
				int ansr = dp[i][j+1];
				int ansd = dp[i+1][j+1];
				dp[i][j] = input[i][j] + Math.min(ansb, Math.min(ansr, ansd));
			}
		}
		return dp[0][0];
		
	}
	
	static int minCostPathR(int[][] input,int[][] dp,int r,int c) {
		
		if(r == input.length-1 && c == input[0].length-1)
			return input[r][c];
		if(r >= input.length || c >= input[0].length)
			return Integer.MAX_VALUE;
		
		int ansb,ansr,ansd,rslt;
		if(dp[r+1][c] == Integer.MIN_VALUE) {
			ansb = minCostPathR(input,dp,r+1,c);
			dp[r+1][c] = ansb;
		}
		else
			ansb = dp[r+1][c];
		if(dp[r][c+1] == Integer.MIN_VALUE) {
			ansr = minCostPathR(input,dp,r,c+1);
			dp[r][c+1] = ansr;
		}
		else
			ansr = dp[r][c+1];
		if(dp[r+1][c+1] == Integer.MIN_VALUE) {
			ansd = minCostPathR(input,dp,r+1,c+1);
			dp[r+1][c+1] = ansd;
		}
		else
			ansd = dp[r+1][c+1];
		
		rslt = input[r][c] + Math.min(ansb, Math.min(ansr, ansd));
		return rslt;
		
	}
	
	static int lcsI(int[][] dp, String s, String t) {
		
		for(int i = s.length()-1;i >= 0;i--) {
			for(int j = t.length()-1;j >= 0;j--) {
				int ans;
				if(s.charAt(i) == t.charAt(j)) {
					ans = 1 + dp[i+1][j+1];
				}
				else {
					int ans1 = dp[i][j+1];
					int ans2 = dp[i+1][j];
					ans = Math.max(ans1, ans2);
				}
				dp[i][j] = ans;
			}
		}
		return dp[0][0];
		
	}
	
	static int lcsR(int[][] dp, String s, String t, int i, int j) {
		
		if(i == s.length() || j == t.length())
			return 0;
		
		int rslt;
		if(s.charAt(i) == t.charAt(j)) {
			int ans;
			if(dp[i+1][j+1] == -1) {
				ans = lcsR(dp,s, t, i+1, j+1);
				dp[i+1][j+1] = ans;
				
			}
			else
				ans = dp[i+1][j+1];
			rslt = 1 + ans;
		}
		else {
			int ans1,ans2;
			if(dp[i][j+1] == -1) {
				ans1 = lcsR(dp,s, t, i, j+1);
				dp[i][j+1] = ans1;
			}
			else
				ans1 = dp[i][j+1];
			if(dp[i+1][j] == -1) {
				ans2 = lcsR(dp,s, t, i+1, j);
				dp[i+1][j] = ans2;
			}
			else
				ans2 = dp[i+1][j];
			rslt = Math.max(ans1,ans2);
		}
		
		return rslt;
		
	}
	
	static int knapsackI(int[][] dp, int[] weights, int[] values, int maxWt) {
		
		for(int i = values.length-1;i >= 0;i--) {
			for(int w = 0;w <= maxWt;w++) {
				int ans;
				if(weights[i] <= w) {
					int ans1 = values[i] + dp[i+1][w-weights[i]];
					int ans2 = dp[i+1][w];
					ans  = Math.max(ans1, ans2);
				}
				else
					ans = dp[i+1][w];
				dp[i][w] = ans;
			}
		}
		return dp[0][maxWt];
	}
	
	static int knapsackR(int[][] dp, int[] weights, int[] values, int i, int wt) {
		
		if(i == values.length)
			return 0;
		
		int rslt;
		if(weights[i] <= wt) {
			int ans1,ans2;
			if(dp[i+1][wt-weights[i]] == -1) {
				ans1 = knapsackR(dp,weights, values, i+1, wt-weights[i]);
				dp[i+1][wt-weights[i]] = ans1;
			}
			else
				ans1 = dp[i+1][wt-weights[i]];
			if(dp[i+1][wt] == -1) {
				ans2 = knapsackR(dp,weights, values, i+1, wt);
				dp[i+1][wt] = ans2;
			}
			else
				ans2 = dp[i+1][wt];
			rslt = Math.max(values[i] + ans1, ans2);
		}
		else {
			if(dp[i+1][wt] == -1) {
				rslt = knapsackR(dp,weights, values, i+1, wt);
				dp[i+1][wt] = rslt;
			}
			else
				rslt = dp[i+1][wt];
		}
				
		return rslt;
		
	}

	static int editDistanceI(int[][] dp, String s, String t) {
		
		for(int i = s.length()-1;i >= 0;i--) {
			for(int j = t.length()-1;j >= 0;j--) {
				int rslt;
				if(s.charAt(i) == t.charAt(j)) {
					rslt = dp[i+1][j+1];
				}
				else {
					int ansd = dp[i+1][j];
					int ansr = dp[i+1][j+1];
					int ansi = dp[i][j+1];
					rslt = 1 + Math.min(ansd, Math.min(ansr, ansi));
				}
				dp[i][j] = rslt;
			}
		}
		return dp[0][0];
		
	}
	
	static int editDistanceR(int[][] dp, String s, String t, int i, int j) {
		
		if(i == s.length())
			return t.length()-j;
		if(j == t.length())
			return s.length()-i;
		
		int rslt;
		
		if(s.charAt(i) == t.charAt(j)) {
			if(dp[i+1][j+1] == -1) {
				rslt = editDistanceR(dp, s, t, i+1, j+1);
				dp[i+1][j+1] = rslt;
				
			}
			else
				rslt = dp[i+1][j+1];
		}
		else {
			int ansd,ansr,ansi;
			if(dp[i+1][j] == -1) {
				ansd = editDistanceR(dp, s, t, i+1, j);
				dp[i+1][j] = ansd;
				
			}
			else
				ansd = dp[i+1][j];
			if(dp[i+1][j+1] == -1) {
				ansr = editDistanceR(dp, s, t, i+1, j+1);
				dp[i+1][j+1] = ansr;
				
			}
			else
				ansr = dp[i+1][j+1];
			if(dp[i][j+1] == -1) {
				ansi = editDistanceR(dp, s, t, i, j+1);
				dp[i][j+1] = ansi;
				
			}
			else
				ansi = dp[i][j+1];
			
			rslt = 1 + Math.min(ansd, Math.min(ansr, ansi));
		}
		return rslt;
		
	}
	
	static int countWaysToMakeChangeI(int[][] dp, int denominations[], int value){
		
		for(int i = denominations.length-1;i >= 0;i--) {
			for(int v = 0;v <= value;v++) {
				int ans;
				if(denominations[i] <= v) {
					int ans1 = dp[i][v-denominations[i]];
					int ans2 = dp[i+1][v];
					ans  = ans1 + ans2;
				}
				else
					ans = dp[i+1][v];
				dp[i][v] = ans;
			}
		}
		return dp[0][value];
		
	}
	
	static int countWaysToMakeChangeR(int[][] dp, int denominations[], int i, int value){
		
		if(value == 0)
			return 1;
		if(i == denominations.length)
			return 0;
		
		int rslt;
		if(denominations[i] <= value) {
			int ans1,ans2;
			if(dp[i][value-denominations[i]] == -1) {
				ans1 = countWaysToMakeChangeR(dp, denominations, i, value-denominations[i]);
				dp[i][value-denominations[i]] = ans1;
			}
			else {
				ans1 = dp[i][value-denominations[i]];
			}
			if(dp[i+1][value] == -1) {
				ans2 = countWaysToMakeChangeR(dp, denominations, i+1, value);
				dp[i+1][value] = ans2;
			}
			else {
				ans2 = dp[i+1][value];
			}
			rslt = ans1 + ans2;
		}
		else {
			if(dp[i+1][value] == -1) {
				rslt = countWaysToMakeChangeR(dp, denominations, i+1, value);
				dp[i+1][value] = rslt;
			}
			else {
				rslt = dp[i+1][value];
			}
			
		}
		return rslt;

	}

	public static void main(String[] args) {
		
//		int[][] arr2d = {{3,4,1,2},{2,1,8,9},{4,7,8,1}};
//		String s = "abcd";
//		String t = "adcb";
//		int[] weights = {20,25,30};
		int[] values = {1,2,3,4,5,6};
		int maxWeight = 300;
//		int[][] dp = new int[arr2d.length+1][arr2d[0].length+1];
//		int[][] dp = new int[s.length()+1][t.length()+1];
		int[][] dp = new int[values.length+1][maxWeight+1];
//		for(int i = 0;i < dp.length;i++) {
//			for(int j = 0;j < dp[i].length;j++) {
//				dp[i][j] = Integer.MIN_VALUE; // for recursive mincost
//				dp[i][j] = Integer.MAX_VALUE; // for iterative mincost
//				dp[i][j] = -1; // for recursive lcs,knapsack,editDistance,coinChange
//				dp[i][j] = 0; // for iterative lcs,knapsack
//			}
//		}
		// for iterative edit distance;
//		for(int i = dp.length-1,j = 0;j < dp[0].length;j++) {
//			dp[i][j] = (dp[0].length-1)-j;
//		}
//		for(int i = 0,j = dp[0].length-1;i < dp.length;i++) {
//			dp[i][j] = (dp.length-1)-i;
//		}
		// for iterative coinChange
		for(int i = 0,j = 0;i < dp.length;i++) {
			dp[i][j] = 1;
		}

//		System.out.println("Minimum Cost Path Value is : " + minCostPathI(arr2d, dp));
//		System.out.println("Length of the Longest Common Subsequence is : " + lcsI(dp, s, t));
//		System.out.println("Maximum Value of the Knapsack : " + knapsackI(dp, weights, values, maxWeight));
//		System.out.println("Minimum Edit Distance is : " + editDistanceI(dp, s, t));
		System.out.println("Number of Ways to make Coin Change : " + countWaysToMakeChangeI(dp,values, maxWeight));
		
	}

}
