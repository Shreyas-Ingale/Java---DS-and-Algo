
public class sortHeap {
	
	private static void downHeapify(int[] arr,int i,int n) {
		
		int currentIndex = i;
		int leftchildIndex = (2 * currentIndex) + 1;
		int rightchildIndex = (2 * currentIndex) + 2;
		while(leftchildIndex < n) {
			int minIndex = currentIndex;
			if(arr[leftchildIndex] > arr[minIndex])
				minIndex = leftchildIndex;
			if(rightchildIndex < n && arr[rightchildIndex] > arr[minIndex])
				minIndex = rightchildIndex;
			if(minIndex == currentIndex)
				return;
			int temp = arr[currentIndex];
			arr[currentIndex] = arr[minIndex];
			arr[minIndex] = temp;
			currentIndex = minIndex;
			leftchildIndex = (2 * currentIndex) + 1;
			rightchildIndex = (2 * currentIndex) + 2;
		}
		
	}
	
	static void heapSort(int[] arr) {
		
		if(arr.length == 0)
			return;
		
		int n = arr.length;
		for(int i = (n/2)-1;i >= 0;i--)
			downHeapify(arr,i,n);
		for(int i = n-1;i >= 0;i--) {
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			downHeapify(arr, 0, i);
		}
		
	}

	public static void main(String[] args) {
		
		int[] arr = {4,7,5,3,2,8,9,6,1};
		heapSort(arr);
		for(int i : arr)
			System.out.print(i + " ");
		
	}

}
