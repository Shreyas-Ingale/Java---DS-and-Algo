
import java.util.ArrayList;

class PQNode<E>{
	
	E value;
	int priority;
	public PQNode(E value, int priority) {
		this.value = value;
		this.priority = priority;
	}
	
}

class priorityQueue<T>{
	
	private ArrayList<PQNode<T>> heap;
	
	public priorityQueue() {
		
		heap = new ArrayList<>();
		
	}
	
	void insert(T value,int priority) {
		
		heap.add(new PQNode<>(value, priority));
		int childIndex = heap.size()-1;
		int parentIndex = (childIndex-1)/2;
		while(childIndex > 0) {
			if(heap.get(childIndex).priority < heap.get(parentIndex).priority) {
				PQNode<T> temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex-1)/2;
			}
			else
				return;
		}
		
	}
	
	T getMin() throws QueueEmptyException {
		
		if(heap.isEmpty())
			throw new QueueEmptyException();
		return heap.get(0).value;
		
	}
	
	T removeMin() throws QueueEmptyException {
		
		if(heap.isEmpty())
			throw new QueueEmptyException();
		PQNode<T> temp = heap.get(0);
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		int currentIndex = 0;
		int leftChildIndex = (2*currentIndex)+1;
		int rightChildIndex = (2*currentIndex)+2;
		
		while(leftChildIndex < heap.size()) {
			int minIndex = currentIndex;
			if(heap.get(leftChildIndex).priority < heap.get(minIndex).priority)
				minIndex = leftChildIndex;
			if(rightChildIndex < heap.size() && heap.get(rightChildIndex).priority < heap.get(minIndex).priority)
				minIndex = rightChildIndex;
			if(minIndex == currentIndex)
				break;
			PQNode<T> temp1 = heap.get(currentIndex);
			heap.set(currentIndex, heap.get(minIndex));
			heap.set(minIndex, temp1);
			currentIndex = minIndex;
			leftChildIndex = (2*currentIndex)+1;
			rightChildIndex = (2*currentIndex)+2;
		}
		
		
		return temp.value;
	}
	
	int size() {
		
		return heap.size();
		
	}
	
	boolean isEmpty() {
		
		return heap.isEmpty();
		
	}
	
}

public class priorityQueue_MinHeap {

	public static void main(String[] args) throws QueueEmptyException {

		priorityQueue<String> pq = new priorityQueue<String>();
		
		pq.insert("abc", 15);
		pq.insert("def", 13);
		pq.insert("popopop", 90);
		pq.insert("mlmlmlml", 150);
		pq.insert("xvxvxvx", 120);
		
		while(!pq.isEmpty()) {
			System.out.println(pq.removeMin());
		}

	}

}
