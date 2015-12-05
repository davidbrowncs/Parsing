public class Int {
	private static char[] numChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	public static int toInt(String s) {
		char[] vals = s.toCharArray();
		boolean n = vals[0] == '-';

		int res = 0;
		if (n) {
			for (int i = vals.length - 1, c = 0; i > 0; i--, c++) {
				int next = getInt(vals[i]);
				if (next == -1) {
					throw new IllegalArgumentException();
				} else {
					res -= next * pow(10, c);
				}
			}
		} else {
			for (int i = vals.length - 1, c = 0; i >= 0; i--, c++) {
				int next = getInt(vals[i]);
				if (next == -1) {
					throw new IllegalArgumentException();
				} else {
					res += next * pow(10, c);
				}
			}
		}
		return res;
	}

	private static int getInt(char c) {
		for (int i = 0; i < numChars.length; i++) {
			if (c == numChars[i]) {
				return i;
			}
		}
		return -1;
	}

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
