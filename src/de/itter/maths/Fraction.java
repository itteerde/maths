package de.itter.maths;

import java.io.Serializable;

public class Fraction implements Serializable, Comparable<Fraction> {

	private static final long serialVersionUID = 7799761909608343361L;
	private long numerator;
	private long denominator;

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

	public void simplify() {
		long gcd = Algorithms.gcd(numerator, denominator);

		numerator /= gcd;
		denominator /= gcd;
	}

	public long getNumerator() {
		return numerator;
	}

	public long getDenominator() {
		return denominator;
	}

	@Override
	public String toString() {
		return numerator + "/" + denominator;
	}

	public Fraction plus(Fraction f) {
		if (denominator == f.denominator) {
			return new Fraction(numerator + f.numerator, denominator);
		}

		long lcm = Algorithms.lcm(denominator, f.denominator);

		return new Fraction(numerator * (lcm / denominator) + f.numerator * (lcm / f.denominator), lcm);
	}

	public Fraction minus(Fraction f) {
		if (denominator == f.denominator) {
			return new Fraction(numerator - f.numerator, denominator);
		}

		long lcm = Algorithms.lcm(denominator, f.denominator);

		return new Fraction(numerator * (lcm / denominator) - f.numerator * (lcm / f.denominator), lcm);
	}

	public Fraction times(Fraction f) {
		return new Fraction(numerator * f.numerator, denominator * f.denominator);
	}

	public Fraction divideBy(Fraction f) {
		return new Fraction(numerator * f.denominator, denominator * f.numerator);
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}

		if (!(o instanceof Fraction)) {
			return false;
		}

		if (this.compareTo((Fraction) o) != 0) {
			return false;
		}

		return true;
	}
}
