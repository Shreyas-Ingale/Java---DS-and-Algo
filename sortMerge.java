import java.util.Scanner;

public class sortMerge {
	
	static void mergeSort(int[] arr){
		
		if(arr.length <= 1)
			return;
		
		int i,mid = arr.length / 2;
        int s1[] = new int[mid];
        int s2[] = new int[arr.length - mid];
        for(i = 0;i < mid;i++)
            s1[i] = arr[i];
        for(int j = 0;i < arr.length;i++,j++)
            s2[j] = arr[i];
		
		mergeSort(s1);
		mergeSort(s2);
		
		int j = 0,k = 0;
		for(i = 0;j < s1.length && k < s2.length;) {
			if(s1[j] < s2[k] ) {
				arr[i++] = s1[j++];
			}
			else
				arr[i++] = s2[k++];
		}
		for(;j < s1.length;)
			arr[i++] = s1[j++];
		for(;k < s2.length;)
			arr[i++] = s2[k++];
		
	}

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the length of the Array : ");
		int s = scn.nextInt();
		int[] srr = new int[s];
		System.out.println("Enter the elements of the Array : ");
		for(int i = 0;i < s;i++)
			srr[i] = scn.nextInt();
		mergeSort(srr);
		for(int i = 0;i < s;i++)
			System.out.print(srr[i] + " ");
		scn.close();
		
	}

}
