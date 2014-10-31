package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.TestBase;
import io.github.atealxt.projecteuler.problem.Problem45;

import org.junit.Assert;

public class Problem45Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertTrue(((Problem45) problem).isHexagon(6));
		Assert.assertTrue(((Problem45) problem).isHexagon(15));
		Assert.assertFalse(((Problem45) problem).isHexagon(16));
		Assert.assertEquals("1533776805", problem.getResult());
	}
}
