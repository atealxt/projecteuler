package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.Problem;

public class Problem53 extends Problem {

	@Override
	public String getTitle() {
		return "Combinatoric selections";
	}

	@Override
	public String getResult() {
		return String.valueOf(getNumOfValues());
	}

	private int getNumOfValues() {
		int cnt = 0;
		for (int n = 10; n <= 100; n++) {
			int rMin = n % 2 == 0 ? n / 2 : n / 2 + 1;
			for (int r = n - 1; r >= rMin; r--) {
				long c = getC(n, r);
				if (c > 1000000) {
					cnt += 2 * (r - rMin);
					cnt += (rMin * 2 == n ? 1 : 2);
					break;
				}
			}
		}
		return cnt;
	}

	long getC(int n, int r) {
		long numerator = getPI(r + 1, n);
		long denominator = getPI(1, n - r);
		long c = numerator / denominator;
		return c;
	}

	long getPI(int from, int to) {
		long pi = from;
		for (int i = from + 1; i <= to; i++) {
			pi = pi * i;
		}
		return pi;
	}
}
