import java.util.Scanner;

public class stringRemoveCertainElement {
	
	public static String removeElement(String str,char ch) {
		
		String ans = "";
		for(int i = 0;i < str.length();i++) {
			if(str.charAt(i) != ch) {
				ans = ans + str.charAt(i);
				}	
		}
		return ans;
		
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the string : ");
		String str = s.nextLine();
		System.out.println("Enter the element to be removed : ");
		String x = s.next();
		str = removeElement(str,x.charAt(0));
		System.out.println("Corrected string is : " + str);
		
	}

}
