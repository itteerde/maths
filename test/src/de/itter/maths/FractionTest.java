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
}
