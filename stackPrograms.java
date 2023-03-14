import java.util.*;

public class stackPrograms {

	static boolean isBalanced(String expr) {
		if(expr == null)
			return true;
		Stack<Character> stack = new Stack<>();
		for(int i = 0;i < expr.length();i++) {
			char x = expr.charAt(i);
			if(x == '(' || x == '[' || x == '{') {
				stack.push(x);
				continue;
			}
			if(stack.isEmpty())
				return false;
			char check;
			switch (x) {
			case ')': {
				check = stack.pop();
				if(check == '[' || check == '{')
					return false;
				break;
			}
			case ']': {
				check = stack.pop();
				if(check == '(' || check == '{')
					return false;
				break;
			}
			case '}': {
				check = stack.pop();
				if(check == '[' || check == '(')
					return false;
				break;
			}
			}
		}
		return stack.isEmpty();

	}
	
	static void transfer(Stack<Integer> s1,Stack<Integer> s2,int n) {
		for(int i = 0;i < n;i++) {
			int temp = s1.pop();
			s2.push(temp);
		}
	}
	
	static void stackReverse(Stack<Integer> s1,Stack<Integer> s2) {
		int n = s1.size();
		for(int i = 0;i < n;i++) {
			int x = s1.pop();
			transfer(s1, s2, n - i - 1);
			s1.push(x);
			transfer(s2, s1, n - i - 1);
		}
	}
	
	static boolean checkBracketRedunduncy(String str) {
		
		Stack<Character> stack = new Stack<>();
		for(int i = 0;i < str.length();i++) {
			char ch = str.charAt(i);
			if(ch == ')') {
				char top = stack.pop();
				boolean flag = true;
				while(top != '(') {
					if(top == '+' || top == '-' || top == '*' || top == '%' || top == '/')
						flag = false;
					top = stack.pop();
				}
				if(flag)
					return true;
			}
			else
				stack.push(ch);
		}
		return false;
		
	}
	
	static int[] calcStockSpan(int[] price) {
		
		int[] rslt = new int[price.length];
		rslt[0] = 1;
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for(int i = 1;i < price.length;i++) {
			while(!stack.isEmpty() && price[stack.peek()] < price[i])
				stack.pop();
			rslt[i] = stack.isEmpty() ? (i+1) : (i-stack.peek());
			stack.push(i);
		}
		return rslt;
		
	}
	
	static int countBracketReversal(String expr) {
		
		int len = expr.length();
		if(len % 2 != 0)
			return -1;
		Stack<Character> stack = new Stack<>();
		for(int i = 0;i < expr.length();i++) {
			char ch = expr.charAt(i);
			if(ch == '}' && !stack.isEmpty()) {
				if(stack.peek() == '{')
					stack.pop();
				else
					stack.push(ch);
			}
			else
				stack.push(ch);
		}
		int redlen = stack.size();
		int n = 0;
		while(!stack.isEmpty() && stack.peek() == '{') {
			stack.pop();
			n++;
		}
		return (redlen/2 + n%2);
		 
	}
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
//		System.out.println(isBalanced(str));
//		Stack<Integer> s1 = new Stack<>();
//		Stack<Integer> s2 = new Stack<>();
//		int n = s.nextInt();
//		for(int i = 0;i< n;i++)
//			s1.push(s.nextInt());
//		stackReverse(s1,s2);
//		while(!s1.isEmpty())
//			System.out.print(s1.pop() + " ");
//		System.out.println(checkBracketRedunduncy(str));
//		int[] price = new int[s.nextInt()];
//		for(int i = 0;i < price.length;i++)
//			price[i] = s.nextInt();
//		int[] rslt = calcStockSpan(price);
//		for(int i = 0;i < rslt.length;i++)
//			System.out.print(rslt[i]);
		System.out.println(countBracketReversal(str));
				
	}

}
