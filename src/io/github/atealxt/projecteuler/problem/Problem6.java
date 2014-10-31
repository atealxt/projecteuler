package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.Problem;

public class Problem6 extends Problem {

	@Override
	public String getTitle() {
		return "Sum square difference";
	}

	@Override
	public String getResult() {
		return String.valueOf(getSumSquareDifference(100));
	}

	private int getSumSquareDifference(int maxNum) {
		int sumNum = (maxNum + 1) * maxNum / 2;
		int squareOfSum = (int) Math.pow(sumNum, 2);
		int sumOfSquares = 0;
		for (int i = 1; i <= maxNum; i++) {
			sumOfSquares += Math.pow(i, 2);
		}
		return squareOfSum - sumOfSquares;
	}
}
