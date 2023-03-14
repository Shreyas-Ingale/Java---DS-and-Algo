import java.util.Scanner;
public class prctenmultiples {

	public static void main(String[] args) {
		int n, i = 1, mul;
		n = new Scanner(System.in).nextInt();
		
		while(i <= 10) {
			mul = n * i;
			System.out.println(mul);
			i += 1;
		}

	}

}
