import java.util.Scanner;

public class prcstringcheck {

	public static void main(String[] args) {
		
//		int prev = 0,curr = 0,i = 1;
//		Scanner scn = new Scanner(System.in);
//		int n = scn.nextInt();
//		int str[] = new int[20];
//		
//		for(int l = 1;l <= n;l++) {
//			str[l] = scn.nextInt();
//		}
//		prev = str[i++];
//		Boolean isDec = true;
//		while(n != 1) {
//			curr = str[i];
//			if(curr < prev) {
//				if(isDec == false) {
//					System.out.println("false");
//					return;
//				}
//				i++;
//			}
//			else if(curr > prev) {
//				isDec = false;
//				i++;
//			}
//			else if(curr == prev){
//				System.out.println("false");
//				return;
//			}
//			prev = curr;
//			n--;
//		}
//		System.out.println("true");
		
		int num = new Scanner(System.in).nextInt();
		int prev = new Scanner(System.in).nextInt();
		int count = 2, crnt;
		boolean isDec = true;
		while(count <= num) {
			crnt = new Scanner(System.in).nextInt();
			count++;
			if(crnt == prev) {
				System.out.println("false");
				return;
			}
			if(crnt<prev) {
				if(isDec == false) {
					System.out.println("false");
					return;
				}
			}
			else {
				if(isDec == true) {
					isDec = false;
				}
			}
			prev = crnt;
		}
		System.out.println("true");
	}

}
