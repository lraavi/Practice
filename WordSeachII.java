import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordSeachII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = { {'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'} };
		String [] words = {"oath","pea","eat","rain"};
		List<String> R = (List<String>) new WordSeachII().findWords(board,words);
		for(String r : R) {
			System.out.println(r);
		}//for r
	}//main
	
	public List<String> findWords(char[][] board, String[] words) {
		boolean [][] visited = new boolean[board.length][board[0].length];
        Trie tree = new Trie();
        HashSet<String> returnArray = new HashSet<String> ();
        for(String word: words){
            tree.insert(word);
        }//for each
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                visited[i][j] = false;
            }//for j (columns)
        }//for i
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                search_word(board,visited,i,j,tree,returnArray,"");
            }//for j (columns)
        }//for i
		List<String> L = new ArrayList<String>();
		L.addAll(returnArray);
		return L;
        
    }//findWords
    
    public void search_word(char[][] board, boolean [][] visited, int i , int j, Trie tree, HashSet<String> returnArray,String str){
    
    	if(i<0||j<0||i>board.length-1||j>board[i].length-1) {
    		return ;
    	}
    	if(visited[i][j]) {
    		return;
    	}
//    	System.out.println("i j str "+i+" "+j+" "+str);
    	str += board[i][j];
    	
    	if(!tree.startsWith(str)) {
    		return ;
    	}//startswith
    	
    if(tree.search(str)) {
    		returnArray.add(str);
    }//search
    
	visited[i][j] = true;
    	search_word(board,visited,i-1,j,tree,returnArray,str);
    	search_word(board,visited,i+1,j,tree,returnArray,str);
    	search_word(board,visited,i,j-1,tree,returnArray,str);
    	search_word(board,visited,i,j+1,tree,returnArray,str);
    	visited[i][j] = false;
    	
    }//search_word
}//WordsSearchII
