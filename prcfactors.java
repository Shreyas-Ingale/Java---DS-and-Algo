import java.util.Scanner;
public class prcfactors {

	public static void main(String[] args) {
		int n,i=2;
		n = new Scanner(System.in).nextInt();
		
		while(i<n) {
			if((n % i) == 0) {
				System.out.print(i + " ");
			}
			i += 1;
		}
	}

}
