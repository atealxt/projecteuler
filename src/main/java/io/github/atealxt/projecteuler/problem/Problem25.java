package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.Problem;

import java.math.BigInteger;

public class Problem25 extends Problem {

	@Override
	public String getTitle() {
		return "1000-digit Fibonacci number";
	}

	@Override
	public String getResult() {
		return String.valueOf(getFirstFibonacci(1000));
	}

	private int getFirstFibonacci(int numOfDigits) {
		BigInteger x1 = BigInteger.ONE;
		BigInteger x2 = BigInteger.ONE;
		BigInteger x3;
		int i = 2;
		BigInteger maxValue = BigInteger.TEN.pow(numOfDigits - 1);
		while (true) {
			i++;
			x3 = x1.add(x2);
			if (x3.compareTo(maxValue) >= 0) {
				return i;
			}
			x1 = x2;
			x2 = x3;
		}
	}
}
