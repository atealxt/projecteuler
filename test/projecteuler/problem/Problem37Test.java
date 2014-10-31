package projecteuler.problem;

import org.junit.Assert;

import projecteuler.TestBase;

public class Problem37Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertTrue(((Problem37) problem).isTruncatable(3797));
		Assert.assertEquals("748317", problem.getResult());
	}
}
