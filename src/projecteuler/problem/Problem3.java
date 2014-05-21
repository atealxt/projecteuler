package projecteuler.problem;

import org.junit.Assert;

import projecteuler.ProblemTemplate;

public class Problem3 extends ProblemTemplate {

	@Override
	public String getTitle() {
		return "Largest prime factor";
	}

	@Override
	public String getResult() {
		Assert.assertEquals(5, getLargestPrimeFactor(10));
		Assert.assertEquals(5, getLargestPrimeFactor(20));
		Assert.assertEquals(11, getLargestPrimeFactor(66));
		Assert.assertEquals(29, getLargestPrimeFactor(13195));
		return String.valueOf(getLargestPrimeFactor(600851475143L));// 6857
	}

	private long getLargestPrimeFactor(long num) {
		long maxLoop = (long) (Math.sqrt(num) + 1);
		for (long i = maxLoop; i > 1; i--) {
			if (num % i != 0) {
				continue;
			}
			long divisor = num / i;
			if (isPrime(divisor)) {
				return divisor;
			}
			if (isPrime(i)) {
				return i;
			}
		}
		return -1;
	}

	static boolean isPrime(long n) {
		if (n == 1) {
			return false;
		} else if (n < 4) {
			return true;
		} else if (n % 2 == 0) {
			return false;
		} else if (n < 9) {
			return true;
		} else if (n % 3 == 0) {
			return false;
		}
		long maxLoop = (long) (Math.sqrt(n) + 1);
		for (long i = 5; i < maxLoop; i += 6) {
			if (n % i == 0) {
				return false;
			}
			if (n % (i + 2) == 0) {
				return false;
			}
		}
		return true;
	}
}

// why sqrt:
// http://bbs.csdn.net/topics/300142134
// http://stackoverflow.com/questions/5811151/why-do-we-check-upto-the-square-root-of-a-prime-number-to-determine-if-it-is-pri
