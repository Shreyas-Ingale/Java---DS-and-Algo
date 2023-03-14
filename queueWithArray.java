
public class queueWithArray {

	private static int[] data = new int[1];
	private static int front = -1;
	private static int rear = -1;
	private static int size = 0;
	
	static int size() {
		
		return size;
		
	}
	
	static boolean isEmpty() {
		
		return size == 0;
		
	}
	
	static void doubleCapacity() {
		
		System.out.println(" here ");
		int[] temp = data;
		data = new int[temp.length * 2];
		int idx = 0;
		for(int i = front;i < temp.length;i++)
			data[idx++] = temp[i];
		for(int i = 0;i < front;i++) {
			data[idx++] = temp[i];
		}
		front = 0;
		rear = idx-1;
		
	}
	
	static void enqueue(int item) {
		
		if(size == data.length)
			doubleCapacity();
		if(front == -1) {
			front = 0;
		}
		rear = (rear + 1) % data.length;
		data[rear] = item;
		size++;
		
	}
	
	static int front() throws QueueEmptyException {
		
		if(size == 0) {
//			System.out.println(front);
			throw new QueueEmptyException();
		}
		else
			return data[front];
		
	}
	
	static int dequeue() throws QueueEmptyException {
		
		if(size == 0)
			throw new QueueEmptyException();
		else {
			int temp = data[front];
			front = (front + 1) % data.length;
			size--;
			if(size == 0) {
				front = -1;
				rear = -1;
			}
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
//		enqueue(1);
//		enqueue(2);
//		enqueue(3);
//		System.out.println(size());
//		System.out.println(front());
//		System.out.println(isEmpty());
//		System.out.println(dequeue());
//		System.out.println(dequeue());
//		System.out.println(dequeue());
////		System.out.println(front());
//		enqueue(4);
//		System.out.println(front());
//		System.out.println(dequeue());
//		System.out.println(isEmpty());
		

	}

}
