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
	public void testPlus() {
		Fraction a = new Fraction(13, 7);
		Fraction b = new Fraction(12, 17);

		assertEquals(new Fraction(305, 119), a.plus(b));
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

	@Test
	public void testTimesLotto() {
		Fraction k1 = new Fraction(6, 49);
		Fraction k2 = new Fraction(5, 48);
		Fraction k3 = new Fraction(4, 47);
		Fraction k4 = new Fraction(3, 46);
		Fraction k5 = new Fraction(2, 45);
		Fraction k6 = new Fraction(1, 44);
		Fraction lotto = k1.times(k2).times(k3).times(k4).times(k5).times(k6);

		assertEquals(new Fraction(1, 13983816), lotto);
	}
}
