
package utils;

public final class DoubleCheck {

	private DoubleCheck() {}

	/**
	 * Returns the difference between the first two arguments with respect to
	 * the third argument
	 *
	 * @param a
	 *            First value
	 * @param b
	 *            Second value
	 * @param c
	 *            The value to calculate difference with respect to
	 * @return Returns the difference between the first two arguments divided by
	 *         the third
	 */
	public static double rangeDifferenceFactor(double a, double b, double c) {
		if (Double.isNaN(a) && Double.isNaN(b)) {
			return 0;
		} else if (a == b) {
			return 0;
		} else {
			return Math.abs((a - b) / c);
		}
	}

	/**
	 * Rounds the first argument to the number of significant figures
	 * represented by the second argument
	 *
	 * @param val
	 *            Value to round
	 * @param n
	 *            Number of significant figures to round to
	 * @return The rounded value as a double
	 */
	public static double roundToSignificantFigures(double val, int n) {
		if (val == 0 || Double.isNaN(val) || Double.isInfinite(val)) {
			return 0;
		}
		int power = n - (int) Math.ceil(Math.log10(val < 0 ? -val : val));
		double magnitude = Math.pow(10, power);
		long shifted = Math.round(val * magnitude);
		return shifted / magnitude;
	}

}
