package projecteuler.problem;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import projecteuler.ProblemTemplate;

/** @see Problem9 */
public class Problem39 extends ProblemTemplate {

	@Override
	public String getTitle() {
		return "Integer right triangles";
	}

	@Override
	public String getResult() {
		return String.valueOf(getPerimeter(1000));
	}

	private int getPerimeter(int maxPerimeter) {
		Map<Integer, MutableInt> mapSolution = new HashMap<>();
		for (int a = 1; a < maxPerimeter; a++) {
			for (int b = a + 1; b < maxPerimeter - a; b++) {
				for (int c = b + 1; c <= maxPerimeter - a - b; c++) {
					if (Math.pow(a, 2) + Math.pow(b, 2) != Math.pow(c, 2)) {
						continue;
					}
					int perimeter = a + b + c;
					MutableInt count = mapSolution.get(perimeter);
					if (count != null) {
						count.increment();
					} else {
						mapSolution.put(perimeter, new MutableInt());
					}
				}
			}
		}
		int max = 0;
		int pMax = 0;
		for (Entry<Integer, MutableInt> entry : mapSolution.entrySet()) {
			int cnt = entry.getValue().get();
			if (max < cnt) {
				max = cnt;
				pMax = entry.getKey();
			}
		}
		return pMax;
	}

	class MutableInt {
		int value = 1;

		public void increment() {
			++value;
		}

		public int get() {
			return value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}
}
