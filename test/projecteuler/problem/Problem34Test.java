package projecteuler.problem;

import org.junit.Assert;

import projecteuler.TestBase;

public class Problem34Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertTrue(((Problem34) problem).isCurious(145));
		Assert.assertEquals("40730", problem.getResult());
	}
}
