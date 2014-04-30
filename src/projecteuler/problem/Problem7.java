package projecteuler.problem;

import projecteuler.ProblemTemplate;

public class Problem7 extends ProblemTemplate {

	@Override
	public String getTitle() {
		return "10001st prime";
	}

	@Override
	public String getResult() {
		return String.valueOf(getPrime(10001));
	}

	private long getPrime(int num) {
		if (num == 1) {
			return 2;
		}
		int numP = 1;
		long i = 3;
		while (true) {
			if (isPrime(i) && ++numP >= num) {
				return i;
			}
			i += 2;// All primes except 2 are odd.
		}
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
		long maxLoop = (long) (Math.sqrt(n) + 1); // Refer to Problem 3 to see why sqrt
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
