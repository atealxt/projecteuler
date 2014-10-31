package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem49 extends Problem {

	@Override
	public String getTitle() {
		return "Prime permutations";
	}

	@Override
	public String getResult() {
		return String.valueOf(getConcatenatingSequence2(1488));
	}

	String getConcatenatingSequence2(int min) {
		Set<Long> cache = new HashSet<>();
		for (int i = min;; i++) {
			if (!Problem3.isPrime(i)) {
				continue;
			}
			int[] numbers = Problem30.getNumbers(i);
			Arrays.sort(numbers);
			List<Long> permutations = Problem41.getPermutation(numbers);
			if (!cache.add(permutations.get(0))) {
				continue;
			}
			List<Integer> primes = new ArrayList<>();
			for (Long p : permutations) {
				if (Problem3.isPrime(p)) {
					primes.add(p.intValue());
				}
			}
			if (primes.size() < 3) {
				continue;
			}
			int[] array = toIntArray(primes);
			List<List<Integer>> combinations = Problem31.getCombinations(array);
			for (List<Integer> combination : combinations) {
				if (combination.size() != 3) {
					continue;
				}
				if (isEqDistance(combination) && combination.get(0) > min) {
					return combination.toString().replaceAll("[\\s\\[\\],]", "");
				}
			}
		}
	}

	private boolean isEqDistance(List<Integer> primes) {
		return primes.get(2) - primes.get(1) == primes.get(1) - primes.get(0);
	}

	static int[] toIntArray(List<Integer> integerList) {
		int[] intArray = new int[integerList.size()];
		for (int i = 0; i < integerList.size(); i++) {
			intArray[i] = integerList.get(i);
		}
		return intArray;
	}

	@SuppressWarnings("unused")
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
						int[] array = toIntArray(primes);
						List<List<Integer>> combinations = Problem31.getCombinations(array);
						for (List<Integer> combination : combinations) {
							if (combination.size() != 3) {
								continue;
							}
							if (isEqDistance(combination) && combination.get(0) > min) {
								return combination.toString().replaceAll("[\\s\\[\\],]", "");
							}
						}
					}
				}
			}
		}
		return "NOT FOUND";
	}
}
