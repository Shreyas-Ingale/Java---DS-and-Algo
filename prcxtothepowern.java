import java.util.Scanner;
public class prcxtothepowern {

	public static void main(String[] args) {
		int x,n,i = 1,calc = 1;
		Scanner scn = new Scanner(System.in);
		x = scn.nextInt();
		n = scn.nextInt();
		
		while(i <= n) {
			 calc *= x;
			 i += 1;
		}
		
		System.out.println(calc);
	}

}
