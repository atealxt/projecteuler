package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.Problem;

import java.util.List;

public class Problem47 extends Problem {

	@Override
	public String getTitle() {
		return "Distinct primes factors";
	}

	@Override
	public String getResult() {
		return String.valueOf(getFirstNumOfConsecutive(4));
	}

	int getFirstNumOfConsecutive(int len) {
		int[] consecution = new int[len];
		int cNumber = 0;
		for (int n = 2;; n++) {
			boolean isPrime = Problem3.isPrime(n);
			if (isPrime) {
				continue;
			}
			List<Long> primeFactors = Problem26.getPrimeFactors(n);
			if (!isValidFactors(n, primeFactors, len)) {
				continue;
			}
			if (isConsecutive(consecution, n)) {
				consecution[cNumber++] = n;
				if (cNumber == len) {
					return consecution[0];
				}
			} else {
				clearConsecution(consecution);
				cNumber = 0;
				consecution[cNumber++] = n;
			}
		}
	}

	private void clearConsecution(int[] consecution) {
		for (int i = 0; i < consecution.length; i++) {
			consecution[i] = 0;
		}
	}

	boolean isConsecutive(int[] consecution, int n) {
		for (int i = consecution.length - 1; i >= 0; i--) {
			if (consecution[i] == 0) {
				continue;
			}
			return n - consecution[i] == 1;
		}
		return true;
	}

	private boolean isValidFactors(int n, List<Long> primeFactors, int len) {
		if (primeFactors.size() != len) {
			return false;
		}
		long product = 1;
		for (long p : primeFactors) {
			product *= p;
		}
		if (product == n) {
			return true;
		}
		return primeFactors.contains(n / product);
	}
}
