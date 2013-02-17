public class Bitsection {
	/** Beräknar nollstället för funktionen f i intervallet [low,high] med precisionen eps. Förutsätter att det finnd ett nollställe i intervallet. */
	public static double getZero(double low, double high, double eps, Function f) {
		double m = (high+low)/2;
		double fm = f.evaluate(m);
		double fl = f.evaluate(low);

		if (Math.abs(high-low( < eps) {
			return m;
		}
		else {
			if ((fm*fl) > 0) {
				getZero(fm, high, eps, f);
			}
			else {
				getZero(low, fm, eps, f);
			}
		}
		return 0;
	}
}
