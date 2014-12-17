package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.Problem;

public class Problem4 extends Problem {

	@Override
	public String getTitle() {
		return "Largest palindrome product";
	}

	@Override
	public String getResult() {
		return String.valueOf(getLargestPalindrome(3));
	}

	private int getLargestPalindrome(int tenthPower) {
		int start = (int) Math.pow(10, tenthPower - 1);
		int end = (int) Math.pow(10, tenthPower);
		int largestPalindrome = -1;
		for (int i = end - 1; i >= start; i--) {
			for (int j = end - 1; j >= start; j--) {
				int product = i * j;
				if (!isPalindrome(String.valueOf(product))) {
					continue;
				}
				if (product > largestPalindrome) {
					largestPalindrome = product;
				}
				break;
			}
		}
		return largestPalindrome;
	}

	static boolean isPalindrome(String s) {
		if (s == null || s.isEmpty()) {
			return false;
		}
		if (s.length() == 1) {
			return true;
		}
		int mid = s.length() / 2, left = mid - 1, right = mid;
		if (s.length() % 2 != 0) {
			right = mid + 1;
		}
		for (int i = 0; i < mid; i++) {
			if (s.charAt(left - i) != s.charAt(right + i)) {
				return false;
			}
		}
		return true;
	}
}
