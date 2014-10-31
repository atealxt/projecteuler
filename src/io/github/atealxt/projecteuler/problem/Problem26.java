package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.Problem;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Problem26 extends Problem {

	@Override
	public String getTitle() {
		return "Reciprocal cycles";
	}

	@Override
	public String getResult() {
		return String.valueOf(getDecimalOfLongestCycle(1000));
	}

	int getDecimalOfLongestCycle(int n) {
		int longestCycle = -1;
		int decimalOfLongestCycle = -1;
		for (int i = 6; i < n; i++) {

			// http://blog.csdn.net/niushuai666/article/details/6691041
			List<Long> primeFactor = getPrimeFactors(i);
			boolean have2Or5 = have2Or5(primeFactor);
			boolean haveOther = haveOther(primeFactor);
			boolean mixed = have2Or5 && haveOther;
			boolean pure = !have2Or5;

			if (mixed || pure) {
				BigDecimal x = BigDecimal.ONE.divide(new BigDecimal(i), i * 2, RoundingMode.HALF_UP);
				int len = getCycleLength(x.toString().substring(2));
				if (len > longestCycle) {
					longestCycle = len;
					decimalOfLongestCycle = i;
				}
			}
		}
		return decimalOfLongestCycle;
	}

	int getDecimalOfLongestCycleMath(int n) {
		int x = 0, maxlen = 0;
		for (int i = 2; i < n; i++) {
			int rest = 1;
			for (int j = 0; j < i; j++) {
				rest = rest * 10 % i;
			}
			int r0 = rest;
			int len = 0;
			do {
				rest = rest * 10 % i;
				len++;
			} while (rest != r0);
			if (len > maxlen) {
				x = i;
				maxlen = len;
			}
		}
		return x;
	}

	int getCycleLength(String str) {
		int start = 0;
		do {
			int loop = 1;
			do {
				String piece = str.substring(start, start + loop);
				boolean isCycle = true;
				for (int i = start + loop; i < str.length() - loop; i += loop) {
					if (!piece.equals(str.substring(i, i + loop))) {
						isCycle = false;
						break;
					}
				}
				if (isCycle) {
					return loop;
				}
				++loop;
			} while (start + loop < str.length() - loop);
		} while (++start < str.length() - 1);
		throw new RuntimeException("Cycle not found!");
	}

	static List<Long> getPrimeFactors(long num) {
		List<Long> primeFactors = new ArrayList<>();
		long maxLoop = (long) (Math.sqrt(num) + 1);
		for (long i = maxLoop; i > 1; i--) {
			if (num % i != 0) {
				continue;
			}
			long divisor = num / i;
			if (Problem3.isPrime(divisor)) {
				primeFactors.add(divisor);
			}
			if (divisor == i) {
				continue;
			}
			if (Problem3.isPrime(i)) {
				primeFactors.add(i);
			}
		}
		return primeFactors;
	}

	private boolean have2Or5(List<Long> primeFactor) {
		for (long i : primeFactor) {
			if (i == 2 || i == 5) {
				return true;
			}
		}
		return false;
	}

	private boolean haveOther(List<Long> primeFactor) {
		for (long i : primeFactor) {
			if (i != 2 && i != 5) {
				return true;
			}
		}
		return false;
	}
}
