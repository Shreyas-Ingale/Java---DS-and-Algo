import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class MinMaxPair<T, U> {
	T minimum;
	U maximum;

	public MinMaxPair(T minimum, U maximum) {
		this.minimum = minimum;
		this.maximum = maximum;
	}

}

public class binaryTreePrograms {

	static BTNode<Integer> takeIPBreadth(){		

		Queue<BTNode<Integer>> pendingNodes = new LinkedList<BTNode<Integer>>();
		System.out.println("Enter the Root Node : ");
		int rootData = new Scanner(System.in).nextInt();
		if(rootData == -1)
			return null;
		BTNode<Integer> root = new BTNode<>(rootData);
		pendingNodes.add(root);
		while(!pendingNodes.isEmpty()) {
			BTNode<Integer> curr ;
			try {
				curr = pendingNodes.remove();
			} catch (Exception e) {
				return null;
			}
			System.out.println("Enter the Left child of " + curr.data + " : ");
			int lcData = new Scanner(System.in).nextInt();
			if(lcData != -1){
				BTNode<Integer> leftChild = new BTNode<Integer>(lcData);
				curr.left = leftChild;
				pendingNodes.add(leftChild);
			}
			System.out.println("Enter the Right child of " + curr.data + " : ");
			int rcData = new Scanner(System.in).nextInt();
			if(rcData != -1){
				BTNode<Integer> rightChild = new BTNode<Integer>(rcData);
				curr.right = rightChild;
				pendingNodes.add(rightChild);
			}
		}
		return root;

	}

	static void printLevelBT(BTNode<Integer> root) {

		Queue<BTNode<Integer>> primary = new LinkedList<BTNode<Integer>>();
		Queue<BTNode<Integer>> secondary = new LinkedList<BTNode<Integer>>();
		primary.add(root);
		while(!primary.isEmpty()) {
			BTNode<Integer> current = null;
			try {
				current = primary.remove();
			} catch (Exception e) {
				System.out.println("Not possible");
			}
			System.out.print(current.data + " : ");
			if(current.left != null) {
				secondary.add(current.left);
				System.out.print("L-" + current.left.data);
			}
			if(current.left != null && current.right != null)
				System.out.print(" , ");
			if(current.right != null) {
				secondary.add(current.right);
				System.out.print("R-" + current.right.data);
			}
			if(primary.isEmpty()) {
				Queue<BTNode<Integer>> temp = secondary;
				secondary = primary;
				primary = temp;
			}
			System.out.println();
		}

	}

	static boolean isNodePresent(BTNode<Integer> root, int x) {

		if(root == null)
			return false;
		if(root.data == x)
			return true;

		return (isNodePresent(root.left, x) || isNodePresent(root.right, x));

	}

	static void printNodesWithoutSibling(BTNode<Integer> root) {

		if(root == null)
			return;

		if(root.right == null && root.left != null)
			System.out.print(root.left.data + " ");
		if(root.left == null && root.right != null)
			System.out.print(root.right.data + " ");

		printNodesWithoutSibling(root.left);
		printNodesWithoutSibling(root.right);

	}

	static void insertDuplicateNode(BTNode<Integer> root) {

		if(root == null)
			return;

		insertDuplicateNode(root.left);
		insertDuplicateNode(root.right);

		BTNode<Integer> dupNode = new BTNode(root.data);
		dupNode.left = root.left;
		dupNode.right = null;
		root.left = dupNode;

	}

	static MinMaxPair<Integer, Integer> getMinAndMax(BTNode<Integer> root) {

		if(root == null)
			return new MinMaxPair(Integer.MAX_VALUE, Integer.MIN_VALUE);

		MinMaxPair<Integer, Integer> leftPair = getMinAndMax(root.left);
		MinMaxPair<Integer, Integer> rightPair = getMinAndMax(root.right);

		MinMaxPair<Integer, Integer> rslt = new MinMaxPair<>(null, null);
		rslt.minimum = Math.min(root.data, Math.min(leftPair.minimum, rightPair.minimum));
		rslt.maximum = Math.max(root.data, Math.max(leftPair.maximum, rightPair.maximum));

		return rslt;
	}

