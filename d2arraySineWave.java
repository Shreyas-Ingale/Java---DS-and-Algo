import java.util.Scanner;

public class d2arraySineWave {

	public static void printSineWave(int[][] mat) {
		
		if(mat.length == 0) {
			return;
		}
		
		int ord = 0,r = mat.length,c = mat[0].length;

		for (int j = 0;j < c; j++) {
			if(ord == 0) {
				for(int i = 0;i < r;i++) {
					System.out.print(mat[i][j] + " ");
					ord = 1;
				}
			}
			else{
				for(int i = r-1;i >= 0;i--) {
					System.out.print(mat[i][j] + " ");
					ord = 0;
				}
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
		
		printSineWave(arr2d);

	}

}



