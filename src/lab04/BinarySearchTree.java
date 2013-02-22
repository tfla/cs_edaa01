package bst;

import java.util.NoSuchElementException;

public class BinarySearchTree<E extends Comparable<? super E>> {
	BinaryNode<E> root;
    int size;
    
	/**
	 * Constructs an empty binary searchtree.
	 */
	public BinarySearchTree() {
		size = 0;	
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		if (root == null) {
			root = new BinaryNode<E>(x);
			size++;
			return true;
		}
		else {
			if (root.add(x)) {
				size++;
				return true;
			}
			return false;
		}
	}

	/**
	 * Computes the height of tree.
	 * @return the height of the tree
	 */
	public int height() {
		return height(root);
	}

	private int height(BinaryNode<E> node) {
		if (node == null) {
			return 0;
		}
		else {
			return 1 + Math.max(height(node.left), height(node.right));
		}
	}

	/**
	 * Returns the number of elements in this tree.
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		printTree(root);
	}

	private void printTree(BinaryNode<E> node) {
		if (node != null) {
			printTree(node.left);
			System.out.println(node.element);
			printTree(node.right);
		}
	}

	/** 
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {
		E[] a = (E[]) new Comparable[size];
		root = buildTree(a, 0, toArray(root, a, 0)-1);
	}
	
	/*
	 * Adds all elements from the tree rooted at n in inorder to the array a
	 * starting at a[index].
	 * Returns the index of the last inserted element + 1 (the first empty
	 * position in a).
	 */
	private int toArray(BinaryNode<E> node, E[] a, int index) {
		if (node != null) {
			index = toArray(node.left, a, index);
			a[index++] = node.element;
			index = toArray(node.right, a, index);
			return index;
		}
		return index;
	}
	
	/*
	 * Builds a complete tree from the elements a[first]..a[last].
	 * Elements in the array a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(E[] a, int first, int last) {
		int mid = (first+last)/2;
		if (first == last) {
			return new BinaryNode<E>(a[mid]);
		}
		else if (first-last==1) {
			BinaryNode<E> newRoot = new BinaryNode<E>(a[first]);
			newRoot.right = new BinaryNode<E>(a[last]);
			return newRoot;
		}
		else if (first-last==-1) {
			BinaryNode<E> newRoot = new BinaryNode<E>(a[last]);
			newRoot.left = new BinaryNode<E>(a[first]);
			return newRoot;
		}
		else {
			BinaryNode<E> newRoot = new BinaryNode<E>(a[mid]);
			newRoot.left = buildTree(a, first, mid-1);
			newRoot.right = buildTree(a, mid+1, last);
			return newRoot;
		}
	}
	


	static class BinaryNode<E extends Comparable<? super E>> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}

		public boolean add(E x) {
			int compResult = x.compareTo(element);
			if (compResult == 0) {
				return false;
			}
			else if (compResult < 0) {
				/** Vänster subträd. */
				if (left == null) {
					left = new BinaryNode<E>(x);
					return true;
				}
				else {
					return left.add(x);
				}
			}
			else if (compResult > 0) {
				/** Höger subträd. */
				if (right == null) {
					right = new BinaryNode<E>(x);
					return true;
				}
				else {
					return right.add(x);
				}
			}
			return false;
		}

	}	
}
