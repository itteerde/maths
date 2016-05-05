package de.itter.maths;

import java.util.Vector;

public class SiebEratosthenes {

	private Vector<Integer> primes = new Vector<Integer>();
	private int maximum = 0;

	public SiebEratosthenes(int maximum) {

		this.maximum = maximum;

		boolean[] isPrime = new boolean[maximum + 1];// waste a little for
														// readability
		for (int i = 2; i <= maximum; i++) {
			isPrime[i] = true;
		}

		for (int i = 2; i * i <= maximum; i++) {

			if (isPrime[i]) {
				for (int j = i; i * j <= maximum; j++) {
					isPrime[i * j] = false;
				}
			}
		}

		for (int i = 2; i < isPrime.length; i++) {
			if (isPrime[i]) {
				primes.add(new Integer(i));
			}
		}
	}

	public int nth(int n) {
		if (maximum < n) {
			new SiebEratosthenes(n);
		}
		return primes.elementAt(n - 1).intValue();
	}

	public Vector<Integer> primes(int maximun) {
		if (primes.size() == 0 || primes.elementAt(primes.size() - 1) < maximum) {
			new SiebEratosthenes(maximun);
		}

		return primes;
	}

}
