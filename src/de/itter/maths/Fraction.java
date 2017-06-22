package de.itter.maths;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * Exact fractions with no size limit (other than memory) using java.math.BigInteger for numerator and denominator if necessary. Small 
 * fractions (long/long) are converted into big fractions (BigInteger/BigInteger) as needed.
 * 
 * @author Erik Itter
 */
public class Fraction implements Serializable, Comparable<Fraction> {

	private static final long serialVersionUID = 7799761909608343361L;
	private static final String ERROR_DIVISION_BY_ZERO = "division by zero";

	private long numerator;
	private long denominator;
	private BigInteger bigNumerator = null;
	private BigInteger bigDenominator = null;

	public Fraction(long numerator, long denominator) {
		if(denominator == 0){
			throw new ArithmeticException(ERROR_DIVISION_BY_ZERO);
		}
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public Fraction(long n) {
		this(n,1);
	}
	
	public Fraction(BigInteger numerator, BigInteger denominator){
		if(denominator.equals(BigInteger.ZERO)){
			throw new ArithmeticException(ERROR_DIVISION_BY_ZERO);
		}
		
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
		
		if(isBigFraction() || r.isBigFraction()){
			if(isBigFraction() && r.isBigFraction()){
				return (getBigNumerator().multiply(r.getBigDenominator()).compareTo(r.getBigNumerator().multiply(getBigDenominator())));
			}
			
			Fraction bigL = null;
			
			if(!isBigFraction()){
				BigInteger numeratorL = new BigInteger(Long.toString(getNumerator()));
				BigInteger denominatiorL = new BigInteger(Long.toString(getDenominator()));
				
				bigL = new Fraction(numeratorL,denominatiorL);
			}
			
			Fraction bigR  = null;
			if(!r.isBigFraction()){
				BigInteger numeratorR = new BigInteger(Long.toString(r.getNumerator()));
				BigInteger denominatiorR = new BigInteger(Long.toString(r.getDenominator()));
				
				bigR = new Fraction(numeratorR,denominatiorR);
				
			}else{
				bigR = r;
			}
			
			return bigL==null? compareTo(bigR):bigL.compareTo(bigR);
		}

		if (numerator * r.denominator < r.numerator * denominator) {
			return -1;
		}

		if (numerator * r.denominator > r.numerator * denominator) {
			return 1;
		}

		return 0;
	}

	public void simplify() {
		if(isBigFraction()){
			simplifyBig();
			return;
		}
		
		long gcd = Algorithms.gcd(numerator, denominator);

		numerator /= gcd;
		denominator /= gcd;
	}

	private void simplifyBig() {
		BigInteger gcd = Algorithms.gcd(getBigNumerator(), getBigDenominator());

		bigNumerator = getBigNumerator().divide(gcd);
		bigDenominator = getBigDenominator().divide(gcd);
		
		if(bigNumerator.compareTo(new BigInteger(Long.toString(Long.MAX_VALUE)))==-1 && bigDenominator.compareTo(new BigInteger(Long.toString(Long.MAX_VALUE)))==-1){
			numerator = bigNumerator.longValue();
			denominator = bigDenominator.longValue();
			
			bigDenominator = null;
		}
	}

	public long getNumerator() {
		return numerator;
	}

	public long getDenominator() {
		return denominator;
	}

	@Override
	public String toString() {
		if(isBigFraction()){
			if (isWholeNumber()) {
				return bigNumerator.toString();
			}
			return bigNumerator.toString() + "/" + bigDenominator.toString();
		}
		
		if (isWholeNumber()) {
			return Long.toString(numerator);
		}
		return numerator + "/" + denominator;
	}

	public Fraction plus(Fraction f) {
		if(this.isBigFraction() || f.isBigFraction()){
			return this.plusBigFraction(f);
		}
		
		if (denominator == f.denominator) {
			return new Fraction(numerator + f.numerator, denominator);
		}

		long lcm = Algorithms.lcm(denominator, f.denominator);

		return new Fraction(numerator * (lcm / denominator) + f.numerator * (lcm / f.denominator), lcm);
	}

	private Fraction plusBigFraction(Fraction f) {
		Fraction l = this;
		Fraction r = f;

		if(!this.isBigFraction()){
			l = toBigFraction(this);
		}
		
		if(!f.isBigFraction()){
			r= toBigFraction(f);
		}
		
		BigInteger lcm = Algorithms.lcmBigInteger(l.bigDenominator, r.bigDenominator);
		
		return new Fraction((l.bigNumerator.multiply(lcm.divide(l.bigDenominator))).add(r.bigNumerator.multiply(lcm.divide(r.bigDenominator))),lcm);
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
		simplify();
		
		if(isBigFraction()){
			return getBigDenominator().equals(BigInteger.ONE);
		}
		
		if (denominator == 1) {
			return true;
		}
		return false;
	}

	public BigInteger getBigNumerator() {
		return bigNumerator;
	}

	public BigInteger getBigDenominator() {
		return bigDenominator;
	}
	
	private Fraction toBigFraction(Fraction f){
		if(f.isBigFraction()){
			return f;
		}
		
		return new Fraction(new BigInteger(Long.toString(f.getNumerator())),new BigInteger(Long.toString(f.getDenominator())));
	}
}
