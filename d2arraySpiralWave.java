import java.util.Scanner;

public class d2arraySpiralWave {

	public static void printSpiralWave(int[][] mat) {
		
		if(mat.length == 0) {
			return;
		}

		int lr_ord = 0,tb_ord = 0,r = mat.length,c = mat[0].length;
		int lt = 0,rt = 0,tp = 0,bm = 0;

		for (int lp = 0;lp < r; lp++) {
			if(lr_ord == 0) {
				for(int i = 0 + lt;i < c - rt;i++) {
					System.out.print(mat[tp][i] + " ");
				}
				tp++;
				lr_ord = 1;
			}
			else{
				for(int i = c - 1 - rt;i >= lt;i--) {
					System.out.print(mat[r-1-bm][i] + " ");
				}
				bm++;
				lr_ord = 0;
			}
			if(tb_ord == 0) {
				for(int i = 0 + tp;i < r - bm;i++) {
					System.out.print(mat[i][c-1-rt] + " ");
				}
				rt++;
			    tb_ord = 1;
			}
			else{
				for(int i = r - 1 - bm;i >= tp;i--) {
					System.out.print(mat[i][lt] + " ");
				}
				lt++;
				tb_ord = 0;
			}
		}

		
	}
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of rows and columns : ");
		int rw = s.nextInt(); 
		int clm = s.nextInt();
		int[][] arr2d = new int[rw][clm];
		
		for(int i = 0;i < arr2d.length;i++) {
			System.out.println("Enter the elements in " + i + "th row : ");
			for(int j = 0;j < arr2d[0].length;j++) {
				arr2d[i][j] = s.nextInt();
			}
		}
		
		printSpiralWave(arr2d);

	}

}