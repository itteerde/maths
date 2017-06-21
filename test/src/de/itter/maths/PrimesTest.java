package de.itter.maths;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class PrimesTest {

	private static final int[] twoPFs = { 2 };

	@Test
	public void testFactorInteger() {
		assertArrayEquals(twoPFs, Primes.factorInteger(2));
	}

}
