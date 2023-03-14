import java.util.*;

class GTNode<T>{
	T data;
	ArrayList<GTNode<T>> children;
	public GTNode() {
		this.children = new ArrayList<>();
	}
	public GTNode(T data) {
		this.data = data;
		this.children = new ArrayList<>();
	}
}

class MSNodeReturn{
	GTNode<Integer> node;
	int maxSum;
	public MSNodeReturn(GTNode<Integer> node,int maxSum) {
		this.node = node;
		this.maxSum = maxSum;
	}
}

class NLNodeReturn{
	GTNode<Integer> node;
	int minDiff;
	public NLNodeReturn(GTNode<Integer> node,int minDiff) {
		this.node = node;
		this.minDiff = minDiff;
	}
}

class SLNodeReturn{
	GTNode<Integer> firstLargest;
	GTNode<Integer> secondLargest;
	public SLNodeReturn(GTNode<Integer> firstLargest, GTNode<Integer> secondLargest) {
		this.firstLargest = firstLargest;
		this.secondLargest = secondLargest;
	}
}

public class genericTree {

	static GTNode<Integer> takeIPR(boolean isRoot, int numChild, int parentData) {
		if(isRoot)
			System.out.println("Enter the Root Node : ");
		else {
			System.out.println("Enter the " + numChild + " child of " + parentData + " : ");
		}
		int rootData = new Scanner(System.in).nextInt();		
		if(rootData == -1)
			return null;
		GTNode<Integer> root = new GTNode<>(rootData);
		System.out.println("Enter the number of children of " + root.data + " : ");
		int n = new Scanner(System.in).nextInt();
		ArrayList<GTNode<Integer>> childArr = new ArrayList<>();
		for(int i = 0;i < n;i++) {
			childArr.add(takeIPR(false, i+1, root.data));
		}
		root.children = childArr;
		return root;
	}

	static GTNode<Integer> takeIPL() {

		Queue<GTNode<Integer>> pendingNodes = new LinkedList<GTNode<Integer>>();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Root Node : ");
		int rootData = s.nextInt();
		if(rootData == -1)
			return null;
		GTNode<Integer> root = new GTNode<>(rootData);
		pendingNodes.add(root);
		while(!pendingNodes.isEmpty()) {
			GTNode<Integer> curr ;
			try {
				curr = pendingNodes.remove();
			} catch (Exception e) {
				return null;
			}
			System.out.println("Enter the number of children of " + curr.data + " : ");
			int n = s.nextInt();
			ArrayList<GTNode<Integer>> childArr = new ArrayList<>();
			if(n != 0){
				for(int i = 0;i < n;i++) {
					System.out.println("Enter the " + (i+1) + " child of " + curr.data + " : ");
					GTNode<Integer> child = new GTNode(s.nextInt());
					childArr.add(child);
					pendingNodes.add(child);
				}
			}
			curr.children = childArr;
		}
		return root;

	}

	static void printTree(GTNode<Integer> root) {

		if(root == null)
			return;
		Queue<GTNode<Integer>> primary = new LinkedList<GTNode<Integer>>();
		Queue<GTNode<Integer>> secondary = new LinkedList<GTNode<Integer>>();
		primary.add(root);
		while(!primary.isEmpty()) {
			GTNode<Integer> current = null;
			try {
				current = primary.remove();
			} catch (Exception e) {
				System.out.println("Not possible");
			}
			System.out.print(current.data + " : ");
			for(int i = 0;i < current.children.size();i++) {
				System.out.print(current.children.get(i).data + " ");
			}
			System.out.println();
			for(int i = 0;i < current.children.size();i++) {
				secondary.add(current.children.get(i));
			}
			if(primary.isEmpty()) {
				Queue<GTNode<Integer>> temp = secondary;
				secondary = primary;
				primary = temp;
			}
		}

	}

