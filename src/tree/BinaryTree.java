package tree;

import java.lang.StringBuilder;
import java.util.NoSuchElementException;

public class BinaryTree<E extends Comparable<? super E>> {
	private Node<E> root;
	private int size;

	/** Constructs a new BinaryTree. */
	public BinaryTree() {
		root = null;
		size = 0;
	}

	/** This is a comment. */
	public boolean add(E e) {
		size++;
		return true;
	}

	/** This is a comment. */
	public E find(E e) {
		return e;
	}

	/** This is a comment. */
	public boolean contains(Object o) {
		return true;
	}

	/** This is a comment. */
	public boolean remove(E e) {
		size--;
		return true;
	}

	/** This is a comment. */
	public int size() {
		//return size(root);
		return size;
	}

//	/** This is a comment. */
//	private int size(Node<E> node) {
//		if (node == null) {
//			return 0;
//		}
//		else {
//			return 1 + size(node.left) + size(node.right);
//		}
//	}

	/** This is a comment. */
	public void printPreorder() {
		printPreorder(root);
	}

	/** Prints the tree in preorder. */
	private void printPreorder(Node<E> node) {
		if (node != null) {
			System.out.println(node.element);
			printPreorder(node.left);
			printPreorder(node.right);
		}
	}

	/** Public method for printing the tree in inorder. */
	public void printInorder() {
		printInorder(root);
	}

	/** Prints the tree in inorder. */
	private void printInorder(Node<E> node) {
		if (node.left != null) {
			printInorder(node.left);
			printInorder(node.right);
			System.out.println(node.element);
		}
	}

	/** Public method for printing the tree in postorder. */
	public void printPostorder() {
		printPostorder(root);
	}

	/** Prints the tree in postorder. */
	private void printPostorder(Node <E> node) {
		if (node.right != null) {
			printPostorder(node.right);
			printPostorder(node.left);
			System.out.println(node.element);
		}
	}

	/** Returns the tree as a String.
	 *  @return the tree as a String.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		buildString(root, sb);
		return sb.toString();
	}

	/** Creates a string. */
	private String buildString(Node<E> node, StringBuilder sb) {
		if (node == null) {
			sb.append("null\n");
		}
		else {
			sb.append(node.element);
			sb.append("\n");
			buildString(node.left, sb);
			buildString(node.right, sb);
		}
		return sb.toString();
	}

	/** Returns the tree as a String.
	 *  @return the tree as a String. 
	 */
	public String toFancyString() {
		StringBuilder sb = new StringBuilder();
		buildFancyString(root, 0, sb);
		return sb.toString();
	}

	/** This is a comment. */
	private void buildFancyString(Node<E> node, int indent, StringBuilder sb) {
		for (int i = 0; i < indent; i++) {
			sb.append(" ");
		}
		if (node == null) {
			sb.append("null\n");
		}
		else {
			sb.append(node.element);
			sb.append("\n");
			buildFancyString(node.left, indent+2, sb);
			buildFancyString(node.right, indent+2, sb);
		}
	}

	/** Returns the number of leaves in the tree. */
	public int nbrLeaves() {
		if (root == null) {
			throw new NoSuchElementException();
		}
		else {
			return root.nbrLeaves();
		}
	}

	/** Static nestled class - describes a node in the tree. */
	private static class Node<E> {
		private E element;
		private Node<E> left;
		private Node<E> right;
		private int nbr;

		private Node(E e) {
			element = e;
			left = right = null;
		}

		private int nbrLeaves() {
			nbr = 0;
			if (this.left == null && this.right == null) {
				nbr++;
			}
			else {
				this.right.nbrLeaves();
				this.left.nbrLeaves();
			}
			return nbr;
		}
	}
}
