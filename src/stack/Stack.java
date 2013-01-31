package stack;

public interface Stack<E> {
	/** Puts E at the top of the stack */
	void push(E x);

	/** Removes and returns the element at the top of the stack. */
	E pop();

	/** Returns the element at the top of the stack. */
	E peek();

	/** Checks if the stack is empty. */
	boolean isEmpty();
}
