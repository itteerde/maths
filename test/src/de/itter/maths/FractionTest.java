package de.itter.maths;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

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
		Fraction b = new Fraction(7);

		assertEquals("13/17", a.toString());
		assertEquals("7", b.toString());
	}

	@Test
	public void testPlus() {
		Fraction a = new Fraction(13, 7);
		Fraction b = new Fraction(12, 17);

		assertEquals(new Fraction(305, 119), a.plus(b));
		assertEquals(new Fraction(13 + 3 * 7, 7), a.plus(3));
	}

	@Test
	public void testMinus() {
		Fraction a = new Fraction(13, 7);
		Fraction b = new Fraction(12, 17);

		assertEquals(new Fraction(137, 119), a.minus(b));
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
		
		a = new Fraction(new BigInteger("123456789123456789123456789123456789"),new BigInteger("123456789123456789123456789123456789"));
		a.simplify();
		assertEquals("1/1",a.toString());
	}

	@Test
	public void testDivideBy() {
		Fraction a = new Fraction(1, 3);

		assertEquals(new Fraction(1, 6), a.divideBy(2));
	}

	/**
	 * This is not a good test as it cannot test multiple cases that should
	 * throw the exception. For example there cannot be a second division by
	 * zero for a Fraction argument in this one method with the annotation
	 * solution.
	 */
	@Test(expected = ArithmeticException.class)
	public void testDivideByZero() {
		Fraction a = new Fraction(1, 3);

		a.divideBy(0);
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
	
	@Test
	public void testFractionBigInteger(){
		String numeratorL = "123456789123456789123456789";
		String denominatorL = "987654321987654321987654321";
		String numeratorR = "123456789123456789123456789";
		String denominatorR = "987654321987654321987654321";
		
		Fraction l = new Fraction(new BigInteger(numeratorL),new BigInteger(denominatorL));
		Fraction r = new Fraction(new BigInteger(numeratorR),new BigInteger(denominatorR));
		
		assertEquals(l,r);
		assertEquals(0,l.compareTo(r));
		
		r = r.plus(new Fraction(1,1));
		assertEquals(-1,l.compareTo(r));
	}

}
