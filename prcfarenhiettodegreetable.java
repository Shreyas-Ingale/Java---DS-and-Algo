import java.util.Scanner;

public class prcfarenhiettodegreetable {
	
	public static void printFahrenheitTable(int start, int end, int step) {
		
		for(;start <= end;start += step) {
			int ftod = (5 * (start - 32)) / 9;
			System.out.println(start + "\t" + ftod);
		}
		
	}
	
	public static void main(String[] args) {
		
		int start = new Scanner(System.in).nextInt();
		int end = new Scanner(System.in).nextInt();
		int step = new Scanner(System.in).nextInt();
		
		printFahrenheitTable(start,end,step);
		
	}

}
