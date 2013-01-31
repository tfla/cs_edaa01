package set;

public class UniqueElements {
	public static void main(String[] args) {
		int[] ints = new int[]{7,5,3,5,2,2,7};
		int[] out = uniqueElements(ints);

		for (int i : out) {
			System.out.println(i);
		}
	}

	public static int[] uniqueElements(int[] ints) {
		MaxSet<Integer> set = new MaxSet<Integer>();
		for (int i : ints) {
			set.add(i);
		}
		int[] result = new int[set.size()];

		for (int i = set.size()-1; i >= 0; i--) {
			result[i] = set.getMax();
			set.remove(set.getMax());
		}
		return result;
	}
}
