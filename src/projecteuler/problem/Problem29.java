package projecteuler.problem;

import java.math.BigInteger;
import java.util.Set;
import java.util.TreeSet;

import projecteuler.Problem;

public class Problem29 extends Problem {

	@Override
	public String getTitle() {
		return "Distinct powers";
	}

	@Override
	public String getResult() {
		return String.valueOf(getNumOfTerms2(100));
	}

	int getNumOfTerms(int max) {
		Set<BigInteger> terms = new TreeSet<>();
		for (int a = 2; a <= max; a++) {
			for (int b = 2; b <= max; b++) {
				BigInteger x = new BigInteger(String.valueOf(a)).pow(b);
				terms.add(x);
			}
		}
		return terms.size();
	}

	int getNumOfTerms2(int max) {
		int n = 0;
		for (int a = 2; a <= max; a++) {
			for (int b = 2; b <= max; b++) {
				if (!duplicated(a, b, max)) {
					n++;
				}
			}
		}
		return n;
	}

	private boolean duplicated(int a, int b, int max) {
		int maxLoop = (int) (Math.sqrt(a) + 1);
		for (int i = 2; i < maxLoop; i++) {
			if (a % i != 0) {
				continue;
			}
			int root = logn(i, a);
			if (root == -1) {
				continue;
			}
			int bPlus = b * root;
			if (bPlus <= max) {
				return true;
			} else {
				for (int j = (int) Math.sqrt(bPlus); j >= 2; j--) {
					if (bPlus % j != 0) {
						continue;
					}
					if (j == root) {
						continue;
					}
					if (bPlus / j > max) {
						return false;
					}
					if (Math.pow(i, j) <= a) {
						return true;
					}
				}
				return false;
			}
		}
		return false;
	}

	int logn(int base, int num) {
		double root = Math.log(num) / Math.log(base);
		if (root % 1 == 0) {
			return (int) root;
		} else {
			return -1;
		}
	}
}

// 4^6 = (2^2)^6 = 2^(6*2) = 2^12
// 64^18 = (8^2)^18 = 8^(18*2) = 8^36
// 8^34 = (2^3)^34 = 2^34*3 = 2^102 = 2^(51*2) = (2^2)^51 = 4^51
// 32^76 = (2^5)^76 = 2^76*5 = 2^380 = 2^(95*4) = (2^4)^95 = 16^95
