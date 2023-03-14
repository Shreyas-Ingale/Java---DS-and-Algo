import java.util.Scanner;

public class prcsumorpdct {

	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();
		int c = new Scanner(System.in).nextInt();
		int sm = 0,prdct = 1;
		
		if(c == 1) {
			for(int i = 1;i <= n;i++) {
				sm += i;
			}
			System.out.println(sm);
		}
		else if(c == 2) {
			for(int i = 1;i <= n;i++) {
				prdct *= i;
			}
			System.out.println(prdct);
		}
		else {
			System.out.println("-1");
		}

	}

}
