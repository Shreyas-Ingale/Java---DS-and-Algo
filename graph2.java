import java.util.*;

public class graph2 {
	
	static void dfsTraversalHelper(int[][] adjMatrix, boolean[] visited, int currentVertex) {

		if(adjMatrix.length == 0)
			return;
		visited[currentVertex] = true;
		for(int i = 0;i < adjMatrix[0].length;i++) {
			if(adjMatrix[currentVertex][i] == 1 && visited[i] == false)
				dfsTraversalHelper(adjMatrix, visited, i);
		}

	}
	
	static int numConnected(int[][] adjMatrix) {
		
		int count = 0;
		boolean[] visited = new boolean[adjMatrix.length];
		for(int i = 0;i < visited.length;i++) {
			if(!visited[i]) {
				dfsTraversalHelper(adjMatrix,visited,i);// can also be done with bfs.
				count++;
			}
		}
		return count;
		
	}
	
	static boolean solveCNHelper(String[] graph, boolean[][] visited, int r, int c, String goal) {
		
		if(goal.length() == 0)
			return true; 
		if(r < 0 || r >= graph.length || c < 0 || c >= graph[0].length() || visited[r][c] || graph[r].charAt(c) != goal.charAt(0))
			return false;
		int[] rStep = {-1,-1,0,1,1,1,0,-1};
		int[] cStep = {0,1,1,1,0,-1,-1,-1};
		visited[r][c] = true;
		for(int i = 0;i < rStep.length;i++) {
			boolean rslt = solveCNHelper(graph, visited, r+rStep[i], c+cStep[i], goal.substring(1));
			if(rslt)
				return true;
		}
		visited[r][c] = false;
		return false;
		
	}
	
	static int solveCN(String[] graph , int n, int m) {
		
		if(n == 0 || m == 0)
			return 0;
		boolean[][] visited = new boolean[n][m];
		String goal = "CODINGNINJA";
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < m;j++) {
				if(graph[i].charAt(j) == goal.charAt(0)) {
					boolean rslt = solveCNHelper(graph,visited,i,j,goal.substring(0));
					if(rslt)
						return 1;
				}
			}
		}
		return 0;
		
	}
	
	static boolean connectingDotsHelper(String[] board, boolean[][] visited, int cnt, int or,int oc, int r, int c) {
		
		if(r >= 0 && r < board.length && c >= 0 && c < board[0].length() && r == or && c == oc && cnt >= 4)
			return true;
		if(r < 0 || r >= board.length || c < 0 || c >= board[0].length() || visited[r][c] || board[r].charAt(c) != board[or].charAt(oc))
			return false;
        int[] rStep = {-1, 0, 1, 0}; // No Diagonal Directions Allowed...
        int[] cStep = {0, 1, 0, -1};
		visited[r][c] = true;
		cnt++;
		for(int i = 0;i < rStep.length;i++) {
			boolean rslt = connectingDotsHelper(board, visited, cnt, or, oc, r+rStep[i], c+cStep[i]);
			if(rslt)
				return true;
		}
		visited[r][c] = false;
		return false;
		
	}
	
	static int connectingDots(String[] board, int n, int m) {
		
		if(n == 0 || m == 0)
			return 0;
		boolean[][] visited = new boolean[n][m];
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < m;j++) {
				int cnt = 0;
				boolean rslt = connectingDotsHelper(board, visited, cnt, i, j, i, j);
				if(rslt)
					return 1;
			}
		}
		return 0;
		
	}
	
	static int largestPieceHelper(String[] edge, boolean[][] visited, int r, int c) {
		
		if(r < 0 || r > edge.length-1 || c < 0 || c > edge[0].length()-1 || visited[r][c] || edge[r].charAt(c) != '1')
			return 0;
        int[] rStep = {-1, 0, 1, 0}; // No Diagonal Directions Allowed...
        int[] cStep = {0, 1, 0, -1};
        visited[r][c] = true;
		int rslt = 1;
		for(int i = 0;i < rStep.length;i++) {
			rslt += largestPieceHelper(edge, visited, r+rStep[i], c+cStep[i]);
		}
		return rslt;
		
	}
	
	static int largestPiece(String[] edge, int n) {
		
		if(edge.length == 0 || edge[0].length() == 0)
			return 0;
		int max = 0;
		boolean[][] visited = new boolean[n][n];
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < n;j++) {
                if (visited[i][j] == false && edge[i].charAt(j) == '1') {
                	max = Math.max(max, largestPieceHelper(edge, visited, i, j));
                }
			}
		}
		return max;
		
	}
	
	static int threeCycle(int[][] adjMatrix, int n) {
		
		if(adjMatrix.length == 0)
			return 0;
		
		int count = 0;
		for(int i = 0;i < adjMatrix.length;i++) {
			for(int j = i+1;j < adjMatrix.length;j++) {
				if(adjMatrix[i][j] == 1) {
					for(int k = j+1;k < adjMatrix.length;k++) {
						if(adjMatrix[j][k] == 1 && adjMatrix[i][k] == 1)
							count++;
					}
				}
			}
		}
		
		return count;
		
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of Vertices and Edges : ");
//		System.out.println("Enter the number of lines or words : ");
		int v = s.nextInt();
		int e = s.nextInt();
		if(v == 0)
			return;
		int[][] adjMatrix = new int[v][v];
//		String[] graph = new String[v];
		if(e > 0)
			System.out.println("Start Entering the Edges as Vertex1-Vertex2 : ");
//		System.out.println("Start Entering the lines or words : ");
		for(int i = 0;i < e;i++) {
			int v1 = s.nextInt();
			int v2 = s.nextInt();
			adjMatrix[v1][v2] = 1;
			adjMatrix[v2][v1] = 1;
		}
//		for(int i = 0;i < v;i++)
//			graph[i] = s.next();
		
//		System.out.println("Number of Connected Groups of Islands are : " + numConnected(adjMatrix));
//		System.out.println("Status of a Path's existence which makes CODINGNINJA : " + solveCN(graph,v,graph[0].length()));
//		System.out.println("Status of a Cycle's existence : " + connectingDots(graph,v,graph[0].length()));
//		System.out.println("Count of 1's in the Biggest Piece : " + largestPiece(graph, v));
		System.out.println("Number of 3-Cycles in the Graph are : " + threeCycle(adjMatrix,v));

	}

}
