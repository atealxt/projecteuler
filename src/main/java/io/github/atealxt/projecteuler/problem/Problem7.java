package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.Problem;

public class Problem7 extends Problem {

	@Override
	public String getTitle() {
		return "10001st prime";
	}

	@Override
	public String getResult() {
		return String.valueOf(getPrime(10001));
	}

	private long getPrime(int num) {
		if (num == 1) {
			return 2;
		}
		int numP = 1;
		long i = 3;
		while (true) {
			if (Problem3.isPrime(i) && ++numP >= num) {
				return i;
			}
			i += 2;// All primes except 2 are odd.
		}
	}
}
