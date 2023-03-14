import java.util.Scanner;

public class d2arrayLargestSum {

	public static void findLargest(int mat[][]){
		
		if(mat.length == 0 || mat[0].length == 0) {
			System.out.print("row 0 " + Integer.MIN_VALUE);
			return;
		}
		
		int r = mat.length,c = mat[0].length;
		int lr = 0,lc = 0,lsr = Integer.MIN_VALUE,lsc = Integer.MIN_VALUE;
		
		for(int i = 0;i < r;i++) {
			int sum = 0;
			for(int j = 0;j < c;j++) {
				sum += mat[i][j];
			}
			if(lsr < sum) {
				lsr = sum;
				lr = i;
			}
		}
		
		for(int i = 0;i < c;i++) {
			int sum = 0;
			for(int j = 0;j < r;j++) {
				sum += mat[j][i];
			}
			if(lsc < sum) {
				lsc = sum;
				lc = i;
			}
		}
		
		if(lsr >= lsc)
			System.out.println("row " + lr + " " + lsr);
		else
			System.out.println("column " + lc + " " + lsc);
		
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
		
		findLargest(arr2d);

	}

}
