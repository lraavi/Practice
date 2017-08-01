import java.util.HashMap;

public class Node<E> {
	
	//Trie data structure attributes
	HashMap<Character, Node<E>> hm ;
    boolean End;
    
    //link list data structure attributes
    Node<E> next;
    E element;
    
    //Graph data structure attributes
    boolean visited;
    Node<E> [] neighbours;
    
    Node(){
    
    	hm = new HashMap<Character,Node<E>> ();
    	End = false;
    	
    	this.element = null;
    	this.next = null;
    	
    this.visited = false;
    this.neighbours = null;
    }//node
    
    //Trie Node
    Node(boolean endChar){
    	hm = new HashMap<Character,Node<E>> ();
    	End = endChar;
    }//node
    
    //Graph Node initialization
    Node(E element, boolean visited, Node<E>[] neighbours){
    	this.element = element;
    	this.visited = false;
    	this.neighbours = neighbours;
    }//Node(.,.,.)
    
    //Graph node another initialization 
    Node(E element, boolean visited){
    	this.element = element;
    	this.visited = false;
    }//Node(.,.)
    
    //Link List Node initialization
    Node(E element){
    	this.element = element;
    }//Node(.)
}
