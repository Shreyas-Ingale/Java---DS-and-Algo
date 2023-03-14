import java.util.Scanner;

public class prcpattern {
	
public static void main(String[] args) {
		
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(),i = 1;
        while(i <= n) {
        	int j = 1,k = 1;
        	while(j <= n - i) {
        		System.out.print(n - j + 1);
        		j += 1;
        	}
        	System.out.print('*');
        	while(k <= i - 1) {
        		System.out.print(i - k);
        		k += 1;
        	}
        	i += 1;
        	System.out.println();
        }

	}
	
}
