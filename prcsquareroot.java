import java.util.Scanner;

public class prcsquareroot {

	public static void main(String[] args) {
		
		int num = new Scanner(System.in).nextInt(),i;
		for (i = 1; i * i <= num;i++);
		--i;
		System.out.println(i);
		
	}

}