	static int numNodes(GTNode<Integer> root) {

		if(root == null)
			return 0;
		int count = 1;
		for(int i = 0;i < root.children.size();i++) {
			int childCount = numNodes(root.children.get(i));
			count += childCount;
		}
		return count;
	}

	static int sumOfAllNodes(GTNode<Integer> root) {

		if(root == null)
			return 0;
		int count = root.data;
		for(int i = 0;i < root.children.size();i++) {
			int childCount = sumOfAllNodes(root.children.get(i));
			count += childCount;
		}
		return count;
	}

	static int numNodeGreater(GTNode<Integer> root,int x){

		if(root == null)
			return 0;
		int count;
		if(root.data > x)
			count = 1;
		else
			count = 0;
		for(int i = 0;i < root.children.size();i++) {
			int childCount = numNodeGreater(root.children.get(i), x);
			count += childCount;
		}
		return count;

	}

	static int getHeight(GTNode<Integer> root){

		if(root == null)
			return 0;
		int rslt = 0;
		for(int i = 0;i< root.children.size();i++) {
			int childHeight = getHeight(root.children.get(i));
			rslt = Math.max(rslt, childHeight);
		}
		return 1 + rslt;

	}

	static void printPostOrder(GTNode<Integer> root) {

		if(root == null)
			return;
		for(int i = 0;i< root.children.size();i++) {
			printPostOrder(root.children.get(i));
		}
		System.out.print(root.data + " ");

	}
	
	static boolean checkIfContainsX(GTNode<Integer> root, int x){
		
		if(root == null)
			return false;
		if(root.data == x)
			return true;
		for(int i = 0;i < root.children.size();i++) {
			boolean childResult = checkIfContainsX(root.children.get(i), x);
			if(childResult)
				return true;
		}
		return false;
		
	}
	
	static MSNodeReturn maxSumNodeHelper(GTNode<Integer> root) {
		
		if(root == null)
			return new MSNodeReturn(root, 0);
		int sum = root.data;
		GTNode<Integer> node = root;
		int maxSum = 0;
		for(int i = 0;i < root.children.size();i++) {
			sum += root.children.get(i).data;
		}
		maxSum = sum;
		for(int i = 0;i < root.children.size();i++) {
			MSNodeReturn childRslt = maxSumNodeHelper(root.children.get(i));
			if(maxSum < childRslt.maxSum) {
				node = childRslt.node;
				maxSum = childRslt.maxSum;
			}
		}
		return new MSNodeReturn(node, maxSum);
		
	}
	
	static GTNode<Integer> maxSumNode(GTNode<Integer> root){
		
		return maxSumNodeHelper(root).node;
		
	}
	
	static boolean checkIdentical(GTNode<Integer> root1, GTNode<Integer> root2){
		
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		if(root1.data == root2.data && root1.children.size() == root2.children.size()) {
			for(int i = 0;i < root1.children.size();i++) {
				if(!checkIdentical(root1.children.get(i), root2.children.get(i)))
					return false;
			}
			return true;
		}
		else
			return false;
	
	}
	
	static NLNodeReturn findNextLargerNodeHelper(GTNode<Integer> root, int n){
		
		if(root == null)
			return new NLNodeReturn(root, Integer.MAX_VALUE);
		int diff = Integer.MAX_VALUE;
		GTNode<Integer> node = null;
		if(root.data > n) {
			diff = root.data - n;
			node = root;
		}
		for(int i = 0;i < root.children.size();i++) {
			NLNodeReturn childRslt = findNextLargerNodeHelper(root.children.get(i), n);
			if(childRslt.minDiff < diff) {
				diff = childRslt.minDiff;
				node = childRslt.node;
			}
		}
		return new NLNodeReturn(node, diff);
		
	}
	
	static GTNode<Integer> findNextLargerNode(GTNode<Integer> root, int n){
		
		return findNextLargerNodeHelper(root, n).node;
		
	}
	
