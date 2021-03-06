package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.Problem;

public class Problem1 extends Problem {

	@Override
	public String getTitle() {
		return "Multiples of 3 and 5";
	}

	@Override
	public String getResult() {
		int sum = 0;
		for (int i = 1; i < 1000; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}
		return String.valueOf(sum);
	}
}
