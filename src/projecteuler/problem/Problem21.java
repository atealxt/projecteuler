package projecteuler.problem;

import java.util.List;

import org.junit.Assert;

import projecteuler.ProblemTemplate;

public class Problem21 extends ProblemTemplate {

	@Override
	public String getTitle() {
		return "Amicable numbers";
	}

	@Override
	public String getResult() {
		Assert.assertEquals(220, getSumOfDivisors(getSumOfDivisors(220)));
		Assert.assertEquals(284, getSumOfDivisors(getSumOfDivisors(284)));
		return String.valueOf(getSumOfAmicableNum(10000));
	}

	private int getSumOfAmicableNum(int max) {
		int sum = 0;
		boolean[] cache = new boolean[max];
		for (int a = 1; a < max; a++) {
			if (cache[a]) {
				continue;
			}
			int b = getSumOfDivisors(a);
			int aPrime = getSumOfDivisors(b);
			if (a != aPrime || a == b) {
				continue;
			}
			cache[b] = true;
			sum += a + b;
		}
		return sum;
	}

	static int getSumOfDivisors(int n) {
		List<Integer> factors = Problem12.getFactors(n);
		int sum = 0;
		for (int i = 0; i < factors.size() - 1; i++) {
			sum += factors.get(i);
		}
		return sum;
	}
}
