package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.TestBase;
import io.github.atealxt.projecteuler.problem.Problem50;

import org.junit.Assert;

public class Problem50Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertEquals(41, ((Problem50) problem).getPrimeIsMostConsecutive(100));
		Assert.assertEquals(953, ((Problem50) problem).getPrimeIsMostConsecutive(1000));
		Assert.assertEquals("997651", problem.getResult());
	}
}
