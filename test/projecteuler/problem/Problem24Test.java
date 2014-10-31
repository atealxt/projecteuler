package projecteuler.problem;

import org.junit.Assert;

import projecteuler.TestBase;

public class Problem24Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertEquals("[1, 1, 0, 0]", ((Problem24) problem).getLexicographicPermutation(new int[] { 0, 0, 1, 1 }, 6));
		Assert.assertEquals("Not found!", ((Problem24) problem).getLexicographicPermutation(new int[] { 0, 0, 1, 1 }, 7));
		Assert.assertEquals("[2, 7, 8, 3, 9, 1, 5, 4, 6, 0]", problem.getResult());
	}
}
