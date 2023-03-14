import java.util.Scanner;

public class arrayLeader {

	public static void findLeader(int[] arr) {
		
		for (int i = 0; i < arr.length; i++)
        {
            int j;
            for (j = i + 1; j < arr.length; j++)
            {
                if (arr[i] < arr[j])
                    break;
            }
            if (j == arr.length)
                System.out.print(arr[i] + " ");
        }
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
		findLeader(arr);
		
	}


}
