import java.util.*;

public class OrderedList<E extends Comparable<E>> implements Iterable<E> {
	private LinkedList<E> theList;

	public OrderedList() {
		theList = new LinkedList<E>();
	}

	public void add(E obj) {
		ListIterator<E> itr = theList.listIterator();
		while(itr.hasNext()) {
			if (obj.compareTo(itr.next()) < 0) {
				itr.previous();
				itr.add(obj);
				return;
			}
		}
		itr.add(obj);
	}

	public E get(int index) {
		return theList.get(index);
	}

	public Iterator<E> iterator() {
		return theList.iterator();
	}

	public int size() {
		return theList.size();
	}

	public boolean remove(E obj) {
		if (theList.size() != 0) {
			ListIterator<E> itr = theList.listIterator();
			while (itr.hasNext()) {
				if (obj.compareTo(itr.next()) < 0) {
					theList.remove();
					return true;
				}
			}
		}
		return false;
	}
}
