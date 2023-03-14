
class RBTNode<T>{

	T data;
	char color;
	RBTNode<T> right;
	RBTNode<T> left;
	RBTNode<T> parent;
	
	public RBTNode() {}

	public RBTNode(T data) {
		this.data = data;
		color = 'R';
		right = null;
		left = null;
		parent = null;
	}

}

public class redblackTree {
	
	private static RBTNode<String> root;
	private static RBTNode<String> TNULL;
	
	public redblackTree() {
		TNULL = new RBTNode<String>();
		TNULL.color = 'B';
		TNULL.left = null;
		TNULL.right = null;
		root = null;
	}
	
	public static RBTNode<String> minimum(RBTNode<String> node) {
		
		while (node.left != TNULL) {
			node = node.left;
		}
		return node;
		
	}
	
	private static RBTNode<String> rotateLeft(RBTNode<String> node) {
		
		RBTNode<String> nodeX = node.right;
		RBTNode<String> nodeY = nodeX.left;
		nodeX.left = node;
        node.right = nodeY;
        node.parent = nodeX; 
        if(nodeY!=null)
            nodeY.parent = node;
        return(nodeX);
		
	}
	
	private static RBTNode<String> rotateRight(RBTNode<String> node) {
		
		RBTNode<String> nodeX = node.left;
		RBTNode<String> nodeY = nodeX.right;
		nodeX.right = node;
        node.left = nodeY;
        node.parent = nodeX;
        if(nodeY!=null)
        	nodeY.parent = node;
        return(nodeX);
		
	}
	
	private static boolean isOnLeft(RBTNode<String> node) {
		
		return node == node.parent.left; 
		
	}
	
	private static boolean hasRedChild(RBTNode<String> node) {
		return ((node.left != TNULL && node.left.color == 'R') ||
				(node.right != TNULL && node.right.color == 'R'));
	}

	private static RBTNode<String> sibling(RBTNode<String> node) {

		if (node.parent == null)
			return null;

		if (isOnLeft(node))
			return node.parent.right;
		else
			return node.parent.left;
			
	}
	
	private static void swapValues(RBTNode<String> nodeU, RBTNode<String> nodeV) {
		
		String temp;
		temp = nodeU.data;
		nodeU.data = nodeV.data;
		nodeV.data = temp;
		
	}
	
	private static boolean ll = false;
	private static boolean rr = false;
	private static boolean lr = false;
	private static boolean rl = false;
	
