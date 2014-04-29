package projecteuler.problem;

import projecteuler.ProblemTemplate;

public class Problem40 extends ProblemTemplate {

	@Override
	public String getTitle() {
		return "Champernowne's constant";
	}

	@Override
	public String getResult() {
		return String.valueOf(getValue());
	}

	private int getValue() {
		int start = 1;
		int cnt = 0;
		int ret = 1;
		for (int i = 1; i <= 6; i++) {
			int end = (int) Math.pow(10, i);
			int dn;
			for (int j = start; j < end; j++) {
				dn = getDn(cnt, i, j);
				if (dn != -1) {
					ret *= dn;
				}
				cnt += i;
			}
			dn = getDn(cnt, i + 1, end);
			if (dn != -1) {
				ret *= dn;
			}
			cnt += i + 1;
			start = end + 1;
		}
		return ret;
	}

	private int getDn(int cnt, int i, int num) {
		int before = (int) Math.log10(cnt);
		int after = (int) Math.log10(cnt + i);
		if (before < after) {
			// System.out.println(cnt + " + " + i + "(" + num + ") = " + (cnt + i));
			int idxN = (int) Math.pow(10, after) - cnt;
			return Integer.parseInt(String.valueOf(num).substring(idxN - 1, idxN));
		}
		return -1;
	}
}
