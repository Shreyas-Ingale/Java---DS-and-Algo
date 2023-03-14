
public class queueWithLinkedList {

	private static LLNode<Integer> front;
	private static LLNode<Integer> rear;
	private static int size;
	
	static int size() {
		
		return size;
		
	}
	
	static boolean isEmpty() {
		
		return size == 0;
		
	}
		
	static void enqueue(int item) {
		
		LLNode<Integer> nnode = new LLNode<>(item);
		if(size == 0) {
			front = nnode;
			rear = nnode;
		}
		else {
			rear.next = nnode;
			rear = nnode;
		}
		size++;
		
	}
	
	static int front() throws QueueEmptyException {
		
		if(size == 0)
			throw new QueueEmptyException();
		else
			return front.data;
		
	}
	
	static int dequeue() throws QueueEmptyException {
		
		if(size == 0)
			throw new QueueEmptyException();
		else {
			int temp = front.data;
			if(front.next != null)
				front = front.next;
			else {
				front = null;
				rear = null;
			}
			size--;
			return temp;
		}
		
	}
	
	public static void main(String[] args) throws QueueEmptyException {
		
		enqueue(1);
		enqueue(2);
		enqueue(3);
		enqueue(4);
		enqueue(5);
		enqueue(6);
		System.out.println(size());
		System.out.println(front());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(size());
//		System.out.println(front());
		enqueue(1);
		enqueue(2);
		enqueue(3);
		System.out.println(size());
		System.out.println(front());
		System.out.println(isEmpty());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(size());
		System.out.println(isEmpty());
//		System.out.println(front());
		enqueue(4);
		System.out.println(front());
		System.out.println(dequeue());
		System.out.println(isEmpty());
		

	}

}
