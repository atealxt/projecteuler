package projecteuler.problem;

import org.junit.Assert;

import projecteuler.ProblemTemplate;

public class Problem35 extends ProblemTemplate {

	@Override
	public String getTitle() {
		return "Circular primes";
	}

	@Override
	public String getResult() {
		Assert.assertArrayEquals(new int[] { 123, 231, 312 }, getRotations(123));
		Assert.assertArrayEquals(new int[] { 5 }, getRotations(5));
		Assert.assertEquals(13, getNumOfCircularPrimes(100));
		return String.valueOf(getNumOfCircularPrimes(1000000));
	}

	private int getNumOfCircularPrimes(int max) {
		int count = 0;
		for (int i = 2; i < max; i++) {
			if (!isPrimeable(i)) {
				continue;
			}
			int[] rotations = getRotations(i);
			boolean isCircularPrime = true;
			for (int n : rotations) {
				if (!Problem7.isPrime(n)) {
					isCircularPrime = false;
					break;
				}
			}
			if (isCircularPrime) {
				count++;
			}
		}
		return count;
	}

	private boolean isPrimeable(int n) {
		if (n < 10) {
			return true;
		}
		int[] numbers = Problem30.getNumbers(n);
		for (int i = 0; i < numbers.length; i++) {
			int x = numbers[i];
			switch (x) {
				case 1:
				case 3:
				case 7:
				case 9:
					break;
				default:
					return false;
			}
		}
		int mod = n % 6;
		if (mod == 5 || mod == 1) {
			return true;
		}
		return false;
	}

	private int[] getRotations(int n) {
		int[] numbers = Problem30.getNumbers(n);
		int[] rotations = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			int[] rotation = new int[numbers.length];
			for (int j = 0; j < numbers.length; j++) {
				int x = j + i;
				if (x >= numbers.length) {
					x -= numbers.length;
				}
				rotation[j] = numbers[x];
			}
			rotations[i] = (int) Problem30.parseNumber(rotation);
		}
		return rotations;
	}
}
