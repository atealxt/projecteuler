package projecteuler.problem;

import org.junit.Assert;

import projecteuler.TestBase;

public class Problem35Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertArrayEquals(new int[] { 123, 231, 312 }, ((Problem35) problem).getRotations(123));
		Assert.assertArrayEquals(new int[] { 5 }, ((Problem35) problem).getRotations(5));
		Assert.assertEquals(13, ((Problem35) problem).getNumOfCircularPrimes(100));
		Assert.assertEquals("55", problem.getResult());
	}
}