	private static RBTNode<String> insertHelper(RBTNode<String> newNode, String data) {
		
        boolean redConflict = false;
        
        if(newNode == null)
            return(new RBTNode<>(data));
        else if(data.compareTo(newNode.data) < 0) {
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
            newNode.left.color = 'R';
            ll = false;
        }
        else if(rr) {
        	newNode = rotateRight(newNode);
        	newNode.color = 'B';
        	newNode.right.color = 'R';
            rr  = false;
        }
        else if(rl) {
        	newNode.right = rotateRight(newNode.right);
        	newNode.right.parent = newNode;
        	newNode = rotateLeft(newNode);
        	newNode.color = 'B';
        	newNode.left.color = 'R';
        	rl = false;
        }
        else if(lr) {
        	newNode.left = rotateLeft(newNode.left);
        	newNode.left.parent = newNode;
        	newNode = rotateRight(newNode);
        	newNode.color = 'B';
        	newNode.right.color = 'R';
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
                	newNode.color = 'B';
                    if(newNode.parent != root)
                    	newNode.parent.color = 'R';
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
                	newNode.color = 'B';
                    if(newNode.parent != root)
                    	newNode.parent.color = 'R';
                }
            }
            redConflict = false;
        }
        return(newNode);  
		
	}
	
	public static void insertNode(String key) {
		
		 if(root==null)
	        {
	            root = new RBTNode<>(key);
	            root.color = 'B';
	        }
	        else
	            root = insertHelper(root,key);
		
	}
	
	private static RBTNode<String> successorNode(RBTNode<String> node) {
		
		RBTNode<String> temp = node;
		while(temp.left != TNULL) {
			temp = temp.left;
		}
		return temp;
		
	}
	
	private static RBTNode<String> bstReplace(RBTNode<String> node){
		
		if(node.left != TNULL && node.right != TNULL)
			return successorNode(node.right);
		if(node.left == TNULL && node.right == TNULL)
			return TNULL;
		if(node.left != TNULL)
			return node.left;
		else
			return node.right;
		
	}
	
	public static void fixDoubleBlack(RBTNode<String> nodeX) {
		
		if(nodeX == root)
			return;
		RBTNode<String> sibling = sibling(nodeX),parent = nodeX.parent;
		if(sibling == TNULL)
			fixDoubleBlack(parent);
		else {
			if(sibling.color == 'R') {
				parent.color = 'R';
				sibling.color = 'B';
				if(isOnLeft(sibling))
					rotateRight(parent);
				else
					rotateLeft(parent);
			}
			else {
				if(hasRedChild(sibling)) {
					if(sibling.left != TNULL && sibling.left.color == 'R') {
						if(isOnLeft(sibling)) {
							sibling.left.color = sibling.color;
							sibling.color = parent.color;
							rotateRight(parent);
						}
						else {
							sibling.left.color = parent.color;
							rotateRight(sibling);
							rotateLeft(parent);
						}
					}
					else {
						if(isOnLeft(sibling)) {
							sibling.right.color = parent.color;
							rotateLeft(sibling);
							rotateRight(parent);
						}
						else {
							sibling.right.color = sibling.color;
							sibling.color = parent.color;
							rotateLeft(parent);
						}
					}
					parent.color = 'B';
				}
				else {
					sibling.color = 'R';
					if(parent.color == 'B')
						fixDoubleBlack(parent);
					else
						parent.color = 'B';
				}
			}
		}
		
	}
	
	private static void deleteNodeHelper(RBTNode<String> nodeV) {
		RBTNode<String> nodeU = bstReplace(nodeV);
		boolean uvBlack = ((nodeU == null || nodeU.color == 'B') && (nodeV.color == 'B'));
		RBTNode<String> parent = nodeV.parent;
		if(nodeU == TNULL) {
			if(nodeV == root)
				root =TNULL;
			else {
				if(uvBlack)
					fixDoubleBlack(nodeV);
				else {
					if(sibling(nodeV) != null || sibling(nodeV) != TNULL)
						sibling(nodeV).color = 'R';
				}
				if(isOnLeft(nodeV))
					parent.left = TNULL;
				else
					parent.right = TNULL;
			}
			return;
		}
		if(nodeV.left == TNULL || nodeV.right == TNULL) {
			if(nodeV == root) {
				nodeV.data = nodeU.data;
				nodeV.left = TNULL;
				nodeV.right = TNULL;
			}
			else {
				if(isOnLeft(nodeV))
					parent.left = nodeU;
				else
					parent.right = nodeU;
				nodeU.parent = parent;
				if(uvBlack)
					fixDoubleBlack(nodeU);
				else
					nodeU.color = 'B';
			}
			return;
		}
		swapValues(nodeU,nodeV);
		deleteNodeHelper(nodeU);
	}
	
	public static void deleteNode(String data) {
		if(root == null)
			return;
		RBTNode<String> temp = searchTree(data);
		if(!temp.data.equals(data)) {
			System.out.println("Given node wasn't found in the Tree.");
			return;
		}
		deleteNodeHelper(temp);
	}
	
	private static RBTNode<String> searchTreeHelper(RBTNode<String> node, String key) {
		if (node == TNULL || key.contentEquals(node.data)) {
			return node;
		}

		if (key.compareTo(node.data) < 0) {
			return searchTreeHelper(node.left, key);
		}
		return searchTreeHelper(node.right, key);
	}

	public static RBTNode<String> searchTree(String k) {
		return searchTreeHelper(root, k);
	}
	
	static void inorderTraversalHelper(RBTNode<String> node) {
		
		if(node!=null)
		{
			inorderTraversalHelper(node.left);
			System.out.print(node.data + " ");
			inorderTraversalHelper(node.right);
		}
		
	}

	public static void inorderTraversal() {
		
		inorderTraversalHelper(root);
		System.out.println();
		
	}

	static void printTreeHelper(RBTNode<String> node) {
		
		if (node != TNULL) {
			System.out.print(node.data + ":");
			if(node.left != TNULL) {
				System.out.print("L-" + node.left.data);
			}
			if(node.left != TNULL && node.right != TNULL) {
				System.out.print(" , ");
			}
			if(node.right != TNULL) {
				System.out.print("R-" + node.right.data);
			}
			System.out.println();

			printTreeHelper(node.left);
			printTreeHelper(node.right);

		}
		
	}

	public static void printTree() {
		
		printTreeHelper(root);
		
	}

	public static void main(String[] args) {
		
		String[] arr = {"55","40","65","60","57"};
		
		for(int i=0;i<arr.length;i++) {
			insertNode(arr[i]);
		}
		inorderTraversal();
		printTree();
		deleteNode("65");
		printTree();

	}

}
