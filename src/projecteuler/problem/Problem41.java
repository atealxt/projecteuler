package projecteuler.problem;

import java.util.Arrays;
import java.util.List;

import projecteuler.ProblemTemplate;

public class Problem41 extends ProblemTemplate {

	@Override
	public String getTitle() {
		return "Pandigital prime";
	}

	@Override
	public String getResult() {
		return String.valueOf(getLargestPP());
	}

	private int getLargestPP() {
		for (int i = 7654321; i >= 2143; i--) { // 8 or 9 numbers can always dividable by 3.
			if (!Problem7.isPrime(i)) {
				continue;
			}
			if (!isPandigital(String.valueOf(i))) {
				continue;
			}
			return i;
		}
		return -1;
	}

	/** @see Problem32#isPandigital(String) */
	static boolean isPandigital(String s) {
		if (s.length() < 2 || s.length() > 9) {
			return false;
		}
		List<String> dic = DIC.get(s.length() - 2);
		return Arrays.asList(Problem32.DIGIT.split(s)).containsAll(dic);
	}

	private static final List<String> DIC_9 = Arrays.asList(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" });
	private static final List<String> DIC_8 = Arrays.asList(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" });
	private static final List<String> DIC_7 = Arrays.asList(new String[] { "1", "2", "3", "4", "5", "6", "7" });
	private static final List<String> DIC_6 = Arrays.asList(new String[] { "1", "2", "3", "4", "5", "6" });
	private static final List<String> DIC_5 = Arrays.asList(new String[] { "1", "2", "3", "4", "5" });
	private static final List<String> DIC_4 = Arrays.asList(new String[] { "1", "2", "3", "4" });
	private static final List<String> DIC_3 = Arrays.asList(new String[] { "1", "2", "3" });
	private static final List<String> DIC_2 = Arrays.asList(new String[] { "1", "2" });
	private static final List<List<String>> DIC = Arrays.asList(DIC_2, DIC_3, DIC_4, DIC_5, DIC_6, DIC_7, DIC_8, DIC_9);
}
