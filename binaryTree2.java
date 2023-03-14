import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;

class BBTReturn{
	
	boolean isbalanced;
	int height;
	
	public BBTReturn() {}
	
	public BBTReturn(boolean isbal,int ht) {
		isbalanced = isbal;
		height = ht;
	}
}

class Pair{
	
	int diameter;
	int height;
	
	public Pair() {}
	
	public Pair(int dia,int ht) {
		diameter = dia;
		height = ht;
	}
}


public class binaryTree2 {

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

	static BTNode<Integer> removeLeaves(BTNode<Integer> root){

		if(root == null)
			return null;
		if(root.left == null && root.right == null)
			return null;
		root.left = removeLeaves(root.left);
		root.right = removeLeaves(root.right);
		return root;

	}

	static void mirrorBinaryTree(BTNode<Integer> root){

		if(root == null)
			return;
		BTNode<Integer> temp = root.left;
		root.left = root.right;
		root.right = temp;
		mirrorBinaryTree(root.left);
		mirrorBinaryTree(root.right);
						
	}
	
	static int height(BTNode<Integer> root) {
		
		if (root == null)
			return 0;
		
		int lHeight = height(root.left);
		int rHeight = height(root.right);
		
		return 1 + Math.max(rHeight, lHeight);
		
	}
	
	static boolean isBalanced(BTNode<Integer> root) {
		
		if(root == null)
			return true;
		
		int lHeight = height(root.left);
		int rHeight = height(root.right);
		
		if(Math.abs(lHeight-rHeight) > 1)
			return false;
		
		boolean isLbalanced = isBalanced(root.left);
		boolean isRbalanced = isBalanced(root.right);
		
		return isLbalanced && isRbalanced;
		
	}
	
	static BBTReturn isBalancedBetter(BTNode<Integer> root) {
		
		if(root == null) {
			BBTReturn rslt = new BBTReturn(true, 0);
			return rslt;
		}
		
		BBTReturn leftOutput = isBalancedBetter(root.left);
		BBTReturn rightoutput = isBalancedBetter(root.right);
		
		int height = 1 + Math.max(leftOutput.height, rightoutput.height);
		boolean isbalanced = true;
		
		if(Math.abs(leftOutput.height - rightoutput.height) > 1)
			isbalanced = false;
		if(!leftOutput.isbalanced || !rightoutput.isbalanced)
			isbalanced = false;
		
		BBTReturn rslt = new BBTReturn(isbalanced, height);
		return rslt;
		
	}
	
	static int diameterOfBinaryTree(BTNode<Integer> root){
		
		if(root == null)
			return 0;
		
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		
		int centreDiameter = leftHeight+rightHeight;
		
		int leftDiameter = diameterOfBinaryTree(root.left);
		int rightDiameter = diameterOfBinaryTree(root.right);
		
		return 1 + Math.max(centreDiameter,Math.max(leftDiameter, rightDiameter));
		
	}
	
	static Pair diameterBetter(BTNode<Integer> root) {
		
		if(root == null) {
			Pair pair = new Pair(0, 0);
			return pair;
		}
		
		Pair leftPair = diameterBetter(root.left);
		Pair rightPair = diameterBetter(root.right);
		
		int leftDiameter = leftPair.diameter;
		int rightDiameter = rightPair.diameter;
		int dist = 1 + leftPair.height + rightPair.height;
		
		int diameter = Math.max(dist,Math.max(leftDiameter, rightDiameter));
		int height = 1 + Math.max(leftPair.height, rightPair.height);
		
		return (new Pair(diameter,height));
		
	}
	
	static BTNode<Integer> buildTreePreIn(int[] preOrder, int[] inOrder) {
		
		BTNode<Integer> root = helperPreIn(preOrder, inOrder, 0, preOrder.length-1, 0, inOrder.length-1);
		return root;
		
	}

	private static BTNode<Integer> helperPreIn(int[] preOrder, int[] inOrder, int siPre, int eiPre, int siIn, int eiIn) {
		
		if(siPre > eiPre)
			return null;
		
		int rootData = preOrder[siPre];
		BTNode<Integer> root = new BTNode<>(rootData);
		
		int rootindex = -1;
		for(int i = siIn;i <= eiIn;i++)
			if(inOrder[i] == rootData) {
				rootindex = i;
				break;
			}
		
		int siInLeft = siIn;
		int eiInLeft = rootindex - 1;
		int siInRight = rootindex + 1;
		int eiInRight = eiIn;
		int siPreLeft = siPre + 1;
		int eiPreLeft = siPreLeft + (eiInLeft - siInLeft);
		int siPreRight = eiPreLeft + 1;
		int eiPreRight = eiPre;
		
		
		
		BTNode<Integer> leftSubTree = helperPreIn(preOrder, inOrder, siPreLeft, eiPreLeft, siInLeft, eiInLeft);
		BTNode<Integer> rightSubTree = helperPreIn(preOrder, inOrder, siPreRight, eiPreRight, siInRight, eiInRight);
		root.left = leftSubTree;
		root.right = rightSubTree;
		
		return root;
				
	}
	
