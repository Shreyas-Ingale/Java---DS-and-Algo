import java.util.*;

public class dynamicProgramming21 {
	
	static int findMaxSquareWithAllZerosI(int[][] input, int[][] assist){

		for(int i = 1;i < input.length;i++) {
			for(int j = 1;j < input[0].length;j++) {
				if(input[i][j] == 1) {
					assist[i][j] = 0;
					continue;
				}
				else {
					if(assist[i-1][j] != 0 && assist[i-1][j-1] != 0 && assist[i][j-1] != 0) {
						int ans = 1 + Math.min(assist[i-1][j], Math.min(assist[i-1][j-1], assist[i][j-1]));
						assist[i][j] = ans;
					}
					else
						assist[i][j] = 1;
				}
			}
		}
		int max = 0;
		for(int i = 0;i < assist.length;i++) {
			for(int j = 0;j < assist[0].length;j++) {
				if(assist[i][j] > max)
					max = assist[i][j];
			}
		}
				
		return max;
		
	}
	
	static int smallestSuperSequenceI(int[][] dp,String s, String t) {
		
		for(int i = s.length()-1;i >= 0;i--) {
			for(int j = t.length()-1;j >= 0;j--) {
				int rslt;
				if(s.charAt(i) == t.charAt(j)) {
					rslt = 1 + dp[i+1][j+1];
				}
				else {
					int ans1 = dp[i+1][j];
					int ans2 = dp[i][j+1];
					rslt = 1 + Math.min(ans1, ans2);
				}
				dp[i][j] = rslt;
			}
		}
		return dp[0][0];
		
		
	}
	
	static int smallestSuperSequenceR(int[][] dp,String s, String t, int i, int j) {
		
		if(i == s.length())
			return t.length()-j;
		if(j == t.length())
			return s.length()-i;
		
		int rslt;
		if(s.charAt(i) == t.charAt(j)) {
			int ans;
			if(dp[i+1][j+1] == -1) {
				ans = smallestSuperSequenceR(dp, s, t, i+1, j+1);
				dp[i+1][j+1] = ans;
			}
			else
				ans = dp[i+1][j+1];
			rslt = 1 + ans;
		}
		else {
			int ans1,ans2;
			if(dp[i][j+1] == -1) {
				ans1 = smallestSuperSequenceR(dp, s, t, i, j+1);
				dp[i][j+1] = ans1;
			}
			else
				ans1 = dp[i][j+1];
			if(dp[i+1][j] == -1) {
				ans2 = smallestSuperSequenceR(dp, s, t, i+1, j);
				dp[i+1][j] = ans2;
			}
			else
				ans2 = dp[i+1][j];
			
			rslt = 1 + Math.min(ans1, ans2);
		}
		return rslt;
		
	}
	
	static int getMinimumStrengthI(int[][] dp, int[][] grid) {
		
		dp[grid.length-1][grid[0].length-1] = 1;
		for(int i = grid.length-1;i >= 0;i--) {
			for(int j = grid[0].length-2;j >= 0;j--) {
				int ansd,ansr,ans;
				ansd = dp[i+1][j];
				ansr = dp[i][j+1];
				ans = Math.min(ansd, ansr) - grid[i][j];
				dp[i][j] = (ans <= 0 ? 1 : ans);
			}
		}
		return dp[0][0];
	}
	
	static int getMinimumStrengthR(int[][] dp, int[][] grid,int r,int c) {
		
		dp[grid.length-1][grid[0].length-1] = 1;
		int ansd,ansr,rslt;
		if(dp[r+1][c] == Integer.MIN_VALUE) { 
			ansd = getMinimumStrengthR(dp, grid, r + 1, c);
			dp[r+1][c] = ansd;
		}
		else
			ansd = dp[r+1][c];
		if(dp[r][c+1] == Integer.MIN_VALUE) { 
			ansr = getMinimumStrengthR(dp, grid, r, c + 1);
			dp[r][c+1] = ansr;
		}
		else
			ansr = dp[r][c+1];
		
		
		rslt = Math.min(ansd, ansr) - grid[r][c];
		
		return rslt <= 0 ? 1 : rslt;
		
	}
	
