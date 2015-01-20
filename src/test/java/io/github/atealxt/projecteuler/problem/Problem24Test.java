package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.TestBase;

import org.junit.Assert;

public class Problem24Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertEquals("[0, 1]", ((Problem24) problem).getLexicographicPermutation(new int[] { 0, 1 }, 1));
		Assert.assertEquals("[1, 0]", ((Problem24) problem).getLexicographicPermutation(new int[] { 1, 0 }, 1));
		Assert.assertEquals("[1, 0]", ((Problem24) problem).getLexicographicPermutation(new int[] { 0, 1 }, 2));
		Assert.assertEquals("[0, 2, 1]", ((Problem24) problem).getLexicographicPermutation(new int[] { 0, 1, 2 }, 2));
		Assert.assertEquals("[1, 0, 2]", ((Problem24) problem).getLexicographicPermutation(new int[] { 0, 1, 2 }, 3));
		Assert.assertEquals("[2, 1, 0]", ((Problem24) problem).getLexicographicPermutation(new int[] { 0, 1, 2 }, 6));
		Assert.assertEquals("[1, 1, 0, 0]", ((Problem24) problem).getLexicographicPermutation(new int[] { 0, 0, 1, 1 }, 6));
		Assert.assertEquals("Not found!", ((Problem24) problem).getLexicographicPermutation(new int[] { 0, 0, 1, 1 }, 7));
		Assert.assertEquals("[2, 7, 8, 3, 9, 1, 5, 4, 6, 0]", problem.getResult());
	}
}
