import java.util.Scanner;

public class stringCountWords {
	
	public static int countWords(String str) {
		
		int words = 1;
		if(str.length() == 0)
			return 0;
		else if(str.charAt(0) == ' ')
			return 0;
		else {
			for(int i = 0;i < str.length();i++) {
				if(str.charAt(i) == ' ') {
					words++;
				}
			}
		}
		
		return words;
		
	}
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		int words = countWords(str);
		System.out.println("Total number of words in the given string are : " + words);

	}

}
