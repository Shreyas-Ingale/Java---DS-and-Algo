import java.util.Scanner;

class othelloBoard{
	
	private int[][] board;
	private final static int p1Symbol = 1;
	private final static int p2Symbol = 2;
	private static int[] xDir = {-1,-1,0,1,1,1,0,-1};
	private static int[] yDir = {0,1,1,1,0,-1,-1,-1};
	
	public othelloBoard() {
		board = new int[8][8];
		board[3][3] = p1Symbol;
		board[4][4] = p1Symbol;
		board[3][4] = p2Symbol;
		board[4][3] = p2Symbol;
	}
	
	boolean move(int symbol, int x, int y) {
		
		if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 0)
			return false;
		boolean isValid = false;
		for(int i = 0;i < 8;i++) {
			int xStep = xDir[i];
			int yStep = yDir[i];
			int count = 0;
			int r = x + xStep;
			int c = y + yStep;
			while(r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] != symbol && board[r][c] != 0) {
				count++;
				r = r + xStep;
				c = c + yStep;
			}
			if(count != 0 && (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[r][c] != symbol))
				count = 0;
			if(count == 0)
				continue;
			else {
				for(r = x,c = y;count >= 0;count--,r += xStep,c += yStep) {
					board[r][c] = symbol;
				}
				isValid = true;
			}
		}
		return isValid;
		
	}
	
	void print() {
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
}

public class classOthello {

	private final static int p1Symbol = 1;
	private final static int p2Symbol = 2;

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		othelloBoard ob = new othelloBoard();
		int n = s.nextInt();
		boolean p1Turn = true;
		while(n > 0) {
			int x = s.nextInt();
			int y = s.nextInt();
			boolean ans = false;
			if(p1Turn) {
				ans = ob.move(p1Symbol, x, y);
			}
			else {
				ans = ob.move(p2Symbol, x, y);
			}
			if(ans) {
				ob.print();
				p1Turn = !p1Turn;
				n--;
			}
			else {
				System.out.println(ans);
			}
		}

	}

}
