/**
 * 
 */
package de.itter.maths.format;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

/**
 * @author Erik Itter
 *
 */
public class IntegerToTextTest {

	@Test
	public void test1To12() {
		assertEquals("eins", IntegerToText.integerToText(new BigInteger("1")));
		assertEquals("zwei", IntegerToText.integerToText(new BigInteger("2")));
		assertEquals("drei", IntegerToText.integerToText(new BigInteger("3")));
		assertEquals("vier", IntegerToText.integerToText(new BigInteger("4")));
		assertEquals("fünf", IntegerToText.integerToText(new BigInteger("5")));
		assertEquals("sechs", IntegerToText.integerToText(new BigInteger("6")));
		assertEquals("sieben", IntegerToText.integerToText(new BigInteger("7")));
		assertEquals("acht", IntegerToText.integerToText(new BigInteger("8")));
		assertEquals("neun", IntegerToText.integerToText(new BigInteger("9")));
		assertEquals("zehn", IntegerToText.integerToText(new BigInteger("10")));
		assertEquals("elf", IntegerToText.integerToText(new BigInteger("11")));
		assertEquals("zwölf", IntegerToText.integerToText(new BigInteger("12")));

		assertEquals("eins", IntegerToText.integerToText(1));
		assertEquals("zwei", IntegerToText.integerToText(2));
		assertEquals("drei", IntegerToText.integerToText(3));
		assertEquals("vier", IntegerToText.integerToText(4));
		assertEquals("fünf", IntegerToText.integerToText(5));
		assertEquals("sechs", IntegerToText.integerToText(6));
		assertEquals("sieben", IntegerToText.integerToText(7));
		assertEquals("acht", IntegerToText.integerToText(8));
		assertEquals("neun", IntegerToText.integerToText(9));
		assertEquals("zehn", IntegerToText.integerToText(10));
		assertEquals("elf", IntegerToText.integerToText(11));
		assertEquals("zwölf", IntegerToText.integerToText(12));
	}

	@Test
	public void test13To19() {
		assertEquals("dreizehn", IntegerToText.integerToText(13));
		assertEquals("vierzehn", IntegerToText.integerToText(14));
		assertEquals("fünfzehn", IntegerToText.integerToText(15));
		assertEquals("sechzehn", IntegerToText.integerToText(16));
		assertEquals("siebzehn", IntegerToText.integerToText(17));
		assertEquals("achtzehn", IntegerToText.integerToText(18));
		assertEquals("neunzehn", IntegerToText.integerToText(19));
	}

	@Test
	public void test20To99() {
		assertEquals("zwanzig", IntegerToText.integerToText(20));
		assertEquals("einundzwanzig", IntegerToText.integerToText(21));
		assertEquals("zweiunddreißig", IntegerToText.integerToText(32));
		assertEquals("dreiundvierzig", IntegerToText.integerToText(43));
		assertEquals("vierundfünfzig", IntegerToText.integerToText(54));
		assertEquals("fünfundsechzig", IntegerToText.integerToText(65));
		assertEquals("sechsundsiebzig", IntegerToText.integerToText(76));
		assertEquals("siebenundachtzig", IntegerToText.integerToText(87));
		assertEquals("achtundneunzig", IntegerToText.integerToText(98));
		assertEquals("neunundneunzig", IntegerToText.integerToText(99));
	}

	@Test
	public void test100To999() {
		assertEquals("einhundert", IntegerToText.integerToText(100));
		assertEquals("einhunderteins", IntegerToText.integerToText(101));
		assertEquals("einhundertzwei", IntegerToText.integerToText(102));
		assertEquals("einhundertdrei", IntegerToText.integerToText(103));
		assertEquals("einhundertsiebenundneunzig", IntegerToText.integerToText(197));
		assertEquals("dreihunderteinunddreißig", IntegerToText.integerToText(331));
		assertEquals("siebenhundertfünfundvierzig", IntegerToText.integerToText(745));
		assertEquals("neunhundert", IntegerToText.integerToText(900));
		assertEquals("neunhundertneunundneunzig", IntegerToText.integerToText(999));
	}

	@Test
	public void test1000To9999() {
		assertEquals("eintausend", IntegerToText.integerToText(1000));
	}

}
