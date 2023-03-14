
class MapNode1 {  

	Integer key;  
	String value;
	Character color;
	MapNode1 left;
	MapNode1 right;
	MapNode1 parent;
	public MapNode1() {}
	public MapNode1(Integer key,String value) {
		this.key = key;
		this.value = value;
		color = 'R';
		right = null;
		left = null;
		parent = null;
	}

}

class Map1{

	private MapNode1 root = null;

	public MapNode1 minimum(MapNode1 node) {

		while (node.left != null) {
			node = node.left;
		}
		return node;

	}

	private MapNode1 rotateLeft(MapNode1 node) {

		MapNode1 nodeX = node.right;
		MapNode1 nodeY = nodeX.left;
		nodeX.left = node;
		node.right = nodeY;
		node.parent = nodeX; 
		if(nodeY!=null)
			nodeY.parent = node;
		return(nodeX);

	}

	private MapNode1 rotateRight(MapNode1 node) {

		MapNode1 nodeX = node.left;
		MapNode1 nodeY = nodeX.right;
		nodeX.right = node;
		node.left = nodeY;
		node.parent = nodeX;
		if(nodeY!=null)
			nodeY.parent = node;
		return(nodeX);

	}

	private boolean isOnLeft(MapNode1 node) {

		return node == node.parent.left; 

	}

	private boolean hasRedChild(MapNode1 node) {
		return ((node.left != null && node.left.color == 'R') ||
				(node.right != null && node.right.color == 'R'));
	}

	private MapNode1 sibling(MapNode1 node) {

		if (node.parent == null)
			return null;

		if (isOnLeft(node))
			return node.parent.right;
		else
			return node.parent.left;

	}

	private void swapKeyValues(MapNode1 nodeU, MapNode1 nodeV) {

		int temp;
		String temp1;
		temp = nodeU.key;
		temp1 = nodeU.value;//
		nodeU.key = nodeV.key;
		nodeU.value = nodeV.value;//
		nodeV.key = temp;
		nodeV.value = temp1;//

	}

	private MapNode1 successorNode(MapNode1 node) {

		MapNode1 temp = node;
		while(temp.left != null) {
			temp = temp.left;
		}
		return temp;

	}

	private MapNode1 bstReplace(MapNode1 node){

		if(node.left != null && node.right != null)
			return successorNode(node.right);
		if(node.left == null && node.right == null)
			return null;
		if(node.left != null)
			return node.left;
		else
			return node.right;

	}

	private static boolean ll = false;
	private static boolean rr = false;
	private static boolean lr = false;
	private static boolean rl = false;

	private MapNode1 insertHelper(MapNode1 newNode, int data) {

		boolean redConflict = false;

		if(newNode == null)
			return(new MapNode1(data,"R"));
		else if(data < newNode.key) {
			newNode.left = insertHelper(newNode.left, data);
			newNode.left.parent = newNode;
			if(newNode != root) {
				if(newNode.color == 'R' && newNode.left.color == 'R')
					redConflict = true;
			}
		}
		else {
			newNode.right = insertHelper(newNode.right,data);
			newNode.right.parent = newNode;
			if(newNode != root) {
				if(newNode.color == 'R' && newNode.right.color == 'R')
					redConflict = true;
			}
		}

		if(ll) {
			newNode = rotateLeft(newNode);
			newNode.color = 'B';
			newNode.value = "B";//
			newNode.left.color = 'R';
			newNode.left.value = "R";//
			ll = false;
		}
		else if(rr) {
			newNode = rotateRight(newNode);
			newNode.color = 'B';
			newNode.value = "B";//
			newNode.right.color = 'R';
			newNode.right.value = "R";//
			rr  = false;
		}
		else if(rl) {
			newNode.right = rotateRight(newNode.right);
			newNode.right.parent = newNode;
			newNode = rotateLeft(newNode);
			newNode.color = 'B';
			newNode.value = "B";//
			newNode.left.color = 'R';
			newNode.left.value = "R";//
			rl = false;
		}
		else if(lr) {
			newNode.left = rotateLeft(newNode.left);
			newNode.left.parent = newNode;
			newNode = rotateRight(newNode);
			newNode.color = 'B';
			newNode.value = "B";//
			newNode.right.color = 'R';
			newNode.right.value = "R";//
			lr = false;
		}

		if(redConflict)
		{
			if(newNode.parent.right == newNode) {
				if(newNode.parent.left == null || newNode.parent.left.color == 'B') {
					if(newNode.left != null && newNode.left.color == 'R')
						rl = true;
					else if(newNode.right != null && newNode.right.color == 'R')
						ll = true;
				}
				else {
					newNode.parent.left.color = 'B';
					newNode.parent.left.value = "B";//
					newNode.color = 'B';
					newNode.value = "B";//
					if(newNode.parent != root) {
						newNode.parent.color = 'R';
						newNode.parent.value = "R";//
					}
				}
			}
			else {
				if(newNode.parent.right == null || newNode.parent.right.color == 'B') {
					if(newNode.left != null && newNode.left.color == 'R')
						rr = true;
					else if(newNode.right != null && newNode.right.color == 'R')
						lr = true;
				}
				else {
					newNode.parent.right.color = 'B';
					newNode.parent.right.value = "B";//
					newNode.color = 'B';
					newNode.value = "B";//
					if(newNode.parent != root) {
						newNode.parent.color = 'R';
						newNode.parent.value = "R";//
					}
				}
			}
			redConflict = false;
		}
		return(newNode);  


	}

