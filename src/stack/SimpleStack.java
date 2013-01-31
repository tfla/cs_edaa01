package stack;

public class SimpleStack<E> implements Stack {
	private E[];
	private int pos = 0;

	public SimpleStack() {
		E[] e = new E[10];
	}
	
	/** Puts E at the top of the stack */
	public void push(E x) {
		e[pos] = x;
		pos++;
	}

	/** Removes and returns the element at the top of the stack. */
	public E pop() {
		if (e[pos] != null) {
			E temp = e[pos];
			e[pos] = null;
			pos--;
			return temp;
		}
		else {
			return new NoSuchElementException();
		}
	}

	/** Returns the element at the top of the stack. */
	public E peek() {
		if (e[pos] != null) {
			return e[pos];
		}
		else {
			return new NoSuchElementException();
		}
	}

	/** Checks if the stack is empty. */
	public boolean isEmpty() {
		return e[0] == null;
	}
