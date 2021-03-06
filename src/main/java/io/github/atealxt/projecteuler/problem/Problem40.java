package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.Problem;

public class Problem40 extends Problem {

	@Override
	public String getTitle() {
		return "Champernowne's constant";
	}

	@Override
	public String getResult() {
		return String.valueOf(getValue());
	}

	private int getValue() {
		int ret = 1, cnt = 0, start = 1, dn, i = 1, max = 1000000;
		while (true) {
			int end = (int) Math.pow(10, i);
			for (int j = start; j < end; j++) {
				dn = getDn(cnt, i, j);
				ret = dn == NON_CARRY ? ret : ret * dn;
				cnt += i;
				if (cnt > max) {
					return ret;
				}
			}
			dn = getDn(cnt, i + 1, end);
			ret = dn == NON_CARRY ? ret : ret * dn;
			cnt += i + 1;
			start = end + 1;
			i++;
		}
	}

	private int getDn(int cnt, int i, int num) {
		int before = (int) Math.log10(cnt);
		int after = (int) Math.log10(cnt + i);
		if (before == after) {
			return NON_CARRY;
		}
		// System.out.println(cnt + " + " + i + "(" + num + ") = " + (cnt + i));
		int idxN = (int) Math.pow(10, after) - cnt;
		return Integer.parseInt(String.valueOf(num).substring(idxN - 1, idxN));
	}

	private static final int NON_CARRY = -1;
}
