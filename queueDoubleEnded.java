
public class queueDoubleEnded {
	

	private static int[] data = new int[10];
	private static int front = -1;
	private static int rear = -1;
	private static int size = 0;
	
//	public queueDoubleEnded() {
//		data = new int[10];
//		front = -1;
//		rear = -1;
//		size = 0;
//	}
	
	public static void insertFront(int item) {
		
		if(size == data.length) {
			System.out.println("-1");
			return;
		}
		if(size == 0) {
			front = 0;
			rear = 0;
			data[front] = item;
			size++;
		}
		else {
			int[] temp = new int[10];
			for(int i = 1;i < data.length;i++)
				temp[i] = data[i-1];
			temp[0] = item;
			data = temp;
			rear ++;
			size++;
		}
		
	}
	
	public static void insertRear(int item) {
		
		if(size == data.length) {
			System.out.println("-1");
			return;
		}
		if(size == 0) {
			front = 0;
			rear = 0;
			data[rear] = item;
			size++;
		}
		else {
			rear++;
			data[rear] = item;
			size++;
		}
		
	}
	
	public static void deleteFront(int item) {
		
		if(size == 0) {
			System.out.print("-1");
			return;
		}
		int temp[] = new int[10];
		for(int i = 1;i < data.length;i++)
			temp[i-1] = data[i];
		data = temp;
		rear--;
		size--;
		
	}
	
	public static void deleteRear() {
		
		if(size == 0) {
			System.out.println("-1");
			return;
		}
		data[rear] = 0;
		rear--;
		size--;
		
	}
	
	public static int getFront() {
		
		if(size == 0) {
			return -1;
		}
		return data[front];
		
	}

	public static int getRear() {
		
		if(size == 0) {
			return -1;
		}
		return data[rear];
	}

	public static void main(String[] args) {
		
		

	}

}