	static int getMinI(int arr[]){
		
		int[] assist = new int[arr.length];
        Arrays.fill(assist, 1);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                assist[i] = assist[i - 1] + 1;
            }
        }
        int sum = assist[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                assist[i] = Math.max(assist[i], assist[i + 1] + 1);
            }
            sum += assist[i];
        }
        return sum;
		
	}
	
	static boolean isSubsetPresentI(boolean[][]dp, int[] arr, int sum) {
		
		for(int i = 0;i <= arr.length;i++) {
			dp[i][0] = true;
		}
		for (int i = 1; i <= sum; i++) {
            dp[0][i] = false;
        }
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j < arr[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        boolean result = dp[arr.length][sum];
        return result;
		
	}
	
    static boolean isSubsetPresentR(int[][]dp, int[] arr, int si, int sum) {
    	
    	if(si == arr.length && sum != 0)
    		return false;
    	if(sum == 0)
    		return true;
    	
    	boolean ans1 = false,ans2;
    	
    	if(sum-arr[si] >= 0) {
    		if(dp[si+1][sum-arr[si]] == -1) {
    			ans1 = isSubsetPresentR(dp, arr, si+1, sum-arr[si]);
    			dp[si+1][sum-arr[si]] = ans1 ? 1 : 0;
    		}
    		else {
    			ans1 = (dp[si+1][sum-arr[si]] == 1) ? true : false;
    		}
    	}
    	if(dp[si+1][sum] == -1) {
    		ans2 = isSubsetPresentR(dp, arr, si+1, sum);
    		dp[si+1][sum] = ans2 ? 1 : 0;
    	}
    	else {
    		ans2 = (dp[si+1][sum] == 1) ? true : false;
    	}
    	
    	return ans1 || ans2;
    	
    }

	
	public static void main(String[] args) {
		
//		int[][] input = {{0,1,-3},{1,-2,0}};
//		String s = "pqqrpt";
//		String t = "qerepct";
		int[] arr = {4,8,23,67,4,56,21};
		int k = new Scanner(System.in).nextInt();
//		int[][] dp = new int[arr.length+1][k+1]; // recursive subset
		boolean[][] dp = new boolean[arr.length+1][k+1];
		for(int i = 0;i < dp.length;i++)
			Arrays.fill(dp[i], false);
//		int[][] dp = new int[input.length][input[0].length];// max square
//		for(int i = 0,j = 0;i < input.length;i++)
//			dp[i][j] = input[i][j] ^ 1;
//		for(int i = 0,j = 0;j < input[0].length;j++)
//			dp[i][j] = input[i][j] ^ 1;
//		int[][] dp = new int[s.length()+1][t.length()+1];
//		for(int i = 0;i < dp.length;i++)
//			Arrays.fill(dp[i], -1);   // recursive superSequence
		  // iterative superSequence
//		for(int i = dp.length-1,j = 0;j < dp[0].length;j++) {
//			dp[i][j] = (dp[0].length-1)-j;
//		}
//		for(int i = 0,j = dp[0].length-1;i < dp.length;i++) {
//			dp[i][j] = (dp.length-1)-i;
//		}
		 // Strength point
//		int[][] dp = new int[input.length+1][input[0].length+1];
//		for(int i = 0;i < dp.length;i++)
//			Arrays.fill(dp[i], Integer.MIN_VALUE);
//		for(int i = input.length,j = 0;j < input[0].length-1;j++)
//			dp[i][j] = Integer.MAX_VALUE;
//		for(int i = 0,j = input[0].length;i < input.length-1;i++)
//			dp[i][j] = Integer.MAX_VALUE;
		
		// recursive version is too complex and more importantly has O(n^5) time complexity
//		System.out.println("Size of maximum square sub-matrix is : " + findMaxSquareWithAllZerosI(input, assist));
//		System.out.println("Length of the smallest super-sequence is : " + smallestSuperSequenceI(dp, s, t));
//		System.out.println("Minimum number of Strength Points to start with are : " + getMinimumStrengthI(dp, input));
//		System.out.println("Minimum number of Chocolates required are : " + getMinI(arr));
		System.out.println("Status of existence of a subset that sums upto " + k + " : " + isSubsetPresentI(dp,arr, k));
		
	}
	
}
