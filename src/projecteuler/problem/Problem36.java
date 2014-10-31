package projecteuler.problem;

import projecteuler.Problem;

public class Problem36 extends Problem {

	@Override
	public String getTitle() {
		return "Double-base palindromes";
	}

	@Override
	public String getResult() {
		return String.valueOf(getSumOfPalindromes());
	}

	private int getSumOfPalindromes() {
		int sum = 0;
		for (int i = 1; i < 1000000; i += 2) {
			if (isDoubleBasePalindrome(i)) {
				sum += i;
			}
		}
		return sum;
	}

	boolean isDoubleBasePalindrome(int n) {
		String s10 = String.valueOf(n);
		if (!Problem4.isPalindrome(s10)) {
			return false;
		}
		String s2 = Integer.toBinaryString(n);
		return Problem4.isPalindrome(s2);
	}
}

// you can only check odd numbers... If the number in base ten is even, then it's base two counterpart will look something like 1 ... 0