	public void insertNode(int key) {

		if(root==null)
        {
            root = new MapNode1(key,"R");
            root.color = 'B';
            root.value = "B";//
        }
        else
            root = insertHelper(root,key);
		
	}

	public void fixDoubleBlack(MapNode1 nodeX) {

		if(nodeX == root)
			return;
		MapNode1 sibling = sibling(nodeX),parent = nodeX.parent;
		if(sibling == null)
			fixDoubleBlack(parent);
		else {
			if(sibling.color == 'R') {
				parent.color = 'R';
				parent.value = "R";//
				sibling.color = 'B';
				sibling.value = "B";//
				if(isOnLeft(sibling))
					rotateRight(parent);
				else
					rotateLeft(parent);
			}
			else {
				if(hasRedChild(sibling)) {
					if(sibling.left != null && sibling.left.color == 'R') {
						if(isOnLeft(sibling)) {
							sibling.left.color = sibling.color;
							sibling.left.value = sibling.value;//
							sibling.color = parent.color;
							sibling.value = parent.value;//
							rotateRight(parent);
						}
						else {
							sibling.left.color = parent.color;
							sibling.left.value = parent.value;//
							rotateRight(sibling);
							rotateLeft(parent);
						}
					}
					else {
						if(isOnLeft(sibling)) {
							sibling.right.color = parent.color;
							sibling.right.value = parent.value;//
							rotateLeft(sibling);
							rotateRight(parent);
						}
						else {
							sibling.right.color = sibling.color;
							sibling.right.value = sibling.value;//
							sibling.color = parent.color;
							sibling.value = parent.value;//
							rotateLeft(parent);
						}
					}
					parent.color = 'B';
					parent.value = "B";//
				}
				else {
					sibling.color = 'R';
					sibling.value = "R";//
					if(parent.color == 'B')
						fixDoubleBlack(parent);
					else {
						parent.color = 'B';
						parent.value = "B";//
					}
				}
			}
		}

	}

	private void deleteNodeHelper(MapNode1 nodeV) {
		MapNode1 nodeU = bstReplace(nodeV);
		boolean uvBlack = ((nodeU == null || nodeU.color == 'B') && (nodeV.color == 'B'));
		MapNode1 parent = nodeV.parent;
		if(nodeU == null) {
			if(nodeV == root)
				root =null;
			else {
				if(uvBlack)
					fixDoubleBlack(nodeV);
				else {
					if(sibling(nodeV) != null || sibling(nodeV) != null) {
						sibling(nodeV).color = 'R';
						sibling(nodeV).value = "R";//
					}
				}
				if(isOnLeft(nodeV))
					parent.left = null;
				else
					parent.right = null;
			}
			return;
		}
		if(nodeV.left == null || nodeV.right == null) {
			if(nodeV == root) {
				nodeV.key = nodeU.key;
				nodeV.value = nodeV.color.toString();
				nodeV.left = null;
				nodeV.right = null;
			}
			else {
				if(isOnLeft(nodeV))
					parent.left = nodeU;
				else
					parent.right = nodeU;
				nodeU.parent = parent;
				if(uvBlack)
					fixDoubleBlack(nodeU);
				else {
					nodeU.color = 'B';
					nodeU.value = "B";//
				}
			}
			return;
		}
		swapKeyValues(nodeU,nodeV);
		deleteNodeHelper(nodeU);
	}

	public void deleteNode(int key) {
		if(root == null)
			return;
		MapNode1 temp = searchTree(key);
		if(temp.key != key) {
			System.out.println("Given node wasn't found in the Tree.");
			return;
		}
		deleteNodeHelper(temp);
	}

	private MapNode1 searchTreeHelper(MapNode1 node, int key) {
		if (node == null || key == node.key) {
			return node;
		}

		if (key < node.key) {
			return searchTreeHelper(node.left, key);
		}
		return searchTreeHelper(node.right, key);
	}

	public MapNode1 searchTree(int k) {
		return searchTreeHelper(root, k);
	}

	void inorderTraversalHelper(MapNode1 node) {

		if(node!=null)
		{
			inorderTraversalHelper(node.left);
			System.out.print(node.key + " ");
			inorderTraversalHelper(node.right);
		}

	}

	public void inorderTraversal() {

		inorderTraversalHelper(root);
		System.out.println();

	}

	void printTreeHelper(MapNode1 node) {

		if (node != null) {
			System.out.print(node.key + "(" + node.value + ")" + ":");
			if(node.left != null) {
				System.out.print("L-" + node.left.key);
			}
			if(node.left != null && node.right != null) {
				System.out.print(" , ");
			}
			if(node.right != null) {
				System.out.print("R-" + node.right.key);
			}
			System.out.println();

			printTreeHelper(node.left);
			printTreeHelper(node.right);

		}

	}

	public void printTree() {

		printTreeHelper(root);

	}

}

public class treeMap_RBT {

	public static void main(String[] args) {

		Map1 map = new Map1();
		int[] arr = {55,40,65,60,57,75};
		for(int i=0;i<arr.length;i++) {
			map.insertNode(arr[i]);
		}
		map.inorderTraversal();
		map.printTree();
		map.deleteNode(65);
		map.printTree();

	}

}
