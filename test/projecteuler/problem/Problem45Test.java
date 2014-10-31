package projecteuler.problem;

import org.junit.Assert;

import projecteuler.TestBase;

public class Problem45Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertTrue(((Problem45) problem).isHexagon(6));
		Assert.assertTrue(((Problem45) problem).isHexagon(15));
		Assert.assertFalse(((Problem45) problem).isHexagon(16));
		Assert.assertEquals("1533776805", problem.getResult());
	}
}
