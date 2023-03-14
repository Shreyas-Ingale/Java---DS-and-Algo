import java.util.Scanner;

public class sortQuick {
	
	public static int partition(int[] arr,int si,int ei) {
		
		int pvt = arr[si],cnt = 0;
		
		for(int l = si + 1;l <= ei;l++) {
			if(pvt > arr[l])
				cnt++;
		}
		
		int temp = arr[si + cnt];
		arr[si + cnt] = pvt;
		arr[si] = temp;
		
		int i = si,j = ei;
		while(i < j){
			if(arr[i] < pvt) {
				i++;
			}
			else if(arr[j] >= pvt){
				j--;
			}
			else {
				temp = arr[i];
				arr[i++] = arr[j];
				arr[j--] = temp;
			}
		}
		return si + cnt;
	}
	
	public static void sort(int[] arr,int si,int ei) {
		
		if(si >= ei)
			return;
		
		int pvtidx = partition(arr,si,ei);
		sort(arr,si,pvtidx-1);
		sort(arr,pvtidx+1,ei);
		
	}
	
	public static void quickSort(int[] arr) {
		
		sort(arr,0,arr.length-1);
		
	}

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the length of the Array : ");
		int l = scn.nextInt();
		int[] arr = new int[l];
		System.out.println("Enter the elements of the Array : ");
		for(int i = 0;i < l;i++)
			arr[i] = scn.nextInt();
		quickSort(arr);
		for(int i = 0;i < l;i++)
			System.out.print(arr[i] + " ");
		scn.close();

	}

}
