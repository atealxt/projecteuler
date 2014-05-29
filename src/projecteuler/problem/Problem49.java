package projecteuler.problem;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import projecteuler.ProblemTemplate;

public class Problem49 extends ProblemTemplate {

	@Override
	public String getTitle() {
		return "Prime permutations";
	}

	@Override
	public String getResult() {
		Assert.assertEquals("148748178147", getConcatenatingSequence(0));
		return String.valueOf(getConcatenatingSequence(1488));
	}

	private String getConcatenatingSequence(int min) {
		for (int i = 1; i <= 9; i++) {
			for (int j = i + 1; j <= 9; j++) {
				for (int k = j + 1; k <= 9; k++) {
					List<Long> permutations = Problem41.getPermutation(new int[] { i, j, k });
					for (int l = 1; l <= 9; l++) {
						List<Integer> primes = new ArrayList<>();
						for (Long p : permutations) {
							int number = (int) (p * 10 + l);
							if (Problem3.isPrime(number)) {
								primes.add(number);
							}
						}
						if (primes.size() < 3) {
							continue;
						}
						if (primes.size() == 3) {
							if (isArithmeticSequence(primes) && primes.get(0) > min) {
								return primes.toString().replaceAll("[\\s\\[\\],]", "");
							}
						} else {
							int[] array = toIntArray(primes);
							List<List<Integer>> combinations = Problem31.getCombinations(array);
							for (List<Integer> combination : combinations) {
								if (combination.size() != 3) {
									continue;
								}
								if (isArithmeticSequence(combination) && combination.get(0) > min) {
									return combination.toString().replaceAll("[\\s\\[\\],]", "");
								}
							}
						}
					}
				}
			}
		}
		return "";
	}

	private boolean isArithmeticSequence(List<Integer> primes) {
		return primes.get(2) - primes.get(1) == primes.get(1) - primes.get(0);
	}

	static int[] toIntArray(List<Integer> integerList) {
		int[] intArray = new int[integerList.size()];
		for (int i = 0; i < integerList.size(); i++) {
			intArray[i] = integerList.get(i);
		}
		return intArray;
	}
}
