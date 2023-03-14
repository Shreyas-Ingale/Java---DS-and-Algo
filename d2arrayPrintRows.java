import java.util.Scanner;

public class d2arrayPrintRows {

	public static void printRows(int[][] mat) {
		
		if(mat.length == 0) {
			return;
		}
		
		int r = mat.length,c = mat[0].length;
		
		for(int i = 0;i < r;i++) {
			for(int k = r - i;k > 0;k--) {
				for(int j = 0;j < c;j++) {
					System.out.print(mat[i][j] + " ");
				}
				System.out.println();
			}
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
		
		printRows(arr2d);

	}

}
