package projecteuler.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;

import projecteuler.ProblemTemplate;

public class Problem41 extends ProblemTemplate {

	@Override
	public String getTitle() {
		return "Pandigital prime";
	}

	@Override
	public String getResult() {
		Assert.assertEquals(5040, getPermutation(new int[] { 1, 2, 3, 4, 5, 6, 7 }).size());
		return String.valueOf(getLargestPP2());
	}

	private int getLargestPP2() {
		List<Integer> list = getPermutation(new int[] { 1, 2, 3, 4, 5, 6, 7 });
		Collections.reverse(list);
		for (int i : list) {
			if (!Problem7.isPrime(i)) {
				continue;
			}
			if (!isPandigital(String.valueOf(i))) {
				continue;
			}
			return i;
		}
		return -1;
	}

	@SuppressWarnings("unused")
	private int getLargestPP() {
		for (int i = 7654321; i >= 2143; i--) { // 8 or 9 numbers can always dividable by 3.
			if (!Problem7.isPrime(i)) {
				continue;
			}
			if (!isPandigital(String.valueOf(i))) {
				continue;
			}
			return i;
		}
		return -1;
	}

	private List<Integer> getPermutation(int[] numbers) {
		List<Integer> list = new ArrayList<>();
		int i = numbers.length - 1;
		while (i != -1) {
			list.add(Problem30.parseNumber(numbers));
			i = Problem24.move(numbers, i);
		}
		if (numbers.length == 2) {
			list.add(Problem30.parseNumber(numbers));
		}
		return list;
	}

	/** @see Problem32#isPandigital(String) */
	private boolean isPandigital(String s) {
		if (s.length() < 2 || s.length() > 9) {
			return false;
		}
		List<String> dic = DIC.get(s.length() - 2);
		return Arrays.asList(Problem32.DIGIT.split(s)).containsAll(dic);
	}

	private static final List<String> DIC_9 = Arrays.asList(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" });
	private static final List<String> DIC_8 = Arrays.asList(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" });
	private static final List<String> DIC_7 = Arrays.asList(new String[] { "1", "2", "3", "4", "5", "6", "7" });
	private static final List<String> DIC_6 = Arrays.asList(new String[] { "1", "2", "3", "4", "5", "6" });
	private static final List<String> DIC_5 = Arrays.asList(new String[] { "1", "2", "3", "4", "5" });
	private static final List<String> DIC_4 = Arrays.asList(new String[] { "1", "2", "3", "4" });
	private static final List<String> DIC_3 = Arrays.asList(new String[] { "1", "2", "3" });
	private static final List<String> DIC_2 = Arrays.asList(new String[] { "1", "2" });
	private static final List<List<String>> DIC = Arrays.asList(DIC_2, DIC_3, DIC_4, DIC_5, DIC_6, DIC_7, DIC_8, DIC_9);
}
