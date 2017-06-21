package de.itter.maths.discrete;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class CombinatoricaTest {

	@Test
	public void testPermutation() {
		fail("Not yet implemented");
	}

	@Test
	public void testFac() {
		assertEquals(1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10, Combinatorica.fac(10));
	}

}
