package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.Problem;

import java.util.ArrayList;
import java.util.List;

public class Problem31 extends Problem {

	@Override
	public String getTitle() {
		return "Coin sums";
	}

	@Override
	public String getResult() {
		return String.valueOf(getNumOfWays(200));
	}

	private int getNumOfWays(int sumPence) {
		int sumWays = 0;
		List<List<Integer>> combinations = getCombinations(ARRAY);
		for (List<Integer> combination : combinations) {
			int ways = getWays(sumPence, combination);
			sumWays += ways;
		}
		return sumWays;
	}

	private int getWays(int leftPences, List<Integer> combination) {
		if (leftPences == 0) {
			if (combination.isEmpty()) {
				return 1;
			} else {
				return 0;
			}
		}
		if (combination.isEmpty()) {
			return 0;
		}
		int ways = 0;
		List<Integer> list = new ArrayList<>(combination);
		int coin = list.remove(list.size() - 1);
		for (int i = 1; i <= leftPences / coin; i++) {
			ways += getWays(leftPences - coin * i, list);
		}
		return ways;
	}

	static List<List<Integer>> getCombinations(int[] array) {
		List<List<Integer>> combinations = new ArrayList<>();
		int[] code = new int[array.length];
		while (next(code)) {
			List<Integer> combination = getCombination(array, code);
			combinations.add(combination);
		}
		return combinations;
	}

	private static List<Integer> getCombination(int[] array, int[] code) {
		List<Integer> combination = new ArrayList<>(array.length);
		for (int i = 0; i < code.length; i++) {
			if (code[i] != 0) {
				combination.add(array[i]);
			}
		}
		return combination;
	}

	private static boolean next(int[] code) {
		for (int i = code.length - 1; i >= 0; i--) {
			if (code[i] != 0) {
				continue;
			}
			for (int j = i - 1; j >= 0; j--) {
				if (code[j] == 1) {
					code[j] = 0;
					code[j + 1] = 1;
					move1ToHead(code, j + 2);
					return true;
				}
			}
			code[0] = 1;
			move1ToHead(code, 1);
			return true;
		}
		return false;
	}

	private static void move1ToHead(int[] code, int range) {
		for (int i = code.length - 1; i > range; i--) {
			if (code[i] == 0) {
				continue;
			}
			for (int j = range; j < i; j++) {
				if (code[j] == 0) {
					code[j] = 1;
					code[i] = 0;
					break;
				}
			}
		}
	}

	private static int[] ARRAY = { 1, 2, 5, 10, 20, 50, 100, 200 };
}
