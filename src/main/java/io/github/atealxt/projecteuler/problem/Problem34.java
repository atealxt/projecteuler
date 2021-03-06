package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.Problem;

public class Problem34 extends Problem {

	@Override
	public String getTitle() {
		return "Digit factorials";
	}

	@Override
	public String getResult() {
		return String.valueOf(getSumOfNumbers());
	}

	private int getSumOfNumbers() {
		int sum = 0;
		int maxLoop = Problem15.factorial(9).intValue();
		for (int i = 10; i <= maxLoop; i++) {
			if (isCurious(i)) {
				sum += i;
			}
		}
		return sum;
	}

	boolean isCurious(int n) {
		int sum = 0;
		int _n = n;
		while (_n > 0) {
			int y = _n - _n / 10 * 10;
			_n = _n / 10;
			sum += Problem15.factorial(y).intValue();
			if (sum > n) {
				return false;
			}
		}
		return sum == n;
	}
}