	static void rootToLeafPathsSumToK(BTNode<Integer> root, int k) {

		String str = new String();
		helper(root, k, str);

	}

	private static void helper(BTNode<Integer> root, int k, String str) {

		if(root == null)
			return;
		if(root.left == null && root.right == null && root.data == k) {
			System.out.println(str + root.data);
			return;
		}

		str += root.data + " ";
		helper(root.left, k - root.data, str);
		helper(root.right, k - root.data, str);

	}

	static void printDepthKNodes(BTNode<Integer> root, int k) {

		if(root == null)
			return;
		if(k == 0) {
			System.out.println(root.data);
			return;
		}
		printDepthKNodes(root.left, k-1);
		printDepthKNodes(root.right, k-1);

	}

	static int printNodesAtDistanceK(BTNode<Integer> root, int node, int k) {

		if(root == null || k < 0)
			return -1;
		if(root.data == node) {
			printDepthKNodes(root, k);
			return 0;
		}

		int leftDistance = printNodesAtDistanceK(root.left, node, k);
		if(leftDistance != -1) {
			if(leftDistance + 1 == k) {
				System.out.println(root.data);
			}
			else {
				printDepthKNodes(root.right, k - leftDistance - 2);
			}
			return leftDistance + 1;
		}

		int rightDistance = printNodesAtDistanceK(root.right, node, k);
		if(rightDistance != -1) {
			if(rightDistance + 1 == k) {
				System.out.println(root.data);
			}
			else {
				printDepthKNodes(root.left, k - rightDistance - 2);
			}
			return rightDistance + 1;
		}

		return -1;

	}
	
	static ArrayList<Integer> nodeToRootPath(BTNode<Integer> root, int x){
		
		if(root == null)
			return null;
		if(root.data == x) {
			ArrayList<Integer> rslt = new ArrayList<Integer>();
			rslt.add(root.data);
			return rslt;
		}
		
		ArrayList<Integer> leftOutput = nodeToRootPath(root.left, x);
		if(leftOutput != null) {
			leftOutput.add(root.data);
			return leftOutput;
		}
		
		ArrayList<Integer> rightOutput = nodeToRootPath(root.right, x);
		if(rightOutput != null) {
			rightOutput.add(root.data);
			return rightOutput;
		}
		
		return null;
		
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		BTNode<Integer> root;
		root = takeIPBreadth();
		printLevelBT(root);
//		System.out.println("Enter the Node to be searched : ");
//		int z = s.nextInt();
//		System.out.println("Status of " + z + "'s presence in the Tree : " + isNodePresent(root, z));
//		System.out.println("Node(s) without siblings in the Tree is/are : ");
//		printNodesWithoutSibling(root);
//		System.out.println("Modified Tree : ");
//		insertDuplicateNode(root);
//		printLevelBT(root);
//		MinMaxPair<Integer, Integer> rslt = getMinAndMax(root);
//		System.out.println("Minimun and Maximum Nodes in the Tree are :" + rslt.minimum + " , " + rslt.maximum);
//		System.out.println("Enter the Target Node value : ");
//		int node = s.nextInt();
//		System.out.println("Enter the Distance value : ");
//		int k = s.nextInt();
//		System.out.println("All Root-to-Leaf paths with sum equal to " + k + " are : ");
//		rootToLeafPathsSumToK(root, k);
//		System.out.println("All the nodes at a distance " + k + " from the node " + node + " are : ");
//		printNodesAtDistanceK(root, node, k);
		System.out.println("Enter the node whose path is to be searched : ");
		int x = s.nextInt();
		ArrayList<Integer> rslt = nodeToRootPath(root, x);
		for(int i : rslt) {
			System.out.print(i + " ");
		}
		
		
	}

}
