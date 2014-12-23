package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.TestBase;

import org.junit.Assert;

public class Problem31Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertEquals(3, Problem31.getCombinations(new int[] { 0, 1 }).size());
		Assert.assertEquals(7, Problem31.getCombinations(new int[] { 0, 1, 2 }).size());
		Assert.assertEquals("73682", problem.getResult());
	}
}
