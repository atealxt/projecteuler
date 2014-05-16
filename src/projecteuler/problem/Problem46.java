package projecteuler.problem;

import java.util.ArrayList;
import java.util.List;

import projecteuler.ProblemTemplate;

public class Problem46 extends ProblemTemplate {

	@Override
	public String getTitle() {
		return "Goldbach's other conjecture";
	}

	@Override
	public String getResult() {
		return String.valueOf(getCompositeNum());
	}

	private int getCompositeNum() {
		int n = 2;
		List<Integer> primes = new ArrayList<>();
		while (++n > 0) {
			boolean isPrime = Problem7.isPrime(n);
			if (isPrime) {
				primes.add(n);
				continue;
			}
			if (n % 2 == 0) {
				continue;
			}
			boolean hit = false;
			for (int i = primes.size() - 1; i >= 0; i--) {
				int p = primes.get(i);
				int sub = (n - p) / 2;
				int j = 0;
				while (++j > 0) {
					int square = (int) Math.pow(j, 2);
					if (square < sub) {
						continue;
					} else {
						if (square == sub) {
							hit = true;
						}
						break;
					}
				}
				if (hit) {
					break;
				}
			}
			if (!hit) {
				return n;
			}
		}
		return -1;
	}
}
