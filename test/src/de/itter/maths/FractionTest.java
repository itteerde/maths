package de.itter.maths;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FractionTest {

	@Test
	public void testCompareTo() {
		Fraction a = new Fraction(13, 17);
		Fraction b = new Fraction(12, 17);

		assertEquals(a.compareTo(b), 1);
		assertEquals(b.compareTo(a), -1);
		assertEquals(a.compareTo(a), 0);

		a = new Fraction(13, 17);
		b = new Fraction(25, 34);

		assertEquals(a.compareTo(b), 1);
		assertEquals(b.compareTo(a), -1);
		assertEquals(a.compareTo(a), 0);
	}

	@Test
	public void testToString() {
		Fraction a = new Fraction(13, 17);
		assertEquals("13/17", a.toString());
	}

	@Test
	public void testTimes() {
		Fraction a = new Fraction(13, 17);
		Fraction b = new Fraction(12, 17);
		Fraction c = a.times(b);

		assertEquals(c, new Fraction(13 * 12, 17 * 17));
	}

	@Test
	public void testSimplify() {
		Fraction a = new Fraction(13 * 7, 17 * 7);
		Fraction b = new Fraction(13, 17);

		a.simplify();

		assertEquals(a.getNumerator(), b.getNumerator());
	}
}
