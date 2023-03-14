import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class graph1 {
	
	static void bfsTraversalHelper(int[][] adjMatrix, boolean[] visited, int sv) {

		Queue<Integer> pending = new LinkedList<Integer>();
		visited[sv] = true;
		pending.add(sv);
		while(!pending.isEmpty()) {
			int currentVertex = pending.poll();
//			System.out.print(currentVertex + " ");// comment this line if the function is to be used for isConnected Function.
			for(int i = 0;i <adjMatrix[0].length;i++) {
				if(adjMatrix[currentVertex][i] == 1 && !visited[i]) {
					visited[i] = true;
					pending.add(i);
				}
			}
		}
		
	}
	
	static void bfsTraversal(int[][] adjMatrix) {

		boolean[] visited = new boolean[adjMatrix.length];
		for(int i = 0;i < visited.length;i++) {
			if(!visited[i]) {
				bfsTraversalHelper(adjMatrix,visited,i);
				System.out.println();
			}
		}

	}

	static void dfsTraversalHelper(int[][] adjMatrix, boolean[] visited, int currentVertex) {

		if(adjMatrix.length == 0)
			return;
//		System.out.print(currentVertex + " ");// comment this line if the function is to be used for isConnected Function.
		visited[currentVertex] = true;
		for(int i = 0;i < adjMatrix[0].length;i++) {
			if(adjMatrix[currentVertex][i] == 1 && visited[i] == false)
				dfsTraversalHelper(adjMatrix, visited, i);
		}

	}

	static void dfsTraversal(int[][] adjMatrix) {

		boolean[] visited = new boolean[adjMatrix.length];
		for(int i = 0;i < visited.length;i++) {
			if(!visited[i]) {
				dfsTraversalHelper(adjMatrix,visited,i);
				System.out.println();
			}
		}

	}
	
	static boolean hasPathBFS(int[][] adjMatrix, boolean[] visited, int v1, int v2) {
		
		if(v1 >= adjMatrix.length || v2 >= adjMatrix.length || adjMatrix.length == 0)
			return false;
		if(adjMatrix[v1][v2] == 1)
			return true;
		Queue<Integer> pending = new LinkedList<Integer>();
		visited[v1] = true;
		pending.add(v1);
		while(!pending.isEmpty()) {
			int currentVertex = pending.poll();
			for(int i = 0;i <adjMatrix[0].length;i++) {
				if(adjMatrix[currentVertex][i] == 1 && !visited[i]) {
					if(i == v2)
						return true;
					else {
						visited[i] = true;
						pending.add(i);
					}
				}
			}
		}
		return false;
		
	}
	
	static boolean hasPathDFS(int[][] adjMatrix, boolean[] visited, int v1, int v2) {
		
		if(v1 >= adjMatrix.length || v2 >= adjMatrix.length || adjMatrix.length == 0)
			return false;
		if(adjMatrix[v1][v2] == 1)
			return true;
		visited[v1] = true;
		boolean rslt = false;
		for(int i = 0;i < adjMatrix[0].length;i++) {
			if(adjMatrix[v1][i] == 1 && visited[i] == false) {
				if(i == v2)
					return true;
				if(hasPathDFS(adjMatrix, visited, i, v2)) {
					rslt = true;
					break;
				}
			}
		}
		return rslt;
		
	}
	
	static boolean hasPath(int[][] adjMatrix, int v1, int v2) {
		
		if(adjMatrix[v1][v2] == 1) {
			return true;
		}
		else {
			boolean[] visited = new boolean[adjMatrix.length];
			return hasPathDFS(adjMatrix,visited,v1,v2);
//			return hasPathBFS(adjMatrix,visited,v1,v2);
		}
		
	}
	
	static ArrayList<Integer> getPathBFS(int[][] adjMatrix, boolean[] visited, int v1, int v2) {
		
		if(v1 >= adjMatrix.length || v2 >= adjMatrix.length || adjMatrix.length == 0)
			return null;
		if(adjMatrix[v1][v2] == 1) {
			ArrayList<Integer> rslt = new ArrayList<>();
			rslt.add(v2);
			rslt.add(v1);
			return rslt;
		}
		Queue<Integer> pending = new LinkedList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<>();
		visited[v1] = true;
		pending.add(v1);
		map.put(v1, -1);
		while(!pending.isEmpty()) {
			int currentVertex = pending.poll();
			for(int i = 0;i <adjMatrix[0].length;i++) {
				if(adjMatrix[currentVertex][i] == 1 && !visited[i]) {
					visited[i] = true;
					pending.add(i);
					map.put(i, currentVertex);
					if(i == v2) {
						ArrayList<Integer> rslt = new ArrayList<>();
						int x = i;
						System.out.println("X : " + x);
						while(x != -1) {
							
							rslt.add(x);
							x = map.get(x);
						}
						return rslt;
					}
				}
			}
		}
		return null;
		
	}
	
	static ArrayList<Integer> getPathDFS(int[][] adjMatrix, boolean[] visited, int v1, int v2) {
		
		if(v1 == v2) {
			ArrayList<Integer> rslt = new ArrayList<>();
			rslt.add(v1);
			return rslt;
		}
		
		visited[v1] = true;
		ArrayList<Integer> rslt = null;
		for(int i = 0;i < adjMatrix.length;i++) {
			if(adjMatrix[v1][i] == 1 && visited[i] == false) {
				rslt = getPathDFS(adjMatrix, visited, i, v2);
				if(rslt != null) {
					rslt.add(v1);
					break;
				}
			}
		}
		return rslt;
		
	}
	
	static ArrayList<Integer> getPath(int[][] adjMatrix, int v1, int v2) {
		
		boolean[] visited = new boolean[adjMatrix.length];
//		return getPathDFS(adjMatrix,visited,v1,v2);
		return getPathBFS(adjMatrix,visited,v1,v2);
		
	}
	
	static boolean isConnected(int[][] adjMatrix) {
		
		if(adjMatrix.length == 0)
			return false;
		boolean[] visited = new boolean[adjMatrix.length];
//		dfsTraversalHelper(adjMatrix,visited,0); // comment the print statement in <- function while using it here.
		bfsTraversalHelper(adjMatrix,visited,0); // comment the print statement in <- function while using it here.
		for(boolean b : visited) {
			if(b)
				continue;
			return false;
		}
		return true;
	}
	
	static ArrayList<Integer> allComponentsBFS(int[][] adjMatrix, boolean[] visited, ArrayList<Integer> output, int sv) {

		Queue<Integer> pending = new LinkedList<Integer>();
		visited[sv] = true;
		pending.add(sv);
		while(!pending.isEmpty()) {
			int currentVertex = pending.poll();
			for(int i = 0;i <adjMatrix[0].length;i++) {
				if(adjMatrix[currentVertex][i] == 1 && !visited[i]) {
					visited[i] = true;
					output.add(i);
					pending.add(i);
				}
			}
		}
		return output;
		
	}
	
	static ArrayList<Integer> allComponentsDFS(int[][] adjMatrix, boolean[] visited, ArrayList<Integer> output, int currentVertex) {

		if(adjMatrix.length == 0)
			return null;
		output.add(currentVertex);
		visited[currentVertex] = true;
		for(int i = 0;i < adjMatrix[0].length;i++) {
			if(adjMatrix[currentVertex][i] == 1 && visited[i] == false)
				output = allComponentsDFS(adjMatrix, visited,output, i);
		}
		return output;

	}
	
	static void allComponents(int[][] adjMatrix) {
		
		if(adjMatrix.length == 0)
			return;
		boolean[] visited = new boolean[adjMatrix.length];
		for(int i = 0;i < visited.length;i++) {
			if(!visited[i]) {
				ArrayList<Integer> output = new ArrayList<>();
				output = allComponentsDFS(adjMatrix,visited,output,i);
				output = allComponentsBFS(adjMatrix,visited,output,i);
				Collections.sort(output);
				for(int j : output)
					System.out.print(j + " ");
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of Vertices and Edges : ");
		int v = s.nextInt();
		int e = s.nextInt();
		if(v == 0)
			return;
		int[][] adjMatrix = new int[v][v];
		if(e > 0)
			System.out.println("Start Entering the Edges as Vertex1-Vertex2 : ");
		for(int i = 0;i < e;i++) {
			int v1 = s.nextInt();
			int v2 = s.nextInt();
			adjMatrix[v1][v2] = 1;
			adjMatrix[v2][v1] = 1;
		}
//		for(int i = 0;i < v;i++) {
//			for(int j = 0;j < v;j++) {
//				System.out.print(adjMatrix[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("DFS Traversal : ");
//		dfsTraversal(adjMatrix);
//		System.out.println("BFS Traversal : ");
//		bfsTraversal(adjMatrix);
//		System.out.println("Enter the two vertices : ");
//		int v1 = s.nextInt();
//		int v2 = s.nextInt();
//		System.out.println("Status of Path's Existence : " + hasPath(adjMatrix,v1,v2));
//		ArrayList<Integer> rslt = getPath(adjMatrix,v1,v2);
//		if(rslt != null) {
//			System.out.println("Path from " + v1 + " to " + v2 + " is : ");
//			System.out.println(rslt);
//		}
//		System.out.println("Status of the Graph being Connected : " + isConnected(adjMatrix));
//		System.out.println("All Components of the Graph are : ");
//		allComponents(adjMatrix); // adjacency List solution on net this is matirx one.
		
	}

}
