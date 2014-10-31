package projecteuler.problem;

import java.math.BigInteger;

import projecteuler.Problem;

public class Problem48 extends Problem {

	@Override
	public String getTitle() {
		return "Self powers";
	}

	@Override
	public String getResult() {
		return String.valueOf(getLastNDigits2(1000, 10));
	}

	private String getLastNDigits2(int pow, int len) {
		long mod = getMOD(len);
		long sum = 0;
		for (int i = 1; i <= pow; i++) {
			long x = i;
			for (int j = 1; j < i; j++) {
				x = x * i % mod;
			}
			sum = (sum + x) % mod;
		}
		return Long.toString(sum);
	}

	private long getMOD(int len) {
		long mod = 1;
		for (int i = 0; i < len; i++) {
			mod *= 10;
		}
		return mod;
	}

	@SuppressWarnings("unused")
	private String getLastNDigits(int len) {
		BigInteger sum = BigInteger.ZERO;
		for (int i = 1; i <= 1000; i++) {
			sum = sum.add(new BigInteger(String.valueOf(i)).pow(i));
		}
		String s = sum.toString();
		return s.substring(s.length() - len);
	}
}
