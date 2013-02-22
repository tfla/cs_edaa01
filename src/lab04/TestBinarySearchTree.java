package bst;

import java.util.Random;

public class TestBinarySearchTree {
	public static void main(String[] args) {
		BinarySearchTree<Integer> tree0 = new BinarySearchTree<Integer>();
		BinarySearchTree<Integer> tree1 = new BinarySearchTree<Integer>();
		BinarySearchTree<Integer> tree2 = new BinarySearchTree<Integer>();
		BSTVisualizer v0 = new BSTVisualizer("TestBinarySearchTree", 1024, 256);
		BSTVisualizer v1 = new BSTVisualizer("TestBinarySearchTree", 1024, 256);
		BSTVisualizer v2 = new BSTVisualizer("TestBinarySearchTree", 1024, 256);
		Random rand = new Random();

		/** Trädet från kompendiet. */
		tree0.add(new Integer(1));
		tree0.add(new Integer(3));
		tree0.add(new Integer(5));
		tree0.add(new Integer(7));
		tree0.add(new Integer(9));
		tree0.add(new Integer(11));
		tree0.add(new Integer(13));

		/** Optimalt träd. */
		for (int i = 0; i < 63; i++) {
			tree1.add(new Integer(i));
		}

		/** Träd med 100 slumpmässiga element. */
		for (int i = 0; i < 100; i++) {
			tree2.add(new Integer(rand.nextInt(i+1)));
		}
		
		/** Testa dubletter. */
		for (int i = 0; i < 10; i++) {
			tree1.add(new Integer(i));
		}

		/** Bygg om och rita upp. */
//		v2.drawTree(tree2);
		tree0.rebuild();
		tree1.rebuild();
		tree2.rebuild();
		v0.drawTree(tree0);
		v1.drawTree(tree1);
		v2.drawTree(tree2);
	}
}
