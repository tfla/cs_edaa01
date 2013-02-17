package sort;
import queue.FifoQueue;


public class RadixSort {
	/** Sorterar talen i vektorn a med positioneringssortering.
	 *  maxNbrOfDigits anger maximalt antal siffror i talen.
	 */
	public static void radixSort(int[] a, int maxNbrOfDigits) {
		FifoQueue<Integer> numbers = new FifoQueue<Integer>();
		FifoQueue<Integer>[] queues = 
			(FifoQueue<Integer>[]) new FifoQueue[10];
		for (int i: a) {
			numbers.add(i);
		}

		for (int i = 0; i < 10; i++) {
			queues[i] = new FifoQueue<Integer>();
		}
		
		for (int i = 1; i <= maxNbrOfDigits; i++) {
			while (numbers.size() != 0) {
				int nbr = numbers.poll();
				int j = (int)(nbr/(Math.pow(10,(i-1))))%10;
				queues[j].add(nbr);
			}
			for (int j = 0; j < 10; j++) {
				numbers.append(queues[j]);
			}
		}

		
		
		int i = 0;
		int k = a.length-1;
		while (i < 9) {
			while (numbers.size() != 0) {
				a[k] = numbers.poll();
				k--;
			}
			i++;
		}
	}
}
