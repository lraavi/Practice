import java.util.ArrayList;

/***
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 * 
 * 1. The root is the maximum number in the array.
 * 2. The left subtree is the maximum tree constructed from left part sub-array divided by the maximum number.
 * 3. The right subtree is the maximum tree constructed from right part sub-array divided by the maximum number.
 * 
 * 
 * @author leela
 *
 */
public class maximumBinaryTree {

	public TreeNode<Integer> maxBTree(int [] arr){
		TreeNode<Integer> root = null;
		
		if(arr.length == 1) {
			
			root = new TreeNode<Integer>(arr[0]);
			
		}else if (arr.length > 1) {
			
			int maxIndex = 0;
			for(int i=0; i<arr.length;i++) {
				if(arr[maxIndex]<arr[i]) {
					maxIndex = i;
				}//if
			}//for i
			
			root = new TreeNode<Integer>(arr[maxIndex]);
			ArrayList<Integer> left = new ArrayList<Integer>();
			ArrayList<Integer> right = new ArrayList<Integer>();
			for(int j =0;j<arr.length;j++) {
				if(j<maxIndex) {
					left.add(arr[j]);
				}else if(j > maxIndex) {
					right.add(arr[j]);
				}
			}//for j 
			
			int[] leftArr = convertToArray(left);
			int[] rightArr = convertToArray(right);
			
			
			
			root.left = maxBTree(leftArr);
			root.right = maxBTree(rightArr);
		}//else if
		
		return root;
	}//maxBtree
	
	/***
	 * The method converts the array list of Integer to array of primitive int.
	 * @param arr : Array List to be converted
	 * @return : Array of primitive int as elements.
	 */
	public int[] convertToArray(ArrayList<Integer> arr) {
		int [] returnArray = new int[arr.size()];
		for(int i =0;i<arr.size();i++) {
			returnArray[i] = arr.get(i).intValue();
		}// for i
		
		return returnArray;
	}
	
}//maximumBinaryTree
