package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.Problem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Problem32 extends Problem {

	@Override
	public String getTitle() {
		return "Pandigital products";
	}

	@Override
	public String getResult() {
		return String.valueOf(getSumOfProducts());
	}

	private int getSumOfProducts() {
		Set<Integer> products = new HashSet<>();
		int sum = 0;
		for (int i = 2; i < 5000; i++) {
			for (int j = 3; j < 1000000000 / i; j++) {
				int product = i * j;
				String s = String.valueOf(i) + String.valueOf(j) + String.valueOf(product);
				if (s.length() > 9) {
					break;
				}
				if (isPandigital(s)) {
					if (products.add(product)) {
						sum += product;
					}
				}
			}
		}
		return sum;
	}

	static boolean isPandigital(String s) {
		if (s.length() != DIC.size()) {
			return false;
		}
		return Arrays.asList(DIGIT.split(s)).containsAll(DIC);
	}

	private static final List<String> DIC = Arrays.asList(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" });
	static final Pattern DIGIT = Pattern.compile("(?<=\\d)");
}
