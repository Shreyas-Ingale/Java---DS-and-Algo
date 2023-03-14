import java.util.*;

class BSTDeleteReturn {

	BTNode<Integer> node;
	boolean deleted;

	public BSTDeleteReturn() {}
	public BSTDeleteReturn(BTNode<Integer> node, boolean deleted) {
		this.node = node;
		this.deleted = deleted;
	}

}

public class binarySearchTree2 {

	private static BTNode<Integer> root;
	private static int size;

	private static boolean isPresentHelper(BTNode<Integer> node, int x) {

		if(node == null)
			return false;

		if(node.data == x)
			return true;
		else if(node.data > x)
			return isPresentHelper(node.left, x);
		else
			return isPresentHelper(node.right, x);

	}

	static boolean isPresent(int x) {

		return isPresentHelper(root, x);

	}

	static int size() {

		return size;

	}

	private static void printTreeHelper(BTNode<Integer> node) {

		if(node == null)
			return;
		System.out.print(node.data + ":");
		if(node.left != null) {
			System.out.print("L-" + node.left.data);
		}
		if(node.left != null && node.right != null) {
			System.out.print(" , ");
		}
		if(node.right != null) {
			System.out.print("R-" + node.right.data);
		}
		System.out.println();

		printTreeHelper(node.left);
		printTreeHelper(node.right);

	}

	static void printTree() {

		printTreeHelper(root);

	}

	private static BTNode<Integer> insertNodeHelper(BTNode<Integer> node,int x){

		if(node == null)
			return new BTNode<Integer>(x);

		if(node.data <= x)
			node.right = insertNodeHelper(node.right, x);
		else
			node.left = insertNodeHelper(node.left, x);

		return node;

	}

	static void insertNode(int x) {

		root = insertNodeHelper(root, x);
		size++;

	}

	private static int minimum(BTNode<Integer> root) {

		if(root == null)
			return Integer.MAX_VALUE;

		int leftMin = minimum(root.left);
		int rightMin = minimum(root.right);

		return Math.min(root.data, Math.min(leftMin, rightMin));

	}

	private static BSTDeleteReturn deleteNodeHelper(BTNode<Integer> node, int x) {

		if(node == null)
			return new BSTDeleteReturn(null, false);

		if(node.data < x) {
			BSTDeleteReturn newRight = deleteNodeHelper(node.right, x);
			node.right = newRight.node;
			newRight.node = node;
			return newRight;
		}

		if(node.data > x) {
			BSTDeleteReturn newLeft= deleteNodeHelper(node.left, x);
			node.left = newLeft.node;
			newLeft.node = node;
			return newLeft;
		}

		if(node.left == null && node.right == null)
			return new BSTDeleteReturn(null, true);

		if(node.left != null && node.right == null)
			return new BSTDeleteReturn(node.left, true);

		if(node.left == null && node.right != null)
			return new BSTDeleteReturn(node.right, true);

		int rightMin = minimum(node.right);
		node.data = rightMin;
		BSTDeleteReturn newRoot = deleteNodeHelper(node.right, rightMin);
		node.right = newRoot.node;
		return new BSTDeleteReturn(node, true);
		
	}

	static boolean deleteNode(int x) {

		BSTDeleteReturn rslt = deleteNodeHelper(root, x);
		if(rslt.deleted)
			size--;
		root = rslt.node;
		return rslt.deleted;

	}

	public static void main(String[] args) {

		insertNode(5);
		insertNode(2);
		insertNode(7);
		insertNode(1);
		insertNode(3);
		insertNode(6);
		insertNode(8);
		System.out.println(isPresent(5));
		deleteNode(5);
		System.out.println(isPresent(5));
		printTree();
		deleteNode(2);
		System.out.println(isPresent(2));
		printTree();
		System.out.println(size());

	}

}
