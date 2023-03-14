import java.util.*;

class Edge implements Comparable<Edge>{
	
	int v1;
	int v2;
	int weight;
	
	public Edge(int v1, int v2, int weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}
	
	public int compareTo(Edge other) {
		return this.weight - other.weight;
	}
	
}

class PairAL<U,V> {
	
	U v2;
	V weight;
	public PairAL(U s, V t) {
		this.v2 = s;
		this.weight = t;
	}
	
}


class Subset {
	
	int parent;
	int rank;
	
	public Subset(int parent, int rank) {
		this.parent = parent;
		this.rank = rank;
			
	}
	
}



public class graph3 {
	
	
	private static int find(int v, Subset[] subsets/*int[] parent*/) {

//		if(v == parent[v])
//			return v;
//		return find(parent[v], parent);
		
		if(subsets[v].parent != v) {
			subsets[v].parent = find(subsets[v].parent, subsets); 
		}
		return subsets[v].parent;
		
	}
	
	private static void union(int v1Parent, int v2Parent, Subset[] subsets) {

		int v1Root = find(v1Parent, subsets);
		int v2Root = find(v2Parent, subsets);
		
		if(subsets[v1Root].rank < subsets[v2Root].rank)
			subsets[v1Root].parent = v2Root;
		else if(subsets[v2Root].rank < subsets[v1Root].rank)
			subsets[v2Root].parent = v1Root;
		else {
			subsets[v1Root].parent = v2Root;
			subsets[v2Root].rank++;
		}
		
	}
	
	static Edge[] kruskalMST(Edge[] edgeList, int v, int e) {
		
		int count = 0,i = 0;
		Edge[] rslt = new Edge[v-1];
		
//		int[] parent = new int[v];
//		for(int j = 0;j < v;j++)
//			parent[j] = j;
		// better version than parent[];
		Subset[] subsets = new Subset[v]; 
		for(int j = 0;j < v;j++)
			subsets[j] = new Subset(j, 0);
		
		while(count != v-1) {
			Edge currEdge = edgeList[i++];
			int v1Parent = find(currEdge.v1,subsets/*parent*/);
			int v2Parent = find(currEdge.v2,subsets/*parent*/);
			if(v1Parent != v2Parent) {
				rslt[count++] = currEdge;
//				parent[v1Parent] = v2Parent;
				union(v1Parent,v2Parent,subsets);
			}
		}
		return rslt;
		
	}
	
	private static int findMinimumVertex(boolean[] visited,int[] quantity) {

		int minVertex = -1;
		for(int i = 0;i < quantity.length;i++) {
			if(!visited[i] && (minVertex == -1 || quantity[i] < quantity[minVertex])) {
				minVertex = i;
			}
		}
		return minVertex;
		
	}
	
	static Edge[] primMST(ArrayList<LinkedList<PairAL<Integer,Integer>>> adjList, int v, int e) {

		Edge[] rslt = new Edge[v-1];
		int[] parent = new int[v];
		Arrays.fill(parent, -1); 
		int[] weight = new int[v];
		Arrays.fill(weight, Integer.MAX_VALUE);
		weight[0] = 0;
		boolean[] visited = new boolean[v];
		for(int i = 0;i < v;i++) {
			int currVertex = findMinimumVertex(visited,weight);
			visited[currVertex] = true;
			for(int j = 0;j < adjList.get(currVertex).size();j++) {
				if(!visited[adjList.get(currVertex).get(j).v2] && adjList.get(currVertex).get(j).weight > 0) {
					if(weight[adjList.get(currVertex).get(j).v2] > adjList.get(currVertex).get(j).weight) {
						weight[adjList.get(currVertex).get(j).v2] = adjList.get(currVertex).get(j).weight;
						parent[adjList.get(currVertex).get(j).v2] = currVertex;
					}
				}
			}
		}
		for(int i = 1;i < v;i++) {
			rslt[i-1] = new Edge(i, parent[i], weight[i]);
		}
		return rslt;
		
	}
	
	/*static Edge[] primMST(int[][] adjMatrix, int v, int e) {

		Edge[] rslt = new Edge[v-1];
		int[] parent = new int[v];
		Arrays.fill(parent, -1); 
		int[] weight = new int[v];
		Arrays.fill(weight, Integer.MAX_VALUE);
		weight[0] = 0;
		boolean[] visited = new boolean[v];
		for(int i = 0;i < v;i++) {
			int currVertex = findMinimumVertex(visited,weight);
			visited[currVertex] = true;
			for(int j = 0;j < v;j++) {
				if(!visited[j] && adjMatrix[currVertex][j] > 0) {
					if(weight[j] > adjMatrix[currVertex][j]) {
						weight[j] = adjMatrix[currVertex][j];
						parent[j] = currVertex;
					}
				}
			}
		}
		for(int i = 1;i < v;i++) {
			rslt[i-1] = new Edge(i, parent[i], weight[i]);
		}
		return rslt;
		
	}*/
	
