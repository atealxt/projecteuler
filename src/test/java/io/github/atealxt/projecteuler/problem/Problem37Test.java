package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.TestBase;
import io.github.atealxt.projecteuler.problem.Problem37;

import org.junit.Assert;

public class Problem37Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertTrue(((Problem37) problem).isTruncatable(3797));
		Assert.assertEquals("748317", problem.getResult());
	}
}
