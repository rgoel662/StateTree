import java.util.Scanner;

/**
 * Binary Tree for State Objects
 *
 * @author 
 * @version 
 */
public class BinaryTree {

	private final String DEFAULT_FILE_NAME = "states2.txt"; // Default input file
	private Scanner keyboard;
	
	private TreeNode<State> root;
	
	public BinaryTree() {

	}
	
	/**
	 *	Load data from a text file
	 */
	public void loadData()
	{
		Scanner reader = FileUtils.openToRead(DEFAULT_FILE_NAME);
		while(reader.hasNext()){
			String n = reader.next();
			String a = reader.next();
			int p = reader.nextInt();
			int ar = reader.nextInt();
			int r = reader.nextInt();
			String c = reader.next();
			int m = reader.nextInt();
			int d = reader.nextInt();
			int y = reader.nextInt();
			State s = new State(n, a, p, ar, r, c, m, d, y);
			insert(s);
		}
	}
	
	/**
	 * Insert State into tree 
	 * @param next  State to insert
	 */
	public void insert(State next) {
		insert(root, next);
	}

	/**
	 * Insert State into tree recursively 
	 * 
	 * @param node	current node
	 * @param next	State to insert
	 */
	public void insert(TreeNode<State> node, State next) {
		if (node == null) {
			node = new TreeNode(next);
		} else if (next.compareTo(node.getValue()) < 0) {
			insert(node.getLeft(), next);
		} else {
			insert(node.getRight(), next);
		}
	}
	

	/**
	 * Prints the tree as a list in ascending order by state name
	 * Which is pretty much the in order traversal of the tree
	 */
	public void printList() {
		printInorderRecurse(root);
	}
	
	/**
	 * Recursive method to print the tree using the order: in-order.
	 * 
	 * @param node The current node
	 */
	private void printInorderRecurse(TreeNode<State> node) {
		if (node == null) return;
		printInorderRecurse(node.getLeft());
		System.out.print(node.getValue() + " ");
		printInorderRecurse(node.getRight());
	}
	
	/**
	 * Prompts user for State name to find, then starts search
	 */
	public void testFind() {

	}
	

	/**
	 * Prompts user for State name to delete
	 * OPTIONAL: Not included in your grade!
	 */
	public void testDelete() {

	}
	
	/**
	 * Finds the number of nodes starting at the root of the tree
	 * @return  the number of nodes in the tree
	 */
	public int size() {
		return 0;
	}
	
	
	/**
	 * Clears the tree of all nodes
	 */
	public void clear() {
		root = null;
	}
	
	/**
	 * Prompts user for level of tree to print.
	 * The top level (root node) is level 0.
	 */
	public void printLevel() {
		
	}
	
	
	/**
	 * Prints the highest level of the tree (root is level 0),
	 * prints "Tree empty" if empty tree
	 */
	public void testDepth() {

	}

}