package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.TestBase;
import io.github.atealxt.projecteuler.problem.Problem34;

import org.junit.Assert;

public class Problem34Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertTrue(((Problem34) problem).isCurious(145));
		Assert.assertEquals("40730", problem.getResult());
	}
}
