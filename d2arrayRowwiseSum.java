import java.util.Scanner;

public class d2arrayRowwiseSum {

	public static void rowwiseSum(int[][] mat) {
		
		if(mat.length == 0 || mat[0].length == 0) {
			System.out.print(" ");
			return;
		}
		
		int r = mat.length,c = mat[0].length;
		
		for(int i = 0;i < r;i++) {
			int sum = 0;
			for(int j = 0;j < c;j++) {
				sum += mat[i][j];
			}
			System.out.print(sum + " ");
		}
		
	}
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of rows : ");
		int rw = s.nextInt(); 
		System.out.println("Enter the number of columns : ");
		
		int clm = s.nextInt();
		int[][] arr2d = new int[rw][clm];
		
		for(int i = 0;i < arr2d.length;i++) {
			System.out.println("Enter the elements in " + i + "th row : ");
			for(int j = 0;j < arr2d[0].length;j++) {
				arr2d[i][j] = s.nextInt();
			}
		}
		
		rowwiseSum(arr2d);

	}

}
