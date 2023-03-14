import java.util.ArrayList;

class TTNode{

	char data;
	boolean isTerminal;
	TTNode[] children;
	int childCount;
	boolean restPalindrome;
	boolean ending;

	public TTNode(char data) {
		this.data = data;
		this.isTerminal = false;
		this.children = new TTNode[26];
		this.childCount = 0;
		this.ending = false;
		this.restPalindrome = false;
	}

}

class Trie{

	private TTNode root;

	public Trie() {
		root = new TTNode('\0');
	}
	
	private boolean isPalindrome(String str) {
		
		if(str.length() == 0)
			return true;
		int i = 0,len = str.length()-1;
		while (i < len) {
            if (str.charAt(i) != str.charAt(len))
                return false;
            i++;
            len--;
        }
		return true;
		
	}

	private void insertHelper(TTNode root, String word) {

		if(word.length() == 0) {
			root.isTerminal = true;
			return;
		}

		int childIndex = word.charAt(0) - 'a';
		TTNode child = root.children[childIndex];
		if(child == null) {
			child = new TTNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}

		insertHelper(child, word.substring(1));

	}

	void insert(String word) {

		insertHelper(root,word);

	}
	
	void insertP(TTNode curr,String word,int index) {
		
		if(index == word.length()) {
			curr.ending = true;
			System.out.println("curr " + curr.data);
			return;
		}
		String temp = word.substring(0,word.length()-index);
		int childIndex = temp.charAt(temp.length()-1) - 'a';
		TTNode child = curr.children[childIndex];
		if(child == null) {
			child = new TTNode(temp.charAt(temp.length()-1));
			curr.children[childIndex] = child;
			curr.childCount++;
		}
		String rev = "";
		for(int i = word.length()-1;i >= 0;i--)
			rev += word.charAt(i);
		if(isPalindrome(rev.substring(index+1)) && (index+1) != word.length()) {
			child.restPalindrome = true;
			System.out.println("child " + child.data);
		}
		insertP(child,word, index+1);
		
	}

	private boolean searchHelper(TTNode root, String word) {

		if(word.length() == 0)
			return root.isTerminal;
		int childIndex = word.charAt(0) - 'a';
		TTNode child = root.children[childIndex];
		if(child == null)
			return false;
		return searchHelper(child, word.substring(1));

	}

	boolean search(String word) {

		return searchHelper(root,word);

	}
	
	boolean searchP(TTNode curr,String word,int index) {
		
		if((curr.ending == true) && ((index+1) <= word.length())){
			if(isPalindrome(word.substring(index)))
					return true;
		}
		if(index == word.length()) {
			if(curr.ending == true)
				return true;
			else if(curr.restPalindrome == true)
				return true;
			else
				return false;
		}
		
		String temp = word.substring(index,word.length());
		int childIndex = temp.charAt(0) - 'a';
		TTNode child = curr.children[childIndex];
		if(child == null)
			return false;
		return searchP(child, word, index+1);
		
	}

	private void removeHelper(TTNode root, String word) {

		if(word.length() == 0) {
			root.isTerminal = false;
			return;
		}

		int childIndex = word.charAt(0) - 'a';
		TTNode child = root.children[childIndex];
		if(child == null)
			return;
		removeHelper(child, word.substring(1));
		if(!root.isTerminal && root.childCount == 0) {
			root.children[childIndex] = null;
			root.childCount--;
		}
	}

	void remove(String word) {

		removeHelper(root,word);

	}

	boolean patternMatching(ArrayList<String> vect, String pattern) {

		if(vect.size() == 0 || pattern.length() == 0)
			return false;

		for(int i = 0;i < vect.size();i++) {
			String str = vect.get(i);
			while(str.length() != 0) {
				insert(str);
				str = str.substring(1);
			}
		}

		return search(pattern);

	}
	
	boolean isPalindromePair(ArrayList<String> words) {
		
		if(words.size() == 0) {
			return false;
		}
		
		for(String i : words) {
			insertP(root, i, 0);
		}
		
		for(String i : words) {
			boolean rslt = searchP(root, i, 0);
			if(rslt)
				return true;
		}
		return false;
		
	}
	
	void allPossibleWords(TTNode curr, String word,String output) {
			
		if(curr.childCount == 0) {
			if(output.length() > 0)
				System.out.println(word + output);
			return;
		}
		if(curr.isTerminal == true)
			System.out.println(word + output);
		for(int i = 0;i < curr.children.length;i++) {
			if(curr.children[i] != null) {
				String temp = output + curr.children[i].data;
				allPossibleWords(curr.children[i], word, temp);
			}
		}
		
	}
	
	TTNode findWord(TTNode curr, String word) {
		
		if(word.length() == 0){
            return curr;
        }
        int childIndex = word.charAt(0) - 'a';
        TTNode child = curr.children[childIndex];
        if(child == null){
            return null; 
        }
        return findWord(child, word.substring(1));
		
	}
	
	void autoComplete(ArrayList<String> input, String word) {
		
		if(input.size() == 0 || word.length() == 0)
			return;
		
		for(String i : input) {
			insert(i);
		}
		
		TTNode wordNode = findWord(root,word);
		if(wordNode != null)
			allPossibleWords(wordNode, word,"");
		
	}

}

public class trie_GenericTree {

	public static void main(String[] args) {

		Trie t = new Trie();
		ArrayList<String> vect = new ArrayList<>();
		String[] str = {"do","dont","no","not","note","notes","den"};
		for(String i : str)
			vect.add(i);
//		System.out.println("Status of the pattern's presence in the given words : " + t.patternMatching(vect,"ef"));
//		System.out.println("Status of the palindrome's presence in the given words : " + t.isPalindromePair(vect));
		System.out.println("All possible Auto-Complete options are : ");
		t.autoComplete(vect, "nom");


	}

}
