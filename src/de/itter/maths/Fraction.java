package de.itter.maths;

import java.io.Serializable;
import java.math.BigInteger;

public class Fraction implements Serializable, Comparable<Fraction> {

	private static final long serialVersionUID = 7799761909608343361L;
	private long numerator;
	private long denominator;
	private BigInteger bigNumerator = null;
	private BigInteger bigDenominator = null;

	public Fraction(long numerator, long denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public Fraction(long n) {
		numerator = n;
		denominator = 1;
	}
	
	public Fraction(BigInteger numerator, BigInteger denominator){
		bigNumerator = numerator;
		bigDenominator = denominator;
	}

	private boolean isBigFraction(){
		if(bigNumerator!=null){
			return true;
		}
		
		return false;
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
		if (isWholeNumber()) {
			return Long.toString(numerator);
		}
		return numerator + "/" + denominator;
	}

	public Fraction plus(Fraction f) {
		if (denominator == f.denominator) {
			return new Fraction(numerator + f.numerator, denominator);
		}

		long lcm = Algorithms.lcm(denominator, f.denominator);

		return new Fraction(numerator * (lcm / denominator) + f.numerator * (lcm / f.denominator), lcm);
	}

	public Fraction plus(long n) {
		return this.plus(new Fraction(n));
	}

	public Fraction minus(long n) {
		return this.minus(new Fraction(n));
	}

	public Fraction times(long n) {
		return this.times(new Fraction(n));
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
		if (f.getNumerator() == 0) {
			throw new ArithmeticException("division by zero");
		}

		return new Fraction(numerator * f.denominator, denominator * f.numerator);
	}

	public Fraction divideBy(long n) {
		return this.divideBy(new Fraction(n));
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

	public long getWholeNumberPart() {
		return numerator / denominator;
	}

	public boolean isWholeNumber() {
		if (denominator == 1) {
			return true;
		}
		return false;
	}
}
