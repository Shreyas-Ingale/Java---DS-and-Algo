import java.util.Scanner;

public class stringCompress {
	
	public static String getCompressed(String str) {
		
		int cnt = 1;
		String ans = "" + str.charAt(0);
		for(int i = 1;i < str.length();i++) {
			if(str.charAt(i) == str.charAt(i-1)) {
				cnt++;
				}
			else {
				if(cnt > 1) {
					ans = ans + cnt;
					cnt = 1;
				}
				ans = ans + str.charAt(i);
			}
		}
		if(cnt > 1)
			ans = ans + cnt;
		
		return ans;
		
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the string : ");
		String str = s.nextLine();
		str = getCompressed(str);
		System.out.println("Compressed string is : " + str);
	}

}
