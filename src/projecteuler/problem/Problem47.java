package projecteuler.problem;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import projecteuler.ProblemTemplate;

public class Problem47 extends ProblemTemplate {

	@Override
	public String getTitle() {
		return "Distinct primes factors";
	}

	@Override
	public String getResult() {
		Assert.assertTrue(isConsecutive(new int[] { 644, 0, 0 }, 645));
		Assert.assertEquals(14, getFirstNumOfConsecutive(2));
		Assert.assertEquals(644, getFirstNumOfConsecutive(3));
		return String.valueOf(getFirstNumOfConsecutive(4));
	}

	private int getFirstNumOfConsecutive(int len) {
		int[] consecution = new int[len];
		int cNumber = 0;
		for (int n = 2;; n++) {
			boolean isPrime = Problem7.isPrime(n);
			if (isPrime) {
				continue;
			}
			List<Integer> factors = Problem12.getFactors(n);
			if (factors.size() - 2 < len) {
				continue;
			}
			List<Integer> primes = new ArrayList<>();
			for (int i = 1; i < factors.size() - 1; i++) {
				int factor = factors.get(i);
				if (Problem7.isPrime(factor)) {
					primes.add(factor);
				}
			}
			if (!isValidFactors(n, primes, len)) {
				continue;
			}
			if (isConsecutive(consecution, n)) {
				consecution[cNumber++] = n;
				if (cNumber == len) {
					return consecution[0];
				}
			} else {
				clearConsecution(consecution);
				cNumber = 0;
				consecution[cNumber++] = n;
			}
		}
	}

	private void clearConsecution(int[] consecution) {
		for (int i = 0; i < consecution.length; i++) {
			consecution[i] = 0;
		}
	}

	private boolean isConsecutive(int[] consecution, int n) {
		for (int i = consecution.length - 1; i >= 0; i--) {
			if (consecution[i] == 0) {
				continue;
			}
			return n - consecution[i] == 1;
		}
		return true;
	}

	private boolean isValidFactors(int n, List<Integer> primes, int len) {
		if (primes.size() != len) {
			return false;
		}
		int product = 1;
		for (int p : primes) {
			product *= p;
		}
		if (product == n) {
			return true;
		}
		return primes.contains(n / product);
	}
}
