
package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class BigDecimalUtils {

	private BigDecimalUtils() {}

	public static BigDecimal sqrt(BigDecimal b) {
		BigDecimal half = new BigDecimal(1d / 2d);
		BigDecimal value = b;
		BigDecimal precision = new BigDecimal(10e-150);
		while (value.subtract(b.divide(value, 300, RoundingMode.HALF_UP)).compareTo(precision.multiply(value)) > 0) {
			value = half.multiply(value.add(b.divide(value, 300, RoundingMode.HALF_UP)));
		}
		return value;
	}

}
