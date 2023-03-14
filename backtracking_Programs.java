
public class backtracking_Programs {
	
	private static boolean ratInAMazeHelper(int maze[][], int path[][], int r, int c){
		
		if(r < 0 || r >= maze.length || c < 0 || c >= maze.length) {
			return false;
		}
		if(maze[r][c] == 0 || path[r][c] == 1) {
			return false;
		}
		
		path[r][c] = 1;
		if((r == maze.length - 1 ) && (c == maze.length - 1)) {
			return true;
		}
		
		if(ratInAMazeHelper(maze, path, r, c+1)) // left
			return true;
		if(ratInAMazeHelper(maze, path, r+1, c)) // bottom
			return true;
		if(ratInAMazeHelper(maze, path, r, c-1)) // right
			return true;
		if(ratInAMazeHelper(maze, path, r-1, c)) // top
			return true;
		
		return false;
		
	}
	
	static boolean ratInAMaze(int maze[][]){
		
		int[][] path = new int[maze.length][maze.length];
		return ratInAMazeHelper(maze,path,0,0);
		
	}
	
	private static void printRatInAMazeHelper(int[][] maze, int[][] path, int r, int c) {
		
		if(r < 0 || r >= maze.length || c < 0 || c >= maze.length) {
			return;
		}
		if(maze[r][c] == 0 || path[r][c] == 1) {
			return;
		}
		
		path[r][c] = 1;
		if((r == maze.length - 1 ) && (c == maze.length - 1)) {
			for(int i = 0;i < path.length;i++) {
				for(int j = 0 ;j < path.length;j++) {
					System.out.print(path[i][j] + " ");
				}
			}
			System.out.println();
			path[r][c] = 0;
			return;
		}

		printRatInAMazeHelper(maze, path, r-1, c); // top
		
		printRatInAMazeHelper(maze, path, r+1, c); // bottom
		
		printRatInAMazeHelper(maze, path, r, c-1);// left
		
		printRatInAMazeHelper(maze, path, r, c+1); // right

		path[r][c] = 0;
		
	}
	
	static void printRatInAMaze(int maze[][], int n) {
		
		int[][] path = new int[maze.length][maze.length];
		printRatInAMazeHelper(maze,path,0,0);
		
	}
	
	private static boolean isSafe(int[][] board, int n, int r, int c) {
		
		for(int i = 0;i < n;i++) {
			if(board[i][c] == 1)
				return false;
		}
		
		for(int i = r,j = c;i >=0 && j < n;i--,j++) {
			if(board[i][j] == 1)
				return false;
		}
		
		for(int i = r,j = c;i >=0 && j >= 0;i--,j--) {
			if(board[i][j] == 1)
				return false;
		}
		
		return true;
		
	}
	
	private static void placeNQueensHelper(int[][] board, int n, int r, int c) {

		if(r == n) {
			for(int i = 0;i < n;i++) {
				for(int j = 0;j < n;j++)
					System.out.print(board[i][j] + " ");
			}
			System.out.println();
			for(int i = 0;i < n;i++)
				board[r-1][i] = 0;
			return;
		}
		
		for(int i = 0;i < n;i++) {
			if(isSafe(board, n, r, i)) {
				board[r][i] = 1;
				placeNQueensHelper(board, n, r+1, 0);
				board[r][i] = 0;
			}
		}
			
	}
	
	static void placeNQueens(int n){
		
		int[][] board = new int[n][n];
		placeNQueensHelper(board,n,0,0);
		
	}

	public static void main(String[] args) {

//		int[][] maze = {{1,1,1},{1,1,0},{0,1,1}};
//		System.out.println("Status of path's existence : " + ratInAMaze(maze));
//		System.out.println("All the possible paths are : ");
//		printRatInAMaze(maze, maze.length);
//		System.out.println("All the possible solutions are : ");
//		placeNQueens(4);

	}

}
