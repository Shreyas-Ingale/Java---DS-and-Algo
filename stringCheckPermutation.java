import java.util.Scanner;

public class stringCheckPermutation {
	
	public static boolean isPermutation(String str1, String str2) {
		
		boolean status = true;
		int[] fr1 = new int[256];
		int[] fr2 = new int[256];
		
		if(str1.length() == str2.length()) {
			for(int i = 0;i < str1.length();i++) {
				fr1[str1.codePointAt(i)]++;
			}
			for(int i = 0;i < str2.length();i++) {
				fr2[str2.codePointAt(i)]++;
			}
			for(int i = 0;i < 256;i++) {
				if(fr1[i] != fr2[i]) {
					status = false;
					break;
				}
			}
		}
		else
			status = false;
		
		
		return status;
		
	}
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the first string : ");
		String str1 = s.nextLine();
		System.out.println("Enter the second string : ");
		String str2 = s.nextLine();
		boolean status = isPermutation(str1,str2);
		if(status)
			System.out.println("Given strings are permutations of each other.");
		else
			System.out.println("Given strings ain't permutations of each other");

	}

}
