package projecteuler.problem;

import java.math.BigInteger;

import projecteuler.ProblemTemplate;

public class Problem48 extends ProblemTemplate {

	@Override
	public String getTitle() {
		return "Self powers";
	}

	@Override
	public String getResult() {
		return String.valueOf(getlastNDigits(10));
	}

	private String getlastNDigits(int len) {
		BigInteger sum = BigInteger.ZERO;
		for (int i = 1; i <= 1000; i++) {
			sum = sum.add(new BigInteger(String.valueOf(i)).pow(i));
		}
		String s = sum.toString();
		return s.substring(s.length() - len);
	}
}
