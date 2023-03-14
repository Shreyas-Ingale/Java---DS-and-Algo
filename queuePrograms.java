import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class queuePrograms {

	static void reverseQueue(Queue<Integer> q) {

		if(q.isEmpty())
			return;
		int temp = q.poll();
		reverseQueue(q);
		q.add(temp);

	}

	static void reverseQueue(Queue<Integer> q,int i) {

		if(q.isEmpty())
			return;
		if(i == 0)
			return;
		int temp = q.poll();
		reverseQueue(q,i-1);
		q.add(temp);

	}

	static Queue<Integer> reverseKElements(Queue<Integer> q, int k) {

		if(q.isEmpty())
			return q;
		reverseQueue(q,k);
		int i = q.size()-k;
		while(i != 0) {
			int temp = q.poll();
			q.add(temp);
			i--;
		}
		return q;

	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<Integer>();
		int n = s.nextInt();
		for(int i = 0;i < n;i++)
			q.add(s.nextInt());
//		reverseQueue(q);
		int k = s.nextInt();
		reverseKElements(q,k);
		while(!q.isEmpty())
			System.out.print(q.poll() + " ");


	}

}
