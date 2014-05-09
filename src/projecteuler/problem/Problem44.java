package projecteuler.problem;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import projecteuler.ProblemTemplate;

public class Problem44 extends ProblemTemplate {

	@Override
	public String getTitle() {
		return "Pentagon numbers";
	}

	@Override
	public String getResult() {
		Assert.assertTrue(isPentagon(5));
		Assert.assertTrue(isPentagon(12));
		Assert.assertFalse(isPentagon(13));
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

	private boolean isPentagon(int x) {
		double y = (Math.sqrt(24 * x + 1) + 1) / 6;
		return y == (int) y;
	}
}
