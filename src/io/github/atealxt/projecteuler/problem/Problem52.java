package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.Problem;

import java.util.Arrays;

public class Problem52 extends Problem {

	@Override
	public String getTitle() {
		return "Permuted multiples";
	}

	@Override
	public String getResult() {
		return String.valueOf(getSmallestInt(6));
	}

	private int getSmallestInt(int time) {
		int start = 100, end = start * 10 / time;
		for (int i = start; i <= end; i++) {
			boolean permute = true;
			for (int j = 2; j <= time; j++) {
				if (!isPermuted(i, i * j)) {
					permute = false;
					break;
				}
			}
			if (permute) {
				return i;
			}
			if (i == end) {
				start *= 10;
				end = start * 10 / time;
			}
		}
		return -1;
	}

	private boolean isPermuted(int i, int j) {
		int[] numI = Problem30.getNumbers(i);
		int[] numJ = Problem30.getNumbers(j);
		if (numI.length != numJ.length) {
			return false;
		}
		Arrays.sort(numI);
		Arrays.sort(numJ);
		return Arrays.equals(numI, numJ);
	}
}
