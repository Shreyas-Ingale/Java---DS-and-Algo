import java.util.Scanner;

public class prcdecimaltobinary {

	public static void main(String[] args) {
		long dnum = new Scanner(System.in).nextInt(),pv = 1,bnum = 0;
		while(dnum != 0) {
			long rem = dnum % 2;
			bnum = bnum + pv* rem;
			pv *= 10;
			dnum /= 2;
		}
		System.out.println(bnum);

	}

}
