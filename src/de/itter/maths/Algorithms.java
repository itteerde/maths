package de.itter.maths;

import java.math.BigInteger;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class Algorithms {

	public static int gcd(int a, int b) {
		return (int) gcd((long) a, (long) b);
	}

	public static long gcd(long a, long b) {

		if (a < 0 || b < 0) {
			throw new ArithmeticException("GCD not defined for negative parameters");
		}

		while (b != 0) {
			long h = a % b;
			a = b;
			b = h;
		}

		return a;
	}

	public static BigInteger gcd(BigInteger a, BigInteger b) {

		if (a.signum() == -1 || b.signum() == -1) {
			throw new ArithmeticException("GCD not defined for negative parameters");
		}

		while (b.compareTo(BigInteger.ZERO) != 0) {
			BigInteger h = a.mod(b);
			a = b;
			b = h;
		}

		return a;
	}

	public static long lcm(long a, long b) {
		return a * (b / gcd(a, b));
	}

	public static long lcm(long[] input) {
		long result = input[0];
		for (int i = 1; i < input.length; i++)
			result = lcm(result, input[i]);
		return result;
	}

	public static BigInteger[] factorize(BigInteger n) {
		Vector<BigInteger> factors = new Vector<BigInteger>();

		BigInteger i = n;
		for (BigInteger t = new BigInteger("2"); i.compareTo(BigInteger.ONE) > 0;) {
			if (i.mod(t).compareTo(BigInteger.ZERO) == 0) {
				factors.add(t);
				i = i.divide(t);
			} else {
				t = t.add(BigInteger.ONE);
			}
		}

		BigInteger[] result = new BigInteger[factors.size()];
		result = factors.toArray(result);

		return result;
	}

	public static long[] amicableChain(long n) {
		return null;
	}

	public static boolean isPerfectNumber(long n) {
		return false;
	}

	public static long[] divisors(long n) {
		LinkedList<Long> divisors = new LinkedList<Long>();

		for (long i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				divisors.add(i);
				divisors.add(n / i);
			}
		}

		Collections.sort(divisors);
		long[] result = new long[divisors.size()];
		Iterator<Long> iterator = divisors.iterator();
		for (int i = 0; i < divisors.size(); i++) {
			result[i] = iterator.next();
		}

		return result;
	}

	public static long[] properDivisors(long n) {
		long[] divisors = divisors(n);
		long[] properDivisors = new long[divisors.length - 1];

		for (int i = 0; i < properDivisors.length; i++) {
			properDivisors[i] = divisors[i];
		}

		return properDivisors;
	}

	public static BigInteger fac(int n) {
		BigInteger fac = BigInteger.ONE;

		for (int i = 1; i <= n; i++) {
			fac = fac.multiply(fac.add(BigInteger.ONE));
		}

		return fac;
	}

	public static double root(double num, double root) {
		return Math.pow(Math.E, Math.log(num) / root);
	}
}
