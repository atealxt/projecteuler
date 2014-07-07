package projecteuler.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Assert;

import projecteuler.ProblemTemplate;

public class Problem51 extends ProblemTemplate {

	private final Map<String, List<Integer>> CACHE = new ConcurrentHashMap<>();
	private static final int MAX_LEN = 6;
	private static final int MAX_VALUE = 999999;
	private static final boolean[][][][][][] matrixs = buildPrimes();

	@Override
	public String getTitle() {
		return "Prime digit replacements";
	}

	@Override
	public String getResult() {
		Assert.assertEquals(56003, getFirstMember(7));
		Assert.assertEquals(13, getFirstMember(6));
		return String.valueOf(getFirstMember(8));
	}

	private int getFirstMember(int numOfFamily) {
		for (int i = 10; i <= MAX_VALUE; i++) {
			int[] numbers = Problem30.getNumbers(i);
			int len = numbers.length;
			List<List<Integer>> stars = Problem31.getCombinations(range(0, len));
			stars.remove(stars.size() - 1);
			for (List<Integer> star : stars) {
				List<Integer> family = getFamily(i, star, matrixs);
				if (family.size() == numOfFamily) {
					return family.get(0);
				}
			}
		}
		return -1;
	}

	private List<Integer> getFamily(int n, List<Integer> star, boolean[][][][][][] matrix) {
		String key = getKey(n, star);
		if (CACHE.containsKey(key)) {
			return CACHE.get(key);
		}
		List<Integer> family = new ArrayList<>();
		int i = applyZero(key) ? 0 : 1;
		for (; i < 10; i++) {
			String s = key.replace("*", String.valueOf(i));
			int[] idx = getIndex(s);
			if (matrix[idx[0]][idx[1]][idx[2]][idx[3]][idx[4]][idx[5]]) {
				family.add(Integer.parseInt(s));
			}
		}
		CACHE.put(key, family);
		return family;
	}

	private int[] getIndex(String s) {
		int[] idx = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			idx[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
		}
		return idx;
	}

	private boolean applyZero(String key) {
		for (int i = 0; i < key.length(); i++) {
			if (key.charAt(i) == '0') {
				continue;
			}
			return key.charAt(i) != '*';
		}
		return false;
	}

	private String getKey(int n, List<Integer> star) {
		StringBuilder key = new StringBuilder(String.valueOf(n));
		for (Integer x : star) {
			key.setCharAt(x, '*');
		}
		for (int i = 0; i < MAX_LEN - String.valueOf(n).length(); i++) {
			key.insert(0, "0");
		}
		return key.toString();
	}

	private static boolean[][][][][][] buildPrimes() {
		boolean[][][][][][] matrix = new boolean[10][10][10][10][10][10];
		for (int i = 2; i <= MAX_VALUE; i++) {
			boolean prime = Problem3.isPrime(i);
			int[] numbers = filledNumbers(i);
			matrix[numbers[0]][numbers[1]][numbers[2]][numbers[3]][numbers[4]][numbers[5]] = prime;
		}
		return matrix;
	}

	private static int[] filledNumbers(int i) {
		int[] numbers = Problem30.getNumbers(i);
		int[] filledNumbers = new int[] { 0, 0, 0, 0, 0, 0 };
		System.arraycopy(numbers, 0, filledNumbers, filledNumbers.length - numbers.length, numbers.length);
		return filledNumbers;
	}

	private int[] range(int start, int end) {
		int[] array = new int[end - start];
		for (int i = 0; i < array.length; i++) {
			array[i] = start + i;
		}
		return array;
	}
}
