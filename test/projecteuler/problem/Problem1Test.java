package projecteuler.problem;

import org.junit.Assert;

import projecteuler.TestBase;

public class Problem1Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertEquals("233168", problem.getResult());
	}
}
