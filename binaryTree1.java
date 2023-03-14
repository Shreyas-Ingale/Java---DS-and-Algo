import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

class BTNode<T> {

	BTNode<T> left;
	BTNode<T> right;
	T data;

	BTNode(){}

	BTNode(T data){
		this.data = data;
	}

}

public class binaryTree1 {

	static BTNode<Integer> takeIPDepth(boolean isRoot, boolean isLeft, int parentData){

		if(isRoot)
			System.out.println("Enter the Root Node : ");
		else {
			if(isLeft)
				System.out.println("Enter the Left Child Node of " + parentData + " : ");
			else
				System.out.println("Enter the Right Child Node of " + parentData + " : ");
		}

		int rootData = new Scanner(System.in).nextInt();
		if(rootData == -1)
			return null;

		BTNode<Integer> root = new BTNode<>(rootData);
		BTNode<Integer> leftChild = takeIPDepth(false, true, rootData);
		BTNode<Integer> rightChild = takeIPDepth(false, false, rootData);

		root.left = leftChild;
		root.right = rightChild;

		return root;

	}
	
	static void printPreBT(BTNode<Integer> root) {
		
		if(root == null)
			return;
		System.out.print(root.data + " : ");
		if(root.left != null)
			System.out.print("L-" + root.left.data);
		if(root.left != null && root.right != null)
			System.out.print(", ");
		if(root.right != null)
			System.out.print("R-" + root.right.data);
		System.out.println();
		printPreBT(root.left);
		printPreBT(root.right);
		
	}
	
	static void printPostBT(BTNode<Integer> root) {
		
		if(root == null)
			return;
		printPostBT(root.left);
		printPostBT(root.right);
		System.out.print(root.data + " : ");
		if(root.left != null)
			System.out.print("L-" + root.left.data);
		if(root.left != null && root.right != null)
			System.out.print(", ");
		if(root.right != null)
			System.out.print("R-" + root.right.data);
		System.out.println();
		
	}
	
	static void printInBT(BTNode<Integer> root) {
		
		if(root == null)
			return;
		printInBT(root.left);
		
		System.out.print(root.data + " : ");
		if(root.left != null)
			System.out.print("L-" + root.left.data);
		if(root.left != null && root.right != null)
			System.out.print(", ");
		if(root.right != null)
			System.out.print("R-" + root.right.data);
		System.out.println();
		printInBT(root.right);
		
	}
	
	static int numNodes(BTNode<Integer> root) {
		
		if(root == null)
			return 0;
		int leftNodes = numNodes(root.left);
		int rightNodes = numNodes(root.right);
		return (leftNodes + rightNodes + 1);
		
	}
	
	static int getSum(BTNode<Integer> root) {
		
		if(root == null)
			return 0;
		int leftSum = getSum(root.left);
		int rightSum = getSum(root.right);
		return (leftSum + rightSum + root.data);
		
	}
	
	static int largestNode(BTNode<Integer> root) {
		
		if(root == null)
			return -1;
		int largestLeft = largestNode(root.left);
		int largestRight = largestNode(root.right);
		return (Math.max(root.data, Math.max(largestLeft, largestRight)));
		
	}
	
	static int largerThanX(BTNode<Integer> root, int x) {
		
		if(root == null)
			return 0;
		
		int largerInLeft = largerThanX(root.left, x);
		int largerInRight = largerThanX(root.right, x);
		if(root.data > x)
			return (largerInLeft + largerInRight + 1);
		else
			return (largerInLeft + largerInRight);
		
	}
	
	static int treeHeight(BTNode<Integer> root) {
		
		if(root == null) 
			return 0;
		
		int leftHeight = treeHeight(root.left);
		int rightHeight = treeHeight(root.right);
		int rslt = 1 + Math.max(leftHeight, rightHeight);
		
		return rslt;
		
	}
	
	static int numLeafNodes(BTNode<Integer> root) {
		
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;
		
		int rslt = numLeafNodes(root.left) + numLeafNodes(root.right);
		
		return rslt;
		
	}
	
	static void depthKNodes(BTNode<Integer> root, int k) {
		
		if(root == null)
			return;
		if(k == 0) {
			System.out.println(root.data);
			return;
		}
		depthKNodes(root.left, k-1);
		depthKNodes(root.right, k-1);
		
	}
	
	static void helper(BTNode<Integer> root, int d) {
		
		if(root == null)
			return;
		
		root.data = d;
		helper(root.left, d+1);
		helper(root.right, d+1);
		
	}
	
	static void changeToDepthTree(BTNode<Integer> root) {
		
		helper(root, 0);
		
	}
	
	public static void main(String[] args) {

		BTNode<Integer> root;
		root = takeIPDepth(true, false, 0);
		printPreBT(root);
//		printPostBT(root);
//		printInBT(root);
//		System.out.println("Number of nodes are : " + numNodes(root));
//		System.out.println("Sum of nodes are : " + getSum(root));
//		System.out.println("Largest node is : " + largestNode(root));
//		int x = new Scanner(System.in).nextInt();
//		System.out.println("Sum of nodes larger than " + x + " are : " + largerThanX(root,x));
//		System.out.println("Height of the Tree is : " + treeHeight(root));
//		System.out.println("Number of Leaf nodes are : " + numLeafNodes(root));
//		int k = new Scanner(System.in).nextInt();
//		System.out.println("Nodes at " + k + " depth are : ");
//		depthKNodes(root, k);
//		changeToDepthTree(root);
//		printInBT(root);
	
	}

}
