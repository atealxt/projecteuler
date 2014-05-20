package projecteuler.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import projecteuler.ProblemTemplate;

public class Problem12 extends ProblemTemplate {

	@Override
	public String getTitle() {
		return "Highly divisible triangular number";
	}

	@Override
	public String getResult() {
		return String.valueOf(getFirstTriangleNum(500));
	}

	private int getFirstTriangleNum(int numOfDivisors) {
		if (numOfDivisors == 1) {
			return 1;
		}
		int i = 2;
		int sum = 1;
		while (true) {
			sum += i++;
			if (numOfDivisors < getFactors(sum).size()) {
				return sum;
			}
		}
	}

	static List<Integer> getFactors(int num) {
		List<Integer> factors = new ArrayList<>();
		factors.add(1);
		int maxLoop = (int) (Math.sqrt(num) + 1);
		for (int i = 2; i < maxLoop; i++) {
			if (num % i == 0) {
				factors.add(i);
				int divisor = num / i;
				if (divisor != i) {
					factors.add(divisor);
				}
			}
		}
		factors.add(num);
		Collections.sort(factors);
		return factors;
	}
}
