package de.itter.maths.discrete;

public class Combinatorica {

	public static int[] permutation(int[] array, int nth) {
		return null;
	}

	void heapPermutation(int a[], int size, int n) {
		// if size becomes 1 then prints the obtained
		// permutation
		if (size == 1)
			return;

		for (int i = 0; i < size; i++) {
			heapPermutation(a, size - 1, n);

			// if size is odd, swap first and last
			// element
			if (size % 2 == 1) {
				int temp = a[0];
				a[0] = a[size - 1];
				a[size - 1] = temp;
			}

			// If size is even, swap ith and last
			// element
			else {
				int temp = a[i];
				a[i] = a[size - 1];
				a[size - 1] = temp;
			}
		}
	}

	public static int fac(int n) {
		int f = 1;
		for (int i = 1; i <= n; f *= i++) {
		}
		return f;
	}
}
