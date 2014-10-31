package projecteuler.problem;

import projecteuler.Problem;

public class Problem45 extends Problem {

	@Override
	public String getTitle() {
		return "Triangular, pentagonal, and hexagonal";
	}

	@Override
	public String getResult() {
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

	boolean isHexagon(long number) {
		double y = (Math.sqrt(8 * number + 1) + 1) / 4;
		return y == (int) y;
	}
}
