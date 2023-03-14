import java.util.Scanner;

public class stringReverseCharWise {
	
	public static String reverseCharwise(String str) {
		
		int i,cnt = 0,wrdstrt = 0;
		String ans = "";
		for(i = 0;i < str.length();i++) {
			if(str.charAt(i) == ' ') {
				int wrdnd = i - 1;
				String curr = "";
				for(int j = wrdstrt;j <= wrdnd;j++) {
					curr = str.charAt(j) + curr;
				}
				ans = ans + curr + " ";
				wrdstrt = i + 1;
			}
			if(i == str.length() - 1) {
				int wrdnd = i;
				String curr = "";
				for(int j = wrdstrt;j <= wrdnd;j++) {
					curr = str.charAt(j) + curr;
				}
				ans = ans + curr;
			}
		}
		return ans;
		
	}
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		str = reverseCharwise(str);
		System.out.println("Word wise reversed string : " + str);

	}

}
