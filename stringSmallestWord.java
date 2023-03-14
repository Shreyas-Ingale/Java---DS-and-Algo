import java.util.Scanner;

public class stringSmallestWord {
	
	public static String smallestWord(String str) {
		
		String word = "";
		int i,smlwrd = Integer.MAX_VALUE,wrdstrt = 0;
		for(i = 0;i < str.length();i++) {
			if(str.charAt(i) == ' ') {
				int wrdnd = i - 1;
				int crrsize = wrdnd - wrdstrt + 1;
				if(crrsize < smlwrd) {
					for(int j = wrdstrt;j <= wrdnd;j++) {
						word = str.substring(wrdstrt, wrdnd+1);
					}
					smlwrd = crrsize;
				}
				wrdstrt = i + 1;
			}
			if(i == str.length() - 1) {
				int wrdnd = i;
				int crrsize = wrdnd - wrdstrt + 1;
				if(crrsize < smlwrd) {
					for(int j = wrdstrt;j <= wrdnd;j++) {
						word = str.substring(wrdstrt, wrdnd+1);
					}
					smlwrd = crrsize;
				}
			}
		}
		return word;
		
	}
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		String word = smallestWord(str);
		System.out.println("Smallest Word is : " +word);
		
	}

}
