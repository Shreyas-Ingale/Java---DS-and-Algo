import java.util.Scanner;
public class prctotalsalary {
	
	public static double clactotsal(int basic, char grd) {
		double totsal, hra, da, pf, allow;
		
		hra = (basic * 20.0)/100.0;
		da = (basic * 50.0)/100.0;
		pf = (basic * 11.0)/100.0;
		
		if(grd == 'A') {
			allow = 1700.0;
		}
		else if(grd == 'B'){
			allow = 1500.0;
		}
		else {
			allow = 1300.0;
		}
		
		totsal = basic + hra + da + allow - pf;
		totsal = Math.round(totsal);
		
		return(totsal);
	}

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int basic = scn.nextInt();
		String str = scn.next();
		char grd = str.charAt(0);
		
		int totsal = (int)clactotsal(basic, grd);
		
		System.out.println(totsal);

	}

}
