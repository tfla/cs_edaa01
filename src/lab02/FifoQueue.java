package queue;
import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {

	}

	/**	
	 * Returns an iterator over the elements in this queue
	 * @return an iterator over the elements in this queue
	 */	
	public Iterator<E> iterator() {
		return new QueueIterator();
	}

	/**	
	 * Returns the number of elements in this queue
	 * @return the number of elements in this queue
	 */
	public int size() {		
		return size;
	}

	/**	
	 * Inserts the specified element into this queue, if possible
	 * post:	The specified element is added to the rear of this queue
	 * @param	x the element to insert
	 * @return	true if it was possible to add the element 
	 * 			to this queue, else false
	 */
	public boolean offer(E x) {
		QueueNode<E> newLast = new QueueNode<E>(x);
		if (last != null) {
			QueueNode<E> temp = last.next;
			newLast.next = temp;
			last.next = newLast;
			last = newLast;
		}
		else {
			last = newLast;
			newLast.next = last;
		}
		size++;
		return true;
	}

	/**	
	 * Retrieves and removes the head of this queue, 
	 * or null if this queue is empty.
	 * post:	the head of the queue is removed if it was not empty
	 * @return 	the head of this queue, or null if the queue is empty 
	 */
	public E poll() {
		if (last == null) {
			return null;
		}
		else if (last.next == last) {
			QueueNode<E> temp = last;
			last = null;
			size--;
			return temp.element;
		}
		else {
			QueueNode<E> temp = last.next;
			last.next = last.next.next;
			size--;
			return temp.element;
		}
	}

	/**	
	 * Retrieves, but does not remove, the head of this queue, 
	 * returning null if this queue is empty
	 * @return 	the head element of this queue, or null 
	 * 			if this queue is empty
	 */
	public E peek() {
		return (last == null)? null: last.next.element;
	}

	/**
	 * Appends the specified queue to this queue
	 * post: all elements from the specified queue are appended
	 *       to this queue. The specified queue (q) is empty
	 * @param q the queue to append
	 */
	public void append(FifoQueue<E> q) {
		if (last != null && q.last != null) {
			QueueNode<E> first = last.next;
			last.next = q.last.next;
			q.last.next = first;
			size += q.size();
			q.size = 0;
			q.last = null;
		}
		else if (last == null && q.last != null) {
			last = q.last;
			size += q.size();
			q.size = 0;
			q.last = null;
		}
	}

	private class QueueIterator implements Iterator<E> {
		private QueueNode<E> pos;

		/** Konstruktor */
		private QueueIterator() {
			if (pos != null) {
				pos = last.next;
			}
			else {
				pos = last;
			}
		}

		public boolean hasNext() {
			return pos != null;
		}

		public E next() {
			if (pos == null || pos == null) {
				throw new NoSuchElementException();
			}
			return pos.next.element;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}

	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}

	}

}