	static void dijkstraMST(ArrayList<LinkedList<PairAL<Integer,Integer>>> adjList, int v, int e) {

		int[] distance = new int[v];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[0] = 0;
		boolean[] visited = new boolean[v];
		for(int i = 0;i < v-1;i++) {
			int currVertex = findMinimumVertex(visited,distance);
			visited[currVertex] = true;
			for(int j = 0;j < adjList.get(currVertex).size();j++) {
				if(!visited[adjList.get(currVertex).get(j).v2] && adjList.get(currVertex).get(j).weight > 0 && adjList.get(currVertex).get(j).weight < Integer.MAX_VALUE) {
					int distanceViaCV = distance[currVertex] + adjList.get(currVertex).get(j).weight;
					if(distanceViaCV < distance[adjList.get(currVertex).get(j).v2]) {
						distance[adjList.get(currVertex).get(j).v2] = distanceViaCV;
					}
				}
			}
		}
		for(int i = 0;i < v;i++) {
			System.out.println(i + " " + distance[i]);
		}
			
	}
	
	/*static void dijkstraMST(int[][] adjMatrix, int v, int e) {

		int[] distance = new int[v];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[0] = 0;
		boolean[] visited = new boolean[v];
		for(int i = 0;i < v-1;i++) {
			int currVertex = findMinimumVertex(visited,distance);
			visited[currVertex] = true;
			for(int j = 0;j < v;j++) {
				if(!visited[j] && adjMatrix[currVertex][j] > 0 && adjMatrix[currVertex][j] < Integer.MAX_VALUE) {
					int distanceViaCV = distance[currVertex] + adjMatrix[currVertex][j];
					if(distanceViaCV < distance[j]) {
						distance[j] = distanceViaCV;
					}
				}
			}
		}
		for(int i = 0;i < v;i++) {
			System.out.println(i + " " + distance[i]);
		}
			
	}*/

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of Vertices and Edges resp. : ");
		int v = sc.nextInt();
		int e = sc.nextInt();
		if(e == 0 || v == 0)
			return;
//		Edge[] edgeList = new Edge[e];
//		int[][] adjMatrix = new int[v][v];
		ArrayList<LinkedList<PairAL<Integer,Integer>>> adjList = new ArrayList<LinkedList<PairAL<Integer,Integer>>>(v);
		for(int i = 0;i < v;i++) {
			adjList.add(new LinkedList<PairAL<Integer,Integer>>());
		}
		System.out.println("Start entering the weighted edges - (v1,v2,wt): ");
		for(int i = 0;i < e;i++) {
//			edgeList[i] = new Edge(sc.nextInt(),sc.nextInt(),sc.nextInt());
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int weight = sc.nextInt();
//			adjMatrix[v1][v2] = weight;
//			adjMatrix[v2][v1] = weight;
			adjList.get(v1).add(new PairAL<>(v2, weight));
			adjList.get(v2).add(new PairAL<>(v1, weight));
		}
//		Arrays.sort(edgeList); //kruskal
//		System.out.println("Graph : ");
//		for(int i = 0;i < e;i++) {
//			System.out.println("("+edgeList[i].v1+","+edgeList[i].v2+") - "+edgeList[i].weight+"|");
//		}
//		for(int i = 0;i < v;i++) {//prim
//			for(int j = 0;j < v;j++) {
//				System.out.print(adjMatrix[i][j] + " ");
//			}
//			System.out.println();
//		}
//		for(int i = 0;i < adjList.size();i++) {
//			System.out.print(i + ": ");
//			for(int j = 0;j < adjList.get(i).size();j++) {
//				System.out.print("("+adjList.get(i).get(j).v2+","+adjList.get(i).get(j).weight+") ");
//			}
//			System.out.println();
//		}
//		Edge[] rslt = kruskalMST(edgeList,v,e);
		Edge[] rslt = primMST(adjList,v,e);
//		dijkstraMST(adjList,v,e);
		for(int i = 0;i < rslt.length;i++) {
			System.out.println((rslt[i].v1 < rslt[i].v2 ? rslt[i].v1+" "+rslt[i].v2 : rslt[i].v2+" "+rslt[i].v1)+" "+rslt[i].weight);
		}
		
	}

}
