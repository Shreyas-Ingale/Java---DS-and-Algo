import java.util.Scanner;

public class recursion_Programs1 {

	static boolean checkAB2(String str) {

		if(str.length() == 0)
			return true;
		boolean rslt = false;
		if(str.charAt(0) == 'a') {
			if(str.length() == 1)
				return true;
			else if(str.charAt(1) == 'a')
				rslt = checkAB2(str.substring(1));
			else if(str.length() >= 3 && (str.charAt(1) == 'b' && str.charAt(2) == 'b')) 
				rslt = checkAB2(str.substring(2));
			else
				return false;
		}
		else if(str.charAt(0) == 'b') {
			if(str.length() == 1)
				return true;
			else if(str.charAt(1) == 'a')
				rslt = checkAB2(str.substring(1));
			else 
				return false;
		}
		return rslt;

	}

	public static boolean checkAB(String str) {

		if(str.charAt(0) != 'a')
			return false;

		return checkAB2(str);

	}

	static boolean checkPalindrome(String str,int si, int ei) {

		if(si == ei)
			return true;
		if(str.charAt(si) != str.charAt(ei)) {
			return false;
		}
		if(si < ei)
			return checkPalindrome(str, si + 1, ei - 1);
		return true;

	}

	public static boolean isStringPalindrome(String input) {

		if(input.length() == 0)
			return true;
		return checkPalindrome(input,0,input.length()-1);

	}
	
	static String addStars(String str) {
		
		if(str.length() == 1)
			return str;
		
		String fnl = new String();
		
		if(str.charAt(0) == str.charAt(1))
			fnl = str.charAt(0) + "*" + addStars(str.substring(1));
		else
			fnl = str.charAt(0) + addStars(str.substring(1));
		
		return fnl;
		
	}
	
	static String removeX(String str) {
		
		if(str.length() == 0)
			return "";
		
		String fnl = removeX(str.substring(1));
		
		if(str.charAt(0) == 'x')
			return fnl;
		else 
			return str.charAt(0) + fnl;
		
		
	}
	
	static String removeDuplicate(String str) {
		
		if(str.length() == 1)
			return str;
		
		String fnl = removeDuplicate(str.substring(1));
		
		if(str.charAt(0) == str.charAt(1))
			return fnl;
		else 
			return str.charAt(0) + fnl;
		
	}

	static String replaceChar(String str,char og,char rp) {
		
		if(str.length() == 0)
			return "";
		
		String fnl = replaceChar(str.substring(1),og,rp);
		
		if(str.charAt(0) == og)
			return rp + fnl;
		else 
			return str.charAt(0) + fnl;
		
	}

	static boolean checkSequence(String a, String b) {
		
		if(a.length() == 0 && b.length() != 0)
			return false;
		if(b.length() == 0)
			return true;
		
		boolean rslt = false;
		
		for(int i = 0;i < a.length();i++) {
			if(b.charAt(0) == a.charAt(i)) {
				rslt = checkSequence(a.substring(i+1), b.substring(1));
				break;
			}
		}
		
		return rslt;
		
	}
	
	static int convertStringToInt(String str){
		
		if(str.length() == 1)
			return str.charAt(0) - '0';
		
		int rslt = convertStringToInt(str.substring(0, str.length() - 1)) * 10 + (str.charAt(str.length() - 1) - '0');
		return rslt;
		
	}
	
	static void towerOfHanoi(int n, char src, char hlp, char dest) {
		
		if(n == 1) {
			System.out.println(src + " " + dest);
			return;
		}
		
		towerOfHanoi(n-1,src,dest,hlp);
		System.out.println(src + " " + dest);
		towerOfHanoi(n-1,hlp,src,dest);
		
	}
	
	static int staircase(int n) {
		
		if(n < 0)
			return 0;
		if(n == 0 || n == 1)
			return 1;
		
		int x = staircase(n-3);
		int y = staircase(n-2);
		int z = staircase(n-1);
		
		return x + y + z;
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
//		String input = s.nextLine();
//		System.out.println(checkAB(input));
//		String input = s.nextLine();
//		System.out.println(isStringPalindrome(input));
//		String input = s.nextLine();
//		System.out.println(addStars(input));
//		System.out.println(removeX("xx"));
//		System.out.println(removeDuplicate("abcdd"));
//		System.out.println(replaceChar("abacd",'a','x'));
//		String large = s.nextLine();
//		String small = s.nextLine();
//		System.out.println(checkSequence(large, small));
//		String input = s.nextLine();
//		System.out.println(convertStringToInt(input));
//		int n = s.nextInt();
//		towerOfHanoi(n, 'a', 'b', 'c');
//		int n = s.nextInt();
//		System.out.println(staircase(n));

	}

}
