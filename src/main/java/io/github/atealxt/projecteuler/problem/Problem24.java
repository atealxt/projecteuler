package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.Problem;

import java.util.Arrays;

public class Problem24 extends Problem {

	@Override
	public String getTitle() {
		return "Lexicographic permutations";
	}

	@Override
	public String getResult() {
		return String.valueOf(getPermutation(1000000));
	}

	private String getPermutation(int nth) {
		return getLexicographicPermutation(DIC, nth);
	}

	/** Base on ASC ordered */
	String getLexicographicPermutation(int[] arr, int nth) {
		int[] array = Arrays.copyOf(arr, arr.length);
		int i = array.length - 1;
		int cnt = 0;
		do {
			if (++cnt == nth) {
				return Arrays.toString(array);
			}
			i = move(array, i);
		} while (i != -1);
		if (cnt == nth || (cnt == 1 && arr.length == 2 && arr[0] != (arr[1]))) { // TODO here is a patch for array length = 2
			return Arrays.toString(array);
		}
		return "Not found!";
	}

	static int move(int[] array, int i) {
		if (array.length <= 1) {
			return -1;
		}
		while (array[i - 1] == array[i]) {
			i--;
			if (i == 0) {
				return -1;
			}
		}
		if (i == array.length - 1) {
			swap(array, i, i - 1);
			i--;
			if (i == 0) {
				return -1;
			} else {
				return i;
			}
		}
		while (array[i - 1] >= array[i]) {
			i--;
			if (i == 0) {
				return -1;
			}
		}
		for (int j = array.length - 1; j > i; j--) {
			if (array[j] > array[i - 1]) {
				swap(array, j, i - 1);
				Arrays.sort(array, i, array.length);
				return array.length - 1;
			}
		}
		swap(array, i, i - 1);
		Arrays.sort(array, i, array.length);
		return array.length - 1;
	}

	private static void swap(int[] array, int i, int j) {
		int x = array[i];
		array[i] = array[j];
		array[j] = x;
	}

	private final static int[] DIC = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
}
