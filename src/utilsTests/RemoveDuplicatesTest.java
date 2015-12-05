
package utilsTests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import utils.RemoveDuplicates;

public class RemoveDuplicatesTest {
	private List<String> c;

	@Before
	public void setup() {
		c = new ArrayList<>();
	}

	@Test
	public void testSimple() {
		c.add("a");
		c.add("a");
		RemoveDuplicates.removeDuplicates(c);
		assertEquals(1, c.size());
		assertEquals("a", c.get(0));
	}

	@Test
	public void testTriple() {
		for (int i = 0; i < 3; i++) {
			c.add("a");
		}
		RemoveDuplicates.removeDuplicates(c);
		assertEquals(1, c.size());
		assertEquals("a", c.get(0));
	}

	@Test
	public void testNormalList() {
		String[] a = new String[] { "a", "b", null, "c", null, "f", "asdad", "a", "asdad" };
		c = new ArrayList<String>(Arrays.asList(a));
		RemoveDuplicates.removeDuplicates(c);
		assertArrayEquals(new Object[] { "a", "b", null, "c", "f", "asdad" }, c.toArray());
	}

	@Test
	public void simpleRemoveDuplicatesArray() {
		String[] a = new String[] { "a", "a" };
		RemoveDuplicates.removeDuplicates(a);
		assertArrayEquals(new Object[] { "a", null }, a);
	}

	@Test
	public void normalRemoveDuplicatesArray() {
		String[] a = new String[] { "a", "b", "a", "c", "a", "b", "d" };
		RemoveDuplicates.removeDuplicates(a);
		assertArrayEquals(new Object[] { "a", "b", "c", "d", null, null, null }, a);
	}

	@Test
	public void removeManyDuplicates() {
		String[] a = new String[] { "a", "a", "a", "a", "a" };
		RemoveDuplicates.removeDuplicates(a);
		assertArrayEquals(new Object[] { "a", null, null, null, null }, a);
	}

	@Test
	public void removeLotsOfDuplicatesArray() {
		Object[] a = new Object[] { "a", "b", "c", "a", "b", "c", "h", "k", "a", "u", "k", "a", "c", "k", "g", "a", "h", "i" };
		RemoveDuplicates.removeDuplicates(a);
		Object[] test = new Object[] { "a", "b", "c", "h", "k", "u", "g", "i", null, null, null, null, null, null, null,
				null, null, null };
		assertArrayEquals(test, a);
	}

	@Test
	public void testNullArray() {
		Object[] a = new Object[] { "a", null, "a", "b" };
		RemoveDuplicates.removeDuplicates(a);
		assertArrayEquals(new Object[] { "a", null, "b", null }, a);
	}

	@Test
	public void testLotsOfNullArray() {
		Object[] a = new Object[] { "a", "b", null, "a", null, "b", null, "c" };
		RemoveDuplicates.removeDuplicates(a);
		assertArrayEquals(new Object[] { "a", "b", null, "c", null, null, null, null }, a);
	}
}
