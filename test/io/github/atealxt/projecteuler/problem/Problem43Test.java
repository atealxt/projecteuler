package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.TestBase;
import io.github.atealxt.projecteuler.problem.Problem43;

import org.junit.Assert;

public class Problem43Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertTrue(((Problem43) problem).hasProperty(1406357289));
		Assert.assertEquals("16695334890", problem.getResult());
	}
}
