import java.util.Scanner;

class ComplexNumbers {
	
	private int real;
	private int imaginary;
	
	ComplexNumbers(int rl,int img){
		this.real = rl;
		this.imaginary = img;
	}
	
	void add(ComplexNumbers c2) {
		this.real = this.real + c2.real;
		this.imaginary = this.imaginary + c2.imaginary;
	}
	
	void mult(ComplexNumbers c2) {
		int real = this.real * c2.real - this.imaginary * c2.imaginary;
		int imaginary = this.real * c2.imaginary + this.imaginary * c2.real;
		this.real = real;
		this.imaginary = imaginary;
	}
	
	void print() {
		System.out.println(this.real + " + i" + this.imaginary);
	}
	
	
}

public class classComplexNumber {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the first complex number : ");
		int real1 = s.nextInt();
		int imaginary1 = s.nextInt();
		System.out.println("Enter the second complex number : ");
		int real2 = s.nextInt();
		int imaginary2 = s.nextInt();
		
		ComplexNumbers c1 = new ComplexNumbers(real1,imaginary1);
		ComplexNumbers c2 = new ComplexNumbers(real2,imaginary2);
		
		System.out.println("Enter your choice :- (1 - Adddition|2- Multiplication) : ");
		int ch = s.nextInt();
		
		if(ch == 1) {
			c1.add(c2);
			c1.print();
		}
		else if(ch == 2) {
			c1.mult(c2);
			c1.print();
		}
		else {
			return;
		}

	}

}
