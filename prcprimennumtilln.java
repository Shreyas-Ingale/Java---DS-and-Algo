import java.util.Scanner;

public class prcprimennumtilln {
	
	public static boolean isPrime(int n) {
		boolean result = true;
		for(int i = 2;i < n;i++) {
			if (n % i == 0) {
				result = false;
			}
		}
		return result;
	}
	
	public static void prime(int n) {
		for(int i = 2;i <= n;i++) {
			if(isPrime(i)) {
				System.out.println(i);
			}
		}
	}

	public static void main(String[] args) {
		
		int n = new Scanner(System.in).nextInt();
		
		if(n == 0 || n == 1) {
			return;
		}
		 prime(n);
	}

}
