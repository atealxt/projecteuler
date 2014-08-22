package projecteuler.problem;

import java.math.BigInteger;

import org.junit.Assert;

import projecteuler.ProblemTemplate;

public class Problem53 extends ProblemTemplate {

	@Override
	public String getTitle() {
		return "Combinatoric selections";
	}

	@Override
	public String getResult() {
		Assert.assertEquals(BigInteger.valueOf(2), getPI(1, 2));
		Assert.assertEquals(BigInteger.valueOf(20), getPI(4, 5));
		Assert.assertEquals(BigInteger.valueOf(90), getPI(9, 10));
		Assert.assertEquals(BigInteger.valueOf(24), getPI(1, 4));
		Assert.assertEquals(BigInteger.valueOf(10), getCombinatorial(10, 9));
		Assert.assertEquals(BigInteger.valueOf(45), getCombinatorial(10, 8));
		Assert.assertEquals(BigInteger.valueOf(120), getCombinatorial(10, 7));
		Assert.assertEquals(BigInteger.valueOf(210), getCombinatorial(10, 6));
		Assert.assertEquals(BigInteger.valueOf(252), getCombinatorial(10, 5));
		return String.valueOf(getNumOfValues());
	}

	private int getNumOfValues() {
		int cnt = 0;
		for (int n = 10; n <= 100; n++) {
			int rMin = n % 2 == 0 ? n / 2 : n / 2 + 1;
			for (int r = n - 1; r >= rMin; r--) {
				BigInteger c = getCombinatorial(n, r);
				if (c.compareTo(ONE_MILLION) > 0) {
					cnt += 2 * (r - rMin);
					cnt += (rMin * 2 == n ? 1 : 2);
					break;
				}
			}
		}
		return cnt;
	}

	private BigInteger getCombinatorial(int n, int r) {
		BigInteger numerator = getPI(r + 1, n);
		BigInteger denominator = getPI(1, n - r);
		BigInteger c = numerator.divide(denominator);
		return c;
	}

	private BigInteger getPI(int from, int to) {
		BigInteger pi = BigInteger.valueOf(from);
		for (int i = from + 1; i <= to; i++) {
			pi = pi.multiply(BigInteger.valueOf(i));
		}
		return pi;
	}

	private static final BigInteger ONE_MILLION = BigInteger.valueOf(1000000);
}
