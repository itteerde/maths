package de.itter.maths;

import java.util.Vector;

public class Primes {

	private static int[] primes = null;

	public static int[] factorInteger(int n) {
		Vector<Integer> primeFactors = new Vector<Integer>();

		SiebEratosthenes sieb = new SiebEratosthenes((int) Math.sqrt(n));
		Vector<Integer> primes = sieb.primes((int) Math.sqrt(n));
		int idx = 0;

		while (n > 1) {

			if (n % primes.elementAt(idx) == 0) {
				primeFactors.add(primes.elementAt(idx));
				n /= primes.elementAt(idx);
				continue;
			}
			idx++;
		}

		int[] res = new int[primeFactors.size()];
		for (int i = 0; i < primeFactors.size(); i++) {
			res[i] = primeFactors.elementAt(i);
		}
		return res;
	}

	private static synchronized void initPrimes() {
		SiebEratosthenes s = new SiebEratosthenes(15485864);
		Vector<Integer> p = s.primes(15485864);
		primes = new int[p.size()];
		for (int i = 0; i < p.size(); i++) {
			primes[i] = p.elementAt(i - 1);
		}
	}

	public static void main(String[] args) {

		initPrimes();
		System.out.println(primes[primes.length - 1]);

	}
}
