import java.util.Scanner;

class DynamicArray { 

	int[] data;  

	public DynamicArray() {

		data = new int[6];
	}

	public void set(int i,int num) { 
		
		if(i >= data.length) {
			int temp[] = data;
			data = new int[2*temp.length];
			for(int j = 0;j < temp.length;j++)
				data[j] = temp[j];
		}
		data[i] = num;
	}
	
	public int get(int i) {
		if(i > data.length) {
			return -1;
		}
		else
			return data[i];
	}

	public int size() {
		return data.length;
	}

}

class Polynomial {

	private DynamicArray dCF;
	
	public Polynomial() {
		this.dCF = new DynamicArray();
	}

	public void setCoefficient(int degree, int coeff) {
		this.dCF.set(degree, coeff);
	}


	public void print(){
		for(int i = 0;i < this.dCF.size();i++) {
			int num = this.dCF.get(i);
			if(num != 0) {
				System.out.print(num + "x" + i + " ");
			}
		}
	}



	public Polynomial add(Polynomial p){
		
		Polynomial r = new Polynomial();
		int i;
		int min = Math.min(this.dCF.size(), p.dCF.size());
		for(i = 0;i < min;i++) {
			r.dCF.set(i,(this.dCF.get(i)+p.dCF.get(i)));
		}
		if(i < this.dCF.size()) {
			for(;i<this.dCF.size();i++)
				if(this.dCF.get(i) != 0)
					r.dCF.set(i, this.dCF.get(i));
		}
		else if(i < p.dCF.size()) {
			for(;i<p.dCF.size();i++)
				if(p.dCF.get(i) != 0)
					r.dCF.set(i, p.dCF.get(i));
		}
		return r;
		
	}


	public Polynomial subtract(Polynomial p){
		
		Polynomial r = new Polynomial();
		int i;
		int min = Math.min(this.dCF.size(), p.dCF.size());
		for(i = 0;i < min;i++) {
			r.dCF.set(i,(this.dCF.get(i)-p.dCF.get(i)));
		}
		if(i < this.dCF.size()) {
			for(;i<this.dCF.size();i++)
				if(this.dCF.get(i) != 0)
					r.dCF.set(i, this.dCF.get(i));
		}
		else if(i < p.dCF.size()) {
			for(;i<p.dCF.size();i++)
				if(p.dCF.get(i) != 0)
					r.dCF.set(i, -p.dCF.get(i));
		}
		return r;
		
	}


	public Polynomial multiply(Polynomial p){
		
		Polynomial r = new Polynomial();
		for(int i = 0;i < this.dCF.size()+p.dCF.size();i++) {
			r.dCF.set(i, 0);
		}
        for(int i = 0;i < this.dCF.size();i++) {
        	if(this.dCF.get(i) != 0) {
        		for(int j = 0;j < p.dCF.size();j++) {
        			if(p.dCF.get(j) != 0) {
        				r.dCF.set(i+j, r.dCF.get(i+j)+(this.dCF.get(i)*p.dCF.get(j)));
        			}
        		}
        	}
        }
        return r;
        
	}

}

public class classPolynomialNumber {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int degree1[] = new int[n];
		for(int i = 0; i < n; i++){
			degree1[i] = s.nextInt();
		}
		int coeff1[] = new int[n];
		for(int i = 0; i < n; i++){
			coeff1[i] = s.nextInt();
		}
		Polynomial first = new Polynomial();
		for(int i = 0; i < n; i++){
			first.setCoefficient(degree1[i],coeff1[i]);
		}
		
		n = s.nextInt();
		int degree2[] = new int[n];
		for(int i = 0; i < n; i++){
			degree2[i] = s.nextInt();
		}
		int coeff2[] = new int[n];
		for(int i = 0; i < n; i++){
			coeff2[i] = s.nextInt();
		}
		Polynomial second = new Polynomial();
		for(int i = 0; i < n; i++){
			second.setCoefficient(degree2[i],coeff2[i]);
		}
		
		first.print();
		second.print();
  
		int choice = s.nextInt();
		Polynomial result;
		switch(choice){
		case 1: 
			result = first.add(second);
			result.print();
			break;	
		case 2 :
			result = first.subtract(second);
			result.print();
			break;
		case 3 :
			result = first.multiply(second);
			result.print();
			break;
		}

	}

}