	static SLNodeReturn findSecondLargestHelper(GTNode<Integer> root,GTNode<Integer> flNode,GTNode<Integer> slNode){
		
		if(root == null) {
			GTNode<Integer> fNode = new GTNode<>(Integer.MIN_VALUE);
			GTNode<Integer> sNode = new GTNode<>(Integer.MIN_VALUE);
			return new SLNodeReturn(fNode, sNode);
		}
		if(root.data > flNode.data) {
			slNode = flNode;
			flNode = root;
		}
		if(root.data > slNode.data && root.data != flNode.data)
			slNode = root;
		for(int i = 0;i < root.children.size();i++) {
			SLNodeReturn child = findSecondLargestHelper(root.children.get(i), flNode, slNode);
			flNode = child.firstLargest;
			slNode = child.secondLargest;
		}
		return new SLNodeReturn(flNode, slNode);
		
	}
	
	static GTNode<Integer> findSecondLargest(GTNode<Integer> root){
		
		GTNode<Integer> flNode = new GTNode<>(Integer.MIN_VALUE);
		GTNode<Integer> slNode = flNode;
		return findSecondLargestHelper(root,flNode,slNode).secondLargest;	
		
	}
	
	static void replaceWithDepthValueHelper(GTNode<Integer> root, int d){
		
		if(root == null)
			return;
		root.data = d;
		for(int i = 0;i < root.children.size();i++) {
			replaceWithDepthValueHelper(root.children.get(i), d + 1);
		}
		
	}
	
	static void replaceWithDepthValue(GTNode<Integer> root){
		
		replaceWithDepthValueHelper(root,0);
		
	}
	 
	static int countLeafNodes(GTNode<Integer> root){
		
		if(root == null)
			return 0;
		if(root.children.isEmpty())
			return 1;
		int rslt = 0;
		for(int i = 0;i < root.children.size();i++) {
			rslt += countLeafNodes(root.children.get(i));
		}
		System.out.println("rslt : " + rslt);
		return rslt;
		
	}
	
	static GTNode<Integer> removeLeafNodes(GTNode<Integer> root) {
		
		if(root == null)
			return null;
		if(root.children.isEmpty())
			return null;
		GTNode<Integer> temp = null;
		for(int i = 0;i < root.children.size();i++) {
			temp = root;
			GTNode<Integer> rslt = removeLeafNodes(root.children.get(i));
			if(rslt == null)
				temp.children.remove(i--);
		}
		return temp;
	}
	
	public static void main(String[] args) {
	
		Scanner s = new Scanner(System.in);
		GTNode<Integer> root = takeIPL();
		printTree(root);
//		System.out.println("Number of nodes in the Tree are : " + numNodes(root));
//		System.out.println("Sum of all nodes in the Tree are : " + sumOfAllNodes(root));
//		System.out.println("Enter the value of 'X' ");
//		int x = s.nextInt();
//		System.out.println("Number of nodes in the Tree  greater than " + x + " are : " + numNodeGreater(root, x));
//		System.out.println("Height of the Tree is : " + getHeight(root));
//		printPostOrder(root);
//		System.out.println("Status of " + x + " being in the Tree is : " + checkIfContainsX(root, x));
//		System.out.println("Node having highest sum of itself and its children is : " + maxSumNode(root).data);
//		GTNode<Integer> root2 = takeIPL();
//		printTree(root2);
//		System.out.println("Status of two Trees being identical : " + checkIdentical(root, root2));
//		System.out.println("Node having value just greater than " + x + " is : " + findNextLargerNode(root, x).data);
//		System.out.println("Second Largest Node in the Tree is : " + findSecondLargest(root).data);
//		System.out.println("Modified Tree after replacing node's value with its depth : ");
//		replaceWithDepthValue(root);
//		printTree(root);
//		System.out.println("Number of Leaf Nodes in the Tree are : " + countLeafNodes(root));
//		removeLeafNodes(root);
//		System.out.println("Modified Tree : ");
//		printTree(root);
	}

}
