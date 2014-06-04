package projecteuler.problem;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import projecteuler.ProblemTemplate;

public class Problem50 extends ProblemTemplate {

	@Override
	public String getTitle() {
		return "Consecutive prime sum";
	}

	@Override
	public String getResult() {
		Assert.assertEquals(41, getPrimeIsMostConsecutive(100));
		Assert.assertEquals(953, getPrimeIsMostConsecutive(1000));
		return String.valueOf(getPrimeIsMostConsecutive(1000000));
	}

	private int getPrimeIsMostConsecutive(int max) {
		if (max < 2) {
			return 0;
		}
		if (max < 3) {
			return 2;
		}
		List<Integer> primes = getPrimes(max);
		int start = 0, maxLen = 0, thePrime = 0;
		while (start < primes.size() - 1) {
			int sum = 0, len = 0, prime = 0;
			for (int i = start + len; i < primes.size(); i++) {
				Integer p = primes.get(i);
				sum += p;
				if (sum > max) {
					break;
				}
				if (Problem3.isPrime(sum)) {
					len = i - start + 1;
					prime = sum;
				}
			}
			if (len > maxLen) {
				maxLen = len;
				thePrime = prime;
			}
			len--;
			prime -= primes.get(start);
			start++;
		}
		return thePrime;
	}

	private List<Integer> getPrimes(int max) {
		List<Integer> primes = new ArrayList<>();
		primes.add(2);
		for (int i = 3; i < max; i += 2) {
			if (Problem3.isPrime(i)) {
				primes.add(i);
			}
		}
		return primes;
	}
}
