import java.util.LinkedList;
import java.util.Queue;

public class stack_Queue {

	private static Queue<Integer> q1 = new LinkedList<Integer>();
	private static Queue<Integer> q2 = new LinkedList<Integer>();
		
	static int size() {
		
		return q1.size();
		
	}
	
	static boolean isEmpty() {
		
		return q1.isEmpty();
		
	}
	
	
	static void push(int item) {
		
		q1.add(item);
		
	}
	
	static int top() throws StackEmptyException {
		
		if(q1.isEmpty())
			throw new StackEmptyException();
		else {
			int size = q1.size();
			while(size != 1) {
				q2.add(q1.poll());
				size--;
			}
			int top = q1.peek();
			q2.add(q1.poll());
			while(!q2.isEmpty())
				q1.add(q2.poll());
			return top;
		}
		
	}
	
	static int pop() throws StackEmptyException {
		
		if(q1.isEmpty())
			throw new StackEmptyException();
		else {
			int size = q1.size();
			while(size != 1) {
				q2.add(q1.poll());
				size--;
			}
			int top = q1.poll();
			while(!q2.isEmpty())
				q1.add(q2.poll());
			return top;
		}
		
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
