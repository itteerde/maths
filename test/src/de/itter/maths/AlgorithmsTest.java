package de.itter.maths;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

public class AlgorithmsTest {

	@Test
	public void testGCD() {

		assertEquals(14, Algorithms.gcd(123242, 546742));
	}

	@Test
	public void testLCM() {
		assertEquals(351, Algorithms.lcm(27, 13));
	}

	@Test
	public void testFac() {
		assertEquals(new BigInteger("720"), Algorithms.fac(6));
	}

	@Test
	public void testDivisors() {
		long[] d30 = { 2, 3, 5 };

		assertEquals(d30[0], Algorithms.factorize(30)[0]);
		assertEquals(d30[1], Algorithms.factorize(30)[1]);
		assertEquals(d30[2], Algorithms.factorize(30)[2]);
	}

}
