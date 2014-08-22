package projecteuler.problem;

import org.junit.Assert;

import projecteuler.ProblemTemplate;

public class Problem53 extends ProblemTemplate {

	@Override
	public String getTitle() {
		return "Combinatoric selections";
	}

	@Override
	public String getResult() {
		Assert.assertEquals(2, getPI(1, 2));
		Assert.assertEquals(20, getPI(4, 5));
		Assert.assertEquals(90, getPI(9, 10));
		Assert.assertEquals(24, getPI(1, 4));
		Assert.assertEquals(10, getC(10, 9));
		Assert.assertEquals(45, getC(10, 8));
		Assert.assertEquals(120, getC(10, 7));
		Assert.assertEquals(210, getC(10, 6));
		Assert.assertEquals(252, getC(10, 5));
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

	private long getC(int n, int r) {
		long numerator = getPI(r + 1, n);
		long denominator = getPI(1, n - r);
		long c = numerator / denominator;
		return c;
	}

	private long getPI(int from, int to) {
		long pi = from;
		for (int i = from + 1; i <= to; i++) {
			pi = pi * i;
		}
		return pi;
	}
}
