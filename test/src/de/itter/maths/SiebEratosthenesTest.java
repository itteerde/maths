package de.itter.maths;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SiebEratosthenesTest {

	@Test
	public void testP1000() {
		SiebEratosthenes sieb = new SiebEratosthenes(10000);
		assertEquals(7919, sieb.nth(1000));
	}
}
