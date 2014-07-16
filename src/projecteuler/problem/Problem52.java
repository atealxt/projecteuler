package projecteuler.problem;

import java.util.Arrays;

import projecteuler.ProblemTemplate;

public class Problem52 extends ProblemTemplate {

	@Override
	public String getTitle() {
		return "Permuted multiples";
	}

	@Override
	public String getResult() {
		return String.valueOf(getSmallestInt(6));
	}

	private int getSmallestInt(int time) {
		for (int i = 1;; i++) {
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
		}
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
