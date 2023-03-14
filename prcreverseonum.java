import java.util.Scanner;

public class prcreverseonum {

	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt(),rnum = 0;
		while(n!=0) {
			int cnum = n % 10;
			rnum = rnum * 10 + cnum;
			n /= 10;
		}
		System.out.println(rnum);
	}

}
