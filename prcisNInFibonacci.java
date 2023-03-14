import java.util.Scanner;

public class prcisNInFibonacci {
		
		public static boolean checkMember(int n) {
			int n1 = 1,n2 = 1,n3 = 0;
			if(n == 1) {
				return true;
			}
			for(int i = 2;i < 20;i++) {
				n3 = n1 + n2;
				n1 = n2;
				n2 = n3;
				if(n == n3) {
					return true;
				}
			}
			return false;
			
		}
		
		public static void main(String[] args) {
			
			int n = new Scanner(System.in).nextInt();
			
			if(checkMember(n))
				System.out.println("true");
			else
				System.out.println("false");
			
		}

}
