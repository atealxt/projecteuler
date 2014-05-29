package projecteuler.problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import projecteuler.ProblemTemplate;

public class Problem30 extends ProblemTemplate {

	@Override
	public String getTitle() {
		return "Digit fifth powers";
	}

	@Override
	public String getResult() {
		Assert.assertEquals(19316, getSumOfNum(4));
		Assert.assertEquals(443839, getSumOfNum(5));
		Assert.assertArrayEquals(new int[] { 1, 2, 3 }, getNumbers(123));
		Assert.assertArrayEquals(new int[] { 1, 3, 2 }, getNumbers(132));
		Assert.assertArrayEquals(new int[] { 5 }, getNumbers(5));
		return String.valueOf(getSumOfNum(5));
	}

	private int getSumOfNum(int pow) {
		cache.clear();
		int total = 0;
		int begin = 10;
		int end = (int) (Math.pow(10, pow + 1) - 1);
		while (begin++ <= end) {
			int[] numbers = getNumbers(begin);
			Arrays.sort(numbers);
			String cacheKey = Arrays.toString(numbers);
			if (existCache(cacheKey)) {
				continue;
			}
			int sumOfPowers = 0;
			for (Integer i : numbers) {
				sumOfPowers += Math.pow(i, pow);
			}
			if (sumOfPowers == 1) {
				continue;
			}
			if (hasEq(numbers, sumOfPowers)) {
				total += sumOfPowers;
			}
			saveToCache(cacheKey);
		}
		return total;
	}

	static int[] getNumbers(long num) {
		String s = String.valueOf(num);
		int[] arr = new int[s.length()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = char2Int(s.charAt(i));
		}
		return arr;
	}

	private static int char2Int(char c) {
		return c - 48;
	}

	private final Map<String, Boolean> cache = new HashMap<>();

	private void saveToCache(String key) {
		cache.put(key, true);
	}

	private boolean existCache(String key) {
		return cache.containsKey(key);
	}

	private boolean hasEq(int[] numbers, int sumOfPowers) {
		int i = numbers.length - 1;
		while (i != -1) {
			int number = (int) parseNumber(numbers);
			if (number == sumOfPowers) {
				if (numbers[0] == 0) {
					return false;
				} else {
					return true;
				}
			}
			i = Problem24.move(numbers, i);
		}
		return false;
	}

	static long parseNumber(int[] numbers) {
		StringBuilder sb = new StringBuilder();
		for (int i : numbers) {
			sb.append(i);
		}
		return Long.parseLong(sb.toString());
	}
}
