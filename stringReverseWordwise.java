import java.util.Scanner;

public class stringReverseWordwise {
	
	public static String reverseWordwise(String str) {
		
		int i,cnt = 0,wrdstrt = 0;
		String ans = "";
		for(i = 0;i < str.length();i++) {
			if(str.charAt(i) == ' ') {
				int wrdnd = i - 1;
				String curr = "";
				for(int j = wrdstrt;j <= wrdnd;j++) {
					curr = str.substring(wrdstrt, wrdnd+1);
				}
				ans = curr + " " + ans;
				wrdstrt = i + 1;
			}
			if(i == str.length() - 1) {
				int wrdnd = i;
				String curr = "";
				for(int j = wrdstrt;j <= wrdnd;j++) {
					curr = str.substring(wrdstrt, wrdnd+1);
				}
				ans = curr + " " + ans;
			}
		}
		return ans;
		
	}
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		str = reverseWordwise(str);
		System.out.println("Word wise reversed string : " + str);

	}

}
