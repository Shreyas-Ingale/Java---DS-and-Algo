import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class priorityQueue_Programs {
	
	static ArrayList<Integer> kLargest(int input[], int k) {
		
		if(input.length == 0 || k == 0)
			return null;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0;i < k;i++)
			pq.add(input[i]);
		for(int i = k;i < input.length;i++) {
			if(pq.peek() < input[i]) {
				pq.poll();
				pq.add(input[i]);
			}
		}
		ArrayList<Integer> rslt = new ArrayList<>();
		for(int i = 0;i < k;i++) {
			rslt.add(pq.peek());
			pq.poll();
		}
		return rslt;
		
	}
	
	static ArrayList<Integer> kSmallest(int[] input, int k) {
		
		if(input.length == 0 || k == 0)
			return null;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0;i < k;i++)
			pq.add(input[i]);
		for(int i = k;i < input.length;i++) {
			if(pq.peek() > input[i]) {
				pq.poll();
				pq.add(input[i]);
			}
		}
		ArrayList<Integer> rslt = new ArrayList<>();
		for(int i = 0;i < k;i++) {
			rslt.add(pq.peek());
			pq.poll();
		}
		Collections.reverse(rslt);
		return rslt;
		
	}
	
	static boolean checkMaxHeap(int arr[]) {
		
		if(arr.length == 0)
			return false;
		
		boolean rslt = true;
		int currIdx = 0;
		int ltchldIndx = (2 * currIdx) + 1;
		int rtchldIndx = (2 * currIdx) + 2;
		while(ltchldIndx < arr.length) {
			if(arr[currIdx] < arr[ltchldIndx])
				rslt = false;
			if(rtchldIndx < arr.length && arr[currIdx] < arr[rtchldIndx])
				rslt = false;
			currIdx++;
			ltchldIndx = (2 * currIdx) + 1;
			rtchldIndx = (2 * currIdx) + 2;
		}
		return rslt;
		
	}
	
	static int kthLargest(int[] input, int k) {
		
		if(input.length == 0 || k == 0)
			return -1;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0;i < k;i++)
			pq.add(input[i]);
		for(int i = k;i < input.length;i++) {
			if(pq.peek() < input[i]) {
				pq.poll();
				pq.add(input[i]);
			}
		}
		return pq.peek();
		
	}
	
	static int buyTicket(int input[], int k) {
		
		if(input.length == 0 || k >= input.length)
			return -1;
		Queue<Integer> idx = new LinkedList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int  i = 0;i < input.length;i++)
			idx.add(i);
		for(int i : input)
			pq.add(i);
		int count = 0;
		while(true) {
			int check = -1;
			if(input[idx.peek()] == pq.peek()) {
				pq.poll();
				check = idx.poll();
				count++;
			}
			else {
				int temp = idx.poll();
				idx.add(temp);
			}
			if(check == k)
				break;
		}
		return count;
		
	}

	public static void main(String[] args) {

		int[] arr = {2,3,2,2,4};
		int k = 3;
//		System.out.println("First " + k + " largest numbers in the array are : ");
//		ArrayList<Integer> rslt = kLargest(arr, k);
//		for(int i : rslt)
//			System.out.print(i + " ");
//		System.out.println("First " + k + " smallest numbers in the array are : ");
//		ArrayList<Integer> rslt = kSmallest(arr, k);
//		for(int i : rslt)
//			System.out.print(i + " ");
//		System.out.println("Status of given array representing a Max-Heap : " + checkMaxHeap(arr));
//		System.out.println("The " + k + " largest element is : " + kthLargest(arr, k));
		System.out.println("Time taken for my ticket is : " + buyTicket(arr, k));
		
	}

}
