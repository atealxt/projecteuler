package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.Problem;

import java.util.List;

public class Problem21 extends Problem {

	@Override
	public String getTitle() {
		return "Amicable numbers";
	}

	@Override
	public String getResult() {
		return String.valueOf(getSumOfAmicableNum(10000));
	}

	private int getSumOfAmicableNum(int max) {
		int sum = 0;
		boolean[] cache = new boolean[max];
		for (int a = 1; a < max; a++) {
			if (cache[a]) {
				continue;
			}
			int b = getSumOfDivisors(a);
			int aPrime = getSumOfDivisors(b);
			if (a != aPrime || a == b) {
				continue;
			}
			cache[b] = true;
			sum += a + b;
		}
		return sum;
	}

	static int getSumOfDivisors(int n) {
		List<Integer> factors = Problem12.getFactors(n);
		int sum = 0;
		for (int i = 0; i < factors.size() - 1; i++) {
			sum += factors.get(i);
		}
		return sum;
	}
}
