package projecteuler.problem;

import org.junit.Assert;

import projecteuler.TestBase;

public class Problem9Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertEquals(60, ((Problem9) problem).getProductOfPythagoreanTriplet(12)); // a:3 b:4 c:5
		Assert.assertEquals("31875000", problem.getResult());
	}
}
