import java.util.Scanner;

public class d2arrayTotalSum {

	public static void totalSum(int[][] mat) {
		int sum = 0,n = mat.length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j || (i + j) == n - 1) {
					sum += mat[i][j];
				}
				else if (i == 0 || j == 0 || i == n - 1|| j == n - 1) {
					sum += mat[i][j];
				}
			}
		}

		System.out.println(sum);
	}
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the size of nxn 2dArray : ");
		int n = s.nextInt(); 
		int[][] arr2d = new int[n][n];
		
		for(int i = 0;i < n;i++) {
			System.out.println("Enter the elements in " + i + "th row : ");
			for(int j = 0;j < n;j++) {
				arr2d[i][j] = s.nextInt();
			}
		}
		
		totalSum(arr2d);

	}

}
