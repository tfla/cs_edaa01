public class TestFunction implements Function {
	public double evaluate(double x) {
		return Math.exp(-x)-1+Math.cos(x);
	}

	public static void main(String[] args) {
		double out = Bitsection.getZero(0, 1.6, 0.00001, new TestFunction());
		System.out.println(out);
	}
}
