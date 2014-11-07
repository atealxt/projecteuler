package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.Problem;

import java.math.BigInteger;

public class Problem55 extends Problem {

	private static final int MAX_VALUE = 10000;
	private static final int MAX_ITERATIONS = 50;

	@Override
	public String getTitle() {
		return "Lychrel numbers";
	}

	@Override
	public String getResult() {
		return String.valueOf(numOfLychrel());
	}

	private int numOfLychrel() {
		int count = 0;
		for (int i = 1; i < MAX_VALUE; i++) {
			if (isLychrel(i)) {
				count++;
			}
		}
		return count;
	}

	boolean isLychrel(int i) {
		BigInteger x = new BigInteger(String.valueOf(i));
		boolean isLychrel = true;
		for (int j = 0; j < MAX_ITERATIONS; j++) {
			x = x.add(getPalindrome(x.toString()));
			if (Problem4.isPalindrome(x.toString())) {
				isLychrel = false;
				break;
			}
		}
		return isLychrel;
	}

	private BigInteger getPalindrome(String x) {
		return new BigInteger(new StringBuilder(x).reverse().toString());
	}
}
