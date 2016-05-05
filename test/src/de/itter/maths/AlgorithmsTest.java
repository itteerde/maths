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
	public void testFactorize() {
		long[][] d30 = { { 2, 1 }, { 3, 1 }, { 5, 1 } };
		long[][] d6 = { { 2, 1 }, { 3, 1 } };
		assertEquals(d6[0][0], Algorithms.factorize(6)[0][0]);
		assertEquals(d6[1][0], Algorithms.factorize(6)[1][0]);

		assertEquals(d30[0][0], Algorithms.factorize(30)[0][0]);
		assertEquals(d30[1][0], Algorithms.factorize(30)[1][0]);
		assertEquals(d30[2][0], Algorithms.factorize(30)[2][0]);
	}

}
