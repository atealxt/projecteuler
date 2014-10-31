package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.TestBase;
import io.github.atealxt.projecteuler.problem.Problem44;

import org.junit.Assert;

public class Problem44Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertTrue(Problem44.isPentagon(5));
		Assert.assertTrue(Problem44.isPentagon(12));
		Assert.assertFalse(Problem44.isPentagon(13));
		Assert.assertEquals("5482660", problem.getResult());
	}
}
