import java.util.Scanner;

public class arrayRotate {

	public static void ShiftZeros(int[] arr,int rt) {
		
		for(int s = 0,e = arr.length - 1;s <= e;s++,e--) {
			int temp = arr[s];
			arr[s]=arr[e];
			arr[e] = temp;
		}
		for(int s = 0,e = arr.length - rt - 1;s <= e;s++,e--) {
			int temp = arr[s];
			arr[s]=arr[e];
			arr[e] = temp;
		}
		for(int s = arr.length - rt,e = arr.length - 1;s <= e;s++,e--) {
			int temp = arr[s];
			arr[s]=arr[e];
			arr[e] = temp;
		}
		
//		int[] temp = new int[rt];
//		for(int i = 0;i < rt;i++) {
//			temp[i] = arr[i];
//		}
//		for(int i = 0;i < arr.length - rt;i++) {
//			arr[i] = arr[i + rt];
//		}
//		for(int i = arr.length - rt,j = 0;i < arr.length;i++,j++) {
//			arr[i] = temp[j];
//		}
//		for(int lp = 0;lp < rt;lp++) {
//			int temp = arr[0];
//			for(int i = 0;i < arr.length - 1;i++) {
//				arr[i] = arr[i + 1];
//			}
//			arr[arr.length - 1] = temp;
//		}
		
//		for(int i = rt;i < arr.length;i++) {
//			for(int j = i - 1,lp = rt;lp > 0 ;lp--,j--) {
//				int temp = arr[j + 1];
//				arr[j + 1] = arr[j];
//				arr[j] = temp;
//			}
//		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("Enter the lenght of the array : ");
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		System.out.println("Start entering the elements : ");
		for(int i = 0;i < n;i++) {
			arr[i]= scn.nextInt();
		}
		System.out.println("Enter the rotation number for array : ");
		int rt = scn.nextInt();
		ShiftZeros(arr,rt);
		System.out.println("Sorted Array : ");
		for(int i = 0;i < n;i++) {
			System.out.print(arr[i] + " ");
		}

	}


}
