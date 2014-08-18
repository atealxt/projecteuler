package projecteuler.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Assert;

import projecteuler.ProblemTemplate;

public class Problem51 extends ProblemTemplate {

	@Override
	public String getTitle() {
		return "Prime digit replacements";
	}

	@Override
	public String getResult() {
		Assert.assertEquals(13, getFirstMember(6));
		Assert.assertEquals(56003, getFirstMember(7));
		return String.valueOf(getFirstMember(8));
	}

	private int getFirstMember(int numOfFamily) {
		for (int i = 11;; i += 2) {
			if (!Problem3.isPrime(i)) {
				continue;
			}
			int len = String.valueOf(i).length();
			List<List<Integer>> masks = Problem31.getCombinations(range(0, len));
			masks.remove(masks.size() - 1);
			for (List<Integer> mask : masks) {
				List<Integer> family = getFamily(i, getPattern(i, mask));
				if (family.size() == numOfFamily) {
					return family.get(0);
				}
			}
		}
	}

	private List<Integer> getFamily(int n, String pattern) {
		if (CACHE.containsKey(pattern)) {
			return CACHE.get(pattern);
		}
		List<Integer> family = new ArrayList<>();
		for (int i = !pattern.startsWith("*") ? 0 : 1; i < 10; i++) {
			String s = pattern.replace("*", String.valueOf(i));
			int x = Integer.parseInt(s);
			if (Problem3.isPrime(x)) {
				family.add(x);
			}
		}
		CACHE.put(pattern, family);
		return family;
	}

	private String getPattern(int n, List<Integer> mask) {
		StringBuilder key = new StringBuilder(String.valueOf(n));
		for (Integer x : mask) {
			key.setCharAt(x, '*');
		}
		return key.toString();
	}

	private int[] range(int start, int end) {
		int[] array = new int[end - start];
		for (int i = 0; i < array.length; i++) {
			array[i] = start + i;
		}
		return array;
	}

	private final Map<String, List<Integer>> CACHE = new ConcurrentHashMap<>();
}
