

import java.util.*;

class LLNode<T>{
	T data;
	LLNode<T> next;
	public LLNode(T data) {
		this.data = data;
	}
}

public class LinkedListBasics1 {
	
	static LLNode<Integer> takeIP(){
		Scanner s = new Scanner(System.in);
		LLNode<Integer> head = null,tail = null;
		int scndat = s.nextInt();
		while(scndat != -1) {
			LLNode<Integer> newnode = new LLNode<>(scndat);
			if(head == null) {
				head = newnode;
				tail = newnode;
			}
			else {
				tail.next = newnode;
				tail = newnode;
			}
			scndat = s.nextInt();
		}
		s.close();
		return head;
	}
	
	static LLNode<Integer> insert(LLNode<Integer> head, int pos,int data){
		LLNode<Integer> temp = head;
		if(pos == 0) {
			LLNode<Integer> nnode = new LLNode<Integer>(data);
			nnode.next = temp;
			return nnode;
		}
		else {
			int cnt = 0;
			LLNode<Integer> prev = head;
			while(cnt < pos-1 && prev != null) {
				cnt++;
				prev = prev.next;
			}
			if(prev != null) {
				LLNode<Integer> nnode = new LLNode<Integer>(data);
				nnode.next = prev.next;
				prev.next = nnode;
			}
			return temp;
		}
	}
	
	static LLNode<Integer> delete(LLNode<Integer> head,int pos) {
		LLNode<Integer> temp = head;
		if(pos == 0) {
			return temp.next;
		}
		else {
			int cnt = 0;
			LLNode<Integer> prev = temp;
			while(cnt < pos-1 && prev != null) {
				cnt++;
				prev = prev.next;
			}
			if(prev.next != null) {
				prev.next = prev.next.next;
			}
			return temp;
		}
	}
	
	static int length(LLNode<Integer> head) {
		LLNode<Integer> temp = head;
		if(temp == null)
			return 0;
		int cnt=1;
		while(temp.next != null) {
			temp = temp.next;
			cnt++;
		}
		return cnt;
	}
	
	static int find(LLNode<Integer> head,int x) {
		int pos = -1,cnt = 0;
		LLNode<Integer>temp = head;
		if(temp == null)
			return pos;
		while(temp != null) {
			if(temp.data == x) {
				pos = cnt;
				break;
			}
			cnt++;
			temp = temp.next;
		}
		
		return pos;
	}
	
	static LLNode<Integer> removeDuplicates(LLNode<Integer> head) {
		if(head == null || head.next == null)
			return head;
		LLNode<Integer> prev = head,temp = head.next;
		while(temp != null) {
			if(temp.data.compareTo(prev.data) == 0) {
				prev.next = temp.next;
				temp = temp.next;
			}
			else {
				prev = temp;
				temp = temp.next;
			}
		}
		return head;		
	}
	
	static void printReverse(LLNode<Integer> head) {
		if(head == null) {
			return;
		}
		printReverse(head.next);
		System.out.print(head.data + " ");
	}
	
	private static LLNode<Integer> frnt;
	static boolean check(LLNode<Integer> curr) {
		if(curr != null) {
			if(!(check(curr.next)))
				return false;
			if(curr.data != frnt.data)
				return false;
			frnt = frnt.next;
		}
		return true;
	}
	static boolean isPalindrome(LLNode<Integer> head) {
		frnt = head;
		return check(head);
	}
	
	static void print(LLNode<Integer> head) {
		LLNode<Integer> temp;
		for(temp = head;temp != null;temp = temp.next) {
			System.out.print(temp.data + " ");
		}
		System.out.println();
	}
	
	static void print(LLNode<Integer> head,int i) {
		LLNode<Integer> temp = head;
		int cnt = 0;
		while(cnt != i && temp != null) {
			temp = temp.next;
			cnt++;
		}
		if(cnt == i && temp != null)
			System.out.print(temp.data + " ");
		System.out.println();
	}
	static LLNode<Integer> append(LLNode<Integer> head,int n){
		if(head == null || n == 0)
			return head;
		LLNode<Integer> temp1 = head;
		LLNode<Integer> temp2 = head;
		int len = length(head);
		int i = 0;
		while(i < len-n-1) {
			temp1=temp1.next;
			i++;
		}
		head = temp1.next;
		temp1.next = null;
		LLNode<Integer> temphead = head;
		while(temphead.next != null) {
			temphead = temphead.next;
		}
		temphead.next = temp2;
		return head;
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		LLNode<Integer> head = takeIP();
//		System.out.println(length(head));
		print(head);
//		head = insert(head,1,11);
//		print(head,1);
//		print(head);
//		head = delete(head,4);
//		print(head);
//		int idx = find(head,s.nextInt());
//		if(idx != -1)
//			System.out.println("Element found at : " + idx);
//		else
//			System.out.println("Element wasn't found.");
//		head = append(head,s.nextInt());
//		print(head);
		head  = removeDuplicates(head);
		print(head);
//		printReverse(head);
//		System.out.println();
//		System.out.println(isPalindrome(head));
		s.close();
		
	}

}
