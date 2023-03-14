
import java.util.Scanner;

class LLNode1<T>{
	T data;
	LLNode1<T> next;
	LLNode1(T data) {
		this.data = data;
	}
}

class DLLNode1<T>{
	LLNode1<T> head;
	LLNode1<T> tail;
	DLLNode1(){}
	DLLNode1(LLNode1<T> head, LLNode1<T> tail) {
		this.head = head;
		this.tail = tail;
	}
}

public class LinkedListBasics2 {
	
	static LLNode1<Integer> takeIP(){
		Scanner s = new Scanner(System.in);
		LLNode1<Integer> head = null,tail = null;
		int scndat = s.nextInt();
		while(scndat != -1) {
			LLNode1<Integer> newnode = new LLNode1<>(scndat);
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
		
		return head;
	}
	
	static int length(LLNode1<Integer> head) {
		LLNode1<Integer> temp = head;
		if(temp == null)
			return 0;
		int cnt=1;
		while(temp.next != null) {
			temp = temp.next;
			cnt++;
		}
		return cnt;
	}
	
	static LLNode1<Integer> recReverseBest(LLNode1<Integer> head){
		
		if(head == null || head.next == null) {
			return head;
		}
		LLNode1<Integer> fh = recReverseBest(head.next);
		LLNode1<Integer> rt = head.next;
		rt.next = head;
		head.next = null;
		return fh;
		
	}
	
	static DLLNode1<Integer> rRB(LLNode1<Integer> head){
		
		DLLNode1<Integer> fdn;
		if(head == null || head.next == null) {
			fdn = new DLLNode1<Integer>(head, head);
			return fdn;
		}
		DLLNode1<Integer> tdn = rRB(head.next);
		tdn.tail.next = head;
		head.next = null;
		fdn = new DLLNode1<Integer>(tdn.head, head);
		return fdn;
		
	}
	
	static LLNode1<Integer> recReverseBetter(LLNode1<Integer> head){
		
		DLLNode1<Integer> ans = rRB(head);
		return ans.head;
		
	}
	
	static LLNode1<Integer> recReverse(LLNode1<Integer> head){
		
		LLNode1<Integer> temp = head;
		if(temp == null || temp.next == null)
			return temp;
		LLNode1<Integer> revhead = recReverse(head.next);
		LLNode1<Integer> revtail = revhead;
		while(revtail.next != null) {
			revtail = revtail.next;
		}
		revtail.next = temp;
		temp.next = null;
		return revhead;
		
	}
	
	static LLNode1<Integer> iteReverse(LLNode1<Integer> head){
		
		LLNode1<Integer> previous = null;  
		LLNode1<Integer> curr = head;  
		LLNode1<Integer> next = null;  
		  
		  
		while (curr != null)   
		{  
		next = curr.next;  
		curr.next = previous;  
		previous = curr;  
		curr = next;  
		}  
		head = previous;  
		return head;  
		
	}
	
	static int helperFindNodeRec(LLNode1<Integer> head, int n, int pos) {

		if(head == null)
			return -1;
		if(head.data == n)
			return pos;
		
		int rslt = helperFindNodeRec(head.next, n, pos+1);
		return rslt;
	}
	
	public static int findNodeRec(LLNode1<Integer> head, int n) {
		
		return helperFindNodeRec(head,n,0);
		
	}
	
	public static LLNode1<Integer> evenAfterOdd(LLNode1<Integer> head) {
		
		if(head == null)
			return head;
		LLNode1<Integer> temp = head,evnhd = null,oddhd = null,evntl = null,oddtl = null;
		while(temp != null) {
			if(temp.data % 2 == 0) {
				if(evnhd == null) {
					evnhd = temp;
					evntl = temp;
				}
				else {
					evntl.next = temp;
					evntl = temp;
				}
			}
			else {
				if(oddhd == null) {
					oddhd = temp;
					oddtl = temp;
				}
				else {
					oddtl.next = temp;
					oddtl = temp;
				}
			}
			temp = temp.next;
		}
		if(oddhd == null) {
			evntl.next = null;
			return evnhd;
		}
		else if(evnhd == null) {
			oddtl.next = null;
			return oddhd;
		}
		else {
			evntl.next = null;
			oddtl.next = evnhd;
			return oddhd;
		}
		
	}
	
	public static LLNode1<Integer> skipMdeleteN(LLNode1<Integer> head, int M, int N) {
		
		if(head == null || N == 0) 
			return head;
		if(M == 0 && N != 0)
			return null;
		int cntm = 1,cntn = 1;
		LLNode1<Integer> t1 = head,t2 = null;
		while(true) {
		while(t1 != null && cntm != M) {
			t1 = t1.next;
			cntm++;
		}
		if(t1 == null)
			break;
		t2 = t1.next;
		while(t2 != null && cntn != N) {
			t2 = t2.next;
			cntn++;
		}
		if(t2 == null) {
			t1.next = null;
			break;
		}
		t1.next = t2.next;
		t1 = t1.next;
		cntm = 1;
		cntn = 1;
		}
		return head;
		
	}
	
	static LLNode1<Integer> findMidpoint(LLNode1<Integer> head){
		
		if(head == null)
			return null;
		LLNode1<Integer> slow = head, fast = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	
	}
	
	static LLNode1<Integer> deleteAlternateNodes(LLNode1<Integer> head) {
		
		LLNode1<Integer> curr = head;
		LLNode1<Integer> altnode = head.next;
		
		while(curr != null && altnode != null) {
			if(altnode != null) {
				curr.next = altnode.next;
				curr = curr.next;
				if(curr != null)
					altnode = curr.next;
			}
		}
		return head;
		
	}
	
	static LLNode1<Integer> funcMerge(LLNode1<Integer> t1,LLNode1<Integer> t2){
		
		if(t1 == null)
			return t2;
		if(t2 == null)
			return t1;
		LLNode1<Integer> head = null, tail = null;
		if(t1.data <= t2.data) {
			head = t1;
			tail = t1;
			t1 = t1.next;
		}
		else {
			head = t2;
			tail = t2;
			t2 = t2.next;
		}
		while(t1 != null && t2 != null) {
			if(t1.data <= t2.data) {
				tail.next = t1;
				tail = t1;
				t1 = t1.next;
			}
			else {
				tail.next = t2;
				tail = t2;
				t2 = t2.next;
			}
		}
		if(t1 != null) {
			tail.next = t1;
		}
		if(t2 != null) {
			tail.next = t2;
		}
		return head;
		
	}
	
	static LLNode1<Integer> mergeSort(LLNode1<Integer> head){
		
		if(head == null || head.next == null)
			return head;
		LLNode1<Integer> mid = findMidpoint(head);
		LLNode1<Integer> part1head = head;
		LLNode1<Integer> part2head = mid.next;
		mid.next = null;
		part1head = mergeSort(part1head);
		part2head = mergeSort(part2head);
		head = funcMerge(part1head, part2head);
		return head;
		
	}
	
	static LLNode1<Integer> recDelete(LLNode1<Integer> head,int pos){
		
		LLNode1<Integer> temp = head;
		if(temp == null && pos >= 0)
			return temp;
		if(pos == 0) {
			return temp.next;
		}
		temp.next = recDelete(temp.next, pos-1);
		return temp;
	}
	
	static LLNode1<Integer> recInsert(LLNode1<Integer> head,int pos,int data){
		
		LLNode1<Integer> temp = head;
		if(temp == null && pos > 0)
			return temp;
		if(pos == 0) {
			LLNode1<Integer> nnode = new LLNode1<Integer>(data);
			nnode.next = temp;
			return nnode;
		}
		temp.next = recInsert(temp.next, pos-1, data);
		return temp;
		
	}
	
	static LLNode1<Integer> iteKReverse(LLNode1<Integer> head, int k) {
		
		if(head == null || k == 0)
			return head;
		int cntk = 1;
		LLNode1<Integer> oghd = null,pvtl = null,tail = head,nxthd = head;
		while(head != null) {
			while(cntk != k && tail.next != null) {
				tail = tail.next;
				cntk++;
			}
			nxthd = tail.next;
			tail.next = null;
			head = recReverseBest(head);
			tail = head;
			while(tail.next != null)
				tail = tail.next;
			if(oghd == null)
				oghd = head;
			if(pvtl != null)
				pvtl.next = head;
			pvtl = tail;
			head = nxthd;
			tail = head;
			cntk = 1;
		}
		return oghd;
		
	}
	
	static LLNode1<Integer> recKReverse(LLNode1<Integer> head, int k) {
		
		if(head == null || k == 0)
			return head;
		LLNode1<Integer> tail = head;
		int cntk = 1; 
		while(cntk != k && tail.next != null) {
			tail = tail.next;
			cntk++;
		}
		LLNode1<Integer> nxthd = tail.next;
		tail.next = null;
		head = recReverseBest(head);
		tail = head;
		while(tail.next != null)
			tail = tail.next;
		tail.next = recKReverse(nxthd, k);
		return head;
		
	}
	
	static LLNode1<Integer> handlenine(LLNode1<Integer> head) {
		
		if(head.next == null) {
			head.data = 0;
			return head;
		}
		
		handlenine(head.next);
		if(head.next.data == 0) {
			if(head.data == 9)
				head.data = 0;
			else
				head.data += 1;
		}
				
		return head;
	}
	
	static LLNode1<Integer> nextLargeNumber(LLNode1<Integer> head) {
		
		if(head == null)
			return head;
		LLNode1<Integer> temp = head;
		while(temp.next != null)
			temp = temp.next;
		if(temp.data != 9) {
			temp.data += 1;
			return head;
		}
		else {
			handlenine(head);
			if(head.data == 0) {
				LLNode1<Integer> temp1 = new LLNode1<>(1);
				temp1.next = head;
				head = temp1;
			}
		}
		return head;
		
	}
	
	static LLNode1<Integer> bubbleSort(LLNode1<Integer> head) {
		
		if(head == null)
			return head;
		int len = length(head),hdck = 0;
		LLNode1<Integer> t1 = head,t2 = head.next,prev = head;
		for(int i = 0;i < len - 1;i++) {
			for(int j = 0;j < len - i - 1;j++) {
				if(t2.data < t1.data) {
					LLNode1<Integer> temp = t2.next;
					t2.next = t1;
					t1.next = temp;
					if(hdck++ == 0) {
						head = t2;
						prev = head;
					}
					else {
						prev.next = t2;
						prev = prev.next;
					}
					t2 = t1.next;
				}
				else {
					if(hdck++ > 0)
						prev = prev.next;
					t1 = t1.next;
					t2 = t2.next;
				}
			}
			t1 = head;
			t2 = head.next;
			prev = head;
			hdck = 0;
		}
		
		return head;
	}
	
	static LLNode1<Integer> swapNodes(LLNode1<Integer> head, int i, int j) {
		
		if(head == null)
			return head;
		int cnti = 0,cntj = 0;
		LLNode1<Integer> ci = null,pi = null,cj = null,pj = null;
		if(i == 0) {
			ci = head;
			pj = head;
			while(cntj != j-1) {
				pj = pj.next;
				cntj++;
			}
			cj = pj.next;
			pj.next = ci;
			LLNode1<Integer> temp = ci.next;
			ci.next = cj.next;
			cj.next = temp;
			return cj;
		}
		else if(j == 0) {
			cj = head;
			pi = head;
			while(cnti != i-1) {
				pi = pi.next;
				cnti++;
			}
			ci = pi.next;
			pi.next = cj;
			LLNode1<Integer> temp = cj.next;
			cj.next = ci.next;
			ci.next = temp;
			return ci;
		}
		else {
			pj = head;
			pi = head;
			while(cntj != j-1) {
				pj = pj.next;
				cntj++;
			}
			cj = pj.next;
			while(cnti != i-1) {
				pi = pi.next;
				cnti++;
			}
			ci = pi.next;
			pi.next = cj;
			pj.next = ci;
			LLNode1<Integer> temp = ci.next;
			ci.next = cj.next;
			cj.next = temp;
			return head;
		}
		
	}
	
	static void recPrint(LLNode1<Integer> head) {
		
		if(head == null)
			return;
		System.out.print(head.data + " ");
		recPrint(head.next);
		
	}
	
	static void recPrintRev(LLNode1<Integer> head) {
		
		if(head == null)
			return;
		recPrint(head.next);
		System.out.print(head.data + " ");
		
	}

	public static void main(String[] args) {
		
		LLNode1<Integer> head = takeIP();
		recPrint(head);
		System.out.println();
//		recPrintRev(head);
//		int len = length(head);
//		head = recInsert(head,0,6);
//		head = recDelete(head,4);
//		head = recReverse(head);
//		head = recReverseBetter(head);
//		head = recReverseBest(head);
//		head = iteReverse(head);
//		System.out.println("Midpoint is : " + findMidpoint(head).data);
//		LLNode1<Integer> head1 = takeIP();
//		LLNode1<Integer> fnlhead = funcMerge(head, head1);
//		recPrint(fnlhead);
//		head = mergeSort(head);
//		int rslt = findNodeRec(head, 11230);
//		if(rslt != -1)
//			System.out.println("Element found at " + rslt + " node.");
//		else
//			System.out.println("Element wasn't found at any node.");
//		head = evenAfterOdd(head);
//		head = skipMdeleteN(head,2,2);
//		head = swapNodes(head,2,1);
//		head = recKReverse(head,3);
//		head = iteKReverse(head,3);
//		head = bubbleSort(head);
//		head = nextLargeNumber(head);
		head = deleteAlternateNodes(head);
		recPrint(head);
	}

}
