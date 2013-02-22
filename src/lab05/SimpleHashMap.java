package map;

public class SimpleHashMap<K,V> implements Map<K,V> {
	Entry<K,V>[] table;
	int size;
	
	/** Constructs an empty hashmap with the default initial capacity (16)
	 *  and the default load factor (0.75). */
	public SimpleHashMap() {
		new SimpleHashMap(16);
	}

	/** Constructs an empty hashmap with the specified initial capacity
	 *  and the default load factor (0.75). */
	public SimpleHashMap(int capacity) {
		table = (Entry<K,V>[]) new Entry[capacity];
		for (int i = 0; i < table.length; i++) {
			table[i] = null;
		}
		size = 0;
	}

	public V get(Object o) {
		return find(index((K)o), (K)o).getValue();
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public V put(K key, V value) {
		/** Kontrollera och justera fyllnadsgrad om nödvändigt. */
		int c = 0;
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				c++;
			}
		}
		if (c > 0.75*table.length) {
			table[table.length] = null;
		}

		/** Lägg in elementet. */
		int index = index(key);
		Entry temp = find(index, key);
		Entry e = new Entry(key, value);
		if (temp != null) {
			temp.next = e;
			size++;
			return (V) temp.getValue();
		}
		table[index] = e;
		size++;
		return null;
	}

	public V remove(Object o) {
		int index = index((K) o);
		if (table[index] == null) {
			return null;
		}
		else if (table[index].getKey() == (K) o) {
			table[index] = table[index].next;
			return null;
		}
		else {
			int pos = 0;
			Entry e = table[index];
			while (e != null && e.getKey() != (K) o) {
				e = e.next;
				if (e == null) {
					return null;
				}
				pos++;
			}
			/** Remove e. */
			return null;
		}
	}

	public int size() {
		return size;
	}

	private int index(K key) {
		return key.hashCode()%table.length;
	}

	private Entry<K,V> find(int index, K key) {
		if (table[index] == null) {
			return null;
		}
		else {
			Entry entry = table[index];
			while (entry != null && entry.getKey() != key) {
				entry = entry.next;
				if (entry == null) {
					return null;
				}
			}
			return entry;
		}
	}

	private void rehash() {
		/** Rehash! */
	}

	public String show() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < table.length; i++) {
			Entry<K,V> entry = table[i];
			while (entry != null) {
				sb.append(entry.toString());
				entry = entry.next;
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	private static class Entry<K,V> implements Map.Entry<K,V> {
		private K key;
		private V value;
		private Entry<K,V> next;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
			next = null;
		}

		public K getKey() {
			return this.key;
		}

		public V getValue() {
			return this.value;
		}

		public V setValue(V value) {
			V temp = this.value;
			this.value = value;
			return temp;
		}

		public String toString() {
			return this.getKey() + " = " + this.getValue();
		}
	}
}
