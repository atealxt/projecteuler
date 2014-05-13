package projecteuler.problem;

import org.junit.Assert;

import projecteuler.ProblemTemplate;

public class Problem45 extends ProblemTemplate {

	@Override
	public String getTitle() {
		return "Triangular, pentagonal, and hexagonal";
	}

	@Override
	public String getResult() {
		Assert.assertTrue(isHexagon(6));
		Assert.assertTrue(isHexagon(15));
		Assert.assertFalse(isHexagon(16));
		return String.valueOf(getNextT(40755));
	}

	private long getNextT(int lowest) {
		long i = 1;
		while (true) {
			long t = i * (i + 1) / 2;
			if (Problem44.isPentagon(t) && isHexagon(t)) {
				if (t > lowest) {
					return t;
				}
			}
			i++;
		}
	}

	private boolean isHexagon(long number) {
		double y = (Math.sqrt(8 * number + 1) + 1) / 4;
		return y == (int) y;
	}
}
