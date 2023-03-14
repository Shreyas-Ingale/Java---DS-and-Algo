import java.util.*;

class isBSTReturn{

	int min;
	int max;
	boolean isBST;

	public isBSTReturn() {}

	public isBSTReturn(int min, int max, boolean isBST) {
		this.min = min;
		this.max = max;
		this.isBST = isBST;
	}

}

class PairOfNodeElem{

	LLNode<Integer> head;
	LLNode<Integer> tail;

}

class heightBSTReturn{
	
	int min;
	int max;
	boolean isBST;
	int height;
	
	public heightBSTReturn() {}
	
	public heightBSTReturn(int min, int max, boolean isBST,int height) {
		this.min = min;
		this.max = max;
		this.isBST = isBST;
		this.height = height;
	}
	
}

public class binarySearchTree1 {

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

	static boolean searchInBST(BTNode<Integer> root, int k) {

		if(root == null)
			return false;

		if(root.data == k)
			return true;
		else if(root.data > k)
			return searchInBST(root.left, k);
		else
			return searchInBST(root.right, k);

	}

	static void elementsInRangeK1K2(BTNode<Integer> root,int k1,int k2){

		if(root == null)
			return;

		if(k2 < root.data) {
			elementsInRangeK1K2(root.left, k1, k2);
		}
		else if(k1 > root.data) {
			elementsInRangeK1K2(root.right, k1, k2);
		}
		else {
			elementsInRangeK1K2(root.left, k1, k2);
			System.out.print(root.data + " ");
			elementsInRangeK1K2(root.right, k1, k2);
		}

	}

	static BTNode<Integer> sortedArrayToBST(int[] arr, int si, int ei){

		if(si > ei)
			return null;
		if(si == ei)
			return new BTNode<Integer>(arr[si]);

		int mid = (si + ei) / 2;
		BTNode<Integer> root = new BTNode<>(arr[mid]);

		root.left = sortedArrayToBST(arr, si, mid-1);
		root.right = sortedArrayToBST(arr, mid+1, ei);

		return root;

	}

	static int minimum(BTNode<Integer> root) {

		if(root == null)
			return Integer.MAX_VALUE;

		int leftMin = minimum(root.left);
		int rightMin = minimum(root.right);

		return Math.min(root.data, Math.min(leftMin, rightMin));

	}

	static int maximum(BTNode<Integer> root) {

		if(root == null)
			return Integer.MIN_VALUE;

		int leftMax = maximum(root.left);
		int rightMax = maximum(root.right);

		return Math.max(root.data, Math.max(leftMax, rightMax));

	}

