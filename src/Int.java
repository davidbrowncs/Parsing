/**
 * Simple utility class to convert strings to their corresponding {@code int}
 * values so long as the string is a valid integer
 *
 * @author David
 *
 */
public final class Int {

	private static final char[] numChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	int i = Integer.parseInt("a");

	private Int() {}

	/**
	 * Returns the integer value of the given string, or throws a
	 * {@code NumberFormatException} if the given string contains invalid
	 * characters
	 *
	 * @param s
	 *            The string to convert
	 * @return Returns the {@code int} version of the given string, so long as
	 *         it is a valid integer
	 */
	public static int toInt(String s) {
		if (s == null) {
			throw new NullPointerException();
		}
		char[] vals = s.toCharArray();
		if (vals.length == 0) {
			throw new NumberFormatException();
		} else if (getInt(vals[0]) == -1 && vals[0] != '-' && vals[0] != '+') {
			throw new NumberFormatException();
		}
		boolean negative = vals[0] == '-';

		int res = 0;
		if (negative) {
			for (int i = vals.length - 1, c = 0; i > 0; i--, c++) {
				int next = getInt(vals[i]);
				if (next == -1) {
					throw new NumberFormatException();
				} else {
					res -= next * pow(10, c);
				}
			}
		} else {
			for (int i = vals.length - 1, c = 0; i >= 0; i--, c++) {
				int next = getInt(vals[i]);
				if (next == -1) {
					throw new NumberFormatException();
				} else {
					res += next * pow(10, c);
				}
			}
		}
		if ((negative && res > 0) || (!negative && res < 0)) {
			throw new IllegalStateException();
		}
		return res;
	}

	/**
	 * Returns the integer corresponding to the char given, if the given char is
	 * not a digit this returns -1
	 *
	 * @param c
	 *            Char to compare against valid number chars
	 * @return The corresponding int
	 */
	private static int getInt(char c) {
		for (int i = 0; i < numChars.length; i++) {
			if (c == numChars[i]) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Only works for integer powers, returns the value of the given value to
	 * the given power (val ^ pow)
	 *
	 * @param val
	 *            The value to apply the exponent to
	 * @param pow
	 *            The exponent to apply to the value
	 * @return The value given by val^pow
	 */
	private static int pow(int val, int pow) {
		int res = val;
		if (pow == 0) {
			return 1;
		} else if (pow >= 1) {
			for (int i = 1; i < pow; i++) {
				res *= val;
			}
		} else {
			for (int i = 1; i < pow; i++) {
				res /= val;
			}
		}
		return res;
	}
}
