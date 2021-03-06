package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.TestBase;
import io.github.atealxt.projecteuler.problem.Problem41;

import org.junit.Assert;

public class Problem41Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertEquals(5040, Problem41.getPermutation(new int[] { 1, 2, 3, 4, 5, 6, 7 }).size());
		Assert.assertEquals("7652413", problem.getResult());
	}
}
