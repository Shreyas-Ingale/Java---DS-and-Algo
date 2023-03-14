
public class stack_Array {

	static int[] data = new int[10];
	static int topidx = -1;
		
	static int size() {
		return topidx+1;
	}
	
	static boolean isEmpty() {
		return topidx == -1;
	}
	
	static void doublecapacity() {
		int[] temp = data;
		data = new int[temp.length * 2];
		for(int i = 0;i < temp.length;i++)
			data[i] = temp[i];
	}
	
	static void push(int item) {
		if(topidx == data.length-1)
			doublecapacity();
		data[++topidx] = item; 
	}
	
	static int top() throws StackEmptyException {
		if(topidx == -1)
			throw new StackEmptyException();
		return data[topidx];
	}
	
	static int pop() throws StackEmptyException {
		if(topidx == -1)
			throw new StackEmptyException();
		int temp = data[topidx];
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
