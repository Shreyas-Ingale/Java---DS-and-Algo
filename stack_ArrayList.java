import java.util.ArrayList;

public class stack_ArrayList {

	static ArrayList<Integer> data = new ArrayList<>(10);
	static int topidx = -1;
		
	static int size() {
		return topidx+1;
	}
	
	static boolean isEmpty() {
		return topidx == -1;
	}
	
	
	static void push(int item) {
		
		data.add(item);
		topidx++;
	}
	
	static int top() throws StackEmptyException {
		if(topidx == -1)
			throw new StackEmptyException();
		return data.get(topidx);
	}
	
	static int pop() throws StackEmptyException {
		if(topidx == -1)
			throw new StackEmptyException();
		int temp = data.get(topidx);
		topidx--;
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
