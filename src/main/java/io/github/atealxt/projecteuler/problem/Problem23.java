package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.Problem;

import java.util.ArrayList;
import java.util.List;

public class Problem23 extends Problem {

	@Override
	public String getTitle() {
		return "Non-abundant sums";
	}

	@Override
	public String getResult() {
		return String.valueOf(getSumOfNonAbundant());
	}

	private int getSumOfNonAbundant() {
		List<Integer> abundants = new ArrayList<>();
		for (int i = 1; i <= THRESHOLD; i++) {
			if (isAbundant(i)) {
				abundants.add(i);
			}
		}
		boolean[] sumOfTwoAbundant = new boolean[THRESHOLD];
		for (int i = 0; i < abundants.size(); i++) {
			for (int j = i; j < abundants.size(); j++) {
				int n = abundants.get(i) + abundants.get(j);
				if (n > THRESHOLD) {
					break;
				}
				sumOfTwoAbundant[n - 1] = true;
			}
		}
		int sum = 0;
		for (int i = 0; i < sumOfTwoAbundant.length; i++) {
			if (!sumOfTwoAbundant[i]) {
				sum += i + 1;
			}
		}
		return sum;
	}

	private boolean isAbundant(int i) {
		return Problem21.getSumOfDivisors(i) > i;
	}

	private final static int THRESHOLD = 28123;
}
