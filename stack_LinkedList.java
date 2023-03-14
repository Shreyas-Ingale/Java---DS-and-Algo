
public class stack_LinkedList {

	private static LLNode<Integer> head = null;
	private static int size = 0;
		
	static int size() {
		return size;
	}
	
	static boolean isEmpty() {
		return size == 0;
	}
	
	
	static void push(int item) {
		LLNode<Integer> nnode = new LLNode<>(item);
		nnode.next = head;
		head = nnode;
		size++;
	}
	
	static int top() throws StackEmptyException {
		if(size == 0)
			throw new StackEmptyException();
		return head.data;
	}
	
	static int pop() throws StackEmptyException {
		if(size == 0)
			throw new StackEmptyException();
		int temp = head.data;
		head = head.next;
		size--;
		return temp;
	}
	
	public static void main(String[] args) throws StackEmptyException {
		
		push(10);
		push(20);
		push(30);
		push(40);
		System.out.println(top());
		System.out.println(size());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(size());
		push(10);
		push(20);
		push(30);
		System.out.println(top());
		System.out.println(size());
		System.out.println(isEmpty());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(isEmpty());

	}

}
