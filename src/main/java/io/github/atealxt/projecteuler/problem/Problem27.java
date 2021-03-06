package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.Problem;

public class Problem27 extends Problem {

	@Override
	public String getTitle() {
		return "Quadratic primes";
	}

	@Override
	public String getResult() {
		return String.valueOf(getProductOfCoefficients(1000, 1000));
	}

	private int getProductOfCoefficients(int a, int b) {
		int maxNumOfPrime = -1;
		int productOfCoefficients = -1;
		for (int i = 0 - a; i < a; i++) {
			for (int j = 0 - b; j < b; j++) {
				int numOfPrime = 0;
				for (int n = 0;; n++) {
					int x = n * n + i * n + j;
					if (!Problem3.isPrime(x)) {
						break;
					}
					numOfPrime++;
				}
				if (maxNumOfPrime <= numOfPrime) {
					maxNumOfPrime = numOfPrime;
					productOfCoefficients = i * j;
				}
			}
		}
		return productOfCoefficients;
	}
}
