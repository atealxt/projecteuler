package projecteuler.problem;

import org.junit.Assert;

import projecteuler.TestBase;

public class Problem3Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertEquals(5, ((Problem3) problem).getLargestPrimeFactor(10));
		Assert.assertEquals(5, ((Problem3) problem).getLargestPrimeFactor(20));
		Assert.assertEquals(11, ((Problem3) problem).getLargestPrimeFactor(66));
		Assert.assertEquals(29, ((Problem3) problem).getLargestPrimeFactor(13195));
		Assert.assertEquals("6857", problem.getResult());
	}
}
