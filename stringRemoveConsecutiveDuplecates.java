import java.util.Scanner;

public class stringRemoveConsecutiveDuplecates {
	
	public static String removeDuplicate(String str) {
		
		int cnt = 0;
		String ans = "" + str.charAt(0);
		for(int i = 1;i < str.length();i++) {
			if(str.charAt(i) != str.charAt(i-1)) {
				if(ans.charAt(cnt) != str.charAt(i-1))
					ans = ans + str.charAt(i) + str.charAt(i-1);
				else
					ans = ans + str.charAt(i);
				cnt++;
				}	
		}
		return ans;
		
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the string : ");
		String str = s.nextLine();
		str = removeDuplicate(str);
		System.out.println("Corrected string is : " + str);
	}

}
