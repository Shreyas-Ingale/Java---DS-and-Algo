import java.util.Scanner;

public class stringCheckHighestChar {
	
	public static char checkHighest(String str) {
		
		int[] fr = new int[256];
		
		for(int i = 0;i < str.length();i++) {
			fr[str.codePointAt(i)]++;
		}
		int hgnum = 0,hgindx = 0;
		for(int i = 0;i < 256;i++) {
			if(hgnum < fr[i]) {
				hgnum = fr[i];
				hgindx = i;
			}
		}
		char ch = (char)hgindx;
		return ch;
		
	}
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the string : ");
		String str = s.nextLine();
		char ch = checkHighest(str);
		System.out.println("Highest Occuring Character is : " + ch);
		
	}

}
