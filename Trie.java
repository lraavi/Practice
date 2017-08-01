import java.util.concurrent.LinkedBlockingQueue;

public class Trie {
    public Node<String> root = null;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node<String>(true);
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    		Node<String> current = root;
        for(int i=0;i<word.length();i++) {
        		if(!current.hm.containsKey(word.charAt(i))) {
        			current.hm.put(word.charAt(i), new Node<String>());
        			
        			
        		}//if
        		current = current.hm.get(word.charAt(i));
        		if(i == word.length()-1) {
    				current.End = true;
        		}
//    			}else {
//    				current.End = false;
//    			}//if i==..
        }//for
    }//insert
    
    public boolean search(String word) {
    		Node<String> temp = root;
		for(int i =0; i<word.length();i++) {
			if(!temp.hm.containsKey(word.charAt(i))) {
				return false;
			}//if
			temp = temp.hm.get(word.charAt(i));
		}//for
		if(temp.End) {
			return true;
		}else {
			return false;
		}
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	Node<String> temp = root;
		for(int i =0; i<prefix.length();i++) {
			if(!temp.hm.containsKey(prefix.charAt(i))) {
				return false;
			}//if
			temp = temp.hm.get(prefix.charAt(i));
		}//for  
		return true;
    }
    
    public static void main(String[] args) {
    		Trie t = new Trie();
    		t.insert("test");
    		t.insert("tesla");
    		t.insert("abcd");
    		System.out.println(t.search("tes")+"<---tes(search) abcde(search)---->"+t.search("abcde"));
    		System.out.println(t.startsWith("ab")+"<---ab(startsWith) lee(startsWith)---->"+t.startsWith("lee"));
    		LinkedBlockingQueue<Node<String>> q = new LinkedBlockingQueue<Node<String>>();
    		System.out.println("Printing root node");
    		for(char c : t.root.hm.keySet()) {
    			System.out.println(c);
    			q.add(t.root.hm.get(c));
    		}//for
    		
    		
    		while(!q.isEmpty()) {
    			System.out.println("Printing other node");
    			Node<String> temp = q.remove();// q.pop()
	    		for(char characterInString: temp.hm.keySet()) {
	    			System.out.println(characterInString);
	    			q.add(temp.hm.get(characterInString));
	    		}//for char:...
    		}//while
    }//main
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */