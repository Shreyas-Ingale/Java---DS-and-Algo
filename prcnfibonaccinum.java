import java.util.Scanner;

public class prcnfibonaccinum {

	public static void main(String[] args) {
		
		int n = new Scanner(System.in).nextInt(),n1 = 1,n2 = 1,n3 = 0;
		if(n == 1) {
			System.out.println('1');
			return;
		}
		if(n == 2) {
			System.out.println('1');
			return;
		}
		for(int i=3;i <= n;i++) {
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
		}
		System.out.println(n3);

	}

}