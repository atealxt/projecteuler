package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.Problem;

public class Problem37 extends Problem {

	@Override
	public String getTitle() {
		return "Truncatable primes";
	}

	@Override
	public String getResult() {
		return String.valueOf(getSumOfPrimes(11));
	}

	private int getSumOfPrimes(int maxCnt) {
		int sum = 0;
		int cnt = 0;
		int i = 11;
		while (cnt < maxCnt) {
			if (isTruncatable(i)) {
				cnt++;
				sum += i;
			}
			i += 2;
			if (i % 5 == 0) { // All primes above 5 end with digit 1, 3, 7 or 9
				i += 2;
			}
		}
		return sum;
	}

	boolean isTruncatable(int n) {
		String s = String.valueOf(n);
		for (int i = 0; i < s.length(); i++) {
			if (!Problem3.isPrime(Integer.valueOf(s.substring(i)))) {
				return false;
			}
		}
		for (int i = s.length() - 1; i >= 0; i--) {
			if (!Problem3.isPrime(Integer.valueOf(s.substring(0, s.length() - i)))) {
				return false;
			}
		}
		return true;
	}
}

// http://en.wikipedia.org/wiki/Truncatable_prime
