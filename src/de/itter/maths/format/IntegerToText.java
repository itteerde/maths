/**
 * 
 */
package de.itter.maths.format;

import java.math.BigInteger;

/**
 * @author Erik Itter
 *
 */
public class IntegerToText {

	private static final String[] NUll_BIS_NEUNZEHN = { "null", "eins", "zwei", "drei", "vier", "fünf", "sechs",
			"sieben", "acht", "neun", "zehn", "elf", "zwölf", "dreizehn", "vierzehn", "fünfzehn", "sechzehn",
			"siebzehn", "achtzehn", "neunzehn" };

	private static final String[] DIGIT_PREFIX = { "", "ein", "zwei", "drei", "vier", "fünf", "sechs", "sieben", "acht",
			"neun" };

	private static final String[] ZEHNER = { "", "zehn", "zwanzig", "dreißig", "vierzig", "fünfzig", "sechzig",
			"siebzig", "achtzig", "neunzig" };

	private static final String HUNDERT = "hundert";

	private static final String[] MAGNITUDE_NAMES_SINGULAR = { "", "tausend", "million", "milliarde", "billion",
			"billiarde", "trillion", "trilliarde", "quadrillion", "quadrillliarde", "quintillion", "quintilliarde",
			"sextillion", "sextilliarde", "septillion", "septilliarde", "oktillion", "oktilliarde", "nonillion",
			"nonilliarde", "dezillion", "dezilliarde", "undezillion", "undezilliarde", "dodezillion", "dodezilliarde",
			"tredizillion", "tredizilliarde", "quattuordezillion", "quattuordezilliarde", "quindezillion",
			"quindezilliarde", "sedezillion", "sedezilliarde", "septendezillion", "septendezilliarde" };

	private static final String[] MAGNITUDE_NAMES_PLURAL = { "", "tausend", "millionen", "milliarden", "billionen",
			"billiarden", "trillionen", "trilliarden", "quadrillionen", "quadrillliarden", "quintillionen",
			"quintilliarden", "sextillionen", "sextilliarden", "septillionen", "septilliarden", "oktillionen",
			"oktilliarden", "nonillionen", "nonilliarden", "dezillionen", "dezilliarden", "undezillionen",
			"undezilliarden", "dodezillionen", "dodezilliarden", "tredizillionen", "tredizilliarden",
			"quattuordezillionen", "quattuordezilliarden", "quindezillionen", "quindezilliarden", "sedezillionen",
			"sedezilliarden", "septendezillionen", "septendezilliarden" };

	private static final BigInteger N_12 = new BigInteger("12");
	private static final BigInteger N_19 = new BigInteger("19");
	private static final BigInteger N_99 = new BigInteger("99");

	private static void appendTriplet(StringBuffer s, int n, int magnitude) {
		if (n == 0) {
			return;
		}

		if (n <= 19) {
			s.append(NUll_BIS_NEUNZEHN[n]);
			if (magnitude > 3) {
				if (n == 1) {
					s.append(" " + MAGNITUDE_NAMES_SINGULAR[magnitude / 3]);
				}
				if (n > 1) {
					s.append(" " + MAGNITUDE_NAMES_PLURAL[magnitude / 3]);
				}
			}

			return;
		}
		if (n <= 99) {
			if (n % 10 != 0) {
				s.append(DIGIT_PREFIX[n % 10]);
				s.append("und");
			}
			s.append(ZEHNER[n / 10]);
			if (magnitude > 3) {
				if (n == 1) {
					s.append(" " + MAGNITUDE_NAMES_SINGULAR[magnitude / 3]);
				}
				if (n > 1) {
					s.append(" " + MAGNITUDE_NAMES_PLURAL[magnitude / 3]);
				}
			}
			return;
		}

		s.append(DIGIT_PREFIX[n / 100]);
		s.append(HUNDERT);
		appendTriplet(s, n % 100, magnitude);
		if (magnitude > 2) {
			s.append(" ");
			s.append(MAGNITUDE_NAMES_PLURAL[magnitude / 3]);
		}
	}

	public static String integerToText(long n) {
		return integerToText(new BigInteger(Long.toString(n)));
	}

	public static String integerToText(BigInteger n) {

		String asString = n.toString();
		int magnitude = asString.length() - 1;

		StringBuffer s = new StringBuffer();
		while (magnitude >= 0) {
			appendTriplet(s, Integer.parseInt(asString.substring(asString.length() - magnitude,
					Math.min(asString.length() - magnitude + 2, asString.length()))), magnitude);
			magnitude -= 3;
		}

		return s.toString();

	}
}
