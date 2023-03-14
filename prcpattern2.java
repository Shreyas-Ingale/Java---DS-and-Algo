import java.util.Scanner;

public class prcpattern2 {
	
public static void main(String[] args) {
		
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(),i = 1;
        while(i <= n) {
        	int j = 1,k = 1,l = 1,m = 1;
        	while(j <= i - 1) {
        		System.out.print("0");
        		j += 1;
        	}
        	System.out.print("*");
        	while(k <= n - i) {
        		System.out.print("0");
        		k += 1;
        	}
        	System.out.print("*");
        	while(l <= n - i) {
        		System.out.print("0");
        		l += 1;
        	}
        	System.out.print("*");
        	while(m <= i - 1) {
        		System.out.print("0");
        		m += 1;
        	}
        	i += 1;
        	System.out.println();
        }

	}
	
}