	static isBSTReturn isBSTHelper1(BTNode<Integer> root) {

		if(root == null) {
			return new isBSTReturn(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
		}

		isBSTReturn leftAns = isBSTHelper1(root.left);
		isBSTReturn rightAns = isBSTHelper1(root.right);

		int min = Math.min(root.data, Math.min(leftAns.min, rightAns.min));
		int max = Math.max(root.data, Math.max(leftAns.max, rightAns.max));
		boolean isBST = true;
		if(leftAns.max > root.data)
			isBST = false;
		if(rightAns.min <= root.data)
			isBST = false;
		if(!leftAns.isBST)
			isBST = false;
		if(!rightAns.isBST)
			isBST = false;

		return new isBSTReturn(min, max, isBST);

	}

	static boolean isBSTHelper2(BTNode<Integer> root, int minRange, int maxRange) {

		if(root == null)
			return true;

		if(root.data < minRange || root.data > maxRange)
			return false;

		boolean isBSTLeft = isBSTHelper2(root.left, minRange, root.data);
		boolean isBSTRight = isBSTHelper2(root.right, root.data+1, maxRange);

		return (isBSTLeft && isBSTRight);

	}

	static boolean isBST(BTNode<Integer> root) {

		if(root == null)
			return true;

		/*int leftMax = maximum(root.left);
		if(leftMax > root.data)
			return false;

		int rightMin = minimum(root.right);
		if(rightMin <= root.data)
			return false;

		boolean isLeftBST = isBST(root.left);
		boolean isRightBST = isBST(root.right);
		return (isLeftBST && isRightBST);*/

		/*isBSTReturn rslt = isBSTHelper1(root);
		return rslt.isBST;*/

		boolean rslt = isBSTHelper2(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
		return rslt;

	}

	static PairOfNodeElem constructLinkedListHelper(BTNode<Integer> root) {

		if(root == null) 
			return new PairOfNodeElem();

		LLNode<Integer> currNode = new LLNode<>(root.data);
		PairOfNodeElem leftList = constructLinkedListHelper(root.left);
		PairOfNodeElem rightList = constructLinkedListHelper(root.right);
		PairOfNodeElem returnPair = new PairOfNodeElem();

		if(leftList.tail != null)
			leftList.tail.next = currNode;
		currNode.next = rightList.head;

		if(leftList.head != null)
			returnPair.head = leftList.head;
		else
			returnPair.head = currNode;

		if(rightList.tail != null)
			returnPair.tail = rightList.tail;
		else
			returnPair.tail = currNode;

		return returnPair;

	}

	static LLNode<Integer> constructLinkedList(BTNode<Integer> root) {

		//		if(root == null)
		//			return null;
		//		
		//		LLNode<Integer> leftHead = constructLinkedList(root.left);
		//		if(leftHead == null) {
		//			LLNode<Integer> currNode = new LLNode<>(root.data);
		//			LLNode<Integer> rightHead = constructLinkedList(root.right);
		//			if(rightHead != null)
		//				currNode.next = rightHead;
		//			return currNode;
		//		}
		//		else {
		//			LLNode<Integer> currNode = new LLNode(root.data);
		//			LLNode<Integer> temp = leftHead;
		//			while(temp.next != null)
		//				temp = temp.next;
		//			temp.next = currNode;
		//			LLNode<Integer> rightHead = constructLinkedList(root.right);
		//			if(rightHead != null)
		//				currNode.next = rightHead;
		//			return leftHead;			
		//		}

		return constructLinkedListHelper(root).head;

	}

	static int getLCA(BTNode<Integer> root, int a, int b) {

		if(root == null)
			return -1;

		if(root.data > a && root.data > b)
			return getLCA(root.left, a, b);

		if(root.data < a && root.data < b)
			return getLCA(root.right, a, b);

		return root.data;

	}

	static int replaceHelper(BTNode<Integer> root,int sum) {

		if(root == null)
			return 0;

		int rightSum = replaceHelper(root.right, sum);
		int rootData = root.data;
		root.data += rightSum + sum;
		int leftSum = replaceHelper(root.left, root.data);

		return rootData + rightSum + leftSum;

	}

	static void replaceWithLargerNodesSum(BTNode<Integer> root) {

		replaceHelper(root,0);

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

	static void printLinkedList(LLNode<Integer> temp)
	{
		while(temp != null){
			System.out.print(temp.data + " ") ;
			temp = temp.next;
		}
		System.out.println();
	}

	static ArrayList<LLNode<Integer>> constructLinkedListForEachLevel(BTNode<Integer> root){

		if(root == null)
			return null;
		Queue<BTNode<Integer>> primary = new LinkedList<BTNode<Integer>>();
		Queue<BTNode<Integer>> secondary = new LinkedList<BTNode<Integer>>();
		primary.add(root);
		ArrayList<LLNode<Integer>> arr = new ArrayList<>(); 
		arr.add(new LLNode<>(root.data));
		LLNode<Integer> head = null,tail = null;
		while(!primary.isEmpty()) {
			BTNode<Integer> current = null;
			try {
				current = primary.remove();
			} catch (Exception e) {
				System.out.println("Not possible");
			}

			if(current.left != null) {
				secondary.add(current.left);
				LLNode<Integer> nnode = new LLNode(current.left.data);
				if(head == null) {
					head = nnode;
					tail = nnode;
				}
				else {
					tail.next = nnode;
					tail = tail.next;
				}
			}

			if(current.right != null) {
				secondary.add(current.right);
				LLNode<Integer> nnode = new LLNode(current.right.data);
				if(head == null) {
					head = nnode;
					tail = nnode;
				}
				else {
					tail.next = nnode;
					tail = tail.next;
				}
			}
			if(primary.isEmpty()) {
				Queue<BTNode<Integer>> temp = secondary;
				secondary = primary;
				primary = temp;
				if(head != null)
					arr.add(head);
				head = null;
				tail = null;
			}
		}
		return arr;

	}

	static int countNodes(BTNode<Integer> root) {

		if(root == null)
			return 0;
		return countNodes(root.left) + countNodes(root.right) + 1;

	}

	static void printNodesSumToS(BTNode<Integer> root, int s) {

		if(root == null || s < 0)
			return;

		int totalCount = countNodes(root);
		int count = 0;

		Stack<BTNode<Integer>> leftStack = new Stack<>();
		Stack<BTNode<Integer>> rightStack = new Stack<>();

		BTNode<Integer> temp = root;
		while(temp != null) {
			leftStack.add(temp);
			temp = temp.left;
		}
		temp = root;
		while(temp != null) {
			rightStack.add(temp);
			temp = temp.right;
		}

		while(count < totalCount - 1) {
			if((leftStack.peek().data + rightStack.peek().data) == s) {
				BTNode<Integer> leftTop = leftStack.pop(), rightTop = rightStack.pop();
				count += 2;
				System.out.println(leftTop.data + " " + rightTop.data);
				BTNode<Integer> rightWala = leftTop;
				if(rightWala.right != null) {
					rightWala = rightWala.right;
					while(rightWala != null) {
						leftStack.add(rightWala);
						rightWala = rightWala.left;
					}
				}
				BTNode<Integer> leftWala = rightTop;
				if(leftWala.left != null) {
					leftWala = leftWala.left;
					while(leftWala != null) {
						rightStack.add(leftWala);
						leftWala = leftWala.right;
					}
				}
			}
			else if((leftStack.peek().data + rightStack.peek().data) > s) {
				BTNode<Integer> leftWala = rightStack.pop();
				count++;
				if(leftWala.left != null) {
					leftWala = leftWala.left;
					while(leftWala != null) {
						rightStack.add(leftWala);
						leftWala = leftWala.right;
					}
				}
			}
			else {
				BTNode<Integer> rightWala = leftStack.pop();
				count++;
				if(rightWala.right != null) {
					rightWala = rightWala.right;
					while(rightWala != null) {
						leftStack.add(rightWala);
						rightWala = rightWala.left;
					}
				}
			}
		}

	}
	
	static heightBSTReturn largestBSTSubtreeHelper(BTNode<Integer> root) {

		if(root == null)
			return new heightBSTReturn(Integer.MAX_VALUE, Integer.MIN_VALUE, true, 0);
		
		heightBSTReturn leftTree = largestBSTSubtreeHelper(root.left);
		heightBSTReturn rightTree = largestBSTSubtreeHelper(root.right);
		
		int min = Math.min(root.data, Math.min(leftTree.min, rightTree.min));
		int max = Math.max(root.data, Math.max(leftTree.max, rightTree.max));
		boolean isBST;
		int height;
		if(leftTree.isBST && rightTree.isBST) {
			if(leftTree.max < root.data && root.data < rightTree.min) {
				isBST = true;
				height = 1 + Math.max(leftTree.height, rightTree.height);
			}
			else {
				isBST = false;
				height = Math.max(leftTree.height, rightTree.height);
			}
		}
		else {
			isBST = false;
			height = Math.max(leftTree.height, rightTree.height);			
		}
		System.out.println("here " + isBST + height);
		return new heightBSTReturn(min, max, isBST, height);
		
	}
	
	static int largestBSTSubtree(BTNode<Integer> root) {
		
		return largestBSTSubtreeHelper(root).height;
		
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		BTNode<Integer> root;
		root = takeIPBreadth();
		printLevelBT(root);
//		System.out.println("Enter the element to be searched : ");
//		int k = s.nextInt();
//		System.out.println("Status of " + k + "'s presence in the BST : " + searchInBST(root, k));
//		System.out.println("Enter the Range(k1, k2) Values : ");
//		int k1 = s.nextInt();
//		int k2 = s.nextInt();
//		System.out.println("All the elements in the range " + k1 + " - " + k2 + " are : ");
//		elementsInRangeK1K2(root, k1, k2);
//		System.out.println("Enter the length of the Sorted Array : ");
//		int n = s.nextInt();
//		System.out.println("Enter the elements of the Sorted Array : ");
//		int[] arr = new int[n];
//		for(int i = 0;i < n;i++)
//			arr[i] = s.nextInt();
//		root = sortedArrayToBST(arr, 0, n-1);
//		printLevelBT(root);
//		System.out.println("Status of the Tree being a BST is : " + isBST(root));
//		System.out.println("Linked List from the BST is : ");
//		LLNode<Integer> head = constructLinkedList(root);
//		while(head!=null) {
//			System.out.print(head.data + " ");
//			head = head.next;
//		}
//		System.out.println("Enter the two nodes for LCA calculation : ");
//		int a = s.nextInt();
//		int b = s.nextInt();
//		int rslt = getLCA(root, a, b);
//		if(rslt != -1)
//			System.out.println("LCA of " + a + " and " + b + " is : " + rslt);
//		else
//			System.out.println("LCA of " + a + " and " + b + " wasn't found.");
//		System.out.println("Modified Tree after replacing with <= nodes sum : ");
//		printLevelBT(root);
//		System.out.println("Enter the Node whose path is to be searched : ");
//		int x = s.nextInt();
//		ArrayList<Integer> rslt = nodeToRootPath(root, x);
//		if(rslt != null) {
//			System.out.println("Path Found : ");
//			for(int i : rslt)
//				System.out.print(i + " ");
//		}
//		else
//			System.out.println("Path Not Found");
//		System.out.println("Tree through LinkedList-ArrayList in Levelwise Form : ");
//		ArrayList<LLNode<Integer>> rslt = constructLinkedListForEachLevel(root);
//		for(LLNode<Integer> head : rslt) {
//			printLinkedList(head);
//		}
//		System.out.println("Enter the value of the sum : ");
//		int sum = s.nextInt();
//		System.out.println("Pair of nodes which sums upto " + sum + " in the Tree are : ");
//		printNodesSumToS(root, sum)
		System.out.println("Height of the largest BST in the binary tree is : " + largestBSTSubtree(root));	

	}

}
