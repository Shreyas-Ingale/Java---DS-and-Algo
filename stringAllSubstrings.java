import java.util.Scanner;

public class stringAllSubstrings {
	
	public static void allSubstrings(String str) {
		
		//by chars;
//		for(int i = 0;i < str.length();i++) {
//			for(int j = i;j < str.length();j++) {
//				System.out.println(str.substring(i,j + 1));
//			}
//		}
		
		//by length;
//		for(int i = 0;i < str.length();i++) {
//			for(int j = 0;j + i < str.length();j++) {
//				System.out.println(str.substring(j,j + 1 + i));
//			}
//		}
		
	}
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		allSubstrings(str);

	}

}
