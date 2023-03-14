import java.util.Scanner;

public class prcarmstrongnum {
	
public static void main(String[] args) {
		
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(),i = 1;
        int m = n,count = 0,calc = 0;
        
        while(m != 0) {
        	count += 1;
        	m /= 10;
        }
        
        m = n;
        while(m != 0) {
        	int cnt = count,cube = 1;
        	while(cnt > 0) {
        		cube *= (m % 10);
        		cnt -= 1;
        	}
        	calc += cube;
        	m /= 10;
        }
        
        if(calc == n)
        	System.out.println("true");
        else
        	System.out.println("false");
        
	}
	
}
