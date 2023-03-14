import java.util.Scanner;

public class prcbinarytodecimal {

	public static void main(String[] args) {
		int bnum = new Scanner(System.in).nextInt(),pv = 1,dnum = 0;
		while(bnum != 0) {
			int cnum = bnum % 10; 
			dnum = dnum + cnum * pv;
			pv *= 2;
			bnum /= 10;
		}
		System.out.println(dnum);
	}

}
