/***
 * The LinkLists class accumulates general link lists problems into different methods of the class.
 * 
 * @authors Leela K Raavi, Saurabh Sawhney
 *
 */
public class LinkLists {
	
	/***
	 * merge_recursive method merges two sorted link lists by using recursive approach
	 * @param head1 : head reference of the first sorted link list
	 * @param head2 : head reference of the second sorted link list
	 * @return : head reference of the merged sorted link list
	 */
	public Node<Integer> merge_recursive(Node<Integer> head1, Node<Integer> head2){
		Node<Integer> mergeHead;
		if(head1==null) {
			return head2;
		}
		if(head2==null) {
			return head1;
		}
		
		if(head1.element<head2.element){
			mergeHead = head1;
			head1.next = merge_recursive(head1.next,head2);
		}else {
			mergeHead = head2;
			head2.next = merge_recursive(head1,head2.next);
		}
		return mergeHead;
	}
	
	/***
	 * merge_iterative method merges two sorted link lists by using iterative approach
	 * @param head1 : head reference of the first sorted link list
	 * @param head2 : head reference of the second sorted link list
	 * @return : head reference of the merged sorted link list
	 */
	public Node<Integer> merge_iterative(Node<Integer> head1, Node<Integer> head2){
		
		if(head1==null) {
			return head2;
		}//if head1
		
		if(head2==null) {
			return head1;
		}//if head2
		
		Node<Integer> mergeListHead = null;
		Node<Integer> last = null;
		Node<Integer> current1 = head1;
		Node<Integer> current2 = head2;
		
		while(current1!=null && current2!=null) {
			Node<Integer> node = null;
			
			//finding the minimum current node
			if(current1.element< current2.element) {
				node = current1;
				current1 = current1.next;
			}else {
				node = current2;
				current2=current2.next;
			}
			
			//adding the current minimum node to last node
			if(last == null) {
				last = node;
				mergeListHead = node;
			}else {
				last.next = node;
				last = last.next;
			}
			
			last.next = null;
		}//while
		
		if(current1 !=null) {
			last.next = current1;
		}else if (current2 !=null) {
			last.next = current2;
		}
		return mergeListHead;
	}//merge(.,.)
	
	public Node<Integer> reverseLinkList(Node<Integer> head) {
		Node<Integer> newHead = null;
		Node<Integer> previous = null;
		Node<Integer> nextNode = null;
		
		while(head != null) {
			newHead = head;
			nextNode = head.next;
			head.next = previous;
			previous = head;
			head = nextNode;
		}//while
		
		return newHead;
	}
	
	
	/***
	 * The main method tests different methods of the class.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input1 = {1,2,4,10};
		Node<Integer> temp1 = new Node<Integer>(input1[0]);
		Node<Integer> head1 =temp1;
		for(int i=1;i<input1.length;i++) {
			temp1.next = new Node<Integer>(input1[i]);
			temp1 = temp1.next;
		}//for input1
		
		int[] input2 = {5,6,7,8,9};
		Node<Integer> temp2 = new Node<Integer>(input2[0]);
		Node<Integer> head2 =temp2;
		for(int j=1;j<input2.length;j++) {
			temp2.next = new Node<Integer>(input2[j]);
			temp2= temp2.next;
		}//for input1
		
		LinkLists l = new LinkLists();
		
//		Node<Integer> head = l.reverseLinkList(head2);
 		Node<Integer> head = l.merge_iterative(head1,head2);
//		Node<Integer> head = l.merge_recursive(head1,head2);
		
		while(head!=null) {
			System.out.println(head.element);
			head = head.next;
		}
	}//main

}//LinkLists
