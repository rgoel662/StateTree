import java.util.Scanner;

/**
 * Binary Tree for State Objects
 *
 * @author 
 * @version 
 */
public class BinaryTree {

	private final String DEFAULT_FILE_NAME = "states2.txt"; // Default input file
	
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
		if (root == null) root = new TreeNode<State>(next);
		else insert(root, next);
	}

	/**
	 * Insert State into tree recursively 
	 * 
	 * @param node	current node
	 * @param next	State to insert
	 */
	public TreeNode<State> insert(TreeNode<State> node, State next) {
		if (node == null) {
			return new TreeNode<State>(next);
		} else if (next.compareTo(node.getValue()) < 0) {
			node.setLeft(insert(node.getLeft(), next));
		} else {
			node.setRight(insert(node.getRight(), next));
		}
		return node;
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
		System.out.println(node.getValue());
		printInorderRecurse(node.getRight());
	}
	
	/**
	 * Prompts user for State name to find, then starts search
	 */
	public void testFind() {
		String choice = Prompt.getString("Enter state name to search for (Q to quit) ");
		do {
			if (choice.equalsIgnoreCase("Q")) return;
			State s = find(root, choice.toLowerCase());
			if (s == null) System.out.println("Name = " + choice + " State not found");
			else System.out.println("\n" + s + "\n");
			choice = Prompt.getString("Enter state name to search for (Q to quit) ");
		} while (!choice.equalsIgnoreCase("Q"));
	}

	/**
	 * Finds the State with the given name
	 * @param node  the node to start at
	 * @param name  the name to search for
	 * @return      the State with the given name, null if not found
	 */
	public State find(TreeNode<State> node, String name){
		if (node == null) return null;
		if (node.getValue().getName().toLowerCase().equals(name)) 
			return node.getValue();
		if (name.compareTo(node.getValue().getName().toLowerCase()) < 0) 
			return find(node.getLeft(), name);
		return find(node.getRight(), name);
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
		return size(root);
	}

	/**
	 * Finds the number of nodes starting at the given node
	 * @param node  the node to start counting at
	 * @return      the number of nodes in the tree
	 */
	public int size(TreeNode<State> node) {
		if (node == null) return 0;
		return 1 + size(node.getLeft()) + size(node.getRight());
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
		int level = Prompt.getInt("Enter level to print (-1 to quit)");
		System.out.println();
		do {
			System.out.println("Level \t" + level);
			printLevel(root, level);
			System.out.println("\n");
			level = Prompt.getInt("Enter level to print (-1 to quit)");
			System.out.println();
		} while (level != -1);
	}

	/**
	 * Prints the given level of the tree (root is level 0),
	 * prints "Tree empty" if empty tree
	 * @param node  the node to start at
	 * @param level the level to print
	 */
	public void printLevel(TreeNode<State> node, int level) {
		if (node == null) return;
		else if (level == 0) System.out.print(node.getValue().getName() + "\t");
		else {
			printLevel(node.getLeft(), level - 1);
			printLevel(node.getRight(), level - 1);
		}
	}
	
	
	/**
	 * Prints the highest level of the tree (root is level 0),
	 * prints "Tree empty" if empty tree
	 */
	public void testDepth() {
		if (root == null) System.out.println("Tree empty\n");
		else System.out.println("Depth: " + (depth(root) - 1));
	}

	/**
	 * Finds the depth of the tree starting at the given node
	 * @param node  the node to start at
	 * @return      the depth of the tree
	 */
	public int depth(TreeNode<State> node) {
		if (node == null) return 0;
		return 1 + Math.max(depth(node.getLeft()), depth(node.getRight()));
	}

}