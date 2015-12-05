package utilsTests;
import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import utils.Int;

public class IntTest {

	@Test
	public void testIntBasic() {
		t(1, "1");
	}

	@Test
	public void testIntNegative() {
		t(-1, "-1");
	}

	@Test
	public void testLongerInt() {
		t(8273918, "8273918");
	}

	@Test
	public void testLongerNegativeInt() {
		t(-12839172, "-12839172");
	}

	@Test(expected = NumberFormatException.class)
	public void testIntWithNonDigits() {
		t("3123131a312321");
	}

	@Test(expected = IllegalStateException.class)
	public void testPositiveOverflow() {
		t("2147483648");
	}

	@Test(expected = IllegalStateException.class)
	public void testNegativeOverflow() {
		t("-2147483649");
	}

	@Test(expected = NullPointerException.class)
	public void testNull() {
		t(null);
	}

	@Test
	public void testZero() {
		t(0, "0");
	}

	@Test
	public void testMultipleZeros() {
		t(0, "000000000");
	}

	@Test
	public void testNegativeZero() {
		t(0, "-0");
	}

	@Test
	public void testMultipleNegativeZeros() {
		t(0, "-0000000");
	}

	@Test(expected = NumberFormatException.class)
	public void testNonInteger() {
		t("a");
	}

	@Test(expected = NumberFormatException.class)
	public void testEmptyString() {
		t("");
	}

	@Ignore
	public void t(int v, String s) {
		assertEquals(v, Int.toInt(s));
	}

	@Ignore
	public void t(String s) {
		try {
			Int.toInt(s);
		} catch (Exception e) {
			throw e;
		}
	}
}
