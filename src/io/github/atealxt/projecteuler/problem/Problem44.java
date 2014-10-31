package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.Problem;

import java.util.ArrayList;
import java.util.List;

public class Problem44 extends Problem {

	@Override
	public String getTitle() {
		return "Pentagon numbers";
	}

	@Override
	public String getResult() {
		return String.valueOf(getD());
	}

	private int getD() {
		List<Integer> pNumbers = new ArrayList<>();
		int i = 1;
		while (true) {
			int pI = i * (3 * i - 1) / 2;
			pNumbers.add(pI);
			for (int j = i - 1; j > 0; j--) {
				int pJ = pNumbers.get(j - 1);
				int sub = pI - pJ;
				if (!isPentagon(sub)) {
					continue;
				}
				if (sub == pJ) {
					continue;
				}
				if (!isPentagon(pI + pJ)) {
					continue;
				}
				return sub;
			}
			i++;
		}
	}

	static boolean isPentagon(long number) {
		double y = (Math.sqrt(24 * number + 1) + 1) / 6;
		return y == (int) y;
	}
}
