import java.util.Scanner;

public class stringCheckPalindrome {
	
	public static boolean checkPalindrome(String str) {
		
		int s = 0,e = str.length() - 1;
		boolean status = true;
		while(s <= e) {
			if(str.charAt(s) != str.charAt(e)) {
				status = false;
				break;
			}
			else {
				s++;
				e--;
			}
		}
		return status;
		
	}
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		boolean status = checkPalindrome(str);
		if(status)
			System.out.println("give string is a palindrome.");
		else
			System.out.println("give string is not a palindrome.");

	}

}
