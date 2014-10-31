package projecteuler.problem;

import java.util.List;

import projecteuler.Problem;

public class Problem43 extends Problem {

	@Override
	public String getTitle() {
		return "Sub-string divisibility";
	}

	@Override
	public String getResult() {
		return String.valueOf(getSumOfPandigitalNum());
	}

	private long getSumOfPandigitalNum() {
		List<Long> list = Problem41.getPermutation(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		long sum = 0;
		for (long i : list) {
			if (hasProperty(i)) {
				sum += i;
			}
		}
		return sum;
	}

	boolean hasProperty(long i) {
		int[] numbers = Problem30.getNumbers(i);
		if (numbers[5] != 5 && numbers[5] != 0) {
			return false;
		}
		if (numbers[3] % 2 != 0) {
			return false;
		}
		if ((numbers[2] + numbers[3] + numbers[4]) % 3 != 0) {
			return false;
		}
		if ((numbers[4] * 100 + numbers[5] * 10 + numbers[6]) % 7 != 0) {
			return false;
		}
		if ((numbers[5] * 100 + numbers[6] * 10 + numbers[7]) % 11 != 0) {
			return false;
		}
		if ((numbers[6] * 100 + numbers[7] * 10 + numbers[8]) % 13 != 0) {
			return false;
		}
		if ((numbers[7] * 100 + numbers[8] * 10 + numbers[9]) % 17 != 0) {
			return false;
		}
		return true;
	}
}
