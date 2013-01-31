package stack;
import java.util.LinkedList;
import java.util.Scanner;

/** Läser in tal och skriver ut dem i omvänd ordning. */
public class SmallStackExample {
	public static void main(String[] args) {
		LinkedList<Integer> stack = new LinkedList<Integer>();

		Scanner scan = new Scanner(System.in);
		while(scan.hasNextInt()) {
			stack.push(scan.nextInt());
		}

		while(!stack.isEmpty) {
			System.out.println(stack.pop());
		}
	}
}
