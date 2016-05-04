package de.itter.maths;

import java.io.Serializable;

public class Fraction implements Serializable, Comparable<Fraction> {

	private static final long serialVersionUID = 7799761909608343361L;
	long numerator;
	long denominator;

	public Fraction(long numerator, long denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	@Override
	public int compareTo(Fraction r) {

		if (numerator * r.denominator < r.numerator * denominator) {
			return -1;
		}

		if (numerator * r.denominator > r.numerator * denominator) {
			return 1;
		}

		return 0;
	}

	public static Fraction simplify(Fraction a, Fraction b) {
		Fraction result = new Fraction(0, 0);

		return result;
	}

}
