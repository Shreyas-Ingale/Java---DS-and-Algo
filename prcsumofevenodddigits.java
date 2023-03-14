import java.util.Scanner;

public class prcsumofevenodddigits {

	public static void main(String[] args) {
		int num, sum_e = 0, sum_o = 0;
		
		num = new Scanner(System.in).nextInt();
		
		while(num != 0) {
			int digit = num % 10;
			
			if((digit % 2) == 0){
				sum_e += digit;
			}
			else {
				sum_o += digit;
			}
			
			num /= 10;
		}
		
		System.out.println(sum_e + " " + sum_o);

	}

}
