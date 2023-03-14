
public class arraySwapalt {

	public static int[] printpairs(int[] arr) {

		 for(int i = 0; i < arr.length; i+= 2) {
			 int j = i + 1;
			 if(j < arr.length) {
				 int temp = arr[i];
				 arr[i] = arr[j];
				 arr[j]= temp;
			 }
		 }
		 return arr;
	 }
	 public static void main(String[] args) {
		 int[] arr = {1,4,7,6,5,9,10};
		 arr = printpairs(arr);
		 for(int i = 0;i < arr.length;i++)
			 System.out.print(arr[i] + " ");
		 }

}