	static BTNode<Integer> buildTreePostIn(int[] postOrder, int[] inOrder) {
		
		BTNode<Integer> root = helperPostIn(postOrder, inOrder, 0, postOrder.length-1, 0, inOrder.length-1);
		return root;
		
	}
	
	private static BTNode<Integer> helperPostIn(int[] postOrder, int[] inOrder, int siPost, int eiPost, int siIn, int eiIn) {
		
		if(siPost > eiPost)
			return null;
		
		int rootData = postOrder[eiPost];
		BTNode<Integer> root = new BTNode<>(rootData);
		
		int rootindex = -1;
		for(int i = siIn;i <= eiIn;i++)
			if(inOrder[i] == rootData) {
				rootindex = i;
				break;
			}
		
		int siInLeft = siIn;
		int eiInLeft = rootindex - 1;
		int siInRight = rootindex + 1;
		int eiInRight = eiIn;
		int siPostLeft = siPost;
		int eiPostLeft = siPostLeft + (eiInLeft - siInLeft);
		int siPostRight = eiPostLeft + 1;
		int eiPostRight = eiPost -1;
		
		
		
		BTNode<Integer> leftSubTree = helperPostIn(postOrder, inOrder, siPostLeft, eiPostLeft, siInLeft, eiInLeft);
		BTNode<Integer> rightSubTree = helperPostIn(postOrder, inOrder, siPostRight, eiPostRight, siInRight, eiInRight);
		root.left = leftSubTree;
		root.right = rightSubTree;
		
		return root;
		
	}
	
	static int findLevel(BTNode<Integer> root, int elem) {
		
		if(root == null)
			return -1;
		if(root.data == elem)
			return 0;
		int leftRslt = findLevel(root.left, elem);
		if(leftRslt != -1)
			return leftRslt + 1;
		else {
			int rightRslt = findLevel(root.right, elem);
			if(rightRslt != -1)
				return rightRslt + 1;
			else
				return -1;
		}
		
	}
	
	static boolean isSiblings(BTNode<Integer> root, int p, int q) {
		
		if(root == null)
			return false;
		if(root.left != null && root.right != null) {
			if(root.left.data == p && root.right.data == q)
				return true;
			else if(root.left.data == q && root.right.data == p)
				return true;
			else
				return isSiblings(root.left, p, q) || isSiblings(root.right, p, q);
		}
		if(root.right != null)
			return isSiblings(root.right, p, q);
		else
			return isSiblings(root.left, p, q);
		
	}
	
	static boolean isCousin(BTNode<Integer> root, int p, int q) {
		
		if(root == null)
			return false;
		int levelP = findLevel(root,p);
		int levelQ = findLevel(root,q);
		
		boolean isSiblings = isSiblings(root,p,q);
		
		return((levelP == levelQ) && (!isSiblings));
		
	}
	
	static ArrayList<Integer> longestRootToLeafPath(BTNode<Integer> root){
		
		if(root == null)
			return new ArrayList<>();
		
		ArrayList<Integer> leftPath = longestRootToLeafPath(root.left);
		ArrayList<Integer> rightPath = longestRootToLeafPath(root.right);
		
		if(leftPath.size() > rightPath.size())
			leftPath.add(root.data);
		else
			rightPath.add(root.data);
		
		return ((leftPath.size() > rightPath.size()) ? leftPath : rightPath);
		
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		BTNode<Integer> root;
		root = takeIPBreadth();
		printLevelBT(root);
//		removeLeaves(root);
//		mirrorBinaryTree(root);
//		System.out.println("Status of the Tree being balanced : " + isBalanced(root));
//		System.out.println("Status of the Tree being balanced : " + isBalancedBetter(root).isbalanced);
//		System.out.println("Diameter of the Tree is : " + diameterOfBinaryTree(root));
//		System.out.println("Diameter of the Tree is : " + diameterBetter(root).diameter);
//		System.out.println("Enter the number of nodes : ");
//		int n = s.nextInt();
//		System.out.println("Enter the Pre-order traversal of the Tree : ");
//		int[] pre = new int[n];
//		for(int i = 0;i < n;i++)
//			pre[i] = s.nextInt();
//		System.out.println("Enter the Post-order traversal of the Tree : ");
//		int[] post = new int[n];
//		for(int i = 0;i < n;i++)
//			post[i] = s.nextInt();
//		System.out.println("Enter the In-order traversal of the Tree : ");
//		int[] in = new int[n];
//		for(int i = 0;i < n;i++)
//			in[i] = s.nextInt();
//		root = buildTreePreIn(pre, in);
//		root = buildTreePostIn(post, in);
//		printLevelBT(root);
//		System.out.println("Enter the values for the two nodes : ");
//		int p = s.nextInt();
//		int q = s.nextInt();
//		System.out.println("Status of " + p + " and " + q + " being cousins : " + isCousin(root, p, q));
//		ArrayList<Integer> rslt = longestRootToLeafPath(root);
//		System.out.println("Longest Root to Leaf Path in the Tree : ");
//		for(int i = 0; i< rslt.size();i++) {
//			System.out.print(rslt.get(i) + " ");
//		}
		System.out.println("");
		
		
	}

}
