import java.util.NoSuchElementException;

public class SingleLinkedList<E> {
	private ListNode<E> first;

	/** Creates an empty list */
	public SingleLinkedList() {
		first = null;
	}

	/** Inserts the specified element at the beginning of this list */
	public void addFirst(E e) {
		ListNode<E> n = new ListNode<E>(e);
		n.next = first;
		first = n;
	}
	
	/** Returns the first element in this list.
		Throws NoSuchElementException if this list is empty. */
	public E getFirst() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		else {
			return first.element;
		}
	}

	/** Returns the last element in this list.
		Throws NoSuchElementException if this list is empty. */
	public E getLast() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		else {
			ListNode<E> last = first;
			while (last.next != null) {
				last = first.next;
			}
			return last.element;
		}
	}

	/** Returns true if this collection contains the specified element. */
	public boolean contains(Object x) {
		ListNode<E> node = first;
		while (node.next != null) {
			if (node.element.equals(x)) {
				return true;
			}	
		}
		return false;
	}
	
	/** Removes the first occurance of the specified element from this list, if it is present. If this list does not contain the element, it is unchanged. Returns true if this list contained the specified element (or equivalently, this list changed as a result of the call). */
	boolean remove(Object e) {
		if (contains(e)) {
			ListNode<E> node = first;
			if (node.next == null) {
				node.element = null;
				return true;
			}
			while (node.next != null) {
				if (node.next.equals(e)) {
					node.next = node.next.next;
					return true;
				}
			}
		}
		return false;
	}

	/** Nested class. Represents a node which contains an element of type E. */
	private static class ListNode<E> {
		private E element;
		private ListNode<E> next;

		/** Creates a ListNode which contains E. */
		private ListNode(E e) {
			element = e;
			next = null;
		}
	}
}
