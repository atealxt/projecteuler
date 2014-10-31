package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.TestBase;
import io.github.atealxt.projecteuler.problem.Problem26;

import org.junit.Assert;

public class Problem26Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertEquals(1, ((Problem26) problem).getCycleLength("3333333333333333"));// 1/3
		Assert.assertEquals(1, ((Problem26) problem).getCycleLength("16666666666666666"));// 1/6
		Assert.assertEquals(6, ((Problem26) problem).getCycleLength("07692307692307693"));// 1/13
		Assert.assertEquals(2, ((Problem26) problem).getCycleLength("045454545454545456"));// 1/22
		Assert.assertEquals(3, ((Problem26) problem).getCycleLength("0033783783783783786"));// 1/296
		Assert.assertEquals("983", problem.getResult());
	}
}
