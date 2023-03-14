import java.util.Stack;

public class queueWithStacks {

	private static Stack<Integer> s1 = new Stack<>();
	private static Stack<Integer> s2 = new Stack<>();
	
	static int size() {
		
		return s1.size();
		
	}
	
	static boolean isEmpty() {
		
		return s1.isEmpty();
		
	}
		
	static void enqueue(int item) {
		
		s1.push(item);
		
	}
	
	static int front() throws QueueEmptyException {
		
		if(s1.isEmpty()) {
			throw new QueueEmptyException();
		}
		else {
			while(!s1.isEmpty()) {
				int temp = s1.pop();
				s2.push(temp);
			}
			int front = s2.peek();
			while(!s2.isEmpty()) {
				int temp = s2.pop();
				s1.push(temp);
			}
			return front;
		}
		
	}
	
	static int dequeue() throws QueueEmptyException {
		
		if(s1.isEmpty())
			throw new QueueEmptyException();
		else {
			while(!s1.isEmpty()) {
				int temp = s1.pop();
				s2.push(temp);
			}
			int front = s2.pop();
			while(!s2.isEmpty()) {
				int temp = s2.pop();
				s1.push(temp);
			}
			return front;
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
		System.out.println(isEmpty());
		System.out.println(front());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(isEmpty());
//		System.out.println(front());
		enqueue(4);
		System.out.println(front());
		System.out.println(dequeue());
		System.out.println(isEmpty());
		

	}

}
