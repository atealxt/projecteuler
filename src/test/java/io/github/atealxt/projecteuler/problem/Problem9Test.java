package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.TestBase;
import io.github.atealxt.projecteuler.problem.Problem9;

import org.junit.Assert;

public class Problem9Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertEquals(60, ((Problem9) problem).getProductOfPythagoreanTriplet(12)); // a:3 b:4 c:5
		Assert.assertEquals("31875000", problem.getResult());
	}
}
